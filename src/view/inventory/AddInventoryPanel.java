package view.inventory;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI;

import controller.CarPropertiesController;

public class AddInventoryPanel extends JPanel {

	private JPanel panel;
	private JComboBox<String>[] make_boxes, model_boxes, trim_boxes, color_boxes;
	private JComboBox<Integer>[] quantity_boxes;
	private JLabel make_label, model_label, trim_label, color_label, quantity_label;
	private CarPropertiesController carpropscontroller;
	int size;
	// private InventoryController inventorycontroller;

	AddInventoryPanel() {

		this.setLayout(null);
		setTitle("Add Inventory");
		carpropscontroller = new CarPropertiesController();

		// Amount of rows
		size = 15;

		panel = BoxesPanel(size);
		this.add(panel);

		PopulateMakerBoxes();

	}

	public void setTitle(String text) {
		JLabel title = new JLabel(text);
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		Map<TextAttribute, ?> attributes = title_font.getAttributes();
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(20, 31, 520, 80);
		this.add(title);

	}

	public JPanel BoxesPanel(int size) {

		make_label = new JLabel("Make:");
		model_label = new JLabel("Model:");
		trim_label = new JLabel("Trim:");
		color_label = new JLabel("Color:");
		quantity_label = new JLabel("Quantity:");

		make_boxes = new JComboBox[size];
		model_boxes = new JComboBox[size];
		trim_boxes = new JComboBox[size];
		color_boxes = new JComboBox[size];
		quantity_boxes = new JComboBox[size];

		Font big_font = new Font("Helvetica", Font.BOLD, 25);

		make_label.setFont(big_font);
		model_label.setFont(big_font);
		trim_label.setFont(big_font);
		color_label.setFont(big_font);
		quantity_label.setFont(big_font);

		JPanel boxesPanel = new JPanel();
		boxesPanel.setLayout(null);
		boxesPanel.setBounds(20, 150, 1500, 800);
		// boxesPanel.setBackground(Color.RED);

		int spacing = 60;
		int field_size = 150;
		int init_placement = 20;

		BasicComboBoxUI test = new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				return new JButton() {
					@Override
					public int getWidth() {
						return 0;
					}
				};
			}
		};

		make_label.setBounds(init_placement, 0, 100, 50);
		model_label.setBounds(init_placement + (field_size + 20) * 1, 0, 100, 50);
		trim_label.setBounds(init_placement + (field_size + 20) * 2, 0, 100, 50);
		color_label.setBounds(init_placement + (field_size + 20) * 3, 0, 100, 50);
		quantity_label.setBounds(init_placement + (field_size + 30) * 4, 0, 150, 50);

		boxesPanel.add(make_label);
		boxesPanel.add(model_label);
		boxesPanel.add(trim_label);
		boxesPanel.add(color_label);
		boxesPanel.add(quantity_label);

		for (int i = 0; i < size; i++) {
			make_boxes[i] = new JComboBox<String>();
			model_boxes[i] = new JComboBox<String>();
			trim_boxes[i] = new JComboBox<String>();
			color_boxes[i] = new JComboBox<String>();
			quantity_boxes[i] = new JComboBox<Integer>();

			for (int j = 0; j < 10; j++) {
				quantity_boxes[i].addItem(j);
			}

			int num = i;
			make_boxes[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					PopulateModelBox(num);
				}
			});

			
			
			model_boxes[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					PopulateTrimsAndColors(num);
				}
			});
						
			make_boxes[i].setBounds(init_placement, spacing, field_size, 30);
			model_boxes[i].setBounds(init_placement + (field_size + 20) * 1, spacing, field_size, 30);
			trim_boxes[i].setBounds(init_placement + (field_size + 20) * 2, spacing, field_size, 30);
			color_boxes[i].setBounds(init_placement + (field_size + 20) * 3, spacing, field_size, 30);
			quantity_boxes[i].setBounds(init_placement + (field_size + 30) * 4, spacing, field_size, 30);

			model_boxes[i].setEnabled(false);
			trim_boxes[i].setEnabled(false);
			color_boxes[i].setEnabled(false);
			quantity_boxes[i].setEnabled(false);

			boxesPanel.add(make_boxes[i]);
			boxesPanel.add(model_boxes[i]);
			boxesPanel.add(trim_boxes[i]);
			boxesPanel.add(color_boxes[i]);
			boxesPanel.add(quantity_boxes[i]);

			spacing += 40;

		}

		return boxesPanel;
	}

	public void PopulateMakerBoxes() {

		ArrayList<String> make_names = carpropscontroller.getAllMakeNames();

		for (JComboBox<String> make_box : make_boxes) {
			make_box.addItem("Select..");
			for (String name : make_names) {
				make_box.addItem(name);
			}
		}
	}

	public void PopulateModelBox(int index) {

		String make = (String) make_boxes[index].getSelectedItem();

		ArrayList<String> model_names = carpropscontroller.getModelsByMaker(make);

		if (!make_boxes[index].getSelectedItem().equals("Select..")) {
			model_boxes[index].setEnabled(true);
			model_boxes[index].addItem("Select..");
			for (String model : model_names) {
				model_boxes[index].addItem(model);
			}

		} else {

			model_boxes[index].removeAllItems();
			model_boxes[index].setEnabled(false);
			trim_boxes[index].removeAllItems();
			trim_boxes[index].setEnabled(false);
			color_boxes[index].removeAllItems();
			color_boxes[index].setEnabled(false);
		}

	}

	public void PopulateTrimsAndColors(int index) {

		String model = (String) model_boxes[index].getSelectedItem();
		
		if (!model.equals("Select..")) {
			Map<String, Integer> trims = carpropscontroller.getTrimsMap(model);
			List<String> colors = carpropscontroller.getColors(model);
			
			color_boxes[index].setEnabled(true);
			trim_boxes[index].setEnabled(true);
			quantity_boxes[index].setEnabled(true);
			
			for (Map.Entry<String, Integer> entry : trims.entrySet()) {
				trim_boxes[index].addItem(entry.getKey());
			}
			
			for (String color : colors) {
			color_boxes[index].addItem(color);
			}
			
			
		} else {

			trim_boxes[index].removeAllItems();
			trim_boxes[index].setEnabled(false);
			color_boxes[index].removeAllItems();
			color_boxes[index].setEnabled(false);
		}

	}

}

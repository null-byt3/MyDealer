package view.inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI;

import controller.CarPropertiesController;
import controller.InventoryController;

public class AddInventoryPanel extends JPanel {

	private JPanel panel, buttons_panel, mainPanel, titlePanel;
	private JComboBox<String>[] make_boxes, model_boxes, trim_boxes, color_boxes;
	private JComboBox<Integer>[] quantity_boxes;
	private JLabel make_label, model_label, trim_label, color_label, quantity_label;
	private CarPropertiesController carpropscontroller;
	private InventoryController inventorycontroller;
	int size;
	ArrayList<Integer> selected_lines;

	AddInventoryPanel() {
		this.setLayout(new BorderLayout());
		titlePanel = CreateTitlePanel();
		mainPanel = new JPanel(null);
		
		carpropscontroller = new CarPropertiesController();
		inventorycontroller = new InventoryController();

		// Amount of rows
		size = 15;

		panel = BoxesPanel(size);
		buttons_panel = CreateButtonsPanel();
		mainPanel.add(panel);
		mainPanel.add(buttons_panel);

		this.add(titlePanel, BorderLayout.NORTH);
		this.add(mainPanel, BorderLayout.CENTER);
		
		
		PopulateMakerBoxes();

	}

	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  Add Inventory");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
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
		boxesPanel.setBounds(20, 50, 1000, 700);
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

			for (int j = 1; j <= 10; j++) {
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
			quantity_boxes[index].setSelectedItem(1);
			quantity_boxes[index].setEnabled(false);
		}

	}

	public void PopulateTrimsAndColors(int index) {

		if (model_boxes[index].isEnabled()) {

			trim_boxes[index].removeAllItems();
			color_boxes[index].removeAllItems();

			String model = (String) model_boxes[index].getSelectedItem();

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

		}

	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(20, 750, 1000, 100);
		// buttonsPanel.setBackground(Color.ORANGE);

		JButton saveButton = new JButton("Add Inventory");
		saveButton.setBackground(Color.ORANGE);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(20, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToInventory();
				JOptionPane.showMessageDialog(null, "Added to inventory");

				
				for (int i = 0; i < size; i++) {
					make_boxes[i].setSelectedIndex(0);
				}
			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.setForeground(Color.ORANGE);
		clearButton.setBackground(Color.DARK_GRAY);
		clearButton.setBounds(770, 0, 120, 45);
		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < size; i++) {
					make_boxes[i].setSelectedIndex(0);
				}
			}
		});

		buttonsPanel.add(saveButton);
		buttonsPanel.add(clearButton);
		return buttonsPanel;
	}

	public void addToInventory() {
		for (int i = 0; i < size; i++) {

			if (verifyFields(i)) {
				String make = (String) make_boxes[i].getSelectedItem();
				String model = (String) model_boxes[i].getSelectedItem();
				String type = carpropscontroller.getType(model);
				String trim = (String) trim_boxes[i].getSelectedItem();
				String color = (String) color_boxes[i].getSelectedItem();
				int quantity = (Integer) quantity_boxes[i].getSelectedItem();

				inventorycontroller.add(type, make, model, trim, color, quantity);
			}
		}

	}

	public boolean verifyFields(int index) {

		if (make_boxes[index].getSelectedItem().equals("Select..")) {
			return false;
		}

		return true;
	}

}

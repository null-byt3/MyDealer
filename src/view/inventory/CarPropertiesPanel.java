package view.inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.CarPropertiesController;

public class CarPropertiesPanel extends JPanel {

	private JPanel panel, mainPanel, titlePanel;
	private EditCarPropertiesWindow editcarprops;
	private JButton newButton;
	private JPanel[] carTypePanel;
	private CarPropertiesController carpropscontroller = new CarPropertiesController();
	private int num_of_types;
	private HashMap<String, JPanel[]> slots_hash = new HashMap<String, JPanel[]>();
	CarPropertiesPanel() {

		this.setLayout(new BorderLayout());

		
		titlePanel = CreateTitlePanel();
		mainPanel = new JPanel(null);
		

		newButton = AddCarButton();
		panel = CreateVehicleGrid(carpropscontroller.getAllCarTypes());

		mainPanel.add(newButton);
		mainPanel.add(panel);

		this.add(mainPanel, BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);
		
		PopulateGrid();

	}
	
	
	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  Car Properties");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
	}

	public JPanel CreateVehicleGrid(ArrayList<String> types) {

		num_of_types = types.size();
		JPanel vehicleGridPanel = new JPanel();
		vehicleGridPanel.setLayout(new GridLayout(5, 1, 10, 10));
		vehicleGridPanel.setBounds(20, 80, 1600, 1000);

		carTypePanel = new JPanel[num_of_types];

		for (int i = 0; i < num_of_types; i++) {

			carTypePanel[i] = new JPanel();
			carTypePanel[i].setName(types.get(i));
			JLabel label = new JLabel(types.get(i) + ":");
			Font title_font = new Font("Helvetica", Font.BOLD, 30);
			Map attributes = title_font.getAttributes();
			label.setFont(title_font.deriveFont(attributes));
			label.setSize(200, 100);

			carTypePanel[i].setLayout(new BorderLayout());
			carTypePanel[i].setBounds(20, 100, 600, 200);

			JPanel innerGridPanel = InnerGridPanel(types.get(i));

			carTypePanel[i].add(label, BorderLayout.NORTH);
			carTypePanel[i].add(innerGridPanel, BorderLayout.CENTER);

			vehicleGridPanel.add(carTypePanel[i]);
		}

		return vehicleGridPanel;
	}

	public JPanel InnerGridPanel(String type) {
		JPanel innerGridPanel = new JPanel();
		innerGridPanel.setLayout(new GridLayout(1, 10, 10, 10));
		
		slots_hash.put(type, new JPanel[10]);
		JPanel[] slots = slots_hash.get(type);

		// slots = new JPanel[num_of_types][10];
		for (int j = 0; j < 10; j++) {
			slots[j] = carSlot();
			innerGridPanel.add(slots[j]);
		}

		return innerGridPanel;
	}

	public JPanel carSlot() {

		JPanel slot = new JPanel();
		slot.setLayout(new BorderLayout());
		slot.setSize(80, 80);
		slot.setBackground(Color.DARK_GRAY);
		slot.setVisible(false);

		return slot;
	}

	public void PopulateGrid() {

		ArrayList<String> model_names = carpropscontroller.getAllModelNames();

		for (String model_name : model_names) {
			String car_type = carpropscontroller.getModelType(model_name);

			for (JPanel slot : slots_hash.get(car_type)) {

				if (slot.isVisible() == true) {
					continue;
				}

				Font big_font = new Font("Helvetica", Font.BOLD, 25);
				Map big_attributes = big_font.getAttributes();

				Font small_font = new Font("Helvetica", Font.BOLD, 15);
				Map small_attributes = small_font.getAttributes();

				JLabel make = new JLabel();
				make.setText(carpropscontroller.getMake(model_name));
				make.setForeground(Color.ORANGE);
				make.setHorizontalAlignment(JLabel.CENTER);
				make.setFont(big_font.deriveFont(big_attributes));

				JLabel model = new JLabel();
				model.setText(model_name);
				model.setForeground(Color.ORANGE);
				model.setHorizontalAlignment(JLabel.CENTER);
				model.setFont(big_font.deriveFont(big_attributes));

				JLabel available_trims = new JLabel();
				available_trims.setText("Available Trims: " + carpropscontroller.getNumOfTrims(model_name));
				available_trims.setForeground(Color.LIGHT_GRAY);
				available_trims.setHorizontalAlignment(JLabel.CENTER);
				available_trims.setFont(small_font.deriveFont(small_attributes));

				JLabel available_colors = new JLabel();
				available_colors.setText("Available Colors: " + carpropscontroller.getNumOfColors(model_name));
				available_colors.setForeground(Color.WHITE);
				available_colors.setHorizontalAlignment(JLabel.CENTER);
				available_colors.setFont(small_font.deriveFont(small_attributes));

				JPanel north_panel = new JPanel();
				north_panel.setLayout(new BorderLayout());
				north_panel.setBackground(Color.DARK_GRAY);
				north_panel.add(make, BorderLayout.NORTH);
				north_panel.add(model,BorderLayout.SOUTH);
				
				JPanel south_panel = new JPanel();
				south_panel.setLayout(new BorderLayout());
				south_panel.add(available_trims,BorderLayout.NORTH);
				south_panel.add(available_colors,BorderLayout.SOUTH);
				south_panel.setBackground(Color.DARK_GRAY);

				slot.add(north_panel,BorderLayout.NORTH);
				slot.add(south_panel,BorderLayout.SOUTH);

				slot.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2) {
							editcarprops = new EditCarPropertiesWindow((JFrame) SwingUtilities.getWindowAncestor(panel),
									model.getText());
							editcarprops.addWindowListener(new WindowAdapter() {
								public void windowClosed(WindowEvent e) {
									RefreshPanel();
									
								}
							});
						}
					}
				});

				slot.setVisible(true);
				break;
			}
		}
	}

	public JButton AddCarButton() {

		JButton button = new JButton("New Car Property");

		button.setBackground(Color.ORANGE);
		button.setForeground(Color.BLACK);
		button.setBounds(20, 30, 150, 30);

		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				System.out.println("New Car");
				editcarprops = new EditCarPropertiesWindow((JFrame) SwingUtilities.getWindowAncestor(panel), null);
				RefreshPanel();
			}
		});

		return button;
	}
	
	public void RefreshPanel() {
		panel.removeAll();
		mainPanel.remove(panel);
		slots_hash = new HashMap<String, JPanel[]>();
		panel = CreateVehicleGrid(carpropscontroller.getAllCarTypes());
		mainPanel.add(panel);
		PopulateGrid();
	}
	
	
}
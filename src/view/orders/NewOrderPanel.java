package view.orders;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.CarPropertiesController;
import controller.ClientController;
import controller.EmployeeController;
import controller.InventoryController;
import controller.LoginController;
import controller.OrderController;

public class NewOrderPanel extends JPanel {

	// CONTROLLERS
	OrderController ordercontroller = new OrderController();
	EmployeeController employeecontroller = new EmployeeController();
	ClientController clientcontroller = new ClientController();
	InventoryController inventorycontroller = new InventoryController();
	LoginController logincontroller = new LoginController();
	CarPropertiesController carpropscontroller = new CarPropertiesController();

	// DATA
	int basePrice, finalPrice;
	String make, model, trim, color;
	int exWarPrice = 3500, mobEyePrice = 3000, revSenPrice = 3000, winLiftPrice = 2500;

	// GUI ITEMS
	JTextField price_field;
	JComboBox<String> agent_box, client_box;
	JLabel firstName_label, lastName_label, gender_label, city_label, address_label, phoneNum_label, email_label;
	JLabel firstName, lastName, gender, city, address, phoneNum, email;
	JLabel make_label, model_label, trim_label, color_label, curr_inventory_label, curr_inventory;
	JButton check_inventory;
	JComboBox<String> make_box, model_box, trim_box, color_box;
	Font labelFont = new Font("Helvetica", Font.PLAIN, 15);
	Font clientFont = new Font("Helvetica", Font.BOLD, 15);
	JCheckBox isExtendedWarranty, isMobileEyeIncluded, isReverseSensors, isWindowLifters;
	

	NewOrderPanel() {
		this.setLayout(null);

		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y)

		// "Create New Order" -- Label
		JLabel title = new JLabel("Create New Order");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setFont(title_font);
		title.setBounds(65, 31, 520, 50);
		this.add(title);

		/// Agent Details -- Panel
		JPanel agentDetails = CreateAgentDetails();
		agentDetails.setBounds(65, 170, 400, 100);
		this.add(agentDetails);

		/// Client Details -- Panel
		JPanel clientDetails = CreateClientDetails();
		clientDetails.setBounds(65, 300, 400, 300);
		this.add(clientDetails);

		/// Car Details -- Panel
		JPanel carDetails = CreateCarDetails();
		carDetails.setBounds(65, 630, 400, 300);
		this.add(carDetails);

		/// Extras -- Panel
		JPanel extras = CreateExtrasPanel();
		extras.setBounds(500, 300, 400, 250);
		this.add(extras);

		/// Prices -- Panel
		// JPanel pricesPanel = CreatePricesPanel();
		// this.add(pricesPanel);

		/// Submit Button -- Panel
		// JPanel buttons = CreateButtonsPanel();
		// this.add(buttons);

	}

	public JPanel CreateAgentDetails() {

		// Agent Details -- Panel
		JPanel agentDetails = new JPanel();
		agentDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Agent Details");
		agentDetails.setBorder(titledborder);

		agent_box = new JComboBox<String>();

		String[][] employeeMatrix = employeecontroller.getEmployeeMatrix();

		for (String[] employee : employeeMatrix) {
			agent_box.addItem(employee[2] + " " + employee[3]);
		}

		agent_box.setSelectedItem(logincontroller.getLoggedUserFullName());

		agent_box.setBounds(20, 50, 150, 30);
		agentDetails.add(agent_box);

		// Agent name
		JLabel agent_name = new JLabel("Name");
		agent_name.setBounds(20, 10, 100, 50);
		agentDetails.add(agent_name);
		return agentDetails;
	}

	public JPanel CreateClientDetails() {

		// Client Details -- Panel
		JPanel clientDetails = new JPanel();
		clientDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Client Details");
		clientDetails.setBorder(titledborder);

		client_box = new JComboBox<String>();
		String[][] clientMatrix = clientcontroller.getClientMatrix();

		client_box.addItem("Select..");
		for (String[] client : clientMatrix) {
			client_box.addItem("(" + client[0] + ") " + client[1] + " " + client[2]);
		}

		client_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				client_box.removeItem("Select..");

				int id = Integer.valueOf(clientMatrix[client_box.getSelectedIndex()][0]);
				firstName.setText(clientcontroller.getFirstName(id));
				lastName.setText(clientcontroller.getLastName(id));
				gender.setText(clientcontroller.getGender(id));
				city.setText(clientcontroller.getCity(id));
				address.setText(clientcontroller.getAddress(id));
				phoneNum.setText(clientcontroller.getPhoneNum(id));
				email.setText(clientcontroller.getEmail(id));
			}
		});

		client_box.setBounds(20, 30, 200, 30);
		clientDetails.add(client_box);

		firstName_label = new JLabel("F. Name: ");
		firstName_label.setFont(labelFont);
		firstName = new JLabel();
		firstName.setFont(clientFont);
		firstName_label.setBounds(20, 80, 100, 50);
		firstName.setBounds(100, 80, 100, 50);

		lastName_label = new JLabel("L. Name: ");
		lastName_label.setFont(labelFont);
		lastName = new JLabel();
		lastName.setFont(clientFont);
		lastName_label.setBounds(220, 80, 100, 50);
		lastName.setBounds(300, 80, 100, 50);

		gender_label = new JLabel("Gender: ");
		gender_label.setFont(labelFont);
		gender = new JLabel();
		gender.setFont(clientFont);
		gender_label.setBounds(20, 120, 100, 50);
		gender.setBounds(100, 120, 100, 50);

		city_label = new JLabel("City: ");
		city_label.setFont(labelFont);
		city = new JLabel();
		city.setFont(clientFont);
		city_label.setBounds(220, 120, 100, 50);
		city.setBounds(300, 120, 100, 50);

		address_label = new JLabel("Address: ");
		address_label.setFont(labelFont);
		address = new JLabel();
		address.setFont(clientFont);
		address_label.setBounds(20, 160, 100, 50);
		address.setBounds(100, 160, 300, 50);

		phoneNum_label = new JLabel("Phone: ");
		phoneNum_label.setFont(labelFont);
		phoneNum = new JLabel();
		phoneNum.setFont(clientFont);
		phoneNum_label.setBounds(20, 200, 100, 50);
		phoneNum.setBounds(100, 200, 100, 50);

		email_label = new JLabel("Email: ");
		email_label.setFont(labelFont);
		email = new JLabel();
		email.setFont(clientFont);
		email_label.setBounds(20, 240, 100, 50);
		email.setBounds(100, 240, 300, 50);

		clientDetails.add(firstName_label);
		clientDetails.add(firstName);
		clientDetails.add(lastName_label);
		clientDetails.add(lastName);
		clientDetails.add(gender_label);
		clientDetails.add(gender);
		clientDetails.add(city_label);
		clientDetails.add(city);
		clientDetails.add(address_label);
		clientDetails.add(address);
		clientDetails.add(phoneNum_label);
		clientDetails.add(phoneNum);
		clientDetails.add(email_label);
		clientDetails.add(email);

		return clientDetails;

	}

	public JPanel CreateCarDetails() {
		JPanel carDetails = new JPanel();
		carDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Car Details");
		carDetails.setBorder(titledborder);

		make_label = new JLabel("Make:");
		make_label.setFont(labelFont);
		model_label = new JLabel("Model:");
		model_label.setFont(labelFont);
		trim_label = new JLabel("Trim:");
		trim_label.setFont(labelFont);
		color_label = new JLabel("Color:");
		color_label.setFont(labelFont);

		make_label.setBounds(20, 30, 100, 50);
		model_label.setBounds(20, 80, 100, 50);
		trim_label.setBounds(20, 130, 100, 50);
		color_label.setBounds(20, 180, 100, 50);

		make_box = new JComboBox<String>();
		model_box = new JComboBox<String>();
		trim_box = new JComboBox<String>();
		color_box = new JComboBox<String>();

		make_box.setBounds(100, 40, 250, 30);
		model_box.setBounds(100, 90, 250, 30);
		trim_box.setBounds(100, 140, 250, 30);
		color_box.setBounds(100, 190, 250, 30);

		model_box.setEnabled(false);
		trim_box.setEnabled(false);
		color_box.setEnabled(false);

		PopulateMakerBox();

		make_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make = (String) make_box.getSelectedItem();
				PopulateModelBox();
			}
		});

		model_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model_box.getItemCount() > 0) {
					model = (String) model_box.getSelectedItem();
					PopulateTrimsAndColors();
				}
			}
		});

		trim_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (trim_box.getItemCount() > 0) {
					trim = (String) trim_box.getSelectedItem();
					trim = trim.substring(0, trim.indexOf("(") - 1);
				}
			}
		});

		color_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (color_box.getItemCount() > 0) {
					color = (String) color_box.getSelectedItem();
					
					if (color.contains("(")) {
						color = color.substring(0, color.indexOf("(")-1);	
					}					
				}
			}
		});

		carDetails.add(make_label);
		carDetails.add(model_label);
		carDetails.add(trim_label);
		carDetails.add(color_label);

		carDetails.add(make_box);
		carDetails.add(model_box);
		carDetails.add(trim_box);
		carDetails.add(color_box);

		curr_inventory_label = new JLabel("Currently in Inventory:");
		curr_inventory_label.setFont(labelFont);
		curr_inventory_label.setBounds(20, 240, 150, 50);

		curr_inventory = new JLabel();
		curr_inventory.setFont(clientFont);
		curr_inventory.setBounds(180, 240, 50, 50);
		curr_inventory.setEnabled(false);

		check_inventory = new JButton("Check");
		check_inventory.setBounds(250, 250, 100, 30);
		check_inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInventory();
			}
		});

		carDetails.add(curr_inventory_label);
		carDetails.add(curr_inventory);
		carDetails.add(check_inventory);

		return carDetails;
	}

	public JPanel CreateExtrasPanel() {
		JPanel extrasPanel = new JPanel();

		extrasPanel.setLayout(new GridLayout(4,1,5,5));
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Extras");
		extrasPanel.setBorder(titledborder);

		// 	int exWarPrice = 3500, mobEyePrice = 3000, revSenPrice = 3000, winLiftPrice = 2500;
		isExtendedWarranty = new JCheckBox("3-Year warranty (+" + NumberFormat.getIntegerInstance().format(exWarPrice) + "₪)");
		isMobileEyeIncluded = new JCheckBox("MobileEye (+" + NumberFormat.getIntegerInstance().format(mobEyePrice) + "₪)");
		isReverseSensors = new JCheckBox("Reverse Parking Sensors (+" + NumberFormat.getIntegerInstance().format(revSenPrice) + "₪)");
		isWindowLifters = new JCheckBox("Window Lifters (+" + NumberFormat.getIntegerInstance().format(winLiftPrice) + "₪)");
		
		isExtendedWarranty.setFont(labelFont);
		isMobileEyeIncluded.setFont(labelFont);
		isReverseSensors.setFont(labelFont);
		isWindowLifters.setFont(labelFont);
		
		//isExtendedWarranty.setb
		
		
		extrasPanel.add(isExtendedWarranty);
		extrasPanel.add(isMobileEyeIncluded);
		extrasPanel.add(isReverseSensors);
		extrasPanel.add(isWindowLifters);
		
		
		return extrasPanel;
	}

	public JPanel CreatePricesPanel() {
		JPanel pricesPanel = new JPanel();

		pricesPanel.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Car Details");
		pricesPanel.setBorder(titledborder);
		pricesPanel.setBounds(65, 530, 400, 250);

		return pricesPanel;
	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(65, 1000, 1000, 70);

		JButton saveButton = new JButton("Save Order");
		saveButton.setBackground(Color.GREEN);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(800, 0, 120, 45);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		buttonsPanel.add(saveButton);
		buttonsPanel.add(clearButton);
		return buttonsPanel;
	}

	public void PopulateMakerBox() {

		ArrayList<String> make_names = carpropscontroller.getAllMakeNames();
		make_box.addItem("Select..");

		for (String name : make_names) {
			make_box.addItem(name);
		}
	}

	public void PopulateModelBox() {

		String make = (String) make_box.getSelectedItem();

		ArrayList<String> model_names = carpropscontroller.getModelsByMaker(make);

		if (!make_box.getSelectedItem().equals("Select..")) {
			model_box.setEnabled(true);
			for (String model : model_names) {
				model_box.addItem(model);
			}

		} else {

			model_box.removeAllItems();
			model_box.setEnabled(false);
			trim_box.removeAllItems();
			trim_box.setEnabled(false);
			color_box.removeAllItems();
			color_box.setEnabled(false);

		}

	}

	public void PopulateTrimsAndColors() {

		if (model_box.isEnabled()) {

			trim_box.removeAllItems();
			color_box.removeAllItems();

			String model = (String) model_box.getSelectedItem();

			Map<String, Integer> trims = carpropscontroller.getTrimsMap(model);
			List<String> colors = carpropscontroller.getColors(model);

			color_box.setEnabled(true);
			trim_box.setEnabled(true);

			for (Map.Entry<String, Integer> entry : trims.entrySet()) {
				String price = NumberFormat.getIntegerInstance().format(entry.getValue()) + "₪";
				trim_box.addItem(entry.getKey() + " (" + price + ")");
			}

			int colorPrice = carpropscontroller.getColorPrice(model);

			for (String color : colors) {

				if (color.equals(carpropscontroller.getDefaultColor(model))) {

					color_box.addItem(color);

				} else {
					color_box.addItem(color + " (+" + colorPrice + "₪)");
				}
			}

		}

	}

	public void CheckInventory() {
		int quantity = inventorycontroller.getQuantity(make, model, trim, color);
		
		curr_inventory.setVisible(true);

		
		if (quantity == 1 || quantity == 2) {
			curr_inventory_label.setForeground(Color.ORANGE);
		}
		
		if (quantity == 0) {
			curr_inventory_label.setForeground(Color.RED);
		}
		
		curr_inventory.setText(Integer.toString(quantity));
	}

}

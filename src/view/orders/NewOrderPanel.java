package view.orders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.CarPropertiesController;
import controller.ClientController;
import controller.EmployeeController;
import controller.InventoryController;
import controller.LoginController;
import controller.OrderController;
import model.InputValidation.InputValidationException;

public class NewOrderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// CONTROLLERS
	OrderController ordercontroller = new OrderController();
	EmployeeController employeecontroller = new EmployeeController();
	ClientController clientcontroller = new ClientController();
	InventoryController inventorycontroller = new InventoryController();
	LoginController logincontroller = new LoginController();
	CarPropertiesController carpropscontroller = new CarPropertiesController();

	// DATA
	int basePrice = 0, colorPrice = 0, totalPrice = 0, discount = 0, finalPrice = 0;
	String make, model, trim, color, discountType = "Cash";
	int exWarPrice = 3500, mobEyePrice = 3000, revSenPrice = 3000, winLiftPrice = 2500;
	int client_id;

	// GUI ITEMS
	JTextField price_field, discount_field;
	JComboBox<String> agent_box, client_box;
	JLabel firstName_label, lastName_label, gender_label, city_label, address_label, phoneNum_label, email_label;
	JLabel firstName, lastName, gender, city, address, phoneNum, email;
	JLabel make_label, model_label, trim_label, color_label, curr_inventory_label, curr_inventory;
	JLabel discount_sign;
	JButton check_inventory, applyDiscount;
	JComboBox<String> make_box, model_box, trim_box, color_box;
	Font labelFont = new Font("Helvetica", Font.PLAIN, 15);
	Font clientFont = new Font("Helvetica", Font.BOLD, 15);
	JCheckBox isExtendedWarranty, isMobileEyeIncluded, isReverseSensors, isWindowLifters;
	JPanel MainOrderPanel, pricePanel, titlePanel;
	JRadioButton percent_rdiobtn, cash_rdiobtn;

	JLabel basePrice_label, colorPrice_label, exWar_label, mobEye_label, revSen_label, winLift_label, totalPrice_label,
			finalPrice_label, discount_label;
	JLabel prices_basePrice, prices_colorPrice, prices_exWar, prices_mobEye, prices_revSen, prices_winLift,
			prices_totalPrice, prices_discount, prices_finalPrice;

	NewOrderPanel() {
		this.setLayout(new BorderLayout());

		JPanel orderContainerPanel = new JPanel();
		orderContainerPanel.setLayout(new BorderLayout());

		MainOrderPanel = new JPanel();
		MainOrderPanel.setLayout(new GridLayout(3, 2, 10, 10));

		pricePanel = CreatePricesPanel();
		titlePanel = CreateTitlePanel();

		/// Agent Details -- Panel
		JPanel agentDetails = CreateAgentDetails();
		MainOrderPanel.add(agentDetails);

		/// Client Details -- Panel
		JPanel clientDetails = CreateClientDetails();
		MainOrderPanel.add(clientDetails);

		MainOrderPanel.add(new JPanel()); // Empty space filler

		/// Car Details -- Panel
		JPanel carDetails = CreateCarDetails();
		MainOrderPanel.add(carDetails);

		/// Extras -- Panel
		JPanel extras = CreateExtrasPanel();
		MainOrderPanel.add(extras);

		MainOrderPanel.add(new JPanel()); // Empty space filler

		/// Discount -- Panel
		JPanel discountPanel = CreateDiscountPanel();
		MainOrderPanel.add(discountPanel);

		MainOrderPanel.add(new JPanel()); // Empty space filler
		MainOrderPanel.add(new JPanel()); // Empty space filler

		orderContainerPanel.add(MainOrderPanel, BorderLayout.CENTER);

		this.add(titlePanel, BorderLayout.NORTH);
		this.add(orderContainerPanel, BorderLayout.CENTER);
		this.add(pricePanel, BorderLayout.EAST);

	}

	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  Create New Order");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
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

				client_id = Integer.valueOf(clientMatrix[client_box.getSelectedIndex()][0]);
				firstName.setText(clientcontroller.getFirstName(client_id));
				lastName.setText(clientcontroller.getLastName(client_id));
				gender.setText(clientcontroller.getGender(client_id));
				city.setText(clientcontroller.getCity(client_id));
				address.setText(clientcontroller.getAddress(client_id));
				phoneNum.setText(clientcontroller.getPhoneNum(client_id));
				email.setText(clientcontroller.getEmail(client_id));
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
					basePrice = carpropscontroller.getPrice(model, trim);
					prices_basePrice.setText(priceFormatter(basePrice));
					updatePrices();
				}
			}
		});

		color_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (color_box.getItemCount() > 0) {
					color = (String) color_box.getSelectedItem();

					if (color.contains("(")) {
						color = color.substring(0, color.indexOf("(") - 1);
						colorPrice = carpropscontroller.getColorPrice(model);
					} else {
						colorPrice = 0;

					}
					prices_colorPrice.setText(priceFormatter(colorPrice));
					updatePrices();
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

		extrasPanel.setLayout(new GridLayout(5, 1, 5, 5));
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Extras");
		extrasPanel.setBorder(titledborder);

		// int exWarPrice = 3500, mobEyePrice = 3000, revSenPrice = 3000, winLiftPrice =
		// 2500;
		isExtendedWarranty = new JCheckBox("3-Year Warranty (+" + priceFormatter(exWarPrice) + ")");
		isMobileEyeIncluded = new JCheckBox("MobileEye (+" + priceFormatter(mobEyePrice) + ")");
		isReverseSensors = new JCheckBox("Reverse Parking Sensors (+" + priceFormatter(revSenPrice) + ")");
		isWindowLifters = new JCheckBox("Window Lifters (+" + priceFormatter(winLiftPrice) + ")");

		isExtendedWarranty.setFont(labelFont);
		isMobileEyeIncluded.setFont(labelFont);
		isReverseSensors.setFont(labelFont);
		isWindowLifters.setFont(labelFont);

		ActionListener updatePrices = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePrices();
			}
		};

		isExtendedWarranty.addActionListener(updatePrices);
		isMobileEyeIncluded.addActionListener(updatePrices);
		isReverseSensors.addActionListener(updatePrices);
		isWindowLifters.addActionListener(updatePrices);

		extrasPanel.add(isExtendedWarranty);
		extrasPanel.add(isMobileEyeIncluded);
		extrasPanel.add(isReverseSensors);
		extrasPanel.add(isWindowLifters);

		return extrasPanel;
	}

	public JPanel CreateDiscountPanel() {
		JPanel discountPanel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Discount");
		discountPanel.setBorder(titledborder);
		discountPanel.setLayout(null);

		JLabel chooseDiscount = new JLabel("Discount Type: ");
		chooseDiscount.setFont(labelFont);
		chooseDiscount.setBounds(20, 20, 200, 50);

		ButtonGroup bg = new ButtonGroup();
		cash_rdiobtn = new JRadioButton("Cash", true);
		percent_rdiobtn = new JRadioButton("Percent");
		bg.add(percent_rdiobtn);
		bg.add(cash_rdiobtn);

		cash_rdiobtn.setBounds(20, 60, 100, 50);
		cash_rdiobtn.setFont(clientFont);

		cash_rdiobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				discount_sign.setText("$");
				discountType = "Cash";
			}
		});

		percent_rdiobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				discount_sign.setText("%");
				discountType = "Percent";
			}
		});

		percent_rdiobtn.setBounds(120, 60, 100, 50);
		percent_rdiobtn.setFont(clientFont);

		discount_field = new JTextField("0");
		discount_field.setBounds(20, 120, 50, 30);

		applyDiscount = new JButton("Apply");
		applyDiscount.setBounds(20, 180, 100, 30);

		applyDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				applyDiscount();
			}
		});

		discount_sign = new JLabel("$");
		discount_sign.setBounds(80, 120, 20, 30);

		discountPanel.add(percent_rdiobtn);
		discountPanel.add(cash_rdiobtn);
		discountPanel.add(chooseDiscount);
		discountPanel.add(discount_field);
		discountPanel.add(discount_sign);
		discountPanel.add(applyDiscount);

		return discountPanel;
	}

	public JPanel CreatePricesPanel() {
		JPanel pricesPanel = new JPanel();
		pricesPanel.setLayout(new BorderLayout());
		pricesPanel.setBackground(Color.LIGHT_GRAY);
		pricesPanel.setPreferredSize(new Dimension(500, Integer.MAX_VALUE));

		JPanel innerPricesPanel = new JPanel();
		innerPricesPanel.setLayout(null);
		innerPricesPanel.setBackground(Color.LIGHT_GRAY);

		basePrice_label = new JLabel("Base Price:");
		colorPrice_label = new JLabel("Extra Color:");
		JLabel extras_label = new JLabel("Extras:");
		exWar_label = new JLabel("Extended Warranty:");
		mobEye_label = new JLabel("Mobile Eye:");
		revSen_label = new JLabel("Revrse Parking Sensors:");
		winLift_label = new JLabel("Window Lifters:");

		prices_basePrice = new JLabel("0$", SwingConstants.RIGHT);
		prices_colorPrice = new JLabel("0$", SwingConstants.RIGHT);
		prices_exWar = new JLabel("0$", SwingConstants.RIGHT);
		prices_mobEye = new JLabel("0$", SwingConstants.RIGHT);
		prices_revSen = new JLabel("0$", SwingConstants.RIGHT);
		prices_winLift = new JLabel("0$", SwingConstants.RIGHT);

		basePrice_label.setFont(new Font("Helvetica", Font.BOLD, 30));
		colorPrice_label.setFont(new Font("Helvetica", Font.BOLD, 15));
		extras_label.setFont(new Font("Helvetica", Font.BOLD, 30));
		exWar_label.setFont(new Font("Helvetica", Font.BOLD, 15));
		mobEye_label.setFont(new Font("Helvetica", Font.BOLD, 15));
		revSen_label.setFont(new Font("Helvetica", Font.BOLD, 15));
		winLift_label.setFont(new Font("Helvetica", Font.BOLD, 15));

		prices_basePrice.setFont(new Font("Helvetica", Font.BOLD, 30));
		prices_colorPrice.setFont(new Font("Helvetica", Font.BOLD, 15));
		prices_exWar.setFont(new Font("Helvetica", Font.BOLD, 15));
		prices_mobEye.setFont(new Font("Helvetica", Font.BOLD, 15));
		prices_revSen.setFont(new Font("Helvetica", Font.BOLD, 15));
		prices_winLift.setFont(new Font("Helvetica", Font.BOLD, 15));

		int height = 0;
		int price_xDist = 220;

		basePrice_label.setBounds(10, height += 50, 250, 50);
		prices_basePrice.setBounds(price_xDist, height, 250, 50);
		colorPrice_label.setBounds(10, height += 50, 250, 50);
		prices_colorPrice.setBounds(price_xDist, height, 250, 50);
		extras_label.setBounds(10, height += 100, 250, 50);
		exWar_label.setBounds(10, height += 50, 250, 50);
		prices_exWar.setBounds(price_xDist, height, 250, 50);
		mobEye_label.setBounds(10, height += 50, 250, 50);
		prices_mobEye.setBounds(price_xDist, height, 250, 50);
		revSen_label.setBounds(10, height += 50, 250, 50);
		prices_revSen.setBounds(price_xDist, height, 250, 50);
		winLift_label.setBounds(10, height += 50, 250, 50);
		prices_winLift.setBounds(price_xDist, height, 250, 50);

		innerPricesPanel.add(basePrice_label);
		innerPricesPanel.add(colorPrice_label);
		innerPricesPanel.add(extras_label);
		innerPricesPanel.add(exWar_label);
		innerPricesPanel.add(mobEye_label);
		innerPricesPanel.add(revSen_label);
		innerPricesPanel.add(winLift_label);

		innerPricesPanel.add(prices_basePrice);
		innerPricesPanel.add(prices_colorPrice);
		innerPricesPanel.add(prices_exWar);
		innerPricesPanel.add(prices_mobEye);
		innerPricesPanel.add(prices_revSen);
		innerPricesPanel.add(prices_winLift);

		JPanel separator = new JPanel();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, height += 100, 470, 2);
		innerPricesPanel.add(separator);

		totalPrice_label = new JLabel("Total:");
		totalPrice_label.setFont(new Font("Helvetica", Font.BOLD, 30));
		totalPrice_label.setBounds(10, height += 30, 250, 50);

		prices_totalPrice = new JLabel("0$", SwingConstants.RIGHT);
		prices_totalPrice.setFont(new Font("Helvetica", Font.BOLD, 30));
		prices_totalPrice.setBounds(price_xDist, height, 250, 50);

		innerPricesPanel.add(totalPrice_label);
		innerPricesPanel.add(prices_totalPrice);

		discount_label = new JLabel("Discount:");
		discount_label.setFont(new Font("Helvetica", Font.BOLD, 20));
		discount_label.setBounds(10, height += 60, 250, 50);

		prices_discount = new JLabel("0", SwingConstants.RIGHT);
		prices_discount.setFont(new Font("Helvetica", Font.BOLD, 20));
		prices_discount.setBounds(price_xDist, height, 250, 50);

		innerPricesPanel.add(discount_label);
		innerPricesPanel.add(prices_discount);

		JPanel separator2 = new JPanel();
		separator2.setBackground(Color.DARK_GRAY);
		separator2.setBounds(10, height += 80, 470, 2);
		innerPricesPanel.add(separator2);

		finalPrice_label = new JLabel("Final:");
		finalPrice_label.setFont(new Font("Helvetica", Font.BOLD, 40));
		finalPrice_label.setBounds(10, height += 60, 250, 50);

		prices_finalPrice = new JLabel("0$", SwingConstants.RIGHT);
		prices_finalPrice.setFont(new Font("Helvetica", Font.BOLD, 40));
		prices_finalPrice.setBounds(price_xDist, height, 250, 50);

		innerPricesPanel.add(finalPrice_label);
		innerPricesPanel.add(prices_finalPrice);

		pricesPanel.add(innerPricesPanel, BorderLayout.CENTER);
		JPanel ButtonsPanel = CreateButtonsPanel();
		pricesPanel.add(ButtonsPanel, BorderLayout.SOUTH);

		return pricesPanel;
	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.DARK_GRAY);

		JButton saveButton = new JButton("Save Order");
		saveButton.setBackground(Color.ORANGE);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 250, 80);
		saveButton.setPreferredSize(new Dimension(260,70));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Validator()) {
					PlaceOrder();
					JOptionPane.showMessageDialog(null, "Order placed successfully");

				}
			}
		});

		JPanel spacing_panel = new JPanel();
		spacing_panel.setBackground(Color.RED);
		spacing_panel.setPreferredSize(new Dimension(0, 100));

		buttonsPanel.add(saveButton);
		buttonsPanel.add(spacing_panel);
		return buttonsPanel;
	}

///////////////////////// HELP METHODS ////////////////////

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
			model_box.removeAllItems();
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
				trim_box.addItem(entry.getKey() + " (" + priceFormatter(entry.getValue()) + ")");
			}

			int colorPrice = carpropscontroller.getColorPrice(model);

			for (String color : colors) {

				if (color.equals(carpropscontroller.getDefaultColor(model))) {

					color_box.addItem(color);

				} else {
					color_box.addItem(color + " (+" + colorPrice + "$)");
				}
			}

		}

	}

	public void CheckInventory() {

		if (make == null || model == null) {
			return;
		}

		int quantity = inventorycontroller.getQuantity(make, model, trim, color);

		curr_inventory.setVisible(true);

		if (quantity > 0) {
			curr_inventory_label.setForeground(Color.GREEN);
		}

		if (quantity == 0) {
			curr_inventory_label.setForeground(Color.RED);
		}

		curr_inventory.setForeground(Color.YELLOW);
		curr_inventory.setText(Integer.toString(quantity));
	}

	public void updatePrices() {

		totalPrice = 0;
		finalPrice = 0;

		prices_basePrice.setText(priceFormatter(basePrice));
		prices_colorPrice.setText(priceFormatter(colorPrice));

		totalPrice += basePrice;
		totalPrice += colorPrice;

		if (isExtendedWarranty.isSelected()) {
			prices_exWar.setText(priceFormatter(exWarPrice));

			totalPrice += exWarPrice;
		} else {
			prices_exWar.setText("0$");
		}

		if (isMobileEyeIncluded.isSelected()) {
			prices_mobEye.setText(priceFormatter(mobEyePrice));

			totalPrice += mobEyePrice;
		} else {
			prices_mobEye.setText("0$");
		}

		if (isReverseSensors.isSelected()) {
			prices_revSen.setText(priceFormatter(revSenPrice));
			totalPrice += revSenPrice;
		} else {
			prices_revSen.setText("0$");
		}

		if (isWindowLifters.isSelected()) {
			prices_winLift.setText(priceFormatter(winLiftPrice));
			totalPrice += winLiftPrice;
		} else {
			prices_winLift.setText("0$");
		}

		prices_discount.setText(priceFormatter(discount));
		prices_totalPrice.setText(priceFormatter(totalPrice));
		finalPrice = totalPrice - discount;
		prices_finalPrice.setText(priceFormatter(finalPrice));

	}

	public String priceFormatter(int num) {

		String formatted_string = NumberFormat.getIntegerInstance().format(num) + "$";
		return formatted_string;
	}

	public void PlaceOrder() {

		int agentId = logincontroller.getLoggedUserId();
		int warrantyPrice = isExtendedWarranty.isSelected() ? exWarPrice : 0;
		int mobileEyePrice = isMobileEyeIncluded.isSelected() ? mobEyePrice : 0;
		int reverseSensorsPrice = isReverseSensors.isSelected() ? revSenPrice : 0;
		int windowLiftersPrice = isWindowLifters.isSelected() ? winLiftPrice : 0;

		try {
			ordercontroller.createOrder(client_id, agentId, make, model, trim, color, basePrice, totalPrice, discount,
					finalPrice, warrantyPrice, mobileEyePrice, reverseSensorsPrice, windowLiftersPrice);
		} catch (InputValidationException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			e.printStackTrace();
		}

	}

	public boolean Validator() {

		if (client_box.getSelectedItem().equals("Select..")) {
			JOptionPane.showMessageDialog(null, "Error: Please select a client");
			return false;
		}

		if (make_box.getSelectedItem().equals("Select..")) {
			JOptionPane.showMessageDialog(null, "Error: Please select a car");
			return false;
		}

		int numInInventory = inventorycontroller.getQuantity(make, model, trim, color);
		if (numInInventory == 0) {
			JOptionPane.showMessageDialog(null, "Error: Car not in inventory");
			return false;
		}

		return true;
	}

	public void applyDiscount() {

		int current_value = Integer.parseInt(discount_field.getText());

		if (discountType.equals("Percent")) {
			if (current_value > 100) {
				discount_field.setText("100");
			}

			if (current_value < 0) {
				discount_field.setText("0");
			}
			discount = totalPrice * Integer.parseInt(discount_field.getText()) / 100;

		}

		if (discountType.equals("Cash")) {
			if (current_value > totalPrice) {
				discount_field.setText(String.valueOf(totalPrice));
			}

			if (current_value < 0) {
				discount_field.setText("0");
			}
			discount = Integer.parseInt(discount_field.getText());
		}

		updatePrices();

	}

}

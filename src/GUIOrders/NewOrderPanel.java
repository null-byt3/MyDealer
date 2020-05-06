package GUIOrders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.border.*;
import javax.swing.*;


import Order.Order;
import database.OrderDB;
import Client.Client;
import database.ClientDB;
import Employee.Employee;
import database.EmployeeDB;
import Car.Car;
import database.InventoryDB;
import database.Serializer;

public class NewOrderPanel extends JPanel {

	OrderDB orderdb = null;
	EmployeeDB employeedb = null;
	ClientDB clientdb = null;
	InventoryDB inventorydb = null;
	JTextField price_field;

	
	NewOrderPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y) 
		
		// "Create New Order" -- Label
		JLabel title = new JLabel("Create New Order");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		
		/// Agent Details -- Panel
		JPanel agentDetails = CreateAgentDetails();
		this.add(agentDetails);
		
		/// Client Details -- Panel
		JPanel clientDetails = CreateClientDetails();
		this.add(clientDetails);
		
		/// Car Details -- Panel
		JPanel carDetails = CreateCarDetails();
		this.add(carDetails);
		
		/// Submit Button -- Panel
		JPanel buttons = CreateButtonsPanel();
		this.add(buttons);

	}

	public JPanel CreateAgentDetails() {
			
		// Agent Details -- Panel
		JPanel agentDetails = new JPanel();
		agentDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Agent Details");
		agentDetails.setBorder(titledborder);
		agentDetails.setBounds(65,120,400,100);
		agentDetails.setBackground(Color.WHITE);
		
		JComboBox<String> comboBox1 = new JComboBox<String>();
		Serializer serializer = new Serializer();
		try {
			employeedb = (EmployeeDB) serializer.deserialize("EmployeeDB.db");
			} catch (Exception e) {
				System.out.println("NewClientPanel Error -> Cannot deserialize EmployeeDB");
			}
		
		for (Employee employee : employeedb) {
			comboBox1.addItem(employee.getFullName());
		}		
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		
		comboBox1.setBounds(20, 50, 150, 30);
		agentDetails.add(comboBox1);
		
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
		clientDetails.setBounds(65,250,400,100);
		clientDetails.setBackground(Color.WHITE);
		
		JComboBox<String> comboBox2 = new JComboBox<String>();
		Serializer serializer = new Serializer();
		try {
			clientdb = (ClientDB) serializer.deserialize("ClientDB.db");
			} catch (Exception e) {
				System.out.println("NewOrderPanel Error -> Cannot deserialize ClientDB");
			}
		
		for (Client client : clientdb) {
			comboBox2.addItem(client.getFullName());
		}
		
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		
		comboBox2.setBounds(20, 50, 150, 30);
		clientDetails.add(comboBox2);
		
		// Client name
		JLabel client_name = new JLabel("Name");
		client_name.setBounds(20, 10, 100, 50);
		clientDetails.add(client_name);		
		return clientDetails;
	}
	
	
	public JPanel CreateCarDetails() {
		JPanel carDetails = new JPanel();
		carDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Car Details");
		carDetails.setBorder(titledborder);
		carDetails.setBounds(65,380,400,250);
		carDetails.setBackground(Color.WHITE);
		
		JComboBox<String> comboBox3 = new JComboBox<String>();
		JComboBox<String> comboBox4 = new JComboBox<String>();
		JComboBox<String> comboBox5 = new JComboBox<String>();
		JComboBox<String> comboBox6 = new JComboBox<String>();
		JComboBox<String> comboBox7 = new JComboBox<String>();
		JComboBox<String> comboBox8 = new JComboBox<String>();


		Serializer serializer = new Serializer();
		
		try {
			inventorydb = (InventoryDB) serializer.deserialize("InventoryDB.db");
			} catch (Exception e) {
				System.out.println("NewOrderPanel Error -> Cannot deserialize InventoryDB");
			}
		
		// Make
		{
		for (Car car : inventorydb) {
			comboBox3.addItem(car.getMake());
		}
		
		comboBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			}
		});
		comboBox3.setBounds(20, 45, 150, 30);
		carDetails.add(comboBox3);
		JLabel make = new JLabel("Make");
		make.setBounds(20, 10, 100, 50);
		carDetails.add(make);
		}
		
		// Model 
		{
		for (Car car : inventorydb) {
			comboBox4.addItem(car.getModel());
		}
		
		comboBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});	
		comboBox4.setBounds(200, 45, 150, 30);
		carDetails.add(comboBox4);
		JLabel model = new JLabel("Model");
		model.setBounds(200, 10, 100, 50);
		carDetails.add(model);
	}
		
		
		// Trim 
		{
		for (Car car : inventorydb) {
			comboBox5.addItem(car.getTrim());
		}
		comboBox5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});	
		comboBox5.setBounds(20, 95, 150, 30);
		carDetails.add(comboBox5);
		JLabel trim = new JLabel("Trim");
		trim.setBounds(20, 60, 100, 50);
		carDetails.add(trim);
		}
		
		// Color
		{
		for (Car car : inventorydb) {
			comboBox6.addItem(car.getColor());
		}
		comboBox6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});	
		comboBox6.setBounds(200, 95, 150, 30);
		carDetails.add(comboBox6);
		JLabel color = new JLabel("Color");
		color.setBounds(200, 60, 100, 50);
		carDetails.add(color);
		}
		
		// Location
		{
		for (Car car : inventorydb) {
			comboBox7.addItem(car.getLocation());
		}
		comboBox7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});	
		comboBox7.setBounds(20, 145, 150, 30);
		carDetails.add(comboBox7);
		JLabel location = new JLabel("Location");
		location.setBounds(20, 110, 100, 50);
		carDetails.add(location);
		}
		
		// Status
		{
		for (Car car : inventorydb) {
			comboBox8.addItem(car.getStatus());
		}
		comboBox8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});	
		comboBox8.setBounds(200, 145, 150, 30);
		carDetails.add(comboBox8);
		JLabel status = new JLabel("Status");
		status.setBounds(200, 110, 100, 50);
		carDetails.add(status);
		}
		
		// Price
		{
		JLabel price = new JLabel("Price:");
		price_field = new JTextField();
		price.setBounds(20, 160, 100, 50);
		price_field.setBounds(20, 195, 150, 30);
		carDetails.add(price);		
		carDetails.add(price_field);
		}
		
		return carDetails;
	}
	
	public JPanel CreateButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(550,585,120,45);
		buttonsPanel.setBackground(Color.WHITE);
		
		JButton saveButton = new JButton("Save Order");
		saveButton.setBackground(Color.GREEN);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
					//JOptionPane.showMessageDialog(null, "Data Missing");
				//else		
				//JOptionPane.showMessageDialog(null, "Data Submitted");
			}
		});
		
		
		buttonsPanel.add(saveButton);	
		return buttonsPanel;
	}
		
}
	
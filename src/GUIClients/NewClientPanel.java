package GUIClients;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.border.*;
import javax.swing.*;


import Employee.Employee;
import database.EmployeeDB;
import database.Serializer;

public class NewClientPanel extends JPanel {

	private Employee current_user;
	EmployeeDB employeedb = null;
	JTextField firstName_field;
	JTextField lastName_field;
	JRadioButton male;
	JRadioButton female;
	JTextField city_field;
	JTextField address_field;
	JTextField phoneNum_field;
	JTextField email_field;
	
	NewClientPanel(Employee current_user) {
		this.current_user = current_user;
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y) 
		
		// "Create New Client" -- Label
		JLabel title = new JLabel("Create New Client");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		
		/// Agent Details -- Panel
		JPanel agentDetails = CreateAgentDetails(current_user);
		this.add(agentDetails);
		
		
		/// Client Details -- Panel
		JPanel clientDetails = CreateClientDetails();
		this.add(clientDetails);
		
		/// Submit & Clear Buttons -- Panel
		JPanel buttons = CreateButtonsPanel();
		this.add(buttons);

	}
	
	public JPanel CreateAgentDetails(Employee current_user) {
			
		// Agent Details -- Panel
		JPanel agentDetails = new JPanel();
		agentDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Agent Details");
		agentDetails.setBorder(titledborder);
		agentDetails.setBounds(65,120,400,100);
		agentDetails.setBackground(Color.WHITE);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		Serializer serializer = new Serializer();
		try {
			employeedb = (EmployeeDB) serializer.deserialize("EmployeeDB.db");
			} catch (Exception e) {
				System.out.println("NewClientPanel Error -> Cannot deserialize EmployeeDB");
			}
		
		for (Employee employee : employeedb) {
			comboBox.addItem(employee.getFullName());
		}
		
		comboBox.setSelectedItem(current_user.getFullName());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		comboBox.setBounds(20, 50, 150, 30);
		agentDetails.add(comboBox);
		
		// Agent name
		JLabel agent_name = new JLabel("Name");
		agent_name.setBounds(20, 10, 100, 50);
		agentDetails.add(agent_name);		
		return agentDetails;
	}
	
	
	public JPanel CreateClientDetails() {
		
		JPanel clientDetails = new JPanel();
		clientDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Client Details");
		clientDetails.setBorder(titledborder);
		clientDetails.setBounds(65,250,650,320);
		clientDetails.setBackground(Color.WHITE);
		
		
		// FIRST NAME
		JLabel first_name = new JLabel("First Name:");
		firstName_field = new JTextField();
		first_name.setBounds(20, 10, 100, 50);
		firstName_field.setBounds(20, 50, 150, 30);
		clientDetails.add(first_name);		
		clientDetails.add(firstName_field);
		
		// LAST NAME
		JLabel last_name = new JLabel("Last Name:");
		lastName_field = new JTextField();
		last_name.setBounds(220, 10, 100, 50);
		lastName_field.setBounds(220, 50, 150, 30);
		clientDetails.add(last_name);		
		clientDetails.add(lastName_field);
		
		// GENDER
		JLabel gender = new JLabel("Gender:");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		gender.setBounds(420, 10, 100, 50);
		male.setBounds(420, 50, 60, 30);
		male.setBackground(Color.WHITE);
		female.setBounds(480, 50, 90, 30);
		female.setBackground(Color.WHITE);
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				female.setSelected(false);
			}
		});
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				male.setSelected(false);
			}
		});
		clientDetails.add(gender);		
		clientDetails.add(male);
		clientDetails.add(female);
		
		
		
		// CITY
		JLabel city = new JLabel("City:");
		city_field = new JTextField();
		city.setBounds(20, 80, 100, 50);
		city_field.setBounds(20, 120, 150, 30);
		clientDetails.add(city);		
		clientDetails.add(city_field);
		
		// Address
		JLabel address = new JLabel("Address:");
		address_field = new JTextField();
		address.setBounds(220, 80, 100, 50);
		address_field.setBounds(220, 120, 300, 30);
		clientDetails.add(address);		
		clientDetails.add(address_field);
		
		// Phone Number
		JLabel phoneNum = new JLabel("Phone Number:");
		JLabel hyphen = new JLabel("-");
		phoneNum_field = new JTextField();
		String[] prefix_string = {"02","03","04","07","08","09","050","052","053","054","055","058"};
		JComboBox phonePrefix = new JComboBox(prefix_string);	
		phoneNum.setBounds(20, 150, 100, 50);
		phonePrefix.setBounds(20, 190, 50, 30);
		hyphen.setBounds(77, 195, 10, 10);
		phoneNum_field.setBounds(90, 190, 230, 30);
		clientDetails.add(phonePrefix);
		clientDetails.add(phoneNum);	
		clientDetails.add(hyphen);
		clientDetails.add(phoneNum_field);
		
		
		
		
		// EMAIL
		JLabel email = new JLabel("E-Mail:");
		email_field = new JTextField();
		email.setBounds(20, 220, 100, 50);
		email_field.setBounds(20, 260, 300, 30);
		clientDetails.add(email);		
		clientDetails.add(email_field);
		
		
		return clientDetails;
	}
	
	
	public JPanel CreateButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(65,600,800,150);
		buttonsPanel.setBackground(Color.WHITE);
		
		JButton saveButton = new JButton("Save Client");
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
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.setForeground(Color.BLACK);
		clearButton.setBounds(530, 0, 120, 45);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstName_field.setText(null);
				lastName_field.setText(null);
				male.setSelected(false);
				female.setSelected(false);
				city_field.setText(null);
				address_field.setText(null);
				phoneNum_field.setText(null);
				email_field.setText(null);
				//comboBox.setSelectedItem("Select");
			}
		});
		
		
		
		
		buttonsPanel.add(saveButton);	
		buttonsPanel.add(clearButton);
		return buttonsPanel;
	}
		
}
	
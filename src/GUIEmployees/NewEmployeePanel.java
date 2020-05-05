package GUIEmployees;

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

public class NewEmployeePanel extends JPanel {

	private Employee current_user;
	EmployeeDB employeedb = null;
	JTextField firstName_field;
	JTextField lastName_field;
	JRadioButton male;
	JRadioButton female;
	JTextField username_field;
	JTextField password_field;
	JTextField salary_field;
	JTextField job_field;
	
	
	NewEmployeePanel(Employee current_user) {
		this.current_user = current_user;
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y) 
		
		// "Create New Client" -- Label
		JLabel title = new JLabel("Create New Employee");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		
		/// Employee Details -- Panel
		JPanel employeeDetails = CreateEmployeeDetails();
		this.add(employeeDetails);
		
		/// Submit & Clear Buttons -- Panel
		JPanel buttons = CreateButtonsPanel();
		this.add(buttons);

	}
	
	
	
	public JPanel CreateEmployeeDetails() {
		
		JPanel employeeDetails = new JPanel();
		employeeDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Employee Details");
		employeeDetails.setBorder(titledborder);
		employeeDetails.setBounds(65,250,650,320);
		employeeDetails.setBackground(Color.WHITE);
		
		// job -Manger,Secretary,Agent
		JLabel job = new JLabel("Job:");
		job_field = new JTextField();
		job.setBounds(20, 160, 100, 50);
		job_field.setBounds(20, 200, 150, 30);
		employeeDetails.add(job);		
		employeeDetails.add(job_field);
		
		
		// FIRST NAME
		JLabel first_name = new JLabel("First Name:");
		firstName_field = new JTextField();
		first_name.setBounds(20, 10, 100, 50);
		firstName_field.setBounds(20, 50, 150, 30);
		employeeDetails.add(first_name);		
		employeeDetails.add(firstName_field);
		
		// LAST NAME
		JLabel last_name = new JLabel("Last Name:");
		lastName_field = new JTextField();
		last_name.setBounds(220, 10, 100, 50);
		lastName_field.setBounds(220, 50, 150, 30);
		employeeDetails.add(last_name);		
		employeeDetails.add(lastName_field);
		
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
		employeeDetails.add(gender);		
		employeeDetails.add(male);
		employeeDetails.add(female);
		
		
		
		// UserName
		JLabel city = new JLabel("UserName:");
		username_field = new JTextField();
		city.setBounds(20, 80, 100, 50);
		username_field.setBounds(20, 120, 150, 30);
		employeeDetails.add(city);		
		employeeDetails.add(username_field);
		
		// Password
		JLabel address = new JLabel("Password:");
		password_field = new JTextField();
		address.setBounds(220, 80, 100, 50);
		password_field.setBounds(220, 120, 300, 30);
		employeeDetails.add(address);		
		employeeDetails.add(password_field);
				
	
	
		// Salary
		JLabel email = new JLabel("Salary:");
		salary_field = new JTextField();
		email.setBounds(20, 220, 100, 50);
		salary_field.setBounds(20, 260, 300, 30);
		employeeDetails.add(email);		
		employeeDetails.add(salary_field);
		
		
		return employeeDetails;
	}
	
	
	public JPanel CreateButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(65,600,800,150);
		buttonsPanel.setBackground(Color.WHITE);
		
		JButton saveButton = new JButton("Save Employee");
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
				username_field.setText(null);
				password_field.setText(null);
				salary_field.setText(null);
				//comboBox.setSelectedItem("Select");
			}
		});
		
	
		buttonsPanel.add(saveButton);	
		buttonsPanel.add(clearButton);
		return buttonsPanel;
	}
}

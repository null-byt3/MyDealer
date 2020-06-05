package view.employees;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.database.EmployeeDB;

public class NewEmployeePanel extends JPanel {

	EmployeeDB employeedb = null;
	JTextField firstName_field;
	JTextField lastName_field;
	JRadioButton male;
	JRadioButton female;
	JTextField username_field;
	JTextField password_field;
	JTextField salary_field;
	JTextField role_field;
	JPanel mainPanel, titlePanel;
	
	
	NewEmployeePanel() {
		
		this.setLayout(new BorderLayout());

		titlePanel = CreateTitlePanel();
		mainPanel = new JPanel(null);
		
		/// Employee Details -- Panel
		JPanel employeeDetails = CreateEmployeeDetails();
		
		/// Submit & Clear Buttons -- Panel
		JPanel buttons = CreateButtonsPanel();
		
		mainPanel.add(employeeDetails);
		mainPanel.add(buttons);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);

	}
	
	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  Create New Employee");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
	}
	
	public JPanel CreateEmployeeDetails() {
		
		JPanel employeeDetails = new JPanel();
		employeeDetails.setLayout(null);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titledborder = BorderFactory.createTitledBorder(blackline, "Employee Details");
		employeeDetails.setBorder(titledborder);
		employeeDetails.setBounds(65,50,650,320);
			
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
		female.setBounds(480, 50, 90, 30);
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
		JLabel city = new JLabel("User Name:");
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
		
		//Role 
		JLabel role = new JLabel("Role:");
		role.setBounds(20, 150, 100, 50);
		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.addItem("Agent");
		comboBox1.addItem("Secretary");
		comboBox1.addItem("Manger");

		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		comboBox1.setBounds(20, 190, 150, 30);
		employeeDetails.add(role);
		employeeDetails.add(comboBox1);
		
		
		
		// Role -Manger,Secretary,Agent
		//JLabel role = new JLabel("Role:");
		//	role_field = new JTextField();
		//	role.setBounds(20, 150, 100, 50);
		//	role_field.setBounds(20, 190, 150, 30);
		//	employeeDetails.add(role);		
		//	employeeDetails.add(role_field);
				
	
		// Salary
		JLabel salary = new JLabel("Salary:");
		salary_field = new JTextField();
		salary.setBounds(20, 220, 100, 50);
		salary_field.setBounds(20, 260, 300, 30);
		employeeDetails.add(salary);		
		employeeDetails.add(salary_field);
		
		
		return employeeDetails;
	}
	
	
	public JPanel CreateButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(65,400,800,150);
		
		JButton saveButton = new JButton("Save Employee");
		saveButton.setBackground(Color.ORANGE);
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

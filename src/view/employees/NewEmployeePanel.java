package view.employees;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.EmployeeController;
import model.InputValidation.InputValidationException;

public class NewEmployeePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField firstName_field, lastName_field, username_field, password_field, salary_field;
	JLabel firstName_label, lastName_label, userName_label, password_label, salary_label, gender_label;
	JRadioButton male;
	JRadioButton female;
	JPanel mainPanel, titlePanel;
	EmployeeController employeecontroller;
	JComboBox<String> role_box;
	String selected_gender;

	NewEmployeePanel() {

		this.setLayout(new BorderLayout());

		titlePanel = CreateTitlePanel();
		mainPanel = new JPanel(null);

		employeecontroller = new EmployeeController();
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
		employeeDetails.setBounds(65, 50, 650, 320);

		// FIRST NAME
		firstName_label = new JLabel("First Name:");
		firstName_field = new JTextField();
		firstName_label.setBounds(20, 10, 100, 50);
		firstName_field.setBounds(20, 50, 150, 30);
		employeeDetails.add(firstName_label);
		employeeDetails.add(firstName_field);

		// LAST NAME
		lastName_label = new JLabel("Last Name:");
		lastName_field = new JTextField();
		lastName_label.setBounds(220, 10, 100, 50);
		lastName_field.setBounds(220, 50, 150, 30);
		employeeDetails.add(lastName_label);
		employeeDetails.add(lastName_field);

		// GENDER
		gender_label = new JLabel("Gender:");
		male = new JRadioButton("Male", true);
		female = new JRadioButton("Female");
		gender_label.setBounds(420, 10, 100, 50);
		male.setBounds(420, 50, 60, 30);
		female.setBounds(480, 50, 90, 30);
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				female.setSelected(false);
				selected_gender = "Male";
			}
		});
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				male.setSelected(false);
				selected_gender = "Female";
			}
		});
		employeeDetails.add(gender_label);
		employeeDetails.add(male);
		employeeDetails.add(female);

		// UserName
		userName_label = new JLabel("User Name:");
		username_field = new JTextField();
		userName_label.setBounds(20, 80, 100, 50);
		username_field.setBounds(20, 120, 150, 30);
		employeeDetails.add(userName_label);
		employeeDetails.add(username_field);

		// Password
		password_label = new JLabel("Password:");
		password_field = new JTextField();
		password_label.setBounds(220, 80, 100, 50);
		password_field.setBounds(220, 120, 300, 30);
		employeeDetails.add(password_label);
		employeeDetails.add(password_field);

		// Role
		JLabel role = new JLabel("Role:");
		role.setBounds(20, 150, 100, 50);
		role_box = new JComboBox<String>();
		role_box.addItem("Agent");
		role_box.addItem("Secretary");
		role_box.addItem("Manager");

		role_box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		role_box.setBounds(20, 190, 150, 30);
		employeeDetails.add(role);
		employeeDetails.add(role_box);

		// Salary
		salary_label = new JLabel("Salary:");
		salary_field = new JTextField();
		salary_label.setBounds(20, 220, 100, 50);
		salary_field.setBounds(20, 260, 300, 30);
		employeeDetails.add(salary_label);
		employeeDetails.add(salary_field);

		return employeeDetails;
	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(65, 400, 800, 150);

		JButton saveButton = new JButton("Save Employee");
		saveButton.setBackground(Color.ORANGE);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String role = (String) role_box.getSelectedItem();
				String firstName = firstName_field.getText();
				String lastName = lastName_field.getText();
				String userName = username_field.getText();
				String password = password_field.getText();
				int salary;
				
				try {
					salary = Integer.parseInt(salary_field.getText());
				} catch (NumberFormatException ex) {
					salary = 0;
				}
				
				try {
					employeecontroller.createEmployee(role, firstName, lastName, selected_gender, userName, password,
							salary);
					JOptionPane.showMessageDialog(null, "Employee Created");
				} catch (InputValidationException ex) {
					JOptionPane.showMessageDialog(null, ex.toString());

				}

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
				// comboBox.setSelectedItem("Select");
			}
		});

		buttonsPanel.add(saveButton);
		buttonsPanel.add(clearButton);
		return buttonsPanel;
	}

}

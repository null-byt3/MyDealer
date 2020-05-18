package view.clients;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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

import controller.ClientController;
import controller.EmployeeController;
import controller.LoginController;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Employee;

public class NewClientPanel extends JPanel {

	private EmployeeDB employeedb = null;
	private JRadioButton male, female;
	private JComboBox phonePrefix;
	private JTextField firstName_field, lastName_field, city_field, address_field, phoneNum_field, email_field;
	private JLabel agent_name, first_name, last_name, gender, city, address, phoneNum, email;
	private ClientController clientController = new ClientController();
	private LoginController loginController = new LoginController();
	private EmployeeController employeeController = new EmployeeController();
	
	NewClientPanel() {
		//this.setBackground(Color.WHITE);
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
		JPanel agentDetails = CreateAgentDetails();
		this.add(agentDetails);
		
		
		/// Client Details -- Panel
		JPanel clientDetails = CreateClientDetails();
		this.add(clientDetails);
		
		/// Submit & Clear Buttons -- Panel
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		String employeeMatrix[][] = employeeController.getEmployeeMatrix();
		
		
		for (String[] employee : employeeMatrix) {
			comboBox.addItem(employee[2] + " " + employee[3]);
			
		}
		
		comboBox.setSelectedItem(loginController.getLoggedUserFullName());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		
		comboBox.setBounds(20, 50, 150, 30);
		agentDetails.add(comboBox);
		
		// Agent name
		agent_name = new JLabel("Name");
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
		first_name = new JLabel("First Name:");
		firstName_field = new JTextField();
		first_name.setBounds(20, 10, 100, 50);
		firstName_field.setBounds(20, 50, 150, 30);
		clientDetails.add(first_name);		
		clientDetails.add(firstName_field);
		
		// LAST NAME
		last_name = new JLabel("Last Name:");
		lastName_field = new JTextField();
		last_name.setBounds(220, 10, 100, 50);
		lastName_field.setBounds(220, 50, 150, 30);
		clientDetails.add(last_name);		
		clientDetails.add(lastName_field);
		
		// GENDER
		gender = new JLabel("Gender:");
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
		city = new JLabel("City:");
		city_field = new JTextField();
		city.setBounds(20, 80, 100, 50);
		city_field.setBounds(20, 120, 150, 30);
		clientDetails.add(city);		
		clientDetails.add(city_field);
		
		// Address
		address = new JLabel("Address:");
		address_field = new JTextField();
		address.setBounds(220, 80, 100, 50);
		address_field.setBounds(220, 120, 300, 30);
		clientDetails.add(address);		
		clientDetails.add(address_field);
		
		// Phone Number
		phoneNum = new JLabel("Phone Number:");
		JLabel hyphen = new JLabel("-");
		phoneNum_field = new JTextField();
		String[] prefix_string = {"02","03","04","07","08","09","050","052","053","054","055","058"};
		phonePrefix = new JComboBox(prefix_string);	
		phoneNum.setBounds(20, 150, 100, 50);
		phonePrefix.setBounds(20, 190, 50, 30);
		hyphen.setBounds(77, 195, 10, 10);
		phoneNum_field.setBounds(90, 190, 230, 30);
		clientDetails.add(phonePrefix);
		clientDetails.add(phoneNum);	
		clientDetails.add(hyphen);
		clientDetails.add(phoneNum_field);
		
		
		
		
		// EMAIL
		email = new JLabel("E-Mail:");
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
				if(!verifyFields()) {
					JOptionPane.showMessageDialog(null, "Error: Invalid fields");
				}
				else	{
					int agentId = loginController.getLoggedUserId();
					String firstName = firstName_field.getText();
					String lastName = lastName_field.getText();
					String gender = (male.isSelected()) ? male.getText() : female.getText();
					String city = city_field.getText();
					String address = address_field.getText();
					String phoneNum = phonePrefix.getSelectedItem() + phoneNum_field.getText();
					String email = email_field.getText();
					clientController.createClient(agentId, firstName, lastName, gender, city, address, phoneNum, email);
					JOptionPane.showMessageDialog(null, "Client Created");
				}
			}
		});
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.setForeground(Color.BLACK);
		clearButton.setBounds(530, 0, 120, 45);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				first_name.setForeground(Color.BLACK);
				last_name.setForeground(Color.BLACK);
				gender.setForeground(Color.BLACK);
				city.setForeground(Color.BLACK);
				address.setForeground(Color.BLACK);
				phoneNum.setForeground(Color.BLACK);
				email.setForeground(Color.BLACK);
			
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
	
	
	public boolean verifyFields() {
		first_name.setForeground(Color.BLACK);
		last_name.setForeground(Color.BLACK);
		gender.setForeground(Color.BLACK);
		city.setForeground(Color.BLACK);
		address.setForeground(Color.BLACK);
		phoneNum.setForeground(Color.BLACK);
		email.setForeground(Color.BLACK);
		
		boolean valid = true;
		
		if (firstName_field.getText().isEmpty())  {
			first_name.setForeground(Color.RED);
			valid = false;
		}
		
		if (lastName_field.getText().isEmpty()) {
			last_name.setForeground(Color.RED);
			valid = false;
		}
		
		if (!male.isSelected() && !female.isSelected()) {
			gender.setForeground(Color.RED);
			valid = false;
		}
		
		if (city_field.getText().isEmpty()) {
			city.setForeground(Color.RED);
			valid = false;
		}
		
		if (address_field.getText().isEmpty()) {
			address.setForeground(Color.RED);
			valid = false;
		}
		
		if (phoneNum_field.getText().isEmpty() || phoneNum_field.getText().length() != 7 || !phoneNum_field.getText().matches("[0-9]+")) {
			phoneNum.setForeground(Color.RED);
			valid = false;
		}
		
		if (email_field.getText().isEmpty() || !email_field.getText().matches("^(.+)@(.+)$")) {
			email.setForeground(Color.RED);
			valid = false;
		}
		
		return valid;
	}
}
	
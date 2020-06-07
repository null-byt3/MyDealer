package view.clients;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ClientController;
import controller.LoginController;

public class EditClientsWindow extends JDialog {

	private JPanel main_panel, buttonsPanel;
	private JLabel first_name, last_name, gender, city, address, phoneNum, email;
	private JTextField firstName_field, lastName_field, city_field, address_field, phoneNum_field, email_field;
	private JComboBox phonePrefix;
	private JRadioButton male,female;
	private JButton saveButton, deleteButton;
	private int client_id;
	ClientController clientController = new ClientController();
	LoginController loginController = new LoginController();

	EditClientsWindow(JFrame mainwindow, int id) {
		super(mainwindow);
		requestFocus();
		setModal(true);
		//setAlwaysOnTop(true);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL); 
		this.setTitle("Edit Client: " + id);
		this.client_id = id;
		setSize(350, 500);
		setLocation(500, 280);
		this.main_panel = createPanel();
		this.buttonsPanel = CreateButtonsPanel();
		populateFields(id);
		main_panel.setLayout(null);
		buttonsPanel.setLayout(null);
		main_panel.add(buttonsPanel);
		this.add(main_panel);
		setVisible(true);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();

		// FIRST NAME
		first_name = new JLabel("First Name:");
		firstName_field = new JTextField();
		first_name.setBounds(20, 10, 100, 50);
		firstName_field.setBounds(20, 50, 130, 30);
		panel.add(first_name);
		panel.add(firstName_field);

		// LAST NAME
		last_name = new JLabel("Last Name:");
		lastName_field = new JTextField();
		last_name.setBounds(170, 10, 100, 50);
		lastName_field.setBounds(170, 50, 130, 30);
		panel.add(last_name);
		panel.add(lastName_field);

		// CITY
		city = new JLabel("City:");
		city_field = new JTextField();
		city.setBounds(20, 80, 100, 50);
		city_field.setBounds(20, 120, 130, 30);
		panel.add(city);
		panel.add(city_field);

		// GENDER
		gender = new JLabel("Gender:");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		gender.setBounds(170, 80, 100, 50);
		male.setBounds(170, 120, 60, 30);
		female.setBounds(230, 120, 90, 30);
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
		panel.add(gender);		
		panel.add(male);
		panel.add(female);
		
		
		
		// Address
		address = new JLabel("Address:");
		address_field = new JTextField();
		address.setBounds(20, 150, 100, 50);
		address_field.setBounds(20, 190, 300, 30);
		panel.add(address);
		panel.add(address_field);

		// Phone Number
		phoneNum = new JLabel("Phone Number:");
		JLabel hyphen = new JLabel("-");
		phoneNum_field = new JTextField();
		String[] prefix_string = { "02", "03", "04", "07", "08", "09", "050", "052", "053", "054", "055", "058" };
		phonePrefix = new JComboBox(prefix_string);
		phoneNum.setBounds(20, 220, 100, 50);
		phonePrefix.setBounds(20, 260, 50, 30);
		hyphen.setBounds(77, 265, 10, 10);
		phoneNum_field.setBounds(90, 260, 230, 30);
		panel.add(phonePrefix);
		panel.add(phoneNum);
		panel.add(hyphen);
		panel.add(phoneNum_field);

		// EMAIL
		email = new JLabel("E-Mail:");
		email_field = new JTextField();
		email.setBounds(20, 290, 100, 50);
		email_field.setBounds(20, 330, 300, 30);
		panel.add(email);
		panel.add(email_field);

		return panel;
	}
	
	private void populateFields(int id) {
		firstName_field.setText(clientController.getFirstName(id)); 
		lastName_field.setText(clientController.getLastName(id)); 
		city_field.setText(clientController.getCity(id)); 
		
		if (clientController.getGender(id).equals("Male")) {
			male.setSelected(true);
		}
		else {
			female.setSelected(true);
		}
		
		address_field.setText(clientController.getAddress(id)); 
		String phoneNum = clientController.getPhoneNum(id);
		
		if (phoneNum.charAt(1) == '5') {
			phonePrefix.setSelectedItem(phoneNum.substring(0, 3));
			phoneNum_field.setText(phoneNum.substring(4)); 

		}
		else {
			phonePrefix.setSelectedItem(phoneNum.substring(0, 2));
			phoneNum_field.setText(phoneNum.substring(3)); 

		}
		email_field.setText(clientController.getEmail(id)); 
	}
	
	
	
	public JPanel CreateButtonsPanel() {
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(20,380,300,150);
		
		saveButton = new JButton("Save Client");
		saveButton.setBackground(Color.GREEN);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!fieldValidator()) {
					JOptionPane.showMessageDialog(null, "Error: Invalid fields");
				}
				else	{
					//int agentId = loginController.getLoggedUserId();
					String firstName = firstName_field.getText();
					String lastName = lastName_field.getText();
					String gender = (male.isSelected()) ? male.getText() : female.getText();
					String city = city_field.getText();
					String address = address_field.getText();
					String phoneNum = phonePrefix.getSelectedItem() + "-" + phoneNum_field.getText();
					String email = email_field.getText();
					clientController.updateClient(client_id, firstName, lastName, gender, city, address, phoneNum, email);
					JOptionPane.showMessageDialog(null, "Client Updated");
					dispose();
				}
			}
		});
		
		
		deleteButton = new JButton("Delete Client");
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setBackground(Color.RED);
		deleteButton.setBounds(170, 0, 120, 45);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientController.eraseClient(client_id);
				JOptionPane.showMessageDialog(null, "Client Deleted");
				dispose();
			}
		});
		
		buttonsPanel.add(saveButton);	
		buttonsPanel.add(deleteButton);
		return buttonsPanel;
	}
	
	
	public boolean fieldValidator() {
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
	
	
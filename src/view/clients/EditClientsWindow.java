package view.clients;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ClientController;
import controller.LoginController;
import model.client.Client;
import model.employee.Employee;

public class EditClientsWindow extends JDialog {

	private Client client;
	private Employee current_user;
	private JPanel panel;
	private JLabel first_name, last_name, gender, city, address, phoneNum, email;
	private JTextField firstName_field, lastName_field, city_field, address_field, phoneNum_field, email_field;
	ClientController clientController = new ClientController();
	LoginController loginController = new LoginController();

	EditClientsWindow(int id) {
		this.setTitle("Edit Client: " + id);
		setSize(350, 500);
		setLocation(500, 280);
		this.client = clientController.getClient(id);
		this.current_user = loginController.getLoggedUser();
		this.panel = createPanel();
		panel.setLayout(null);
		this.add(panel);
		setVisible(true);
		requestFocus();
		setAlwaysOnTop(true);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();

		// FIRST NAME
		first_name = new JLabel("First Name:");
		firstName_field = new JTextField("HELLO");
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
		city_field.setBounds(20, 120, 150, 30);
		panel.add(city);
		panel.add(city_field);

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
		JComboBox phonePrefix = new JComboBox(prefix_string);
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
	
//	private void setFields() {
//		// CONTINUE TOMORROW
//		firstName_field = 
//		lastName_field = 
//		city_field =  
//		address_field = 
//		phoneNum_field = 
//		email_field =
//	}

}

package view.orders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.ClientController;
import controller.EmployeeController;
import controller.OrderController;
import model.car.Car;
import model.client.Client;
import model.database.ClientDB;
import model.database.EmployeeDB;
import model.database.InventoryDB;
import model.database.OrderDB;
import model.database.Serializer;
import model.employee.Employee;

public class NewOrderPanel extends JPanel {

	OrderDB orderdb = null;
	EmployeeDB employeedb = null;
	ClientDB clientdb = null;
	InventoryDB inventorydb = null;

	OrderController ordercontroller = new OrderController();
	EmployeeController employeecontroller = new EmployeeController();
	ClientController clientcontroller = new ClientController();
	// InventoryController inventorycontroller = new InventoryController();
	JTextField price_field;

	NewOrderPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y)

		// "Create New Order" -- Label
		JLabel title = new JLabel("Create New Order");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		Map attributes = title_font.getAttributes();
		// attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
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
		agentDetails.setBounds(65, 120, 400, 100);
		agentDetails.setBackground(Color.WHITE);

		JComboBox<String> comboBox1 = new JComboBox<String>();

		String[][] employeeMatrix = employeecontroller.getEmployeeMatrix();

		for (String[] employee : employeeMatrix) {
			comboBox1.addItem(employee[2] + " " + employee[3]);
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
		clientDetails.setBounds(65, 250, 400, 100);
		clientDetails.setBackground(Color.WHITE);

		JComboBox<String> comboBox2 = new JComboBox<String>();
		String[][] clientMatrix = clientcontroller.getClientMatrix();

		for (String[] client : clientMatrix) {
			comboBox2.addItem(client[1] + " " + client[2]);
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
		carDetails.setBounds(65, 380, 400, 250);
		carDetails.setBackground(Color.WHITE);

		JComboBox<String> comboBox3 = new JComboBox<String>();
		JComboBox<String> comboBox4 = new JComboBox<String>();
		JComboBox<String> comboBox5 = new JComboBox<String>();
		JComboBox<String> comboBox6 = new JComboBox<String>();
		JComboBox<String> comboBox7 = new JComboBox<String>();
		JComboBox<String> comboBox8 = new JComboBox<String>();

		//String[][] inventoryMatrix = inventorycontroller.getInventoryMatrix();


		return carDetails;
	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBounds(550, 585, 120, 45);
		buttonsPanel.setBackground(Color.WHITE);

		JButton saveButton = new JButton("Save Order");
		saveButton.setBackground(Color.GREEN);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 120, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
				// JOptionPane.showMessageDialog(null, "Data Missing");
				// else
				// JOptionPane.showMessageDialog(null, "Data Submitted");
			}
		});

		buttonsPanel.add(saveButton);
		return buttonsPanel;
	}

}

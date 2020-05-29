package model.database_initializers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.database.CarPropertiesDB;
import model.database.ClientDB;
import model.database.EmployeeDB;
import model.database.IdProvider;
import model.database.InventoryDB;
import model.database.OrderDB;
import model.database.Serializer;

public class Initializer {

	Serializer serializer = Serializer.getInstance();
	private EmployeeDB employeedb = null;
	private ClientDB clientdb = null;
	private InventoryDB inventorydb = null;
	private OrderDB orderdb = null;
	private CarPropertiesDB carpropertiesdb = null;

	JPanel panel;
	JFrame window;
	JLabel label;

	JCheckBox clients;
	JCheckBox employees;
	JCheckBox orders;
	JCheckBox inventory;
	JCheckBox carprops;
	JCheckBox all;

	JButton button;

	Initializer() {
		window = new JFrame();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		label = new JLabel("Choose DB to initialize:");
		label.setFont(label.getFont().deriveFont(20f));

		clients = new JCheckBox("ClientDB");
		employees = new JCheckBox("EmployeeDB");
		orders = new JCheckBox("OrderDB");
		inventory = new JCheckBox("InventoryDB");
		carprops = new JCheckBox("CarPropertiesDB");
		all = new JCheckBox("All");

		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean status = all.isSelected();
				clients.setSelected(status);
				employees.setSelected(status);
				orders.setSelected(status);
				inventory.setSelected(status);
				carprops.setSelected(status);
			}
		});

		button = new JButton("Initialize");
		button.setBackground(Color.GREEN);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clients.isSelected()) {
					resetDB("ClientDB");
				}
				if (employees.isSelected()) {
					resetDB("EmployeeDB");
				}
				if (orders.isSelected()) {
					resetDB("OrderDB");
				}
				if (inventory.isSelected()) {
					resetDB("InventoryDB");
				}
				if (carprops.isSelected()) {
					resetDB("CarPropertiesDB");
				}

			}
		});

		panel.add(label);
		panel.add(clients);
		panel.add(employees);
		panel.add(orders);
		panel.add(inventory);
		panel.add(carprops);
		panel.add(all);
		panel.add(button);
		window.add(panel);

		window.setSize(250, 250);
		window.setLocation(650, 280);
		window.setVisible(true);

	}

	private void resetDB(String type) {
		if (type.equals("ClientDB")) {
			serializer.resetId("clientId");
			clientdb = ClientDBinitializer.getDB();
			serializer.save("ClientDB", clientdb);
		}
		if (type.equals("EmployeeDB")) {
			serializer.resetId("employeeId");
			employeedb = EmployeeDBinitializer.getDB();
			serializer.save("EmployeeDB", employeedb);
		}
		if (type.equals("OrderDB")) {
			serializer.resetId("orderId");
			orderdb = OrderDBinitializer.getDB();
			serializer.save("OrderDB", orderdb);
		}
		if (type.equals("InventoryDB")) {
			serializer.resetId("inventoryId");
			inventorydb = InventoryDBinitializer.getDB();
			serializer.save("InventoryDB", inventorydb);
		}
		if (type.equals("CarPropertiesDB")) {
			carpropertiesdb = CarPropertiesInitializer.getDB();
			serializer.save("CarPropertiesDB", carpropertiesdb);
		}

	}

	public static void main(String[] args) {
		new Initializer();
	}

}

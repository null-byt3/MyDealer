package view.orders;

import java.awt.Color;
import java.awt.Font;

import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import model.car.Car;
import model.client.Client;
import model.database.ClientDB;
import model.database.EmployeeDB;
import model.database.InventoryDB;
import model.database.OrderDB;
import model.database.Serializer;
import model.employee.Employee;
import model.order.Order;


public class AllOrdersPanel extends JPanel {

	JScrollPane tableScroll;
	
	AllOrdersPanel() {
		JLabel title = new JLabel("All Orders");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		this.setBackground(Color.WHITE);
		
		tableScroll = CreateTable();
		this.add(tableScroll);
		this.setLayout(null);
	}
	
	public JScrollPane CreateTable() {
		
		String[] columnNames = {"OrderID","Date Created", "Agent Name","Client Name","CarID", "More Details"};
		String[][] data = null;
		OrderDB orderdb = null;
		InventoryDB inventorydb = null;
		{
		Serializer serializer = new Serializer();
		try {
			orderdb = (OrderDB)serializer.deserialize("OrderDB.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		{
		Serializer serializer = new Serializer();
		try {
			inventorydb = (InventoryDB)serializer.deserialize("InventoryDB.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		int size = orderdb.size();
		data = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			data[i] = new String[10];
			Order order = orderdb.get(i);
			data[i][0] = String.valueOf(order.getOrderId());
			data[i][1] = order.getOrderDate();
			data[i][2] = order.getAgentName();
			data[i][3] = order.getClientName();
			data[i][4] = String.valueOf(order.getCarId());
			data[i][5] = null;
		}
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		JTable ordersTable = new JTable(data, columnNames);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		ordersTable.setBorder(blackline);
		ordersTable.setFont(new Font("Arial", Font.BOLD, 12));
		ordersTable.setRowHeight(30);
		
		ordersTable.getColumnModel().getColumn(0).setMaxWidth(50);
		ordersTable.getColumnModel().getColumn(1).setMaxWidth(80);
		ordersTable.getColumnModel().getColumn(2).setMaxWidth(100);
		ordersTable.getColumnModel().getColumn(3).setMaxWidth(100);
		ordersTable.getColumnModel().getColumn(4).setMaxWidth(80);
		ordersTable.getColumnModel().getColumn(5).setMaxWidth(80);


		ordersTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);


		JScrollPane tblScrl = new JScrollPane(ordersTable);
		tblScrl.setBounds(50, 300, 450, 200);
		
		return tblScrl;
	}
}
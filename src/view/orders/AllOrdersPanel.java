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

import controller.OrderController;
import model.database.InventoryDB;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;


public class AllOrdersPanel extends JPanel {

	JScrollPane tableScroll;
	OrderController orderController = new OrderController();
	
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
		
		String[] columnNames = {"Order ID","Client ID", "Agent ID","Car ID"};
		String[][] data = orderController.getOrderMatrix();
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


		ordersTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		ordersTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);


		JScrollPane tblScrl = new JScrollPane(ordersTable);
		tblScrl.setBounds(50, 300, 450, 200);
		
		return tblScrl;
	}
}
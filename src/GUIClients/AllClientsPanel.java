package GUIClients;

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

import Client.Client;
import database.ClientDB;
import database.Serializer;

public class AllClientsPanel extends JPanel {

	JScrollPane tableScroll;

	AllClientsPanel() {
		JLabel title = new JLabel("All Clients");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		tableScroll = CreateTable();
		
		
		
		this.add(tableScroll);
		
	}
	
	
	public JScrollPane CreateTable() {
		
		String[] columnNames = {"ID","First Name","Last Name","City","Address","Phone Number", "E-Mail"};
		String[][] data = null;
		ClientDB clientdb = null;
		
		
		Serializer serializer = new Serializer();
		try {
		clientdb = (ClientDB)serializer.deserialize("ClientDB.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int size = clientdb.size();
		data = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			data[i] = new String[7];
			Client client = clientdb.get(i);
			data[i][0] = String.valueOf(client.getId());
			data[i][1] = client.getFirstName();
			data[i][2] = client.getLastName();
			data[i][3] = client.getCity();
			data[i][4] = client.getAddress();
			data[i][5] = client.getPhoneNum();
			data[i][6] = client.getEmail();
		}
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JTable clientsTable = new JTable(data,columnNames);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		clientsTable.setBorder(blackline);
		clientsTable.setFont(new Font("Arial", Font.BOLD, 12));
		clientsTable.setRowHeight(30);
		
		clientsTable.getColumnModel().getColumn(0).setMaxWidth(50);
		clientsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		JScrollPane tblScrl = new JScrollPane(clientsTable);
		tblScrl.setBounds(50, 300, 1600, 550);
		
		return tblScrl;
	}
	
}

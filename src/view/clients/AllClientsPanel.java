package view.clients;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import controller.ClientController;

public class AllClientsPanel extends JPanel {

	JScrollPane tableScroll;
	ClientController clientController = new ClientController();
	EditClientsWindow editClientsWindow;

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
		String[][] data = clientController.getClientMatrix();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		JTable clientsTable = new JTable(data,columnNames) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		clientsTable.setBorder(blackline);
		clientsTable.setFont(new Font("Arial", Font.BOLD, 12));
		clientsTable.setRowHeight(30);
		
		// A way to change the default width of a column
		clientsTable.getColumnModel().getColumn(0).setMaxWidth(50);
		clientsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		// Makes the table scrollable
		JScrollPane tblScrl = new JScrollPane(clientsTable);
		tblScrl.setBounds(50, 300, 1600, 550);
		
		clientsTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 2) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int id = Integer.parseInt(target.getValueAt(row, 0).toString());
			      System.out.println(id);
			      new EditClientsWindow(id);
			      
			    }
			}
		});
		
		
		return tblScrl;
	}
	
}

package view.clients;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ClientController;

public class AllClientsPanel extends JPanel {

	JScrollPane tableScroll;
	ClientController clientController = new ClientController();
	JPanel panel;
	EditClientsWindow editclientswindow;
	JTable clientsTable;
	DefaultTableCellRenderer centerRenderer;
	DefaultTableModel dtm;
	String[][] data;

	AllClientsPanel() {
		JLabel title = new JLabel("All Clients");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		Map attributes = title_font.getAttributes();
		// attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 50);
		this.add(title);
		this.panel = this;
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		tableScroll = CreateTable();
		this.add(tableScroll);
	}

	public JScrollPane CreateTable() {

		String[] columnNames = { "ID", "First Name", "Last Name", "City", "Address", "Phone Number", "E-Mail" };
		data = clientController.getClientMatrix();
		Border blackline = BorderFactory.createLineBorder(Color.black);

		clientsTable = new JTable();
		dtm = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		clientsTable.setModel(dtm);
		dtm.setColumnIdentifiers(columnNames);
		
		populateTable();
		
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
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
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int id = Integer.parseInt(target.getValueAt(row, 0).toString());
					System.out.println(id);
					editclientswindow = new EditClientsWindow((JFrame) SwingUtilities.getWindowAncestor(panel), id);
					editclientswindow.addWindowListener(new WindowAdapter() {
						public void windowClosed(WindowEvent e) {
							
							populateTable();
						}
					});

				}
			}
		});

		return tblScrl;
	}
	
	private void populateTable() {
		dtm.setRowCount(0);
		data = clientController.getClientMatrix();
		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
	}

}

package view.clients;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ClientController;

public class AllClientsPanel extends JPanel {

	private JScrollPane tableScroll;
	private ClientController clientController = new ClientController();
	private JPanel panel, searchPanel;
	private EditClientsWindow editclientswindow;
	private JTable clientsTable;
	private JTextField searchField;
	private JLabel searchLabel;
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableModel dtm;
	private String[][] data;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();

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
		
		searchPanel = searchPanel();
		tableScroll = CreateTable();
		this.add(tableScroll);
		this.add(searchPanel);
	}

	public JPanel searchPanel() {
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());
		searchPanel.setBounds(50, 270, 400, 30);
		searchField = new JTextField();
		searchLabel = new JLabel("Search: ");
		searchLabel.setBackground(Color.WHITE);
		
		
		 searchField.getDocument().addDocumentListener(new DocumentListener(){

	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                String text = searchField.getText();
	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                String text = searchField.getText();
	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	            }

	        });
		
		
		searchPanel.add(searchLabel, BorderLayout.WEST);
		searchPanel.add(searchField, BorderLayout.CENTER); 
		
		return searchPanel;
	}
	
	
	
	public JScrollPane CreateTable() {

		String[] columnNames = { "ID", "First Name", "Last Name", "City", "Address", "Phone Number", "E-Mail" };
		Border blackline = BorderFactory.createLineBorder(Color.black);

		dtm = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		
		populateTable();
		
		clientsTable = new JTable(dtm);
		rowSorter.setModel(dtm);
		clientsTable.setRowSorter(rowSorter);
		clientsTable.getTableHeader().setReorderingAllowed(false);
		
				
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

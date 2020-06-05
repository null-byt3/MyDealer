package view.inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ClientController;
import controller.InventoryController;

public class AllInventoryPanel extends JPanel {


	private JScrollPane tableScroll;
	private InventoryController inventorycontroller = new InventoryController();
	private JPanel panel, searchPanel, mainPanel, titlePanel;
	private JTable inventoryTable;
	private JTextField searchField;
	private JLabel searchLabel;
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableModel dtm;
	private String[][] data;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();

	AllInventoryPanel() {

		this.setLayout(new BorderLayout());

		titlePanel = CreateTitlePanel();
		mainPanel = new JPanel(null);
		this.panel = this;
		
		searchPanel = searchPanel();
		tableScroll = CreateTable();
		mainPanel.add(tableScroll);
		mainPanel.add(searchPanel);
		
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(mainPanel, BorderLayout.CENTER);
	}

	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  Create New Client");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
	}
	
	
	public JPanel searchPanel() {
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());
		searchPanel.setBounds(50, 50, 400, 30);
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

		String[] columnNames = { "Type", "Make", "Model", "Trim", "Color", "Quantity", };
		Border blackline = BorderFactory.createLineBorder(Color.black);

		dtm = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		
		populateTable();
		
		inventoryTable = new JTable(dtm);
		rowSorter.setModel(dtm);
		inventoryTable.setRowSorter(rowSorter);
		inventoryTable.getTableHeader().setReorderingAllowed(false);
		
				
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		inventoryTable.setBorder(blackline);
		inventoryTable.setFont(new Font("Arial", Font.BOLD, 12));
		inventoryTable.setRowHeight(30);
		
		// A way to change the default width of a column
		//inventoryTable.getColumnModel().getColumn(0).setMaxWidth(50);
		//inventoryTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		// Makes the table scrollable
		JScrollPane tblScrl = new JScrollPane(inventoryTable);
		tblScrl.setBounds(50, 100, 1550, 850);

		inventoryTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int id = Integer.parseInt(target.getValueAt(row, 0).toString());
					System.out.println(id);

				}
			}
		});

		return tblScrl;
	}
	
	private void populateTable() {
		dtm.setRowCount(0);
		data = inventorycontroller.getInventoryMatrix();
		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
	}
	
}

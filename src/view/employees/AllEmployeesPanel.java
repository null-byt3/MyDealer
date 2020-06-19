package view.employees;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import controller.EmployeeController;

public class AllEmployeesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane tableScroll;
	private EmployeeController employeeController = new EmployeeController();
	private JPanel MainEmployeesPanel, searchPanel, titlePanel;
	private JTable employeesTable;
	private JTextField searchField;
	private JLabel searchLabel;
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableModel dtm;
	private String[][] data;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();
	
	AllEmployeesPanel() {
		
		this.setLayout(new BorderLayout());
		titlePanel = CreateTitlePanel();
		MainEmployeesPanel = new JPanel(null);
		searchPanel = searchPanel();
		tableScroll = CreateTable();
		
		MainEmployeesPanel.add(tableScroll);
		MainEmployeesPanel.add(searchPanel);
		
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(MainEmployeesPanel, BorderLayout.CENTER);
		
	}
	
	
	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  All Employees");
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
		
		String[] columnNames = { "ID", "Role", "First Name", "Last Name", "Gender", "User Name", "Salary" };
		Border blackline = BorderFactory.createLineBorder(Color.black);

		dtm = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		
		populateTable();
		
		employeesTable = new JTable(dtm);
		rowSorter.setModel(dtm);
		employeesTable.setRowSorter(rowSorter);
		employeesTable.getTableHeader().setReorderingAllowed(false);
		
				
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		employeesTable.setBorder(blackline);
		employeesTable.setFont(new Font("Arial", Font.BOLD, 12));
		employeesTable.setRowHeight(30);
		
		// A way to change the default width of a column
		employeesTable.getColumnModel().getColumn(0).setMaxWidth(50);
		employeesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		// Makes the table scrollable
		JScrollPane tblScrl = new JScrollPane(employeesTable);
		tblScrl.setBounds(50, 100, 1550, 850);

		employeesTable.addMouseListener(new MouseAdapter() {
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
		data = employeeController.getEmployeeMatrix();
		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
	}
	
}

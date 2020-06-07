package view.reports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ReportsController;

public class MyReportsPanel extends JPanel {

	// GUI
	private JPanel titlePanel, mainContainer;
	private JPanel sidePanel, mainPanel;
	private JButton topModelSold_btn, topCashByClient_btn, topCashByOrder_btn, topOrdersByClient_btn;
	private JTable table;
	private DefaultTableCellRenderer centerRenderer;
	private DefaultTableModel dtm;
	private String[][] data;
	private JScrollPane tblScrl;
	private TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();

	// CONTROLLERS

	ReportsController reportscontroller;

	MyReportsPanel() {

		this.setLayout(new BorderLayout());
		titlePanel = CreateTitlePanel();

		reportscontroller = new ReportsController();

		mainContainer = new JPanel(new BorderLayout());
		sidePanel = CreateSidePanel();
		mainPanel = CreateMainPanel();

		mainContainer.add(sidePanel, BorderLayout.WEST);
		mainContainer.add(mainPanel, BorderLayout.CENTER);

		this.add(mainContainer, BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);

	}

	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  My Reports");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
	}

	public JPanel CreateSidePanel() {

		JPanel sidePanelContainer = new JPanel(new BorderLayout());

		JPanel spacing = new JPanel();
		spacing.setPreferredSize(new Dimension(50, Integer.MAX_VALUE));

		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(6, 1, 40, 60));
		sidePanel.setPreferredSize(new Dimension(150, Integer.MAX_VALUE));

		topModelSold_btn = new JButton("Top Models");
		topModelSold_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblScrl.setVisible(false);
			}
		});
		topCashByClient_btn = new JButton("Top Clients ($)");
		topCashByOrder_btn = new JButton("Top Orders ($)");
		topOrdersByClient_btn = new JButton("Top Clients (Orders)");

		sidePanel.add(new JPanel()); // empty space

		topModelSold_btn.setPreferredSize(new Dimension(100, 100));
		topModelSold_btn.setBackground(Color.DARK_GRAY);
		topModelSold_btn.setForeground(Color.ORANGE);
		topCashByClient_btn.setBackground(Color.DARK_GRAY);
		topCashByClient_btn.setForeground(Color.ORANGE);
		topCashByOrder_btn.setBackground(Color.DARK_GRAY);
		topCashByOrder_btn.setForeground(Color.ORANGE);
		topOrdersByClient_btn.setBackground(Color.DARK_GRAY);
		topOrdersByClient_btn.setForeground(Color.ORANGE);

		sidePanel.add(topModelSold_btn);
		sidePanel.add(topCashByOrder_btn);
		sidePanel.add(topCashByClient_btn);
		sidePanel.add(topOrdersByClient_btn);

		sidePanelContainer.add(sidePanel, BorderLayout.CENTER);
		sidePanelContainer.add(spacing, BorderLayout.WEST);

		return sidePanelContainer;
	}

	public JPanel CreateMainPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(CreateTable());
		return panel;
	}

	public JScrollPane CreateTable() {

		String[] columnNames = { "Make", "Model", "Sold Cars", "Total Value" };
		Border blackline = BorderFactory.createLineBorder(Color.black);

		dtm = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(columnNames);

		populateTable();

		table = new JTable(dtm);
		rowSorter.setModel(dtm);
		table.setRowSorter(rowSorter);
		table.getTableHeader().setReorderingAllowed(false);

		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setBorder(blackline);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setRowHeight(30);

		// A way to change the default width of a column
		// table.getColumnModel().getColumn(0).setMaxWidth(50);
		// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		// Makes the table scrollable
		tblScrl = new JScrollPane(table);
		tblScrl.setBounds(50, 100, 1400, 850);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
		rowSorter.setSortKeys(sortKeys);

		return tblScrl;
	}

	private void populateTable() {
		dtm.setRowCount(0);
		data = reportscontroller.getMostSoldModelMatrix();
		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
		rowSorter.sort();
	}

}

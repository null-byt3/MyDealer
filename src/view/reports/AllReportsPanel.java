package view.reports;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class AllReportsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// GUI
	private JPanel titlePanel, mainContainer;
	private JPanel sidePanel, mainPanel;
	private CardLayout cl;
	private JButton topModelSold_btn, topClientsByCash_btn, topCashByOrder_btn, topAgentsByCash_btn;

	// CONTROLLERS

	ReportsController reportscontroller;

	AllReportsPanel() {

		this.setLayout(new BorderLayout());
		titlePanel = CreateTitlePanel();

		reportscontroller = new ReportsController();

		mainContainer = new JPanel(new BorderLayout());
		sidePanel = CreateSidePanel();

		CreateMainPanel();

		mainContainer.add(sidePanel, BorderLayout.WEST);
		mainContainer.add(mainPanel, BorderLayout.CENTER);

		this.add(mainContainer, BorderLayout.CENTER);
		this.add(titlePanel, BorderLayout.NORTH);

	}

	public JPanel CreateTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.DARK_GRAY);
		JLabel title = new JLabel("  All Reports");
		Font title_font = new Font("Helvetica", Font.BOLD, 60);
		title.setForeground(Color.orange);
		title.setFont(title_font);
		panel.add(title);

		return panel;
	}

	public void CreateMainPanel() {
		mainPanel = new JPanel();
		cl = new CardLayout();
		mainPanel.setLayout(cl);
		mainPanel.setBackground(Color.YELLOW);

		JPanel mostSoldModel = CreateMostSoldTable();
		JPanel mostValueClient = CreateMostValueClientTable();
		JPanel mostValueOrder = CreateMostValueOrderTable();
		JPanel mostValueAgent = CreateMostValueAgentTable();

		mainPanel.add(mostSoldModel, "MostSoldModel");
		mainPanel.add(mostValueClient, "MostValueClient");
		mainPanel.add(mostValueOrder, "MostValueOrder");
		mainPanel.add(mostValueAgent, "MostValueAgent");

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
				cl.show(mainPanel, "MostSoldModel");
			}
		});
		topClientsByCash_btn = new JButton("Top Clients");
		topClientsByCash_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "MostValueClient");
			}
		});
		topCashByOrder_btn = new JButton("Top Orders");
		topCashByOrder_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "MostValueOrder");
			}
		});
		topAgentsByCash_btn = new JButton("Top Agents");
		topAgentsByCash_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "MostValueAgent");
			}
		});

		sidePanel.add(new JPanel()); // empty space

		topModelSold_btn.setPreferredSize(new Dimension(100, 100));
		topModelSold_btn.setBackground(Color.DARK_GRAY);
		topModelSold_btn.setForeground(Color.ORANGE);
		topClientsByCash_btn.setBackground(Color.DARK_GRAY);
		topClientsByCash_btn.setForeground(Color.ORANGE);
		topCashByOrder_btn.setBackground(Color.DARK_GRAY);
		topCashByOrder_btn.setForeground(Color.ORANGE);
		topAgentsByCash_btn.setBackground(Color.DARK_GRAY);
		topAgentsByCash_btn.setForeground(Color.ORANGE);

		sidePanel.add(topModelSold_btn);
		sidePanel.add(topClientsByCash_btn);
		sidePanel.add(topCashByOrder_btn);
		sidePanel.add(topAgentsByCash_btn);

		sidePanelContainer.add(sidePanel, BorderLayout.CENTER);
		sidePanelContainer.add(spacing, BorderLayout.WEST);

		return sidePanelContainer;
	}

	public JPanel CreateMostSoldTable() {

		JScrollPane scrollPanel;
		DefaultTableCellRenderer centerRenderer, leftRenderer;
		String[] columnNames = { "Make", "Model", "Sold Cars", "Total Value" };
		int sortBy = 2;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Object[][] data = reportscontroller.getMostSoldModelMatrix(false);
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();
		JTable table;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				default:
					return Integer.class;
				}
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		dtm.setRowCount(0);

		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
		rowSorter.sort();

		table = new JTable(dtm);
		rowSorter.setModel(dtm);
		table.setRowSorter(rowSorter);
		table.getTableHeader().setReorderingAllowed(false);

		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);

		table.setBorder(blackline);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setRowHeight(30);

		// A way to change the default width of a column
		table.getColumnModel().getColumn(3).setCellRenderer(new PriceFormatter());
		table.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(50, 100, 1400, 850);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(sortBy, SortOrder.DESCENDING));
		rowSorter.setSortKeys(sortKeys);

		JPanel panel = new JPanel(null);
		panel.add(scrollPanel);
		return panel;
	}

	public JPanel CreateMostValueClientTable() {

		JScrollPane scrollPanel;
		DefaultTableCellRenderer centerRenderer;
		String[] columnNames = { "Client ID", "Name", "Orders", "Total Value" };
		Border blackline = BorderFactory.createLineBorder(Color.black);
		int sortBy = 3;
		Object[][] data = reportscontroller.getTopClientByCashMatrix(false);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();
		JTable table;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Integer.class;
				}
			}

		};
		dtm.setColumnIdentifiers(columnNames);
		dtm.setRowCount(0);

		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
		rowSorter.sort();

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
		table.getColumnModel().getColumn(3).setCellRenderer(new PriceFormatter());
		// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(50, 100, 1400, 850);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(sortBy, SortOrder.DESCENDING));
		rowSorter.setSortKeys(sortKeys);

		JPanel panel = new JPanel(null);
		panel.add(scrollPanel);
		return panel;
	}

	public JPanel CreateMostValueOrderTable() {

		JScrollPane scrollPanel;
		DefaultTableCellRenderer centerRenderer;
		String[] columnNames = { "Order ID", "Client Name", "Car", "Total Value" };
		Border blackline = BorderFactory.createLineBorder(Color.black);
		int sortBy = 3;
		Object[][] data = reportscontroller.getTopOrderByCashMatrix(false);

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();
		JTable table;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Integer.class;
				}
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		dtm.setRowCount(0);

		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
		rowSorter.sort();

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
		table.getColumnModel().getColumn(3).setCellRenderer(new PriceFormatter());
		// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(50, 100, 1400, 850);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(sortBy, SortOrder.DESCENDING));
		rowSorter.setSortKeys(sortKeys);

		JPanel panel = new JPanel(null);
		panel.add(scrollPanel);
		return panel;
	}

	public JPanel CreateMostValueAgentTable() {

		JScrollPane scrollPanel;
		DefaultTableCellRenderer centerRenderer;
		String[] columnNames = { "Agent ID", "Agent Name", "Orders", "Total Value" };
		Border blackline = BorderFactory.createLineBorder(Color.black);
		int sortBy = 3;
		Object[][] data = reportscontroller.getTopAgentMatrix();

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>();
		JTable table;
		DefaultTableModel dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default:
					return Integer.class;
				}
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		dtm.setRowCount(0);

		for (int i = 0; i < data.length; i++) {
			dtm.addRow(data[i]);
		}
		dtm.fireTableDataChanged();
		rowSorter.sort();

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
		table.getColumnModel().getColumn(3).setCellRenderer(new PriceFormatter());
		// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(50, 100, 1400, 850);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(sortBy, SortOrder.DESCENDING));
		rowSorter.setSortKeys(sortKeys);

		JPanel panel = new JPanel(null);
		panel.add(scrollPanel);
		return panel;
	}

	class PriceFormatter extends DefaultTableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Format formatter = NumberFormat.getIntegerInstance();

		public void setValue(Object value) {

			try {
				if (value != null)
					value = formatter.format(value) + "₪";
			} catch (IllegalArgumentException e) {
			}

			super.setValue(value);
		}
	}

}

package view.employees;

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

import controller.EmployeeController;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Employee;

public class AllEmployeesPanel extends JPanel {

	private JScrollPane tableScroll;
	private EmployeeController employeeController;
	
	AllEmployeesPanel() {
		employeeController = new EmployeeController();
		JLabel title = new JLabel("All Employees");
		Font title_font = new Font("Helvetica", Font.BOLD,60);
		Map attributes = title_font.getAttributes();
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		title.setFont(title_font.deriveFont(attributes));
		title.setBounds(65, 31, 520, 70);
		this.add(title);
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		tableScroll = CreateTable();
		this.add(tableScroll);
		
	}
	
	
	public JScrollPane CreateTable() {
		
		String[] columnNames = {"ID","Role","First Name","Last Name","Gender","UserName", "Salary"};
		String[][] data = employeeController.getEmployeeMatrix();
		EmployeeDB employeedb = null;
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JTable employeesTable = new JTable(data,columnNames);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		employeesTable.setBorder(blackline);
		employeesTable.setFont(new Font("Arial", Font.BOLD, 12));
		employeesTable.setRowHeight(30);
		employeesTable.getColumnModel().getColumn(0).setMaxWidth(50);
		employeesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		JScrollPane tblScrl = new JScrollPane(employeesTable);
		tblScrl.setBounds(50, 300, 1600, 550);
		
		return tblScrl;
	}
	
}

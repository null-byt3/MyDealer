package GUIEmployees;

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

import Employee.Employee;
import database.EmployeeDB;
import database.Serializer;

public class AllEmployeesPanel extends JPanel {

	JScrollPane tableScroll;

	AllEmployeesPanel() {
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
		
		String[] columnNames = {"ID","Gender","Role","First Name","Last Name","UserName", "salary"};
		String[][] data = null;
		EmployeeDB employeedb = null;
		
		
		Serializer serializer = new Serializer();
		try {
			employeedb = (EmployeeDB)serializer.deserialize("EmployeeDB.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int size = employeedb.size();
		data = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			data[i] = new String[8];
			Employee employee = employeedb.get(i);
			data[i][0] = String.valueOf(employee.getId());
			data[i][1] = employee.getGender();
			data[i][2] = String.valueOf(employee.getClass().getSimpleName());	
			data[i][3] = employee.getFirstName();
			data[i][4] = employee.getLastName();
			data[i][5] = employee.getUserName();
			data[i][6]= String.valueOf(employee.getSalary());
		}
		
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

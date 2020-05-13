package view.employees;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.employee.Employee;

public class EmployeesMainCard extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	EmployeesCardChanger employeescardchanger;
	EmployeesSidePanel employeessidepanel;
	private Employee current_user;
	
	public EmployeesMainCard(Employee current_user) {
		this.current_user = current_user;
		this.setLayout(bl);
		
		employeescardchanger = new EmployeesCardChanger(current_user);
		employeessidepanel = new EmployeesSidePanel(employeescardchanger);
		
		this.add(employeessidepanel,BorderLayout.WEST);
		this.add(employeescardchanger, BorderLayout.CENTER);
		this.setBackground(Color.BLUE);
	}

}


	

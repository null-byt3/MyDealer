package view.employees;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EmployeesMainCard extends JPanel {

	private static final long serialVersionUID = 1L;
	BorderLayout bl = new BorderLayout(2,2);
	EmployeesCardChanger employeescardchanger;
	EmployeesSidePanel employeessidepanel;
	
	public EmployeesMainCard() {
		this.setLayout(bl);
		
		employeescardchanger = new EmployeesCardChanger();
		employeessidepanel = new EmployeesSidePanel(employeescardchanger);
		
		this.add(employeessidepanel,BorderLayout.WEST);
		this.add(employeescardchanger, BorderLayout.CENTER);
		this.setBackground(Color.ORANGE);
	}

}


	

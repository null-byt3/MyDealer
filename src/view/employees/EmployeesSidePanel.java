package view.employees;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.PanelChanger;

public class EmployeesSidePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private final PanelChanger panelchanger;

	
	JButton bNewEmployee = new JButton("New Employee"); 
	JButton bAllEmployees = new JButton("All Employees"); 
	


	 public EmployeesSidePanel(PanelChanger panelchanger) {
		 
		this.panelchanger = panelchanger;
		bNewEmployee.setPreferredSize(new Dimension(150,100));
		bNewEmployee.setBackground(Color.GRAY);
		bNewEmployee.setForeground(Color.WHITE);
		bAllEmployees.setPreferredSize(new Dimension(150,100));
		bAllEmployees.setBackground(Color.GRAY);
		bAllEmployees.setForeground(Color.WHITE);
		
		this.setLayout(new GridLayout(15,1,5,5));
		this.setBackground(Color.BLACK);
		this.add(bNewEmployee);
		this.add(bAllEmployees);
		
		
		bNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open new clients panel");
				panelchanger.updateWorkPanel("NewEmployeePanel");
				
			}

		});
		
		bAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open all clients panel");
				panelchanger.updateWorkPanel("AllEmployeesPanel");
				
			}

		});
		
}
	 
	 
	 
}
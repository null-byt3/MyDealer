package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Employee.Employee;

public class SidePanel extends JPanel { 
	
	private final PanelChanger panelChanger;
	
	 public SidePanel(Employee employee, PanelChanger panelChanger) {
		this.panelChanger = panelChanger;
		this.setLayout(new BorderLayout(4,4));
		this.setBackground(Color.BLACK);
		this.add(TopButtonsCluster(employee),BorderLayout.NORTH);
		this.add(BottomButtonsCluster(),BorderLayout.SOUTH);
	}
	
	 
///////////////////////////////////////////////
//////////// TOP   BUTTONS  CLUSTER ///////////
///////////////////////////////////////////////
	 
	public JPanel TopButtonsCluster(Employee employee) {
		
		// CREATE BUTTONS //
		JButton bClients = new JButton("Clients"); 
		JButton bOrders = new JButton("Orders"); 
		JButton bInventory = new JButton("Inventory"); 
		JButton bReports = new JButton("Reports");
		JButton bEmployees = new JButton("Employees");

		// SET SIZE & COLOR OF BUTTONS //
		bClients.setPreferredSize(new Dimension(100,100));
		bClients.setBackground(Color.GRAY);
		bClients.setForeground(Color.WHITE);
		bOrders.setPreferredSize(new Dimension(100,100));
		bOrders.setBackground(Color.GRAY);
		bOrders.setForeground(Color.WHITE);
		bInventory.setPreferredSize(new Dimension(100,100));
		bInventory.setBackground(Color.GRAY);
		bInventory.setForeground(Color.WHITE);
		bReports.setPreferredSize(new Dimension(100,100));
		bReports.setBackground(Color.GRAY);
		bReports.setForeground(Color.WHITE);
		bEmployees.setPreferredSize(new Dimension(100,100));
		bEmployees.setBackground(Color.GRAY);
		bEmployees.setForeground(Color.WHITE);
		
		// ACTION LISTENERS - ASSIGN ACTION TO BUTTON //
		bClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open clients sub-panel");
				panelChanger.updateWorkPanel("ClientsPanel");
				
			}

		});
		
		bOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open orders sub-panel");
				panelChanger.updateWorkPanel("OrdersPanel");
				
			}

		});
		
		bInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Open Inventory sub-panel");
				panelChanger.updateWorkPanel("InventoryPanel");

			}

		});
		
		bReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open Reports sub-panel");
			}

		});
		
		bEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open Employees sub-panel");
				panelChanger.updateWorkPanel("EmployeesPanel");
			}

		});
		
		// CREATE PANEL, ASSIGN LAYOUT //
		JPanel TopButtonsCluster = new JPanel(); 
		TopButtonsCluster.setLayout(new GridLayout(5,1,5,5));

		// ADD BUTTONS TO PANEL //
		TopButtonsCluster.add(bClients); 
		
		if(!employee.getClass().toString().equals("class Employee.Secretary")) {
			TopButtonsCluster.add(bOrders); 
			TopButtonsCluster.add(bInventory); 
		}
		if (employee.getClass().toString().equals("class Employee.Manager")) {
			TopButtonsCluster.add(bReports); 
			TopButtonsCluster.add(bEmployees);
		}

		// SET BACKGROUND TO PANEL //
		TopButtonsCluster.setBackground(Color.BLACK);
		return TopButtonsCluster;

	}
	

///////////////////////////////////////////////
//////////// BOTTOM BUTTONS CLUSTER ///////////
///////////////////////////////////////////////
	
	public JPanel BottomButtonsCluster() {
		
		// CREATE BUTTONS //
		JButton bLogout = new JButton("Logout");
		JButton bExit = new JButton("Exit");  
		
		bLogout.setBackground(Color.GRAY);
		bLogout.setForeground(Color.WHITE);
		bExit.setBackground(Color.GRAY);
		bExit.setForeground(Color.WHITE);
		
		
		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Close main window. Open login-page");
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				new Login();
			}

		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				System.out.println("Close application");
			}

		});

		// CREATE PANEL, ASSIGN LAYOUT //
		JPanel BottomButtonsCluster = new JPanel(); 
		BottomButtonsCluster.setLayout(new GridLayout(2,1,5,5));

		// ADD BUTTONS TO PANEL //
		BottomButtonsCluster.add(bLogout); 
		BottomButtonsCluster.add(bExit); 

		// SET BACKGROUND TO PANEL //
		BottomButtonsCluster.setBackground(Color.BLACK);
		return BottomButtonsCluster;
		
		

	}
}

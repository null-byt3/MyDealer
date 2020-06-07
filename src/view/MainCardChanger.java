package view;


import java.awt.CardLayout;

import javax.swing.JPanel;

import model.employee.Employee;
import view.clients.ClientsMainPage;
import view.employees.EmployeesMainCard;
import view.inventory.InventoryMainCard;
import view.orders.OrdersMainCard;
import view.reports.ReportsMainCard;

public class MainCardChanger extends JPanel implements PanelChanger {
	
	ClientsMainPage clientspanel;
	OrdersMainCard orderspanel; 
	WelcomePanel welcomepanel;
	InventoryMainCard inventorypanel;
	EmployeesMainCard employeespanel;
	ReportsMainCard reportspanel;
	
	CardLayout cl = new CardLayout();

	
	 public MainCardChanger() {
		this.setLayout(cl);
		clientspanel = new ClientsMainPage();
		orderspanel = new OrdersMainCard(); 
		welcomepanel = new WelcomePanel();
		inventorypanel = new InventoryMainCard();
		employeespanel = new EmployeesMainCard();
		reportspanel = new ReportsMainCard();
		
		this.add(welcomepanel, "WelcomePanel");
		this.add(clientspanel, "ClientsPanel");
		this.add(orderspanel, "OrdersPanel");	
		this.add(inventorypanel, "InventoryPanel");
		this.add(reportspanel, "ReportsPanel");
		this.add(employeespanel, "EmployeesPanel");
		
		cl.show(this, "WelcomePanel");
	}
	 
		public void updateWorkPanel(String text) {
		
			cl.show(this, text);
			System.out.println("WorkPanel card changed to: "+ text);
		}
}
package GUI;


import java.awt.CardLayout;

import javax.swing.JPanel;

import Employee.Employee;
import GUIClients.ClientsMainCard;
import GUIEmployees.EmployeesMainCard;
import GUIInventory.InventoryMainCard;
import GUIOrders.OrdersMainCard;

public class MainCardChanger extends JPanel implements PanelChanger {
	
	ClientsMainCard clientspanel;
	OrdersMainCard orderspanel; 
	WelcomePanel welcomepanel;
	InventoryMainCard inventorypanel;
	EmployeesMainCard employeespanel;
	
	CardLayout cl = new CardLayout();

	
	 public MainCardChanger(Employee current_user) {
		this.setLayout(cl);
		clientspanel = new ClientsMainCard(current_user);
		orderspanel = new OrdersMainCard(); 
		welcomepanel = new WelcomePanel();
		inventorypanel = new InventoryMainCard();
		employeespanel = new EmployeesMainCard(current_user);
		
		this.add(welcomepanel, "WelcomePanel");
		this.add(clientspanel, "ClientsPanel");
		this.add(orderspanel, "OrdersPanel");	
		this.add(inventorypanel, "InventoryPanel");
		this.add(employeespanel, "EmployeesPanel");
		
		cl.show(this, "WelcomePanel");
	}
	 
		public void updateWorkPanel(String text) {
			cl.show(this, text);
			System.out.println("WorkPanel card changed to: "+ text);
		}
}
package GUI;


import java.awt.CardLayout;

import javax.swing.JPanel;

import Employee.Employee;
import GUIClients.ClientsMainCard;
import GUIInventory.InventoryMainCard;
import GUIOrders.OrdersMainCard;

public class MainCardChanger extends JPanel implements PanelChanger {
	
	ClientsMainCard clientspanel;
	OrdersMainCard orderspanel; 
	WelcomePanel welcomepanel;
	InventoryMainCard inventorypanel;
	
	CardLayout cl = new CardLayout();

	
	 public MainCardChanger(Employee current_user) {
		this.setLayout(cl);
		clientspanel = new ClientsMainCard(current_user);
		orderspanel = new OrdersMainCard(); 
		welcomepanel = new WelcomePanel();
		inventorypanel = new InventoryMainCard();
		this.add(welcomepanel, "WelcomePanel");
		this.add(clientspanel, "ClientsPanel");
		this.add(orderspanel, "OrdersPanel");	
		this.add(inventorypanel, "InventoryPanel");
		
		cl.show(this, "WelcomePanel");
	}
	 
		public void updateWorkPanel(String text) {
			cl.show(this, text);
			System.out.println("WorkPanel card changed to: "+ text);
		}
}
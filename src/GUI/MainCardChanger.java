package GUI;


import java.awt.CardLayout;

import javax.swing.*;

import GUIClients.ClientsMainCard;
import GUIInventory.InventoryMainCard;
import GUIOrders.OrdersMainCard;

public class MainCardChanger extends JPanel implements PanelChanger {
	
	ClientsMainCard clientspanel = new ClientsMainCard();
	OrdersMainCard orderspanel = new OrdersMainCard(); 
	WelcomePanel welcomepanel = new WelcomePanel();
	InventoryMainCard inventorypanel = new InventoryMainCard();
	
	CardLayout cl = new CardLayout();

	
	 public MainCardChanger() {
		this.setLayout(cl);
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
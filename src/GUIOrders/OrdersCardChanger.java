package GUIOrders;
import java.awt.CardLayout;

import javax.swing.JPanel;

import GUI.PanelChanger;
import GUI.WelcomePanel;

public class OrdersCardChanger extends JPanel implements PanelChanger {
	
	NewOrderPanel neworderpanel = new NewOrderPanel();
	AllOrdersPanel allorderspanel = new AllOrdersPanel();
	WelcomePanel welcomepanel = new WelcomePanel();
	
	CardLayout cl = new CardLayout();
	
	public OrdersCardChanger() {
		this.setLayout(cl);
		this.add(welcomepanel, "WelcomePanel");
		this.add(neworderpanel, "NewOrderPanel");
		this.add(allorderspanel, "AllOrdersPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		cl.show(this, panelName);
		System.out.println("OrdersCardChanger card changed to: "+ panelName);
		
	}
}
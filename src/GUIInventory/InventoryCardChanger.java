package GUIInventory;
import java.awt.CardLayout;

import javax.swing.JPanel;

import GUI.PanelChanger;
import GUI.WelcomePanel;

public class InventoryCardChanger extends JPanel implements PanelChanger {
	
	AllInventoryPanel allinventorypanel = new AllInventoryPanel();
	AvailableInventoryPanel availableinventorypanel = new AvailableInventoryPanel();
	WelcomePanel welcomepanel = new WelcomePanel();
	
	CardLayout cl = new CardLayout();
	
	public InventoryCardChanger() {
		this.setLayout(cl);
		this.add(welcomepanel, "WelcomePanel");
		this.add(allinventorypanel, "AllInventoryPanel");
		this.add(availableinventorypanel, "AvailableInventoryPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		cl.show(this, panelName);
		System.out.println("InventoryCardChanger card changed to: "+ panelName);
		
	}
}

package view.inventory;
import java.awt.CardLayout;

import javax.swing.JPanel;

import view.PanelChanger;
import view.WelcomePanel;

public class InventoryCardChanger extends JPanel implements PanelChanger {
	
	AllInventoryPanel allinventorypanel;
	AvailableInventoryPanel availableinventorypanel;
	WelcomePanel welcomepanel;
	CarPropertiesPanel carpropertiespanel;
	
	CardLayout cl = new CardLayout();
	
	public InventoryCardChanger() {
		
		allinventorypanel = new AllInventoryPanel();
		availableinventorypanel = new AvailableInventoryPanel();
		welcomepanel = new WelcomePanel();
		carpropertiespanel = new CarPropertiesPanel();
		
		this.setLayout(cl);
		this.add(welcomepanel, "WelcomePanel");
		this.add(allinventorypanel, "AllInventoryPanel");
		this.add(availableinventorypanel, "AvailableInventoryPanel");
		this.add(carpropertiespanel,"CarPropertiesPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		
		if (panelName.equals("AllInventoryPanel")) {
			this.remove(allinventorypanel);
			allinventorypanel = new AllInventoryPanel();
			this.add(allinventorypanel,"AllInventoryPanel");
		}
		
		if (panelName.equals("AvailableInventoryPanel")) {
			this.remove(availableinventorypanel);
			availableinventorypanel = new AvailableInventoryPanel();
			this.add(availableinventorypanel,"AvailableInventoryPanel");
		}
		
		if (panelName.equals("CarPropertiesPanel")) {
			this.remove(carpropertiespanel);
			carpropertiespanel = new CarPropertiesPanel();
			this.add(carpropertiespanel,"CarPropertiesPanel");
		}
		
		
		
		cl.show(this, panelName);
		System.out.println("InventoryCardChanger card changed to: "+ panelName);
		
	}
}

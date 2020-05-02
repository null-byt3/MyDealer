package GUIClients;
import java.awt.CardLayout;

import javax.swing.JPanel;

import GUI.PanelChanger;
import GUI.WelcomePanel;

public class ClientsCardChanger extends JPanel implements PanelChanger {
	
	NewClientPanel newClientPanel = new NewClientPanel();
	AllClientsPanel allClientsPanel = new AllClientsPanel();
	WelcomePanel welcomepanel = new WelcomePanel();
	
	CardLayout cl = new CardLayout();
	
	public ClientsCardChanger() {
		this.setLayout(cl);
		this.add(welcomepanel, "WelcomePanel");
		this.add(newClientPanel, "NewClientPanel");
		this.add(allClientsPanel, "AllClientsPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		cl.show(this, panelName);
		System.out.println("ClientsCardChanger card changed to: "+ panelName);
		
	}
}

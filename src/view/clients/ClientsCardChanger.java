package view.clients;
import java.awt.CardLayout;

import javax.swing.JPanel;

import model.employee.Employee;
import view.PanelChanger;
import view.WelcomePanel;

public class ClientsCardChanger extends JPanel implements PanelChanger {
	
	NewClientPanel newClientPanel;
	AllClientsPanel allClientsPanel;
	WelcomePanel welcomepanel;
	
	CardLayout cl = new CardLayout();
	
	public ClientsCardChanger() {
		this.setLayout(cl);
		this.newClientPanel = new NewClientPanel();
		this.allClientsPanel = new AllClientsPanel();
		this.welcomepanel = new WelcomePanel();
		
		this.add(welcomepanel, "WelcomePanel");
		this.add(newClientPanel, "NewClientPanel");
		this.add(allClientsPanel, "AllClientsPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		
		if (panelName.equals("NewClientPanel")) {
			this.remove(newClientPanel);
			newClientPanel = new NewClientPanel();
			this.add(newClientPanel,"NewClientPanel");
		}
		
		if (panelName.equals("AllClientsPanel")) {
			this.remove(allClientsPanel);
			allClientsPanel = new AllClientsPanel();
			this.add(allClientsPanel,"AllClientsPanel");
		}
		
		cl.show(this, panelName);
		
		System.out.println("ClientsCardChanger card changed to: "+ panelName);
		
	}
}

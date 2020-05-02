package GUIClients;
import java.awt.CardLayout;

import javax.swing.JPanel;

import Employee.Employee;
import GUI.PanelChanger;
import GUI.WelcomePanel;

public class ClientsCardChanger extends JPanel implements PanelChanger {
	
	NewClientPanel newClientPanel;
	AllClientsPanel allClientsPanel;
	WelcomePanel welcomepanel;
	Employee current_user;
	
	CardLayout cl = new CardLayout();
	
	public ClientsCardChanger(Employee current_user) {
		this.setLayout(cl);
		this.current_user = current_user;
		this.newClientPanel = new NewClientPanel(current_user);
		this.allClientsPanel = new AllClientsPanel();
		this.welcomepanel = new WelcomePanel();
		
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

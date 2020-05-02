package GUIClients;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import Employee.Employee;

public class ClientsMainCard extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	ClientsCardChanger clientscardchanger;
	ClientsSidePanel clientssidepanel;
	private Employee current_user;
	
	public ClientsMainCard(Employee current_user) {
		this.current_user = current_user;
		this.setLayout(bl);
		
		clientscardchanger = new ClientsCardChanger(current_user);
		clientssidepanel = new ClientsSidePanel(clientscardchanger);
		
		this.add(clientssidepanel,BorderLayout.WEST);
		this.add(clientscardchanger, BorderLayout.CENTER);
		this.setBackground(Color.BLUE);
	}

}


	

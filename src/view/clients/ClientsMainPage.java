package view.clients;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.employee.Employee;

public class ClientsMainPage extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	ClientsCardChanger clientscardchanger;
	ClientsSidePanel clientssidepanel;
	
	public ClientsMainPage() {
		this.setLayout(bl);
		
		clientscardchanger = new ClientsCardChanger();
		clientssidepanel = new ClientsSidePanel(clientscardchanger);
		
		this.add(clientssidepanel,BorderLayout.WEST);
		this.add(clientscardchanger, BorderLayout.CENTER);
		this.setBackground(Color.ORANGE);
	}

}


	

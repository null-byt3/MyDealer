package GUIClients;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ClientsMainCard extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	ClientsCardChanger clientscardchanger = new ClientsCardChanger();
	ClientsSidePanel clientssidepanel = new ClientsSidePanel(clientscardchanger);
	
	public ClientsMainCard() {
		this.setLayout(bl);
		this.add(clientssidepanel,BorderLayout.WEST);
		this.add(clientscardchanger, BorderLayout.CENTER);
		this.setBackground(Color.BLUE);
	}

}


	

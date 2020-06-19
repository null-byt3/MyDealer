package view.clients;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ClientsMainPage extends JPanel {

	private static final long serialVersionUID = 1L;
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


	

package GUIClients;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI.PanelChanger;

public class ClientsSidePanel extends JPanel {
	
	private final PanelChanger panelchanger;

	
	JButton bNewClient = new JButton("New Client"); 
	JButton bAllClients = new JButton("All Clients"); 
	


	 public ClientsSidePanel(PanelChanger panelchanger) {
		 
		this.panelchanger = panelchanger;
		bNewClient.setPreferredSize(new Dimension(150,100));
		bNewClient.setBackground(Color.GRAY);
		bNewClient.setForeground(Color.WHITE);
		bAllClients.setPreferredSize(new Dimension(150,100));
		bAllClients.setBackground(Color.GRAY);
		bAllClients.setForeground(Color.WHITE);
		
		this.setLayout(new GridLayout(15,1,5,5));
		this.setBackground(Color.BLACK);
		this.add(bNewClient);
		this.add(bAllClients);
		
		
		bNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open new clients panel");
				panelchanger.updateWorkPanel("NewClientPanel");
				
			}

		});
		
		bAllClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open all clients panel");
				panelchanger.updateWorkPanel("AllClientsPanel");
				
			}

		});
		
}
	 
	 
	 
}
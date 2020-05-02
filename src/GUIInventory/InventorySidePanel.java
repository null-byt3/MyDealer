package GUIInventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI.PanelChanger;

public class InventorySidePanel extends JPanel {
	
	JButton bAll = new JButton("All"); 
	JButton bAvailable = new JButton("Available for sale"); 
	
	private final PanelChanger panelchanger;

	 public InventorySidePanel(PanelChanger panelchanger) {
		 
		this.panelchanger = panelchanger;
		bAll.setPreferredSize(new Dimension(150,100));
		bAll.setBackground(Color.GRAY);
		bAll.setForeground(Color.WHITE);
		bAvailable.setPreferredSize(new Dimension(150,100));
		bAvailable.setBackground(Color.GRAY);
		bAvailable.setForeground(Color.WHITE);
		
		
		bAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open All Inventory Panel");
				panelchanger.updateWorkPanel("AllInventoryPanel");
		
			}

		});
		
		bAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open Available Inventory Panel");
				panelchanger.updateWorkPanel("AvailableInventoryPanel");
				
			}

		});
		 
		this.setLayout(new GridLayout(15,1,5,5));
		this.setBackground(Color.BLACK);
		this.add(bAll);
		this.add(bAvailable);
}
}
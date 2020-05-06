package GUIOrders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI.PanelChanger;

public class OrdersSidePanel extends JPanel {
	
	JButton bNewOrder = new JButton("New Order"); 
	JButton bAllOrders = new JButton("All Orders"); 
	
	private final PanelChanger panelchanger;

	 public OrdersSidePanel(PanelChanger panelchanger) {
		
		this.panelchanger = panelchanger;
		bNewOrder.setPreferredSize(new Dimension(150,50));
		bNewOrder.setBackground(Color.GRAY);
		bNewOrder.setForeground(Color.WHITE);
		bAllOrders.setPreferredSize(new Dimension(150,50));
		bAllOrders.setBackground(Color.GRAY);
		bAllOrders.setForeground(Color.WHITE);
		 
		this.setLayout(new GridLayout(15,1,5,5));
		this.setBackground(Color.BLACK);
		this.add(bNewOrder);
		this.add(bAllOrders);
		
		bNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open New Order panel");
				panelchanger.updateWorkPanel("NewOrderPanel");
				
			}

		});
		
		bAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Open All Orders panel");
				panelchanger.updateWorkPanel("AllOrdersPanel");
				
			}

		});
}
}
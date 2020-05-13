package view.orders;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class OrdersMainCard extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	OrdersCardChanger orderscardchanger = new OrdersCardChanger();
	OrdersSidePanel orderssidepanel = new OrdersSidePanel(orderscardchanger);
	
	public OrdersMainCard(){
		this.setLayout(bl);
		this.add(orderssidepanel,BorderLayout.WEST);
		this.add(orderscardchanger, BorderLayout.CENTER);
		this.setBackground(Color.GREEN);
		this.setName("OrdersPanel");
	
	}
}
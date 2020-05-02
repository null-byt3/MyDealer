package GUIOrders;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrdersInfo extends JPanel {
	
	
	JLabel something = new JLabel("~~~ ORDERS INFO WILL BE HERE ~~~");
	
	OrdersInfo() {
		this.setBackground(Color.RED);
		//something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD,40));
		this.add(something);

	}
}

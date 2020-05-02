package GUIOrders;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewOrderPanel extends JPanel {

	JLabel something = new JLabel("~~~ NEW CLIENTS WILL BE HERE ~~~");
	
	NewOrderPanel() {
		this.setBackground(Color.BLUE);
		//something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD,40));
		this.add(something);

	}

	
	
	
	
	
}

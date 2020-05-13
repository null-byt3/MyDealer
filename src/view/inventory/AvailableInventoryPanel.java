package view.inventory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AvailableInventoryPanel extends JPanel {

	JLabel something = new JLabel("~~~ AVAILABLE INVENTORY INFO WILL BE HERE ~~~");
	
	AvailableInventoryPanel() {
		this.setBackground(Color.CYAN);
		//something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD,40));
		this.add(something);

	}

	
	
	
	
	
}

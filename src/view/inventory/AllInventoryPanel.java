package view.inventory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AllInventoryPanel extends JPanel {

	JLabel something = new JLabel("~~~ ALL INVENTORY INFO WILL BE HERE ~~~");
	
	AllInventoryPanel() {
		this.setBackground(Color.ORANGE);
		//something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD,40));
		this.add(something);

	}

	
	
	
	
	
}

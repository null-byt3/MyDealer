package GUIClients;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AllClientsPanel extends JPanel {

	JLabel something = new JLabel("~~~ ALL CLIENTS WILL BE HERE ~~~");

	AllClientsPanel() {
		this.setBackground(Color.GREEN);
		// something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD, 40));
		this.add(something);
	}
}

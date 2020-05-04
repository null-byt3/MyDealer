package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class WelcomePanel extends JPanel {
	
	JLabel something = new JLabel("Welcome to MyDealer!");
		
		public WelcomePanel(){
			this.setBackground(Color.GRAY);
			//something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
			something.setFont(new Font("Arial", Font.BOLD,72));
			this.add(something);
		
		}
		
}

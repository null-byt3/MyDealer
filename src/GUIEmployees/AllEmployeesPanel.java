package GUIEmployees;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AllEmployeesPanel extends JPanel {

	JLabel something = new JLabel("~~~ ALL EMPLOYEES WILL BE HERE ~~~");

	AllEmployeesPanel() {
		this.setBackground(Color.GREEN);
		// something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD, 40));
		this.add(something);
	}
}

package GUIEmployees;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.border.*;
import javax.swing.*;

import Employee.Employee;
import database.EmployeeDB;
import database.Serializer;

public class NewEmployeePanel extends JPanel {

	NewEmployeePanel(Employee current_user) {
		JLabel something = new JLabel("~~~ NEW EMPLOYEE WILL BE HERE ~~~");
		this.setBackground(Color.YELLOW);
		// something.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		something.setFont(new Font("Arial", Font.BOLD, 40));
		this.add(something);
	}
}

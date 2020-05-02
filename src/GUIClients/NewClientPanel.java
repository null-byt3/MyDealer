package GUIClients;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewClientPanel extends JPanel {

	JLabel something = new JLabel("~~~ NEW CLIENTS WILL BE HERE ~~~");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Font labelFont;
	
	NewClientPanel() {
		this.setBackground(Color.PINK);
		this.setLayout(null);
		something.setFont(new Font("Arial", Font.BOLD,40));
		this.labelFont = new Font("Arial", Font.BOLD,20);
		this.add(something);

		
		// setBounds arguments - (Position_X, Position_Y, Size_X, Size_Y) 
		textField = new JTextField();
		textField.setBounds(200, 25, 86, 25);
		this.add(textField);
		textField.setColumns(10);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(65, 31, 120, 14);
		firstName.setFont(labelFont);
		this.add(firstName);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(65, 68, 46, 14);
		this.add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 65, 86, 20);
		this.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(65, 115, 46, 14);
		this.add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 112, 247, 17);
		this.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(65, 162, 46, 14);
		this.add(lblAddress);
				
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(126, 157, 212, 40);
		this.add(textArea_1);
		
		
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(312, 900, 120, 45);
		this.add(btnClear);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(65, 228, 46, 14);
		this.add(lblSex);
		
		JLabel lblMale = new JLabel("Male");
		lblMale.setBounds(128, 228, 46, 14);
		this.add(lblMale);
		
		JLabel lblFemale = new JLabel("Female");
		lblFemale.setBounds(292, 228, 46, 14);
		this.add(lblFemale);
		
		JRadioButton radioButton = new JRadioButton("ABCDEF");
		radioButton.setBounds(337, 224, 109, 23);
		this.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(162, 224, 109, 23);
		this.add(radioButton_1);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(65, 288, 67, 14);
		this.add(lblOccupation);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Select");
		comboBox.addItem("Business");
		comboBox.addItem("Engineer");
		comboBox.addItem("Doctor");
		comboBox.addItem("Student");
		comboBox.addItem("Others");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(180, 285, 91, 20);
		this.add(comboBox);
		
		
		JButton btnSubmit = new JButton("Save Client");
		
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(40, 900, 120, 45);
		this.add(btnSubmit);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
					//JOptionPane.showMessageDialog(null, "Data Missing");
				//else		
				//JOptionPane.showMessageDialog(null, "Data Submitted");
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				textField.setText(null);
				textArea_1.setText(null);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				comboBox.setSelectedItem("Select");
				
				
			}
		});
		
	}
}
	
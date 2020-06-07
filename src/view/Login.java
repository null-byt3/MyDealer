package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Employee;

public class Login extends JFrame {

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField user_field = new JTextField(15);
	JPasswordField pass_field = new JPasswordField(15);
	EmployeeDB employeedb = null;
	LoginController loginController = new LoginController();
	JFrame mainwindow;

	Login() {
		super("Login");
		setSize(300, 200);
		setLocation(500, 280);
		panel.setLayout(null);

		user_field.setBounds(70, 30, 150, 20);
		pass_field.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);

		panel.add(blogin);
		panel.add(user_field);
		panel.add(pass_field);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setDefaultButton(blogin);
		setVisible(true);
		actionlogin();
	}

	public void actionlogin() {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = user_field.getText();
				char[] password = pass_field.getPassword();

				boolean loginSuccessful = loginController.attemptLogin(username, password);

				if (loginSuccessful) {
					mainwindow = new MainWindow();
					dispose();
					return;
				}

				JOptionPane.showMessageDialog(null, "Wrong Password / Username");
				user_field.requestFocus();
			}
		});
	}

	public static void main(String[] args) {
		new Login();
	}

}

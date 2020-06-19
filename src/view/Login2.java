package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import model.database.EmployeeDB;

public class Login2 extends JDialog {
	
	private static final long serialVersionUID = 1L;
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField user_field = new JTextField(15);
	JPasswordField pass_field = new JPasswordField(15);
	EmployeeDB employeedb = null;
	LoginController loginController = new LoginController();
	JFrame mainwindow;

	Login2(JFrame mainwindow) {
		super(mainwindow);
		setUndecorated(true);
		//setShape(new RoundRectangle2D.Double(10, 10, 2000, 800, 50, 50));
		setSize(500, 400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		requestFocus();
		this.setModal(true);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		
		panel.setLayout(null);

		user_field.setBounds(70, 30, 150, 20);
		pass_field.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);

		panel.add(blogin);
		panel.add(user_field);
		panel.add(pass_field);
		
		getContentPane().add(panel);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					dispose();
					return;
				}

				JOptionPane.showMessageDialog(null, "Wrong Password / Username");
				user_field.requestFocus();
			}
		});
	}

}

package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.LoginController;
import model.employee.Employee;

public class MainWindow extends JFrame {

	private Container mainContainer = getContentPane();
	private BorderLayout bl = new BorderLayout(2,2);
	private MainCardChanger workpanel;
	private Employee current_user;
	private SidePanel sidepanel;
	private LoginController loginController;
	
	
	MainWindow(){
		super("MyDealer");		
		this.loginController = new LoginController();
		this.current_user = loginController.getLoggedUser();
		workpanel = new MainCardChanger(current_user);
		sidepanel = new SidePanel(current_user, workpanel);
		mainContainer.setLayout(bl);
		mainContainer.setBackground(Color.ORANGE);
		mainContainer.add(sidepanel, BorderLayout.WEST);
		mainContainer.add(workpanel, BorderLayout.CENTER);
	
		setUndecorated(true); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		setVisible(true);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
}

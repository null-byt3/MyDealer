package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import controller.LoginController;
import model.employee.Employee;
import model.employee.Manager;

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
		
		// Border ?
		//getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN))
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true); 
		setVisible(true);
	}
}

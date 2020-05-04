package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import Employee.Employee;
import Employee.Manager;

public class MainWindow extends JFrame {

	private Container mainContainer = getContentPane();
	private BorderLayout bl = new BorderLayout(8,6);
	private MainCardChanger workpanel;
	private Employee current_user;
	private SidePanel sidepanel;
	
	
	MainWindow(Employee employee){
		super("MyDealer");		
		
		this.current_user = employee;
		workpanel = new MainCardChanger(current_user);
		sidepanel = new SidePanel(current_user, workpanel);
		mainContainer.setLayout(bl);
		mainContainer.setBackground(Color.YELLOW);
		mainContainer.add(sidepanel, BorderLayout.WEST);
		mainContainer.add(workpanel, BorderLayout.CENTER);
		
		// Border ?
		//getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN))
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		
		// Complete full screen
		//setUndecorated(true); 

	}	

	public static void main(String[] args) {  
	new MainWindow(new Manager());  
	}
}

package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import Employee.Employee;

public class MainWindow extends JFrame {

	private Container mainContainer = getContentPane();
	private BorderLayout bl = new BorderLayout(8,6);
	private MainCardChanger workpanel = new MainCardChanger();
	private Employee current_user;
	
	
	MainWindow(Employee employee){
		super("MyDealer");		
		
		this.current_user = employee;
		SidePanel sidepanel = new SidePanel(current_user, workpanel);
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
	new MainWindow(new Employee());  
	}
	
	public Employee getUser() {
		
		return current_user;
	}
}

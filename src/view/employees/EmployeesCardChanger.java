package view.employees;
import java.awt.CardLayout;

import javax.swing.JPanel;

import model.employee.Employee;
import view.PanelChanger;
import view.WelcomePanel;

public class EmployeesCardChanger extends JPanel implements PanelChanger {
	
	NewEmployeePanel newEmployeePanel;
	AllEmployeesPanel allEmployeesPanel;
	WelcomePanel welcomepanel;
	Employee current_user;
	
	CardLayout cl = new CardLayout();
	
	public EmployeesCardChanger(Employee current_user) {
		this.setLayout(cl);
		this.current_user = current_user;
		this.newEmployeePanel = new NewEmployeePanel(current_user);
		this.allEmployeesPanel = new AllEmployeesPanel();
		this.welcomepanel = new WelcomePanel();
		
		this.add(welcomepanel, "WelcomePanel");
		this.add(newEmployeePanel, "NewEmployeePanel");
		this.add(allEmployeesPanel, "AllEmployeesPanel");
		cl.show(this, "WelcomePanel");
	}
	
	
	
	
	
	@Override
	public void updateWorkPanel(String panelName) {
		cl.show(this, panelName);
		System.out.println("ClientsCardChanger card changed to: "+ panelName);
		
	}
}

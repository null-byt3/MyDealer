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
	
	CardLayout cl = new CardLayout();
	
	public EmployeesCardChanger() {
		this.setLayout(cl);
		this.newEmployeePanel = new NewEmployeePanel();
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

package view.employees;
import java.awt.CardLayout;

import javax.swing.JPanel;

import view.PanelChanger;
import view.WelcomePanel;

public class EmployeesCardChanger extends JPanel implements PanelChanger {
	
	private static final long serialVersionUID = 1L;
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
		
		if (panelName.equals("NewEmployeePanel")) {
			this.remove(newEmployeePanel);
			newEmployeePanel = new NewEmployeePanel();
			this.add(newEmployeePanel,"NewEmployeePanel");
		}
		
		if (panelName.equals("AllEmployeesPanel")) {
			this.remove(allEmployeesPanel);
			allEmployeesPanel = new AllEmployeesPanel();
			this.add(allEmployeesPanel,"AllEmployeesPanel");
		}
		
		cl.show(this, panelName);
		System.out.println("ClientsCardChanger card changed to: "+ panelName);
		
	}
}

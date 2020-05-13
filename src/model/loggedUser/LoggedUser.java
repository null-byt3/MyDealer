package model.loggedUser;

import model.employee.Employee;
import model.employee.Manager;
import view.MainWindow;

public class LoggedUser {

	private static Employee current_user = null;
	private static LoggedUser firstInstance = null;
	
	private LoggedUser(Employee user) { 
		current_user = user;
	}
	
	public static LoggedUser getInstance(Employee user) {
		
		if(firstInstance == null) {
			firstInstance = new LoggedUser(user); 
		}
		
		return firstInstance;
	}
	
	public static Employee getCurrentUser() {
		return current_user;
	}
	
}

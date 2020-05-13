package controller;

import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Employee;
import model.loggedUser.LoggedUser;


public class LoginController {

	private Employee current_user;
	private EmployeeDB employeedb;
	private Serializer serializer;
	private EmployeeController employeeController;
	
	
	public LoginController() {
		this.current_user = LoggedUser.getCurrentUser();
		this.employeeController = new EmployeeController();
	}
	
	
	private void setLoggedUser(Employee user) {
		LoggedUser.getInstance(user);
		current_user = LoggedUser.getCurrentUser();
	}
	
	
	public Employee getLoggedUser() {
		return current_user;
	}
	
	public int getLoggedUserId() {
		return current_user.getId();
	}
	
	public String getLoggedUserFirstName() {
		return current_user.getFirstName();
	}
	
	public String getLoggedUserFullName() {
		return current_user.getFullName();
	}
	
	public String getLoggedUserRole() {
		String role = current_user.getClass().getSimpleName(); 
		return role;
	}
	
	public boolean attemptLogin(String username, char[] password) {		
		employeedb = (EmployeeDB) employeeController.getEmployeeList();
		
		for (Employee employee : employeedb) {
			System.out.println(employee);
			if (username.equals(employee.getUserName()) && String.valueOf(password).equals(employee.getPassword())) {
				setLoggedUser(employee);
				return true;
			}
		}
		return false;
	}
	
}

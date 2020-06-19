package controller;

import model.database.EmployeeDB;
import model.employee.Employee;
import model.loggedUser.LoggedUser;


public class LoginController {

	private EmployeeDB employeedb;
	private EmployeeController employeeController;
	
	
	public LoginController() {
		this.employeeController = new EmployeeController();
	}
	
	
	private void setLoggedUser(Employee user) {
		LoggedUser.setCurrentUser(user);
	}
	
	
	public Employee getLoggedUser() {
		return LoggedUser.getCurrentUser();
	}
	
	public int getLoggedUserId() {
		return getLoggedUser().getId();
	}
	
	public String getLoggedUserFirstName() {
		return getLoggedUser().getFirstName();
	}
	
	public String getLoggedUserFullName() {
		return getLoggedUser().getFullName();
	}
	
	public String getLoggedUserRole() {
		String role = getLoggedUser().getClass().getSimpleName(); 
		return role;
	}
	
	public boolean attemptLogin(String username, char[] password) {		
		employeedb = (EmployeeDB) employeeController.getEmployeeList();
				
		for (Employee employee : employeedb) {
			if (username.equals(employee.getUserName()) && String.valueOf(password).equals(employee.getPassword())) {
				setLoggedUser(employee);
				return true;
			}
		}
		return false;
	}
	
	public void logOut() {
		LoggedUser.logOut();
	}
	
}

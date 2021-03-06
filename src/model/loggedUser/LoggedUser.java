package model.loggedUser;

import model.employee.Employee;

public class LoggedUser {

	private static Employee current_user = null;

	public static void setCurrentUser(Employee user) {
		current_user = user;
	}

	public static Employee getCurrentUser() {
		return current_user;
	}

	public static void logOut() {
		current_user = null;
	}
}

package model.employee;

import controller.PasswordHash;
import model.InputValidation.InputValidationException;

public class Agent extends Employee {
	
	private static final long serialVersionUID = 2187796130053568599L;

	private Agent(int id, String firstName, String lastName,String gender, String userName, String passwordHash, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.salary = salary;
		this.gender = gender;
	}
	
	public static Agent createAgent(int id, String firstName, String lastName, String gender, String userName,
			String password, int salary) throws InputValidationException {
		EmployeeValidator.validateInput(firstName, lastName, userName, password, salary);
		String passwordHash = PasswordHash.createHash(password);
		Agent agent = new Agent(id, firstName, lastName, gender, userName, passwordHash, salary);
		return agent;
	}

}

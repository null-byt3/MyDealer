package model.employee;

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
		Agent agent = new Agent(id, firstName, lastName, gender, userName, password, salary);
		return agent;
	}

}

package model.employee;

import controller.PasswordHash;
import model.InputValidation.InputValidationException;

public class Manager extends Employee {

	private static final long serialVersionUID = -4609875647076627632L;

	private Manager(int id, String firstName, String lastName, String gender, String userName, String passwordHash,
			int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.passwordHash = passwordHash;
		this.salary = salary;
	}

	public static Manager createManager(int id, String firstName, String lastName, String gender, String userName,
			String password, int salary) throws InputValidationException {
		EmployeeValidator.validateInput(firstName, lastName, userName, password, salary);
		String passwordHash = PasswordHash.createHash(password);

		Manager manager = new Manager(id, firstName, lastName, gender, userName, passwordHash, salary);
		return manager;
	}



}

package model.employee;

import controller.PasswordHash;
import model.InputValidation.InputValidationException;

public class Secretary extends Employee {


	private static final long serialVersionUID = -7300434790048613863L;

	private Secretary(int id, String firstName, String lastName,String gender, String userName, String password, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passwordHash = password;
		this.salary = salary;
		this.gender = gender;
	}
	
	public static Secretary createSecretary(int id, String firstName, String lastName, String gender, String userName,
			String password, int salary) throws InputValidationException {
		EmployeeValidator.validateInput(firstName, lastName, userName, password, salary);
		String passwordHash = PasswordHash.createHash(password);

		Secretary secretary = new Secretary(id, firstName, lastName, gender, userName, passwordHash, salary);
		return secretary;
	}
	
}

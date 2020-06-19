package model.employee;

import java.util.ArrayList;
import java.util.List;

import model.InputValidation.InputValidationException;

public class EmployeeValidator {

	static void validateInput(String firstName, String lastName, String userName, String password, int salary)
			throws InputValidationException {
		List<InputValidationException> exceptions = new ArrayList<InputValidationException>();

		try {
			validateFirstName(firstName);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		try {
			validateLastName(lastName);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		try {
			validateUserName(userName);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		try {
			validatePassword(password);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		try {
			validateSalary(salary);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		if (exceptions.size() > 0) {
			throw new InputValidationException(exceptions);
		}
	}

	private static void validateFirstName(String firstName) throws InputValidationException {

		if (firstName.trim().isEmpty()) {
			throw new InputValidationException("First name cannot be empty");
		}

		if (firstName.matches(".*\\d+.*")) {
			throw new InputValidationException("First name must contain only letters");
		}

		if (firstName.length() > 20) {
			throw new InputValidationException("First name limit is 20 characters");
		}

	}

	private static void validateLastName(String lastName) throws InputValidationException {

		if (lastName.trim().isEmpty()) {
			throw new InputValidationException("Last name cannot be empty");
		}

		if (lastName.matches(".*\\d+.*")) {
			throw new InputValidationException("Last name must contain only letters");
		}

		if (lastName.length() > 20) {
			throw new InputValidationException("Last name limit is 20 characters");
		}

	}

	private static void validateUserName(String userName) throws InputValidationException {

		if (userName.trim().isEmpty()) {
			throw new InputValidationException("Username cannot be empty");
		}

		if (!userName.matches("^[a-zA-Z0-9-_.]*")) {
			throw new InputValidationException("Invalid username");
		}

		if (userName.length() > 20 || userName.length() < 4) {
			throw new InputValidationException("Username must be between 4 and 20 characters long");
		}

	}

	private static void validatePassword(String password) throws InputValidationException {

		if (password.trim().isEmpty()) {
			throw new InputValidationException("Password cannot be empty");
		}

		if (!password.matches("^[a-zA-Z0-9]*")) {
			throw new InputValidationException("Password must contain letters and numbers only");
		}

		if (password.length() > 20 || password.length() < 4) {
			throw new InputValidationException("Password must be between 4 and 20 characters long");
		}

	}

	private static void validateSalary(int salary) throws InputValidationException {

		if (salary <= 0) {
			throw new InputValidationException("Salary must be a positive number");

		}

	}

}

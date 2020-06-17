package model.client;

import java.util.ArrayList;
import java.util.List;

import model.InputValidation.InputValidationException;

public class ClientValidator {

	static void validateInput(String firstName, String lastName, String address, String phoneNum, String email) throws InputValidationException {
		List<InputValidationException> exceptions  = new ArrayList<InputValidationException>();
		
		
		
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
	
		
		
		if (exceptions.size() > 0) {
			throw new InputValidationException(exceptions);
		}
	}
		
	
	private static void validateFirstName(String firstName) throws InputValidationException {

		if (firstName.isEmpty()) {
			throw new InputValidationException("First name is empty");
		}

		if (firstName.matches(".*\\d+.*")) {
			throw new InputValidationException("First name must contain only letters");
		}

	}
	
	private static void validateLastName(String lastName) throws InputValidationException {
		
		if (lastName.isEmpty()) {
			throw new InputValidationException("Last name is empty");
		}

		if (lastName.matches(".*\\d+.*")) {
			throw new InputValidationException("Last name must contain only letters");
		}

	}

	
	
}

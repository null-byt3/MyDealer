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
		
		try {
			validateAddress(address);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}
	
		try {
			validatePhoneNum(phoneNum);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}
		
		try {
			validateEmail(email);
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
	
	private static void validateAddress(String address) throws InputValidationException {
		
		if (address.trim().isEmpty()) {
			throw new InputValidationException("Address cannot be empty");
		}
	}
	
	private static void validatePhoneNum(String phoneNum) throws InputValidationException {
		
		if (phoneNum.trim().isEmpty()) {
			throw new InputValidationException("Phone Number cannot be empty");
		}
		
		if (!phoneNum.matches("^(050|052|053|054|055|02|03|04|07|08|09)-[0-9]{7}$")) {
			throw new InputValidationException("Phone number is not valid");
		}
	}
	
	private static void validateEmail(String email) throws InputValidationException {
		
		if (email.trim().isEmpty()) {
			throw new InputValidationException("Email is empty");
		}
		
		if (!email.matches("^(.+)@(.+)$")) {
			throw new InputValidationException("Email is not valid");
		}
	}

}

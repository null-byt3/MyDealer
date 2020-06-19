package model.order;

import java.util.ArrayList;
import java.util.List;

import model.InputValidation.InputValidationException;

public class OrderValidator {

	static void validateInput() throws InputValidationException {
		List<InputValidationException> exceptions = new ArrayList<InputValidationException>();

		try {
			validateSomething();
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}
		
		try {
			validateSomethingElse();
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		if (exceptions.size() > 0) {
			throw new InputValidationException(exceptions);
		}
	}

	private static void validateSomething() throws InputValidationException {

//		if (something) {
//			throw new InputValidationException("Default_Message");
//		}
		
	}
	
	private static void validateSomethingElse() throws InputValidationException {

//		if (something) {
//			throw new InputValidationException("Default_Message");
//		}
		
	}
}

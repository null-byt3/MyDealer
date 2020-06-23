package model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.InputValidation.InputValidationException;

public class CarPropertiesValidator {

	static void validateInput(String make, String model, Map<String, Integer> trims, List<String> colors) throws InputValidationException {
		List<InputValidationException> exceptions = new ArrayList<InputValidationException>();

		try {
			validateMake(make);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}
		
		try {
			validateModel(model);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}

		if (exceptions.size() > 0) {
			throw new InputValidationException(exceptions);
		}
	}

	private static void validateMake(String make) throws InputValidationException {

		if (make.trim().isEmpty()) {
			throw new InputValidationException("Make cannot be empty");
		}
		
		if (make.length() > 15) {
			throw new InputValidationException("Make cannot be longer than 15 characters");
		}
		
	}
	
	private static void validateModel(String model) throws InputValidationException {

		if (model.trim().isEmpty()) {
			throw new InputValidationException("Model cannot be empty");
		}
		
		if (model.length() > 15) {
			throw new InputValidationException("Model cannot be longer than 15 characters");
		}
		 
	}
	
	private static void validateTrims(Map<String, Integer> trims) throws InputValidationException {

		
		for (Map.Entry<String, Integer> entry : trims.entrySet()) {
			
		
		}
		
		
	}
	
	private static void validateColors(List<String> colors) throws InputValidationException {

//		if (colors.trim().isEmpty()) {
//			throw new InputValidationException("Color cannot be empty");
//		}
//		
//		if (model.length() > 15) {
//			throw new InputValidationException("Make cannot be longer than 15 characters");
//		}
		 
	}
	
}

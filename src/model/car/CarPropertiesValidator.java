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
		
		try {
			validateTrims(trims);
		} catch (InputValidationException ex) {
			exceptions.add(ex);
		}
		
		try {
			validateColors(colors);
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
			
			if (entry.getKey().trim().isEmpty()) {
				throw new InputValidationException("Trim name cannot be empty");
			}
			
			if (entry.getKey().length() > 20) {
				throw new InputValidationException("Trim name be longer thna 20 characters");
			}
			
			if (entry.getKey().matches(".*\\d+.*")) {
				throw new InputValidationException("Trim name must contain only letters");
			}
			
			
			if (entry.getValue() <= 0) {
				throw new InputValidationException("Trim price must be bigger than 0");
			}
		
		}
		
		
	}
	
	private static void validateColors(List<String> colors) throws InputValidationException {

		for (String color : colors) {
						
			if (color.trim().isEmpty()) {
				throw new InputValidationException("Color cannot be empty");
			}
			
			if (color.length() > 15) {
				throw new InputValidationException("Color cannot be longer than 15 characters");
			}
			
		}
		 
	}
	
}

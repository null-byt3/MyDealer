package model.InputValidation;

import java.util.List;

public class InputValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private List<InputValidationException> exceptions;

	
	public InputValidationException(String message) {
		super(message);
	}

	public InputValidationException(List<InputValidationException> exceptions) {
		super(buildErrorMessage(exceptions));
		this.exceptions = exceptions;
	}

	private static String buildErrorMessage(List<InputValidationException> exceptions) {
		StringBuilder sb = new StringBuilder();

		for (Exception exception : exceptions) {
			sb.append("- " + exception.getMessage() + "\n");
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
	
}
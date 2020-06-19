package model.client;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.InputValidation.InputValidationException;

class ClientValidatorTest {

	// FIRST NAME 
	@Test
	public void testValidateInput_invalidFirstNameDueToNumber() {
		try {
		    ClientValidator.validateInput("1", "lastName", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- First name must contain only letters\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testValidateInput_invalidFirstNameEmpty() {
		try {
		    ClientValidator.validateInput("", "lastName", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- First name cannot be empty\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testValidateInput_invalidFirstNameTooLong() {
		try {
		    ClientValidator.validateInput("abcdefghijklmnopqrstuvwxyz", "lastName", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- First name limit is 20 characters\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	// LAST NAME
	@Test
	public void testValidateInput_invalidLastNameDueToNumber() {
		try {
		    ClientValidator.validateInput("Sebas", "Se1bas", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Last name must contain only letters\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testValidateInput_invalidLastNameEmpty() {
		try {
		    ClientValidator.validateInput("Sebas", "  ", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Last name cannot be empty\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testValidateInput_invalidLastNameTooLong() {
		try {
		    ClientValidator.validateInput("Sebas", "abcdefghijklmnopqrstuvwxyz", "address", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Last name limit is 20 characters\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	// ADDRESS
	@Test
	public void testValidateInput_invalidAddressEmpty() {
		try {
		    ClientValidator.validateInput("Sebas", "Whatever", "  ", "054-4366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Address cannot be empty\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	// PHONE NUMBER
	@Test
	public void testValidateInput_invalidPhoneNumEmpty() {
		try {
		    ClientValidator.validateInput("Sebas", "Whatever", "Harei Golan 13", "", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Phone Number cannot be empty\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testValidateInput_invalidPhoneNumFormat() {
		try {
		    ClientValidator.validateInput("Sebas", "Whatever", "Harei Golan 13", "0544366143", "email@www.com");
		    assertTrue(false);
		} catch (InputValidationException ex) {
		   assertEquals("- Phone number is not valid\n", ex.toString());
		} catch (Exception ex) {
			assertTrue(false);
		}
	}


}

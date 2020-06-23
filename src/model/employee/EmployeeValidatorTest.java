package model.employee;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.InputValidation.InputValidationException;
import model.employee.EmployeeValidator;

class EmployeeValidatorTest {

	// FIRST NAME 
		@Test
		public void testValidateInput_invalidFirstNameDueToNumber() {
			try {
			    EmployeeValidator.validateInput("1", "lastName", "dondon", "d12345d", 10500);
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
			    EmployeeValidator.validateInput("", "lastName", "dondon", "d12345d", 10500);
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
			    EmployeeValidator.validateInput("abcdefghijklmnopqrstuvwxyz", "lastName", "dondon", "d12345d", 10500);
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
			    EmployeeValidator.validateInput("Sebas", "Se1bas", "dondon", "d12345d", 10500);
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
			    EmployeeValidator.validateInput("Sebas", "  ", "dondon", "d12345d", 10500);
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
			    EmployeeValidator.validateInput("Sebas", "abcdefghijklmnopqrstuvwxyz", "dondon", "d12345d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Last name limit is 20 characters\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		// UserName
		@Test
		public void testValidateInput_invalidUserNameDueToConfiguration() {
			try {
			    EmployeeValidator.validateInput("Sebas", "sebas", "don@#$don", "d12345d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Invalid username\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidUserNameEmpty() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", " ", "d12345d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Username cannot be empty\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidUserNameTooLong() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", "abcdefghijklmnopqrstuvwxyzfcsdcsdcdasc", "d12345d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Username must be between 4 and 20 characters long\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidUserNameTooShort() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", "aa", "d12345d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Username must be between 4 and 20 characters long\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		// Password
		@Test
		public void testValidateInput_invalidPasswordDueToSign() {
			try {
			    EmployeeValidator.validateInput("Sebas", "sebas", "dondon", "d123@#$45d", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Password must contain letters and numbers only\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidPasswordEmpty() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", "dondon", "  ", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Password cannot be empty\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidPasswordTooLong() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", "dondon", "abcdefghijklmnopqrstuvwxyzfcsdcsdcdasc", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Password must be between 4 and 20 characters long\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		@Test
		public void testValidateInput_invalidPasswordTooShort() {
			try {
			    EmployeeValidator.validateInput("Sebas", "Sebas", "dondon", "aa", 10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Password must be between 4 and 20 characters long\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
		
		// Salary
		@Test
		public void testValidateInput_invalidSalaryNegative() {
			try {
			    EmployeeValidator.validateInput("Sebas", "sebas", "dondon", "d12345d", -10500);
			    assertTrue(false);
			} catch (InputValidationException ex) {
			   assertEquals("- Salary must be a positive number\n", ex.toString());
			} catch (Exception ex) {
				assertTrue(false);
			}
		}
	


}

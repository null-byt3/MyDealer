package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PasswordHashTest {

	
	@Test
	public void testValidatePassword_invalid() {
		String password = "123";
		String wrongPassword = "132";
		
		String passwordHash = PasswordHash.createHash(password);
		String wrongPasswordHash = PasswordHash.createHash(wrongPassword);
		
		assertNotEquals(wrongPasswordHash, passwordHash);
		
	}
	
	
	@Test
	public void testValidatePassword_valid() {
		String password = "123";
		String otherPassword = "123";
		
		String passwordHash = PasswordHash.createHash(password);
		String otherPasswordHash = PasswordHash.createHash(otherPassword);
		
		assertEquals(otherPasswordHash, passwordHash);
		
	}
	
}

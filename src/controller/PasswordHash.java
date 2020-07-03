package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {

	public static String createHash(String password) {

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes());
			String encryptedString = new String(messageDigest.digest());
			return encryptedString;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}
}



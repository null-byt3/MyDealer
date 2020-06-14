package model.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.client.Client;

class ClientTest extends Client{
	
	public static Client clientTest;
	private int id;
	public static int agentId;
	public static String firstName;
	public static String lastName;
	public static String gender;
	public static String city;
	public static String address;
	public static String phoneNum;
	public static String email;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		id = agentId = 1000;
		firstName = "Jon";
		lastName = "Smith";
		gender = "Male";
		city = "New-York";
		address = "Fifth avenue";
		phoneNum = "0503389754";
		email = "jon.smith@gmail.com";
		clientTest = new Client(id, agentId, firstName, lastName, gender, city, address, phoneNum, email);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetFirstName() {
		String firstNameTest = "123";
		clientTest.setFirstName(firstNameTest);
		String expected = ClientTest.firstName;
		String actual = clientTest.getFirstName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetLastName() {
		String lastNameTest = "123";
		clientTest.setLastName(lastNameTest);
		String expected = ClientTest.lastName;
		String actual = clientTest.getLastName();
		assertEquals(expected, actual);	
	}

	@Test
	void testSetCity() {
		String cityTest = "123";
		clientTest.setCity(cityTest);
		String expected = ClientTest.city;
		String actual = clientTest.getCity();
		assertEquals(expected, actual);
	}

	@Test
	void testSetPhoneNum() {
		String phoneNumTest = "050338975";
		clientTest.setPhoneNum(phoneNumTest);
		String expected = ClientTest.phoneNum;
		String actual = clientTest.getPhoneNum();
		assertEquals(expected, actual);
	}


	@Test
	void testSetEmail() {
		String emailTest = "jon.smith";
		clientTest.setEmail(emailTest);
		String expected = ClientTest.email;
		String actual = clientTest.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testSetGender() {
		String genderTest = "123";
		clientTest.setGender(genderTest);
		String expected = ClientTest.gender;
		String actual = clientTest.getGender();
		assertEquals(expected, actual);
	}

}

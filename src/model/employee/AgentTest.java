package model.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentTest {
	
	Employee tester;
	public static String firstName;
	public static String lastName;
	public static String gender;
	public static String userName;
	public static String password;
	public static int salary;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		firstName = "Jon";
		lastName = "Smith";
		gender = "Male";
		userName = "jsmith";
		password = "12345";
		salary = 10500;
		tester = new Agent(2000, firstName, lastName, gender, userName, password, salary);
	}

	@AfterEach
	void tearDown() throws Exception {
		tester = null;
	}

	@Test
	void testSetFirstName() {
		String firstNameTest = "123";
		tester.setFirstName(firstNameTest);
		String expected = AgentTest.firstName;
		String actual = tester.getFirstName();
		assertEquals(expected, actual);	
	}

	@Test
	void testSetLastName() {
		String lastNameTest = "123";
		tester.setLastName(lastNameTest);
		String expected = AgentTest.lastName;
		String actual = tester.getLastName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetGender() {
		String genderTest = "dog";
		tester.setGender(genderTest);
		String expected = AgentTest.gender;
		String actual = tester.getGender();
		assertEquals(expected, actual);	}

	@Test
	void testSetSalary() {
		int salaryTest = -150;
		tester.setSalary(salaryTest);
		int expected = AgentTest.salary;
		int actual = tester.getSalary();
		assertEquals(expected, actual);	
	}

	@Test
	void testSetUserName() {
		Employee tester2 = new Agent(2001, "Donald", "Trump", "Male", "dondon", "abc123", 100000000);
		tester.setUserName("dondon");
		String expected = AgentTest.userName;
		String actual = tester2.getUserName();
		assertEquals(expected, actual);	
	}
}

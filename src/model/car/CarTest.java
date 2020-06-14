package model.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest extends Car {
	
	public static Car carTest;
	public static String type;
	public static String make; 
	public static String model; 
	public static String trim; 
	public static String color;
	
	public static Car testCar;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		type = "Compact";
		make = "Hyundai"; 
		model = "i10"; 
		trim = "Intense"; 
		color = "White"; 
		carTest = new Car(type,make, model, trim, color);
	}

	@AfterEach
	void tearDown() throws Exception {
		carTest = null;
	}

	@Test
	void testEqualsObject() {
		Car carTest1 = new Car("Compact","Hyundai", "i10", "Intense","White");
		Car carTest2 = new Car("Compact","Hyundai", "i20", "Intense","Black");
		assertTrue(carTest.equals(carTest1));
		assertFalse(carTest.equals(carTest2));
	}

	@Test
	void testSetType() {
		String testType = "Bla Bla";
		carTest.setType(testType);
		String expected = CarTest.type;
		String actual = carTest.getType();
		assertEquals(expected, actual);
	}

	@Test
	void testSetMake() {
		String testMake = "Bla Bla";
		carTest.setMake(testMake);
		String expected = CarTest.make;
		String actual = carTest.getMake();
		assertEquals(expected, actual);	
	}

	@Test
	void testSetModel() {
		String testModel = "Bla Bla";
		carTest.setModel(testModel);
		String expected = CarTest.model;
		String actual = carTest.getModel();
		assertEquals(expected, actual);		
	}

	@Test
	void testSetTrim() {
		String testTrim = "Bla Bla";
		carTest.setTrim(testTrim);
		String expected = CarTest.trim;
		String actual = carTest.getTrim();
		assertEquals(expected, actual);		
	}

	@Test
	void testSetColor() {
		String testColor = "Bla Bla";
		carTest.setColor(testColor);
		String expected = CarTest.color;
		String actual = carTest.getColor();
		assertEquals(expected, actual);		
	}

}

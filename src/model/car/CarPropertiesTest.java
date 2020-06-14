package model.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.car.CarProperties;


class CarPropertiesTest extends CarProperties {
		
		public static CarProperties carProp;
		public static Map<String, Integer> iTest_trims;
		public static List<String> iTest_colors;

		@BeforeAll
		static void setUpBeforeClass() throws Exception {
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}

		@BeforeEach
		void setUp() throws Exception {
			iTest_trims = new HashMap<String,Integer>();
			iTest_trims.put("Intense", 69900); 
			iTest_colors = new ArrayList<String>();
			iTest_colors.add("Polar White");
			carProp = new CarProperties("Compact","Hyundai","iTest", iTest_trims,iTest_colors);
		}

		@AfterEach
		void tearDown() throws Exception {
			carProp=null;
		}	

		@Test
		void testSetTrims() {
			Map<String, Integer> iTest1_trims = new HashMap<String,Integer>();
			iTest1_trims.put("Intense", -15);
			carProp.setTrims(iTest1_trims);
			Map<String,Integer> expected = CarPropertiesTest.iTest_trims;
			Map<String,Integer> actual = carProp.getTrims();
			assertEquals(expected, actual);
		}
		
	
		@Test
		void testSetColors() {
			List<String> iTest1_colors = new ArrayList<String>();
			iTest1_colors.addAll(carProp.getColors());
			iTest1_colors.add("Polar White");
			carProp.setColors(iTest1_colors);
			List<String> expected = CarPropertiesTest.iTest_colors;
			List<String> actual = carProp.getColors();
			assertEquals(expected, actual);		
			}

}

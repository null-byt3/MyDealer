package model.car;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.InputValidation.InputValidationException;
import model.car.CarPropertiesValidator;

class CarPropertiesValidatorTest {

			// MAKE 
			@Test
			public void testValidateInput_invalidMakeEmpty() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom Black");
					CarPropertiesValidator.validateInput(" ", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Make cannot be empty\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidMakeTooLong() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom Black");
					CarPropertiesValidator.validateInput("Mazdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Make cannot be longer than 15 characters\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			// Model 
			@Test
			public void testValidateInput_invalidModelEmpty() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom Black");
					CarPropertiesValidator.validateInput("Mazda", "  ", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Model cannot be empty\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidModelTooLong() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom Black");
					CarPropertiesValidator.validateInput("Mazda", "CX-55555555555555555555555555555555555555555555555", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Model cannot be longer than 15 characters\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			// Colors 
			@Test
			public void testValidateInput_invalidColorsListEmpty() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					CarPropertiesValidator.validateInput("Mazda", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Colors List cannot be empty\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidColorsListTooLong() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Black");
					colors.add("Red");
					colors.add("White");
					colors.add("Grey");
					colors.add("Orange");
					colors.add("Green");
					colors.add("Yellow");
					colors.add("Wood");
					colors.add("Tree");
					colors.add("Cat");
					colors.add("Dod");
					CarPropertiesValidator.validateInput("Mazda", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Colors list cannot contain more than 10 colors\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidColorTooLong() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom Blackkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
					CarPropertiesValidator.validateInput("Mazda", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Color cannot contain more than 10 characters\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidColorTooShort() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("c");
					CarPropertiesValidator.validateInput("Mazda", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Color cannot contain less than 3 characters\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}
			
			@Test
			public void testValidateInput_invalidColorDueToConfiguration() {
				try {
					Map<String, Integer> trims = new HashMap<String,Integer>();
					trims.put("Intense", 69900);
					trims.put("Inspire", 79900);
					List<String> colors = new ArrayList<String>();
					colors.add("Polar White");
					colors.add("Phantom$ 5Black");
					CarPropertiesValidator.validateInput("Mazda", "CX-5", trims, colors);
				    assertTrue(false);
				} catch (InputValidationException ex) {
				   assertEquals("- Color mast contain only letters\n", ex.toString());
				} catch (Exception ex) {
					assertTrue(false);
				}
			}

}

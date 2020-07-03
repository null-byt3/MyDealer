package model.car;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import model.InputValidation.InputValidationException;

public class CarProperties implements Serializable {

	private static final long serialVersionUID = 850326163445225005L;
	String type;
	String make;
	String model;
	Map<String, Integer> trims;
	List<String> colors;
	String default_color;
	
	
	private CarProperties(String type, String make, String model, Map<String,Integer> trims, List<String> colors) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.trims = trims;
		this.colors = colors;
		this.default_color = colors.get(0);
		
	}
	
	public static CarProperties createCarProperties(String type, String make, String model, Map<String,Integer> trims, List<String> colors) throws InputValidationException {
		
		CarPropertiesValidator.validateInput(make, model, trims, colors);
		CarProperties carprops = new CarProperties(type, make, model, trims, colors);
		
		return carprops;
	}
	
	public static void updateCarProperties(CarProperties carprops, String make, String model, Map<String,Integer> trims, List<String> colors ) throws InputValidationException {
		CarPropertiesValidator.validateInput(make, model, trims, colors);
		
		carprops.setMake(make);
		carprops.setModel(model);
		carprops.setTrims(trims);
		carprops.setColors(colors);
		
	}
	
	CarProperties() {
		this.make = null;
		this.model = null;
		this.trims = null;
		this.colors = null;
		
	}

	public String getType() {
		return type;
	}

	public String getMake() {
		return make;
	}
	
	private void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}
	
	private void setModel(String model) {
		this.model = model;
	}

	public Map<String, Integer> getTrims() {
		return trims;
	}
	
	public void setTrims(Map<String,Integer> trims) {
		this.trims = trims;
	}
	
	public List<String> getColors() {
		return colors;
	}
	
	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public String getDefault_color() {
		return default_color;
	}
	
}

package model.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarProperties implements Serializable {

	String type;
	String make;
	String model;
	Map<String, Integer> trims;
	List<String> colors;
	String default_color;
	
	
	public CarProperties(String type, String make, String model, Map<String,Integer> trims, List<String> colors) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.trims = trims;
		this.colors = colors;
		this.default_color = colors.get(0);
		
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

	public String getModel() {
		return model;
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

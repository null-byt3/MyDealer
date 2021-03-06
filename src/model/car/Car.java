package model.car;

import java.io.Serializable;

public class Car implements Serializable {
	
	private static final long serialVersionUID = -6615747580315140720L;
	private String type;
	private String make; // Honda, Mitsubishi
	private String model; // Ibiza
	private String trim; // FR
	private String color; // Orange

	
	public Car() {
		this.type = "Null";
		this.make = "Null";
		this.model = "Null";
		this.trim = "Null";
		this.color = "Null";
	}

	public Car(String type, String make, String model, String trim, String color) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.trim = trim;
		this.color = color;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((trim == null) ? 0 : trim.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (trim == null) {
			if (other.trim != null)
				return false;
		} else if (!trim.equals(other.trim))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return make + " " + model + " | " + trim + " | " + color;
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

	public String getTrim() {
		return trim;
	}

	public String getColor() {
		return color;
	}

}

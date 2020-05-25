package model.car;

import java.io.Serializable;

public class Car implements Serializable {
	
	protected int carId; //20056
	private String make; // Honda, Mitsubishi
	private String model; // Ibiza
	private String trim; // FR
	private String color; // Orange
	private String status; //Sold, Free, etc.
	private int price;

	
	public Car() {
		this.carId = 0;
		this.make = "Null";
		this.model = "Null";
		this.trim = "Null";
		this.color = "Null";
		this.status = "Null";
		this.price = 0;
	}

	public Car(String make, String model, String trim, String color, String status, int price) {
		this.carId = 0;
		this.make = make;
		this.model = model;
		this.trim = trim;
		this.color = color;
		this.status = status;
		this.price = price;
	}

	public String toString() {
		return "Car " + this.carId + ": Make= " + this.make + ", Model= " + this.model + ", Trim= "
				+ this.trim + ", Color= " + this.color + ", Status= " + this.status + "\n";
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

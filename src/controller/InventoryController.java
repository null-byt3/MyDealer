package controller;

import java.util.Map;

import model.car.Car;
import model.database.InventoryDB;
import model.database.Serializer;

public class InventoryController {

	private InventoryDB inventoryDB;
	private Serializer serializer;
	private CarPropertiesController carpropscontroller;

	public InventoryController() {
		this.serializer = Serializer.getInstance();
		inventoryDB = (InventoryDB) serializer.load("InventoryDB");
	}

	public void add(String type, String make, String model, String trim, String color, int quantity) {

		Car new_car = new Car(type, make, model, trim, color);
		add(new_car, quantity);
	}

	private void add(Car car, int quantity) {

		if (inventoryDB.containsKey(car)) {
			int current_quantity = inventoryDB.get(car);
			inventoryDB.replace(car, current_quantity + quantity);
		} else {
			inventoryDB.put(car, quantity);
		}
		updateDB();
		System.out.println(quantity + "x " + car + " added to inventory");
	}

	public void remove(String type, String make, String model, String trim, String color, int quantity) {

		Car new_car = new Car(type, make, model, trim, color);
		remove(new_car, quantity);
	}
	
	
	public String[][] getInventoryMatrix() {
		
		String[][] inventoryMatrix;
		int size = inventoryDB.size();
		inventoryMatrix = new String[size][];
		int i = 0;
		
		
		for (Map.Entry<Car, Integer> entry : inventoryDB.entrySet()) {
			inventoryMatrix[i] = new String[6];
			Car car = entry.getKey();
			inventoryMatrix[i][0] = car.getType();
			inventoryMatrix[i][1] =	car.getMake();
			inventoryMatrix[i][2] = car.getModel();
			inventoryMatrix[i][3] = car.getTrim();
			inventoryMatrix[i][4] = car.getColor();
			inventoryMatrix[i][5] = String.valueOf(entry.getValue());
			
			
			i++;
		}
		
		return inventoryMatrix;
	}

	private void remove(Car car, int quantity) {
		if (inventoryDB.containsKey(car)) {
			int current_quantity = inventoryDB.get(car);
			if (current_quantity <= quantity) {
				inventoryDB.remove(car);
			} else {
				inventoryDB.replace(car, current_quantity - quantity);
			}
		}
		updateDB();
		System.out.println(quantity + "x " + car + " removed from inventory");
	}

	public void setQuantity(String type, String make, String model, String trim, String color, int quantity) {
		Car new_car = new Car(type, make, model, trim, color);
		setQuantity(new_car, quantity);
	}

	private void setQuantity(Car car, int quantity) {
		if (inventoryDB.containsKey(car)) {
			if (quantity > 0) {
				inventoryDB.replace(car, quantity);
			} else {
				inventoryDB.remove(car);
			}
		}
		updateDB();
	}

	private void updateDB() {
		serializer.save("InventoryDB", inventoryDB);
		System.out.println("InventoryDB successfully");
	}

}

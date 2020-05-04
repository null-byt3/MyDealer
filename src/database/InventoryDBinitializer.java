package database;

import java.io.File;
import java.io.FileNotFoundException;

import Car.Car;

public class InventoryDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	
	// Fetch whatever InventoryDB currently saved
	
	//InventoryDB inventoryDB = new InventoryDB();
	
	InventoryDB inventorydb = null;
	
	try {
		// Fetch whatever EmployeeDB currently saved
		inventorydb = (InventoryDB) serializer.deserialize("InventoryDB.db");
	} 
	catch (FileNotFoundException e) {
		System.out.println("InventoryDB.db Not found. Creating...");
		inventorydb = new InventoryDB();

	} 
	catch (Exception e) {
		System.out.println("Could not open file InventoryDB.db. Attempting to delete..");
		File file = new File("InventoryDB.db");
		if (file.delete()) {
			System.out.println("File Deleted Successfully. Creating new InventoryDB.db file");
			inventorydb = new InventoryDB();
		} 
		else {
			System.out.println("Could not delete File. Please try manually");
		}
	}
	
	// Empty DB
	inventorydb.clear();	
	
	// Create and add everything back
	Car car1 = new Car("Honda","Civic","Black", "White", "Ashdod","Free");
	Car car2 = new Car("Seat","Ibiza","Camel", "Orange", "Ashdod","Ordered");
	Car car3 = new Car("MG", "ZS", "Grey", "Black", "Haifa", "Free");
	Car car4 = new Car("Mazda","Miata","Black", "Red", "Eilat", "Saved");
	Car car5 = new Car("Ferrari", "458", "Red", "Red", "Tel aviv", "Free");
	Car car6 = new Car("Citroen","DS7","Grey","Bronze", "Haifa", "Ordered");
	
	inventorydb.add(car1);
	inventorydb.add(car2);
	inventorydb.add(car3);
	inventorydb.add(car4); 
	inventorydb.add(car5);
	inventorydb.add(car6);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("InventoryDB.db", inventorydb);
	
}

}
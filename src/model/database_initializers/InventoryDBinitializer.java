package model.database_initializers;

import java.io.File;

import model.car.Car;
import model.database.EmployeeDB;
import model.database.InventoryDB;
import model.database.Serializer;

public class InventoryDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = Serializer.getInstance();
	
	// Fetch whatever InventoryDB currently saved
	
	//InventoryDB inventoryDB = new InventoryDB();
	
	InventoryDB inventorydb = null;
	
	inventorydb = (InventoryDB)serializer.load("InventoryDB");
	
	if (inventorydb == null) {
		System.out.println("InventoryDB.db Not found. Creating...");
		inventorydb = new InventoryDB();
		
	} 
	
	else {
		System.out.println("InventoryDB found. Erasing contents..");
		inventorydb.clear();
	}
	
	
	// Create and add everything back
	Car car1 = new Car("Mazda","2","Dynamic", "White", "Ashdod","Free", 100000);
	Car car2 = new Car("Mazda","3","Activa", "Orange", "Ashdod","Ordered", 120000);
	Car car3 = new Car("Mazda","CX-5", "Executive", "Black", "Haifa", "Free", 140000);
	Car car4 = new Car("Mazda","Miata","Black", "Red", "Eilat", "Saved", 25000);
	Car car5 = new Car("Mazda","6", "Luxury", "Red", "Tel aviv", "Free", 43400);
	Car car6 = new Car("Mazda","CX-5","Signature","Bronze", "Haifa", "Ordered", 95000);
	
	inventorydb.add(car1);
	inventorydb.add(car2);
	inventorydb.add(car3);
	inventorydb.add(car4); 
	inventorydb.add(car5);
	inventorydb.add(car6);
	
	// Serialize the file (aka save to DB)
	serializer.save("InventoryDB", inventorydb);
	
}

}
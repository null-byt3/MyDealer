package database;

<<<<<<< HEAD
import Car.Car;
=======
import database.Serializer;
import Car.*;
>>>>>>> ef4d012f028b721f1648529bf4788a4e1fd4f563

public class InventoryDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	
	// Fetch whatever InventoryDB currently saved
	
<<<<<<< HEAD
=======
	//InventoryDB inventoryDB = new InventoryDB();
>>>>>>> ef4d012f028b721f1648529bf4788a4e1fd4f563
	
	InventoryDB inventoryDB = (InventoryDB)serializer.deserialize("InventoryDB");
	
	// Empty DB
	inventoryDB.clear();	
	
	// Create and add everything back
	Car car1 = new Car("Honda","Civic","Black", "White", "Ashdod","Free");
	Car car2 = new Car("Seat","Ibiza","Camel", "Orange", "Ashdod","Ordered");
	Car car3 = new Car("MG", "ZS", "Grey", "Black", "Haifa", "Free");
	Car car4 = new Car("Mazda","Miata","Black", "Red", "Eilat", "Saved");
	Car car5 = new Car("Ferrari", "458", "Red", "Red", "Tel aviv", "Free");
	Car car6 = new Car("Citroen","DS7","Grey","Bronze", "Haifa", "Ordered");
	
	inventoryDB.add(car1);
	inventoryDB.add(car2);
	inventoryDB.add(car3);
	inventoryDB.add(car4); 
	inventoryDB.add(car5);
	inventoryDB.add(car6);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("InventoryDB", inventoryDB);
	
}

}
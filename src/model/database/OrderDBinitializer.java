package model.database;

import java.io.File;

import model.order.Order;

public class OrderDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	
	// Fetch whatever OrderDB currently saved
	
	//OrderDB orderDB = new OrderDB();
	
	OrderDB orderdb = null;

	try {
		// Fetch whatever OrderDB currently saved
		orderdb = (OrderDB) serializer.deserialize("OrderDB.db");
	} 
	catch (NullPointerException e) {
		System.out.println("OrderDB.db Not found. Creating...");
		orderdb = new OrderDB();

	} 
	catch (Exception e) {
		System.out.println("Could not open file OrderDB.db. Attempting to delete..");
		File file = new File("OrderDB.db");
		if (file.delete()) {
			System.out.println("File Deleted Successfully. Creating new OrderDB.db file");
			orderdb = new OrderDB();
		} 
		else {
			System.out.println("Could not delete File. Please try manually");
		}
	}
	
	// Empty DB
	orderdb.clear();	
		
	// Create and add everything back
	Order order1 = new Order("Etay Rabino", "Israel Cohen", 10006);
	Order order2 = new Order("Sebi Alt", "Ronen Levi", 10003);
	Order order3 = new Order("Vitali Botz", "Sara Israel", 10002);
	Order order4 = new Order("Dani Shovevani", "Yakir Poni", 10005);
	Order order5 = new Order("Enni Alt", "Doron ski", 10004);
	Order order6 = new Order("Tal Levi", "Yaorn Shalom", 10001);
	
	orderdb.add(order1);
	orderdb.add(order2);
	orderdb.add(order3);
	orderdb.add(order4); 
	orderdb.add(order5);
	orderdb.add(order6);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("OrderDB.db", orderdb);
	
}

}
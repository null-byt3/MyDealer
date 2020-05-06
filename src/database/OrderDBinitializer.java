package database;

import java.io.File;

import Order.Order;

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
	Order order1 = new Order(02, 03, 2020, 1001, 1002, 1025);
	Order order2 = new Order(01,01,2019, 1000,1003, 1019);
	Order order3 = new Order(24, 02, 2020, 1004, 1005, 1000);
	Order order4 = new Order(05, 05, 2020, 1001, 1010, 1005);
	Order order5 = new Order(12, 11, 2019, 1010, 1008, 1007);
	Order order6 = new Order(29, 03, 2020, 1002, 1003, 1004);
	
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
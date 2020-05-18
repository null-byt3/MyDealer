package model.database_initializers;

import java.io.File;

import model.database.EmployeeDB;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;

public class OrderDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = Serializer.getInstance();
	
	// Fetch whatever OrderDB currently saved
	
	//OrderDB orderDB = new OrderDB();
	
	OrderDB orderdb = null;
	
	orderdb = (OrderDB)serializer.load("OrderDB");


	if (orderdb == null) {
		System.out.println("OrderDB.db Not found. Creating...");
		orderdb = new OrderDB();
		
	} 
	
	else {
		System.out.println("OrderDB.db found. Erasing contents..");
		orderdb.clear();
	}
	
	// Empty DB
	orderdb.clear();	
		
	// Create and add everything back
	Order order1 = new Order(1001, 1002, 1006);
	Order order2 = new Order(1002, 1001, 10003);
	Order order3 = new Order(1003, 1001, 10002);
	Order order4 = new Order(1004, 1003, 10005);
	Order order5 = new Order(1005, 1001, 10004);
	Order order6 = new Order(1006, 1002, 10001);
	
	orderdb.add(order1);
	orderdb.add(order2);
	orderdb.add(order3);
	orderdb.add(order4); 
	orderdb.add(order5);
	orderdb.add(order6);
	
	// Serialize the file (aka save to DB)
	serializer.save("OrderDB", orderdb);
	
}

}
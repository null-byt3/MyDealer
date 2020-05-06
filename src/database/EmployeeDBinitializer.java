package database;

import database.Serializer;

import java.io.File;
import java.io.IOException;

import Employee.*;

public class EmployeeDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	EmployeeDB employeedb = null;
	
	
	try {
		// Fetch whatever EmployeeDB currently saved
		employeedb = (EmployeeDB)serializer.deserialize("EmployeeDB.db");
	} 
	catch (NullPointerException e) {
		System.out.println("EmployeeDB.db Not found. Creating...");
		employeedb = new EmployeeDB();

	} 
	catch (Exception e) {
		System.out.println("Could not open file EmployeeDB.db. Attempting to delete..");
		File file = new File("../EmployeeDB.db");
		if (file.delete()) {
			System.out.println("File Deleted Successfully. Creating new EmployeeDB.db");
			employeedb = new EmployeeDB();
		} 
		else {
			System.out.println("Could not delete File. Please try manually");
		}
	}
	
	
	

	
	// Empty DB
	employeedb.clear();	
	
	// Create and add everything back
	Employee sebas = new Agent("Sebastian","Altheim","sebas","12345","M",6500);
	Employee eny = new Secretary("Eny","Kaplan","enykap","abcde","F",8000);
	Employee pegi = new Secretary("Peggy", "Allson", "pegi", "pegipeg","F", 8002);
	Employee etay = new Agent("Etay","Rabino","etay","e123","M", 12000);
	Employee vitaly = new Agent("Vitali", "Bucevith", "vitaly","M", "pass", 12050);
	Employee john = new Manager("John","Smith","jsmith","12345","M",9000);
	
	employeedb.add(sebas);
	employeedb.add(eny);
	employeedb.add(pegi);
	employeedb.add(etay); 
	employeedb.add(vitaly);
	employeedb.add(john);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("EmployeeDB.db", employeedb);
	
}

}
package database;

import database.Serializer;
import Employee.*;

public class EmployeeDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	
	// Fetch whatever EmployeeDB currently saved
	EmployeeDB employeedb = (EmployeeDB)serializer.deserialize("EmployeeDB");
	
	// Optional: create a new DB
	//EmployeeDB employeedb = new EmployeeDB();

	
	// Empty DB
	employeedb.clear();	
	
	// Create and add everything back
	Employee sebas = new Agent("Sebastian","Altheim","sebas","12345",6500);
	Employee eny = new Secretary("Eny","Kaplan","enykap","abcde",8000);
	Employee pegi = new Secretary("Peggy", "Allson", "pegi", "pegipeg", 8002);
	Employee etay = new Agent("Etay","Rabino","etay","e123", 12000);
	Employee vitaly = new Agent("Vitali", "Bucevith", "vitaly", "pass", 12050);
	Employee john = new Manager("John","Smith","jsmith","12345",9000);
	
	employeedb.add(sebas);
	employeedb.add(eny);
	employeedb.add(pegi);
	employeedb.add(etay); 
	employeedb.add(vitaly);
	employeedb.add(john);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("EmployeeDB", employeedb);
	
}

}
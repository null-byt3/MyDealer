package model.database_initializers;

import model.database.ClientDB;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Agent;
import model.employee.Employee;
import model.employee.Manager;
import model.employee.Secretary;

import java.io.File;
import java.io.IOException;

public class EmployeeDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = Serializer.getInstance();
	EmployeeDB employeedb = null;
	
	employeedb = (EmployeeDB) serializer.load("EmployeeDB");

	if (employeedb == null) {
		System.out.println("EmployeeDB.db Not found. Creating...");
		employeedb = new EmployeeDB();
		
	} 
	
	else {
		System.out.println("EmployeeDB found. Erasing contents..");
		employeedb.clear();
	}
	
	
	// Create and add everything back
	Employee sebas = new Agent("Sebastian","Altheim","sebas","12345","M",6500);
	Employee eny = new Secretary("Eny","Kaplan","enykap","abcde","F",8000);
	Employee pegi = new Secretary("Peggy", "Allson", "pegi", "pegipeg","F", 8002);
	Employee etay = new Agent("Etay","Rabino","etay","e123","M", 12000);
	Employee vitaly = new Agent("Vitali", "Bucevith", "vitaly","pass", "M", 12050);
	Employee john = new Manager("John","Smith","jsmith","12345","M",9000);
	
	employeedb.add(sebas);
	employeedb.add(eny);
	employeedb.add(pegi);
	employeedb.add(etay); 
	employeedb.add(vitaly);
	employeedb.add(john);
	
	// Serialize the file (aka save to DB)
	serializer.save("EmployeeDB", employeedb);
	
}

}
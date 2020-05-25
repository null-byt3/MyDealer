package model.database_initializers;

import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.Agent;
import model.employee.Employee;
import model.employee.Manager;
import model.employee.Secretary;

public class EmployeeDBinitializer {

public static EmployeeDB getDB() {
	
	Serializer serializer = Serializer.getInstance();
	EmployeeDB employeedb = new EmployeeDB();
	
	
	// Create and add everything back
	Employee sebas = new Agent(serializer.getNextId("employeeId"),"Sebastian","Altheim","sebas","12345","M",6500);
	Employee eny = new Secretary(serializer.getNextId("employeeId"),"Eny","Kaplan","enykap","abcde","F",8000);
	Employee pegi = new Secretary(serializer.getNextId("employeeId"),"Peggy", "Allson", "pegi", "pegipeg","F", 8002);
	Employee etay = new Agent(serializer.getNextId("employeeId"),"Etay","Rabino","etay","e123","M", 12000);
	Employee vitaly = new Agent(serializer.getNextId("employeeId"),"Vitali", "Bucevith", "vitaly","pass", "M", 12050);
	Employee john = new Manager(serializer.getNextId("employeeId"),"John","Smith","jsmith","12345","M",9000);
	
	employeedb.add(sebas);
	employeedb.add(eny);
	employeedb.add(pegi);
	employeedb.add(etay); 
	employeedb.add(vitaly);
	employeedb.add(john);
	
	return employeedb;
}

}
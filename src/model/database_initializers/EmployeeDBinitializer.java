package model.database_initializers;

import controller.EmployeeController;
import model.InputValidation.InputValidationException;
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
	EmployeeController employeecontroller;
	
	try {
	Employee sebas = Agent.createAgent(serializer.getNextId("employeeId"),"Sebastian","Altheim", "Male","sebas","12345",6500);
	Employee eny = Secretary.createSecretary(serializer.getNextId("employeeId"),"Eny","Kaplan","Female","enykap","abcde",8000);
	Employee pegi = Secretary.createSecretary(serializer.getNextId("employeeId"),"Peggy", "Allson","Female", "pegi", "pegipeg", 8002);
	Employee etay = Agent.createAgent(serializer.getNextId("employeeId"),"Etay","Rabino","Male","etay","e123", 12000);
	Employee vitaly = Agent.createAgent(serializer.getNextId("employeeId"),"Vitali", "Bucevith", "Male","vitaly","pass", 12050);
	Employee john = Manager.createManager(serializer.getNextId("employeeId"),"John","Smith","Female","jsmith","12345",9000);
	
	employeedb.add(sebas);
	employeedb.add(eny);
	employeedb.add(pegi);
	employeedb.add(etay); 
	employeedb.add(vitaly);
	employeedb.add(john);
	
	} catch (InputValidationException ex) {
		
		ex.printStackTrace();
	}
	
	return employeedb;
}

}
package controller;

import java.util.ArrayList;

import javax.swing.JPanel;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.*;

public class EmployeeController {

	private EmployeeDB employeeDB;
	private Serializer serializer;
	private JPanel current_panel;
	
	
	
	public EmployeeController() {
		this.serializer = new Serializer();
		try {
			this.employeeDB = (EmployeeDB)serializer.deserialize("EmployeeDB.db");
			
		} catch (Exception e) {
			System.out.println("EmployeeController -> Cannot deserialize EmployeeDB");
		}
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeDB;
	}
	
	public Employee getEmployee(int id) {
		Employee selected_employee = null;
		
		for (Employee employee : employeeDB) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		
		return selected_employee;
	}
	
	public String[][] getEmployeeMatrix() {
		String[][] employeeMatrix;
		int size = employeeDB.size();
		employeeMatrix = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			employeeMatrix[i] = new String[7];
			Employee employee = employeeDB.get(i);
			employeeMatrix[i][0] = String.valueOf(employee.getId());
			employeeMatrix[i][1] = employee.getClass().getSimpleName();
			employeeMatrix[i][2] = employee.getFirstName();
			employeeMatrix[i][3] = employee.getLastName();
			employeeMatrix[i][4] = employee.getGender();
			employeeMatrix[i][5] = employee.getUserName();
			employeeMatrix[i][6] = String.valueOf(employee.getSalary());
		}
		
		return employeeMatrix;
	}
	
	public void updateEmployee(int id, Employee updated_employee) {
		for (Employee employee : employeeDB) {
			if (employee.getId() == id) {
				employee = updated_employee;
				System.out.println("Employee ID " + employee.getId() + " was updated successfully");
				updateDB();
				return;
			}
		}
		
	}
	
	public void createEmployee(String role, String firstName, String lastName, String gender, String userName, String password, int salary) {
		
		Employee new_employee;
		
		if(role.equals("Secretary")) {
			new_employee = new Secretary(firstName,lastName,gender,userName,password,salary);
		}
		else if(role.equals("Agent")) {
			new_employee = new Agent(firstName,lastName,gender,userName,password,salary);
		}
		else if(role.equals("Manager")) {
			new_employee = new Manager(firstName,lastName,gender,userName,password,salary);
		}
		else {
			return;
		}
		
		createEmployee(new_employee);
	}
	
	private void createEmployee(Employee employee) {
		employeeDB.add(employee);
		updateDB();
	}
	
	
	public void updateDB() {
		serializer.serialize("EmployeeDB.db", employeeDB);
	}
	
	
}

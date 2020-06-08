package controller;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.client.Client;
import model.database.EmployeeDB;
import model.database.Serializer;
import model.employee.*;

public class EmployeeController {

	private EmployeeDB employeeDB;
	private Serializer serializer;
	private Employee curr_employee = null;
	
	
	public EmployeeController() {
		this.serializer = Serializer.getInstance();
		employeeDB = (EmployeeDB)serializer.load("EmployeeDB");
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeDB;
	}
	
	public ArrayList<Integer> getAllAgentIds() {
		ArrayList<Integer> agent_ids = new ArrayList<Integer>();
		
		for (Employee employee : employeeDB) {
			if (!employee.getClass().getSimpleName().equals("Secretary")) {
				agent_ids.add(employee.getId());	
			}
		}
		return agent_ids;
	}
	
	public String getFirstName(int id) {
		cacheEmployee(id);
		return curr_employee.getFirstName();
	}
	
	public String getLastName(int id) {
		cacheEmployee(id);
		return curr_employee.getLastName();
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
		int id = serializer.getNextId("employeeId");
		
		System.out.println("ROLE: " + role);
		
		if(role.equals("Secretary")) {
			new_employee = new Secretary(id, firstName,lastName,gender,userName,password,salary);
		}
		else if(role.equals("Agent")) {
			new_employee = new Agent(id, firstName,lastName,gender,userName,password,salary);
		}
		else if(role.equals("Manager")) {
			new_employee = new Manager(id, firstName,lastName,gender,userName,password,salary);
		}
		else {
			System.out.println("Error. Invalid Role");
			return;
		}
		
		createEmployee(new_employee);
	}
	
	private void createEmployee(Employee employee) {
		employeeDB.add(employee);
		updateDB();
	}
	
	
	private void updateDB() {
		serializer.save("EmployeeDB", employeeDB);
		System.out.println("EmplyeeDB saved successfully");
	}
	
	private void cacheEmployee(int id) {
		
		if (curr_employee != null && curr_employee.getId() == id) {
			return;
		}
		
		for (Employee employee : employeeDB) {
			if (employee.getId() == id) {
				this.curr_employee = employee;
				return;
			}
		}
		
		
	}
	
}

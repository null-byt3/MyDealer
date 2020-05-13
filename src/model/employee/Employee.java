package model.employee;

import java.io.Serializable;

public abstract class Employee implements Serializable {

	protected static int idCounter = 1000;

	protected int id;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String gender;
	protected String password;
	protected int salary;

	public Employee() {
		this.id = idCounter++;
		this.firstName = "Null";
		this.lastName = "Null";
		this.userName = "Null";
		this.gender = "Null";
		this.password = "Null";
		this.salary = 0;
	}

	public Employee(String firstName, String lastName, String gender, String userName, String password, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.salary = salary;
		this.gender = gender;
	}
	
	//public abstract String getRole();

	public abstract int getId();
	public abstract void setId(int id);
	public abstract String getFirstName();
	public abstract void setFirstName(String firstName);
	public abstract String getLastName();
	public abstract void setLastName(String lastName);
	public abstract String getUserName();
	public abstract String getGender();
	public abstract void setGender(String gender);
	public abstract int getSalary();
	public abstract void setSalary(int salary);
	public abstract void setUserName(String userName);
	public abstract String getPassword();
	public abstract void setPassword(String password);
	public abstract String toString();
	public abstract String getFullName();

}

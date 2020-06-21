package model.employee;

import java.io.Serializable;

public abstract class Employee implements Serializable {


	private static final long serialVersionUID = -401273629826352559L;
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String gender;
	protected String passwordHash;
	protected int salary;
	
	//public abstract String getRole();


	public String getPassHash() {
		return passwordHash;
	}

	protected void setPassword(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	protected void setSalary(int salary) {
		this.salary = salary;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}


	public String toString() {
		return "Employee:: ID=" + this.id + " Name=" + this.firstName + " " + this.lastName + " UserName="
				+ this.userName + " Password=" + this.passwordHash;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;

	}

}

package model.employee;

import model.InputValidation.InputValidationException;

public class Manager extends Employee {

	private static final long serialVersionUID = -4609875647076627632L;

	private Manager(int id, String firstName, String lastName, String gender, String userName, String password,
			int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.password = password;
		this.salary = salary;
	}

	public static Manager createManager(int id, String firstName, String lastName, String gender, String userName,
			String password, int salary) throws InputValidationException {
		EmployeeValidator.validateInput(firstName, lastName, userName, password, salary);
		Manager manager = new Manager(id, firstName, lastName, gender, userName, password, salary);
		return manager;
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

	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Employee:: ID=" + this.id + " Name=" + this.firstName + " " + this.lastName + " UserName="
				+ this.userName + " Password=" + this.password;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;

	}

}

package model.employee;

import model.InputValidation.InputValidationException;

public class Secretary extends Employee {


	private static final long serialVersionUID = -7300434790048613863L;

	private Secretary(int id, String firstName, String lastName,String gender, String userName, String password, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.salary = salary;
		this.gender = gender;
	}
	
	public static Secretary createSecretary(int id, String firstName, String lastName, String gender, String userName,
			String password, int salary) throws InputValidationException {
		EmployeeValidator.validateInput(firstName, lastName, userName, password, salary);
		Secretary secretary = new Secretary(id, firstName, lastName, gender, userName, password, salary);
		return secretary;
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

	protected void setGender(String gender) {
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
		return "Secretary:: ID=" + this.id + " Name=" + this.firstName + " " + this.lastName + " UserName="
				+ this.userName + " Password=" + this.password;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;

	}
	
}

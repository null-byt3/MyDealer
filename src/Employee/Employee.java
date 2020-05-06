package Employee;

import java.io.Serializable;

public class Employee implements Serializable {

	private static int idCounter = 1000;

	protected int id;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String password;
	protected int salary;
	protected String gender;

	public Employee() {
		this.id = idCounter++;
		this.firstName = "Null";
		this.lastName = "Null";
		this.userName = "Null";
		this.password = "Null";
		this.gender = "Null";
	}

	public Employee(String firstName, String lastName, String userName, String password, String gender, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
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

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Employee:: ID=" + this.id + " Name=" + this.firstName + " " + this.lastName + " UserName="
				+ this.userName + " Password=" + this.password;
	}

	public boolean isValid() {
		return this.firstName != null && this.firstName.length() > 4;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;

	}

}

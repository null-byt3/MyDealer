package model.employee;

public class Manager extends Employee {

	public Manager(int id, String firstName, String lastName, String gender, String userName, String password, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
		this.password = password;
		this.salary = salary;
	}
	
	public Manager() {
		this.id = 0;
		this.firstName = "Null";
		this.lastName = "Null";
		this.userName = "Null";
		this.gender = "Null";
		this.password = "Null";
		this.salary = 0;
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

	public String getFullName() {
		return this.firstName + " " + this.lastName;

	}

}

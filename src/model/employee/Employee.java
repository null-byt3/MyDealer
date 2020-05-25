package model.employee;

import java.io.Serializable;

public abstract class Employee implements Serializable {

	protected int id;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String gender;
	protected String password;
	protected int salary;
	
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

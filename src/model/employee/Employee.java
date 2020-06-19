package model.employee;

import java.io.Serializable;

public abstract class Employee implements Serializable {


	private static final long serialVersionUID = -401273629826352559L;
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String gender;
	protected String password;
	protected int salary;
	
	//public abstract String getRole();

	public abstract int getId();
	protected abstract void setId(int id);
	public abstract String getFirstName();
	protected abstract void setFirstName(String firstName);
	public abstract String getLastName();
	protected abstract void setLastName(String lastName);
	public abstract String getUserName();
	public abstract String getGender();
	protected abstract void setGender(String gender);
	public abstract int getSalary();
	protected abstract void setSalary(int salary);
	protected abstract void setUserName(String userName);
	public abstract String getPassword();
	protected abstract void setPassword(String password);
	public abstract String toString();
	public abstract String getFullName();

}

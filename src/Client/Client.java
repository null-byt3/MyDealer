package Client;

import java.io.Serializable;

public class Client implements Serializable
{
	private int id;
	protected String firstName;
	protected String lastName;
	protected String city;
	protected String address;
	protected String phoneNum;
	protected int AgentId;
	

	protected static int idCounter = 0;


public Client(int AgentId,String firstName, String lastName, String city, String address, String phoneNum)
{
	this.id = idCounter++;
	this.AgentId= AgentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.city = city;
	this.address = address;
	this.phoneNum = phoneNum;

	}
public Client() {
	this.id = idCounter++;
	this.firstName = "Null";
	this.lastName = "Null";
	this.city = "Null";
	this.address = "Null";
	this.phoneNum= "Null";
}
	public int getId() {
		return id;
	}	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public boolean isValid() {
		return this.firstName != null && this.firstName.length() > 4;
	}


	public String getLastName() {
		return lastName;
	}
	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getFullName() {
		return this.firstName + "-" + this.lastName;
	}
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
}

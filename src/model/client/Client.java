package model.client;

import java.io.Serializable;

public class Client implements Serializable
{
	private int id;
	protected int agentId;
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String city;
	protected String address;
	protected String phoneNum;
	protected String email;
	

	protected static int idCounter = 1000;


public Client(int agentId,String firstName, String lastName, String gender, String city, String address, String phoneNum, String email)
{
	this.id = idCounter++;
	this.agentId = agentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.city = city;
	this.address = address;
	this.phoneNum = phoneNum;
	this.email = email;

	}
public Client() {
	this.id = idCounter++;
	this.firstName = "Null";
	this.lastName = "Null";
	this.gender = "Null";
	this.city = "Null";
	this.address = "Null";
	this.phoneNum= "Null";
	this.email = "Null";
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
		return this.firstName + " " + this.lastName;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}

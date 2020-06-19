package model.client;

import java.io.Serializable;

import model.InputValidation.InputValidationException;

public class Client implements Serializable {

	
	private static final long serialVersionUID = 7554019319893569008L;
	private int id;
	protected int agentId;
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String city;
	protected String address;
	protected String phoneNum;
	protected String email;

	private Client(int id, int agentId, String firstName, String lastName, String gender, String city, String address,
			String phoneNum, String email) {
		this.id = id;
		this.agentId = agentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.city = city;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;

	}


	public static Client createClient(int id, int agentId, String firstName, String lastName, String gender,
			String city, String address, String phoneNum, String email) throws InputValidationException {
		
		ClientValidator.validateInput(firstName, lastName, address, phoneNum, email);
		Client client = new Client(id, agentId, firstName, lastName, gender,
			 city, address, phoneNum, email);

		return client;
	}
	
	public static void updateClient(Client client, String firstName, String lastName, String gender,
			String city, String address, String phoneNum, String email) throws InputValidationException {
		
		ClientValidator.validateInput(firstName, lastName, address, phoneNum, email);
			 
		client.setFirstName(firstName);
		client.setLastName(lastName); 
		client.setGender(gender);
		client.setCity(city);
		client.setAddress(address);
		client.setPhoneNum(phoneNum);
		client.setEmail(email);
		
	}

	
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	private void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public int getAgentId() {
		return agentId;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	private void setGender(String gender) {
		this.gender = gender;
	}
}

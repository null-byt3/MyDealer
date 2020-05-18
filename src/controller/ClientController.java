package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.client.Client;
import model.database.ClientDB;
import model.database.Serializer;

public class ClientController {

	private ClientDB clientDB;
	private Serializer serializer;
	private Client client = null;
	
	public ClientController() {
		this.serializer = Serializer.getInstance();
		clientDB = (ClientDB)serializer.load("ClientDB");
				
	}
	
	public ArrayList<Client> getClientsList() {
		return clientDB;
	}
	
	public int getAgentId(int id) {
		setClient(id);
		return client.getAgentId();
	}
	
	public String getFirstName(int id) {
		setClient(id);
		return client.getFirstName();
	}
	
	public String getLastName(int id) {
		setClient(id);
		return client.getLastName();
	}
	
	public String getGender(int id) {
		setClient(id);
		return client.getGender();
	}
	
	public String getCity(int id) {
		setClient(id);
		return client.getCity();
	}
	
	public String getAddress(int id) {
		setClient(id);
		return client.getAddress();
	}
	
	public String getPhoneNum(int id) {
		setClient(id);
		return client.getPhoneNum();
	}
	
	public String getEmail(int id) {
		setClient(id);
		return client.getEmail();
	}
	
	public String[][] getClientMatrix() {
		String[][] clientMatrix;
		int size = clientDB.size();
		clientMatrix = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			clientMatrix[i] = new String[7];
			Client client = clientDB.get(i);
			clientMatrix[i][0] = String.valueOf(client.getId());
			clientMatrix[i][1] = client.getFirstName();
			clientMatrix[i][2] = client.getLastName();
			clientMatrix[i][3] = client.getCity();
			clientMatrix[i][4] = client.getAddress();
			clientMatrix[i][5] = client.getPhoneNum();
			clientMatrix[i][6] = client.getEmail();
		}
		
		return clientMatrix;
	}
	
	public void updateClient(int id, String firstName, String lastName, String gender, String city, String address, String phoneNum, String email) {
		for (Client client : clientDB) {
			if (client.getId() == id) {
				client.setFirstName(firstName);
				client.setLastName(lastName);
				client.setGender(gender);
				client.setCity(city);
				client.setAddress(address);
				client.setPhoneNum(phoneNum);
				client.setEmail(email);
				System.out.println("Client ID " + client.getId() + " was updated successfully");
				updateDB();
				return;
			}
		}
		System.out.println("updateClient -> client id not found");
	}
	
	
	public void createClient(int agentId, String firstName, String lastName, String gender, String city, String address, String phoneNum, String email) {
		Client new_client = new Client(agentId,firstName,lastName, gender, city, address, phoneNum, email);
		createClient(new_client);
	}
	
	private void createClient(Client new_client) {
		clientDB.add(new_client);
		updateDB();
		System.out.println(new_client.getFullName() + " successfully added to DB");
	}
	
	private void updateDB() {
		serializer.save("ClientDB", clientDB);
		System.out.println("ClientDB successfully updated");
	}
	
	private void setClient(int id) {
		
		if (client != null && client.getId() == id) {
			return;
		}
	
		for (Client client : clientDB) {
			if (client.getId() == id) {
				this.client = client;
				return;
			}
		}
	}

}

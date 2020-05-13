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
	private JPanel current_panel;
	
	public ClientController() {
		this.serializer = new Serializer();
		try {
			this.clientDB = (ClientDB)serializer.deserialize("ClientDB.db");
			} catch (Exception e) {
				System.out.println("ClientController -> Cannot desrialize ClientDB.db");
			}
		//this.current_panel = current_panel;
				
	}
	
	public ArrayList<Client> getClientsList() {
		return clientDB;
	}
	
	public Client getClient(int id) {
		Client selected_client = new Client();
		
		for (Client client : clientDB) {
			if (client.getId() == id) {
				return client;
			}
		}
		return selected_client;
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
	
	public void updateClient(int id, Client updated_client) {
		for (Client client : clientDB) {
			if (client.getId() == id) {
				client = updated_client;
				System.out.println("Client ID " + client.getId() + " was updated successfully");
				updateDB();
				return;
			}
		}
	}
	
	public void createClient(int agentId, String firstName, String lastName, String gender, String city, String address, String phoneNum, String email) {
		Client new_client = new Client(agentId,firstName,lastName, gender, city, address, phoneNum, email);
		createClient(new_client);
	}
	
	private void createClient(Client new_client) {
		clientDB.add(new_client);
		System.out.println(new_client.getFullName() + " successfully added to DB");
		updateDB();
	}
	
	private void updateDB() {
		serializer.serialize("ClientDB.db", clientDB);
		System.out.println("ClientDB successfully updated");
	}

}

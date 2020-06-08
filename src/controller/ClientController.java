package controller;

import java.util.ArrayList;

import model.client.Client;
import model.database.ClientDB;
import model.database.IdProvider;
import model.database.Serializer;

public class ClientController {

	private ClientDB clientDB;
	private Serializer serializer;
	private Client curr_client = null;
	private EmployeeController employeecontroller;

	public ClientController() {
		this.serializer = Serializer.getInstance();
		clientDB = (ClientDB) serializer.load("ClientDB");
		this.employeecontroller = new EmployeeController();
	}

	public ArrayList<Client> getClientsList() {
		return clientDB;
	}

	public ArrayList<Integer> getAllClientIds(int agentId) {

		ArrayList<Integer> client_ids = new ArrayList<Integer>();
		if (agentId != 0) {
			for (Client client : clientDB) {
				if (client.getAgentId() == agentId) {
					client_ids.add(client.getId());
				}
			}
		}

		else {
			for (Client client : clientDB) {
				client_ids.add(client.getId());
			}
		}

		return client_ids;
	}

	public int getAgentId(int id) {
		cacheClient(id);
		return curr_client.getAgentId();
	}

	public String getFirstName(int id) {
		cacheClient(id);
		return curr_client.getFirstName();
	}

	public String getLastName(int id) {
		cacheClient(id);
		return curr_client.getLastName();
	}

	public String getFullName(int id) {
		cacheClient(id);
		return curr_client.getFirstName() + " " + curr_client.getLastName();
	}

	public String getGender(int id) {
		cacheClient(id);
		return curr_client.getGender();
	}

	public String getCity(int id) {
		cacheClient(id);
		return curr_client.getCity();
	}

	public String getAddress(int id) {
		cacheClient(id);
		return curr_client.getAddress();
	}

	public String getPhoneNum(int id) {
		cacheClient(id);
		return curr_client.getPhoneNum();
	}

	public String getEmail(int id) {
		cacheClient(id);
		return curr_client.getEmail();
	}

	public String[][] getClientMatrix() {
		String[][] clientMatrix;
		int size = clientDB.size();
		clientMatrix = new String[size][];
		for (int i = 0; i < size; i++) {
			clientMatrix[i] = new String[7];
			Client client = clientDB.get(i);
			clientMatrix[i][0] = String.valueOf(client.getId());
			clientMatrix[i][1] = client.getFirstName();
			clientMatrix[i][2] = client.getLastName();
			clientMatrix[i][3] = client.getCity();
			clientMatrix[i][4] = client.getAddress();
			clientMatrix[i][5] = client.getPhoneNum();

			int agentId = client.getAgentId();
			String agent_name = employeecontroller.getFirstName(agentId) + " "
					+ employeecontroller.getLastName(agentId);

			clientMatrix[i][6] = agent_name;
		}

		return clientMatrix;
	}

	public void updateClient(int id, String firstName, String lastName, String gender, String city, String address,
			String phoneNum, String email) {
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

	public void createClient(int agentId, String firstName, String lastName, String gender, String city, String address,
			String phoneNum, String email) {
		int id = serializer.getNextId("clientId");
		Client new_client = new Client(id, agentId, firstName, lastName, gender, city, address, phoneNum, email);
		createClient(new_client);
	}

	private void createClient(Client new_client) {
		clientDB.add(new_client);
		updateDB();
		System.out.println(new_client.getFullName() + " successfully added to DB");
	}

	public void eraseClient(int id) {
		cacheClient(id);
		clientDB.remove(curr_client);
		updateDB();
	}

	private void updateDB() {
		serializer.save("ClientDB", clientDB);
		System.out.println("ClientDB successfully updated");
	}

	private void cacheClient(int id) {

		if (curr_client != null && curr_client.getId() == id) {
			return;
		}

		for (Client client : clientDB) {
			if (client.getId() == id) {
				this.curr_client = client;
				return;
			}
		}
	}

}

package model.database_initializers;

import controller.ClientController;
import model.client.Client;
import model.database.ClientDB;
import model.database.IdProvider;
import model.database.Serializer;

public class ClientDBinitializer {

	public static void main(String[] args) {

		Serializer serializer = Serializer.getInstance();
		ClientController clientcontroller = new ClientController();
		ClientDB clientdb = null;
		IdProvider idprovider = new IdProvider();
		serializer.save("IdProvider", idprovider);
		clientdb = (ClientDB) serializer.load("ClientDB");

		if (clientdb == null) {
			System.out.println("ClientDB.db Not found. Creating...");
			clientdb = new ClientDB();
			
		} 
		
		else {
			System.out.println("ClientDB found. Erasing contents..");
			clientdb.clear();
		}
		

		
		// Create and add everything back
		Client client1 = new Client(serializer.getNextId("clientId"),1, "Michael", "Jordan", "Male", "New Jersy", "nevermind", "0508441414", "mjordan@nba.com");
		Client client2 = new Client(serializer.getNextId("clientId"),1, "Donald", "Trump", "Male", "newyork", "whitehouse", "97441","therealdonaldtrump@whitehouse.com");
		Client client3 = new Client(serializer.getNextId("clientId"),1, "Vladimir", "Putin", "Male", "Moscov", "kemrlin 1", "0508980797","vladimir@motherrussia.com");
		Client client4 = new Client(serializer.getNextId("clientId"),1, "Etay", "Rabino", "Male", "etay", "e123", "0508980797","YeledZevel@hit.ac.il");
		Client client5 = new Client(serializer.getNextId("clientId"),1, "Noam", "Miadanee", "Male", "rehovot", "hahamim 2/5", "0508980797", "NoamMiadanee@gmail.com");
		Client client6 = new Client(serializer.getNextId("clientId"),1, "John", "Smith", "Male","jsmith", "12345", "0508980797", "jsmith@example.com");

		clientdb.add(client1);
		clientdb.add(client2);
		clientdb.add(client3);
		clientdb.add(client4);
		clientdb.add(client5);
		clientdb.add(client6);

		// Serialize the file (aka save to DB)
		serializer.save("ClientDB", clientdb);

	}

}
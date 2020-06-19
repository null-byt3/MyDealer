package model.database_initializers;

import model.InputValidation.InputValidationException;
import model.client.Client;
import model.database.ClientDB;
import model.database.Serializer;

public class ClientDBinitializer {

	public static ClientDB getDB() {

		Serializer serializer = Serializer.getInstance();
		ClientDB clientdb = new ClientDB();

		Client client1, client2, client3, client4, client5, client6, client7;
		Client client8, client9, client10, client11, client12, client13, client14;

		try {
			client1 = Client.createClient(serializer.getNextId("clientId"), 1000, "Michael", "Jordan", "Male", "Lod",
					"HaShayatim 13/15", "050-8441414", "mjordan@nba.com");
			client2 = Client.createClient(serializer.getNextId("clientId"), 1003, "Donald", "Trump", "Male", "Netanya",
					"Nahal Lachish 14", "054-9744156", "therealdonaldtrump@whitehouse.com");
			client3 = Client.createClient(serializer.getNextId("clientId"), 1004, "Vladimir", "Putin", "Male",
					"Netanya", "Hertzel 7", "050-8980797", "vladimir@motherrussia.com");
			client4 = Client.createClient(serializer.getNextId("clientId"), 1000, "Scarlett", "Johanson", "Female",
					"Ramat Gan", "Weinstein 23/9", "08-9224892", "YeledZevel@hit.ac.il");
			client5 = Client.createClient(serializer.getNextId("clientId"), 1005, "Noam", "Miadanee", "Male", "Ashdod",
					"Hahamim 3", "08-9451062", "NoamMiadanee@gmail.com");
			client6 = Client.createClient(serializer.getNextId("clientId"), 1003, "Jerome", "Hart", "Male", "Ashkelon",
					"Beit Lebron 80", "04-6039277", "jsmith@example.com");
			client7 = Client.createClient(serializer.getNextId("clientId"), 1004, "Karina", "Morgan", "Female",
					"Bnei Brak", "HaShokdim 43/19", "054-7638259", "jsmith@example.com");
			client8 = Client.createClient(serializer.getNextId("clientId"), 1000, "Jasmin", "DeSoto", "Female", "Eilat",
					"Nahal Kishon 43/12", "052-6325888", "jsmith@example.com");
			client9 = Client.createClient(serializer.getNextId("clientId"), 1003, "Nelson", "Rose", "Male", "Hardera",
					"HaHavoda 11", "04-7790330", "jsmith@example.com");
			client10 = Client.createClient(serializer.getNextId("clientId"), 1003, "Hugo", "Patel", "Male", "Haifa",
					"Bialik 16/16", "054-3345879", "jsmith@example.com");
			client11 = Client.createClient(serializer.getNextId("clientId"), 1005, "Natalia", "Allen", "Female",
					"Haifa", "Dizengoff 20/4", "054-3345878", "jsmith@example.com");
			client12 = Client.createClient(serializer.getNextId("clientId"), 1004, "Theodorre", "Pittman", "Male",
					"Holon", "Kislev 99", "054-3345875", "jsmith@example.com");
			client13 = Client.createClient(serializer.getNextId("clientId"), 1000, "Bradley", "Cooper", "Male",
					"Kfar Saba", "Nagmashim 20/12", "050-3345862", "jsmith@example.com");
			client14 = Client.createClient(serializer.getNextId("clientId"), 1003, "Vin", "Diesel", "Male", "Rehovot",
					"Tzeelim 4/12", "052-9235864", "jsmith@example.com");

			clientdb.add(client1);
			clientdb.add(client2);
			clientdb.add(client3);
			clientdb.add(client4);
			clientdb.add(client5);
			clientdb.add(client6);
			clientdb.add(client7);
			clientdb.add(client8);
			clientdb.add(client9);
			clientdb.add(client10);
			clientdb.add(client11);
			clientdb.add(client12);
			clientdb.add(client13);
			clientdb.add(client14);

		} catch (InputValidationException ex) {

			ex.printStackTrace();
		}

		return clientdb;
	}

}
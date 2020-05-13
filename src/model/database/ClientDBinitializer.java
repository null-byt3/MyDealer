package model.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;

import model.client.Client;

public class ClientDBinitializer {

	public static void main(String[] args) {

		Serializer serializer = new Serializer();
		ClientDB clientdb = null;

		try {
			// Fetch whatever EmployeeDB currently saved
			clientdb = (ClientDB) serializer.deserialize("ClientDB.db");

		} catch (NullPointerException e) {
			System.out.println("ClientDB.db Not found. Creating...");
			clientdb = new ClientDB();

		} catch (Exception e) {
			System.out.println("Could not open file ClientDB. Attempting to delete..");
			File file = new File("ClientDB.db");
			if (file.delete()) {
				System.out.println("File Deleted Successfully. Creating new ClientDB.db");
				clientdb = new ClientDB();
			} 
			else {
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getPath());
				System.out.println("Does file exist? " + file.exists());
				System.out.println("Can i read? " + file.canRead() + " Can i write? " + file.canWrite());
				System.out.println("Could not delete File. Please try manually");
				e.printStackTrace();
			}
		}
		

		// Empty DB
		clientdb.clear();

		// Create and add everything back
		Client client1 = new Client(1, "Michael", "Jordan", "Male", "New Jersy", "nevermind", "0508441414", "mjordan@nba.com");
		Client client2 = new Client(1, "Donald", "Trump", "Male", "newyork", "whitehouse", "97441","therealdonaldtrump@whitehouse.com");
		Client client3 = new Client(1, "Vladimir", "Putin", "Male", "Moscov", "kemrlin 1", "0508980797","vladimir@motherrussia.com");
		Client client4 = new Client(1, "Etay", "Rabino", "Male", "etay", "e123", "0508980797","YeledZevel@hit.ac.il");
		Client client5 = new Client(1, "Noam", "Miadanee", "Male", "rehovot", "hahamim 2/5", "0508980797", "NoamMiadanee@gmail.com");
		Client client6 = new Client(3, "John", "Smith", "Male","jsmith", "12345", "0508980797", "jsmith@example.com");

		clientdb.add(client1);
		clientdb.add(client2);
		clientdb.add(client3);
		clientdb.add(client4);
		clientdb.add(client5);
		clientdb.add(client6);

		// Serialize the file (aka save to DB)
		serializer.serialize("ClientDB.db", clientdb);

	}

}
package database;
import Client.Client;
public class ClientDBinitializer {

public static void main(String[] args) {
	
	Serializer serializer = new Serializer();
	
	// Fetch whatever EmployeeDB currently saved
	ClientDB clientb = (ClientDB)serializer.deserialize("ClientDB");
	
	// Empty DB
	clientb.clear();	
	
	// Create and add everything back
	 Client Michel = new Client(1,"Michel","Jordon","New Jersy","nevermind","0508441414");
	 Client Donald = new Client(1,"Donald","Trump","newyork","whitehouse","97441");
	 Client Vladimir = new Client(1,"Vladimir", "Putin", "Moscov", "kemrlin 1", "0508980797");
	 Client John = new Client(1,"Etay","Rabino","etay","e123", "0508980797");
	 Client Noam= new Client(1,"Noam", "Miadanee", "rehovot", "hahamim 2/5", "0508980797");
	 Client Alexandra= new Client(3,"John","Smith","jsmith","12345","0508980797");
	
	 clientb.add(Michel);
	 clientb.add(Donald);
	 clientb.add(Vladimir);
	 clientb.add(John); 
	 clientb.add(Noam);
	 clientb.add(Alexandra);
	
	// Serialize the file (aka save to DB)
	serializer.serialize("ClientDB", clientb);
	
}

}
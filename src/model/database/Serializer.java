package model.database;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	private EmployeeDB employeedb = null;
	private ClientDB clientdb = null;
	private InventoryDB inventorydb = null;
	private OrderDB orderdb = null;
	private IdProvider idprovider = null;
	private CarPropertiesDB carpropertiesdb = null;
	private static Serializer serializer = null;
	
	private Serializer() {

	}

	public static Serializer getInstance() {
		if(serializer == null) {
			serializer = new Serializer();
		}
		
		return serializer;
	}
	
	
	public void save(String db, Object data) {
		if (db.equals("EmployeeDB")) {
			employeedb = (EmployeeDB)data;
			serialize("EmployeeDB.db",employeedb);
		}
		
		else if (db.equals("ClientDB")) {
			clientdb = (ClientDB)data;
			serialize("ClientDB.db",clientdb);
		}
		
		else if (db.equals("InventoryDB")) {
			inventorydb = (InventoryDB)data;
			serialize("InventoryDB.db",inventorydb);
		}
		
		else if (db.equals("OrderDB")) {
			orderdb = (OrderDB)data;
			serialize("OrderDB.db",orderdb);
		}
		else if (db.equals("IdProvider")) {
			serialize("IdProvider",idprovider);
		}
		else if (db.equals("CarPropertiesDB")) {
			carpropertiesdb = (CarPropertiesDB)data;
			serialize("CarPropertiesDB.db",carpropertiesdb);
		}
		
		else {
			System.out.println("Can't save. Invalid DB");
			return;
		}
	}
	
	public Object load(String db) {
		Object data = null;
		if (db.equals("EmployeeDB")) {
			if (employeedb == null) {
				employeedb = (EmployeeDB)this.deserialize("EmployeeDB.db");
			} 
			data = employeedb;
		}
		else if (db.equals("ClientDB")) {
			if (clientdb == null) {
				clientdb = (ClientDB)this.deserialize("ClientDB.db");
			} 
			data = clientdb;
		}
		else if (db.equals("InventoryDB")) {
			if (inventorydb == null) {
				inventorydb = (InventoryDB)this.deserialize("InventoryDB.db");
			} 
			data = inventorydb;
		}
		else if (db.equals("OrderDB")) {
			if (orderdb == null) {
				orderdb = (OrderDB)this.deserialize("OrderDB.db");
			}
			data = orderdb;
		}		
		else if (db.equals("IdProvider")) {
			if (idprovider == null) {
				idprovider = (IdProvider)this.deserialize("IdProvider");
			}
		}
		else if (db.equals("CarPropertiesDB")) {
			if (carpropertiesdb == null) {
				carpropertiesdb = (CarPropertiesDB)this.deserialize("CarPropertiesDB.db");

			}
			data = carpropertiesdb;
		}
		
		else {
			System.out.println("Error. DB Not found");
		}
		return data;
	}
	
	public int getNextId(String type) {
		int id = 0;
		
		if (idprovider == null) {
			idprovider = (IdProvider)this.deserialize("IdProvider");
		}
		id = idprovider.generateId(type);
		serialize("IdProvider", idprovider);
		
		return id;
	}
	
	public void resetId(String type) {
		if (idprovider == null) {
			idprovider = (IdProvider)this.deserialize("IdProvider");
			if (idprovider == null) {
				idprovider = new IdProvider();
			}
		}
		idprovider.reset(type);
		serialize("IdProvider", idprovider);
	}
	
	
	
	private void serialize(String fileName, Object data) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
		    System.out.println("Serializer | " + fileName + " saved successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	private Object deserialize(String fileName)  {
		Object data = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);

			data = ois.readObject();

			ois.close();
			fis.close();
			System.out.println("Serializer | " + fileName + " opened successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			data = null;
			//System.out.println("Serializer | File not found");
		} catch (ClassNotFoundException c) {
			System.out.println("Serializer | Class not found");
		} catch (Exception e) {
			System.out.println("Serializer | General Error");
		}
		return data;

	}
	
	
}

package model.database;

import java.io.Serializable;
import java.util.HashMap;

public class IdProvider implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> map = new HashMap<String, Integer>();

	public int generateId(String type) {

		int id = 0;

		if (map.containsKey(type)) {
			id = map.get(type);
			map.put(type, id + 1);
		}
		return id;
	}

	public void reset(String type) {

		if (type.equals("employeeId")) {
			map.put("employeeId", 1000);

		} else if (type.equals("clientId")) {
			map.put("clientId", 2000);

		} else if (type.equals("orderId")) {
			map.put("orderId", 3000);

		} else if (type.equals("inventoryId")) {
			map.put("inventoryId", 4000);

		} else {
			System.out.println("IdProvider | reset | DB Type not found");
		}
	}
}

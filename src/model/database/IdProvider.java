package model.database;

import java.io.Serializable;
import java.util.HashMap;

public class IdProvider implements Serializable {
	private HashMap<String, Integer> map;

	public int generateId(String type) {
		initializer();
		int id = 0;
		
		if (map.containsKey(type)) {
			id = map.get(type);
			map.put(type, id + 1);
		}
		return id;
	}
	
	public void resetIds() {
		map = new HashMap<>();
		map.put("employeeId", 1000);
		map.put("clientId", 2000);
		map.put("orderId", 3000);
		map.put("inventoryId", 4000);
	}

	private void initializer() {
		if (map == null) {
			resetIds();
		}

		return;
	}

}

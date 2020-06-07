package controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.database.ClientDB;
import model.database.EmployeeDB;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;

public class ReportsController {

	// DBs
	
	private ClientDB clientDB;
	private OrderDB orderDB;
	private EmployeeDB employeeDB;
	private Serializer serializer;
	
	// Controllers
	private InventoryController inventoryController;
	private CarPropertiesController carpropscontroller;
	private EmployeeController employeecontroller;
	private ClientController clientcontroller;
	private LoginController logincontroller;
		
	
	public ReportsController() {
		
		carpropscontroller = new CarPropertiesController();
		inventoryController = new InventoryController();
		employeecontroller = new EmployeeController();
		clientcontroller = new ClientController();
		logincontroller = new LoginController();
		

		this.serializer = Serializer.getInstance();
	}
	
	public String[][] getMostSoldModelMatrix() {
		
		refreshDBs();
		String[][] dataMatrix;
		ArrayList<String> model_names = carpropscontroller.getAllModelNames();
		
		int size = model_names.size();
		dataMatrix = new String[size][];
		
		int agentId = logincontroller.getLoggedUserId();
		
		for (int i = 0; i < size ; i++) {
			
			String model = model_names.get(i);
			
			Entry<Integer,Integer> amountAndValue = AmountSoldAndValue(model, agentId);
			int amountSold = amountAndValue.getKey();
			int sumOfValue = amountAndValue.getValue();
			
			dataMatrix[i] = new String[4];
			dataMatrix[i][0] = carpropscontroller.getMake(model);
			dataMatrix[i][1] = model;
			dataMatrix[i][2] = String.valueOf(amountSold);
			dataMatrix[i][3] = String.valueOf(sumOfValue);
		}
		
		
		return dataMatrix;
	}
	
	public Entry<Integer,Integer> AmountSoldAndValue(String model, int agentId) {
				
		int sum = 0;
		int num = 0;
		
		for (Order order : orderDB) {
			if (order.getAgentId() == agentId && order.getCar().getModel().equals(model)) {
				sum += order.getFinalPrice();
				num++;
			}
		}
		
		Entry<Integer,Integer> amountValue = new SimpleEntry<Integer,Integer>(num, sum);
		return amountValue;
	}
	
	
	public void refreshDBs() {
		 clientDB = (ClientDB)serializer.load("ClientDB");
		 orderDB = (OrderDB)serializer.load("OrderDB");
		employeeDB = (EmployeeDB)serializer.load("EmployeeDB");
		
	}
}

package controller;

import java.util.AbstractMap.SimpleEntry;
import java.text.NumberFormat;
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

	// DATA
	int agentId;

	// Controllers
	private InventoryController inventoryController;
	private CarPropertiesController carpropscontroller;
	private EmployeeController employeecontroller;
	private ClientController clientcontroller;
	private LoginController logincontroller;
	private OrderController ordercontroller;

	public ReportsController() {

		carpropscontroller = new CarPropertiesController();
		inventoryController = new InventoryController();
		employeecontroller = new EmployeeController();
		clientcontroller = new ClientController();
		logincontroller = new LoginController();
		ordercontroller = new OrderController();
		this.serializer = Serializer.getInstance();

		agentId = logincontroller.getLoggedUserId();
	}

	public Object[][] getMostSoldModelMatrix(boolean restrictToUser) {

		refreshDBs();
		Object[][] dataMatrix;
		ArrayList<String> model_names = carpropscontroller.getAllModelNames();

		int size = model_names.size();
		dataMatrix = new Object[size][];

		for (int i = 0; i < size; i++) {

			String model = model_names.get(i);
			Entry<Integer, Integer> amountAndValue;
			
			if (restrictToUser) {
				amountAndValue = AmountSoldAndValueAgent(model, agentId);
	
			}
			else {
				amountAndValue = AmountSoldAndValueAgent(model, 0);
			}
			
			int amountSold = amountAndValue.getKey();
			int sumOfValue = amountAndValue.getValue();

			dataMatrix[i] = new Object[4];
			dataMatrix[i][0] = carpropscontroller.getMake(model);
			dataMatrix[i][1] = model;
			dataMatrix[i][2] = amountSold;
			dataMatrix[i][3] = sumOfValue;
		}

		return dataMatrix;
	}

	public Object[][] getTopClientByCashMatrix(boolean restrictToUser) {

		refreshDBs();
		Object[][] dataMatrix;
		ArrayList<Integer> allClientIds;
		if (restrictToUser) {
			allClientIds = clientcontroller.getAllClientIds(agentId);
		} else {
			allClientIds = clientcontroller.getAllClientIds(0);
		}

		int size = allClientIds.size();
		dataMatrix = new Object[size][];

		for (int i = 0; i < size; i++) {

			int id = allClientIds.get(i);

			Entry<Integer, Integer> ordersAndCash = OrdersAndValueClient(id);
			int amountSold = ordersAndCash.getKey();
			int sumOfValue = ordersAndCash.getValue();

			// Client ID, Client Name, Num of orders, total value;

			dataMatrix[i] = new Object[4];
			dataMatrix[i][0] = String.valueOf(id);
			dataMatrix[i][1] = clientcontroller.getFullName(id);
			dataMatrix[i][2] = amountSold;
			dataMatrix[i][3] = sumOfValue;
		}

		return dataMatrix;

	}

	public Object[][] getTopOrderByCashMatrix(boolean restrictToUser) {

		refreshDBs();
		Object[][] dataMatrix;
		ArrayList<Integer> allOrderIds;
		if (restrictToUser) {
			allOrderIds = ordercontroller.getAllOrderIds(agentId);

		}

		else {
			allOrderIds = ordercontroller.getAllOrderIds(0);
		}

		int size = allOrderIds.size();
		dataMatrix = new Object[size][];

		for (int i = 0; i < size; i++) {

			int id = allOrderIds.get(i);

			Entry<Integer, Integer> ordersAndCash = OrdersAndValueClient(id);
			int amountSold = ordersAndCash.getKey();
			int sumOfValue = ordersAndCash.getValue();

			Order order = ordercontroller.getOrder(id);

			dataMatrix[i] = new Object[4];
			dataMatrix[i][0] = String.valueOf(id);
			dataMatrix[i][1] = clientcontroller.getFullName(order.getClientId());
			dataMatrix[i][2] = order.getCar().toString();
			dataMatrix[i][3] = order.getFinalPrice();
		}

		return dataMatrix;

	}
	
	public Object[][] getTopAgentMatrix() {

		refreshDBs();
		Object[][] dataMatrix;
		ArrayList<Integer> allAgentIds = employeecontroller.getAllAgentIds();


		int size = allAgentIds.size();
		dataMatrix = new Object[size][];

		for (int i = 0; i < size; i++) {

			int id = allAgentIds.get(i);

			Entry<Integer, Integer> ordersAndCash = OrdersAndValueAgent(id);
			int amountSold = ordersAndCash.getKey();
			int sumOfValue = ordersAndCash.getValue();

			Order order = ordercontroller.getOrder(id);
			// Agent ID, Agent Name, Num of orders, total value;

			dataMatrix[i] = new Object[4];
			dataMatrix[i][0] = String.valueOf(id);
			dataMatrix[i][1] = employeecontroller.getFirstName(id) + " " + employeecontroller.getLastName(id);
			dataMatrix[i][2] = amountSold;
			dataMatrix[i][3] = sumOfValue;
		}

		return dataMatrix;

	}

	/// >>>>>>>>>>>>>>> HELP METHODS

	public Entry<Integer, Integer> OrdersAndValueClient(int clientId) {

		int sum = 0;
		int num = 0;

		for (Order order : orderDB) {
			if (order.getClientId() == clientId) {
				sum += order.getFinalPrice();
				num++;
			}
		}

		Entry<Integer, Integer> amountValue = new SimpleEntry<Integer, Integer>(num, sum);
		return amountValue;
	}
	
	public Entry<Integer, Integer> OrdersAndValueAgent(int agentId) {

		int sum = 0;
		int num = 0;

		for (Order order : orderDB) {
			if (order.getAgentId() == agentId) {
				sum += order.getFinalPrice();
				num++;
			}
		}

		Entry<Integer, Integer> amountValue = new SimpleEntry<Integer, Integer>(num, sum);
		return amountValue;
	}

	public Entry<Integer, Integer> AmountSoldAndValueAgent(String model, int agentId) {

		int sum = 0;
		int num = 0;

		if (agentId == 0) {
			for (Order order : orderDB) {
				if (order.getCar().getModel().equals(model)) {
					sum += order.getFinalPrice();
					num++;
				}
			}
		}

		else {

			for (Order order : orderDB) {
				if (order.getAgentId() == agentId && order.getCar().getModel().equals(model)) {
					sum += order.getFinalPrice();
					num++;
				}
			}
		}

		Entry<Integer, Integer> amountValue = new SimpleEntry<Integer, Integer>(num, sum);
		return amountValue;
	}

	public void refreshDBs() {
		clientDB = (ClientDB) serializer.load("ClientDB");
		orderDB = (OrderDB) serializer.load("OrderDB");
		employeeDB = (EmployeeDB) serializer.load("EmployeeDB");

	}

}

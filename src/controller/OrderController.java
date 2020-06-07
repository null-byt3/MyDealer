package controller;

import java.text.NumberFormat;
import java.util.ArrayList;

import model.car.Car;
import model.client.Client;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;

public class OrderController {

	private OrderDB orderdb;
	private Serializer serializer;
	private InventoryController inventoryController;
	private CarPropertiesController carpropscontroller;
	private EmployeeController employeecontroller;
	private ClientController clientcontroller;

	public OrderController() {
		serializer = Serializer.getInstance();
		orderdb = (OrderDB) serializer.load("OrderDB");
		carpropscontroller = new CarPropertiesController();
		inventoryController = new InventoryController();
		employeecontroller = new EmployeeController();
		clientcontroller = new ClientController();
	}

	public ArrayList<Order> getOrdersList() {
		return orderdb;
	}

	public Order getOrder(int id) {
		Order selected_order = null;

		for (Order order : orderdb) {
			if (order.getOrderId() == id) {
				selected_order = order;
			}
		}
		return selected_order;
	}

	public ArrayList<Integer> getAllOrderIds() {

		ArrayList<Integer> allOrderIds = new ArrayList<Integer>();

		for (Order order : orderdb) {
			int id = order.getOrderId();
			
			if (!allOrderIds.contains(id)) {
				allOrderIds.add(id);
			}
		}

		return allOrderIds;
	}

	public String[][] getOrderMatrix() {
		String[][] orderMatrix;
		int size = orderdb.size();
		orderMatrix = new String[size][];
		for (int i = 0; i < size; i++) {
			orderMatrix[i] = new String[6];
			Order order = orderdb.get(i);

			String client_name = clientcontroller.getFirstName(order.getClientId()) + " "
					+ clientcontroller.getLastName(order.getClientId());
			String agent_name = employeecontroller.getFirstName(order.getAgentId()) + " "
					+ employeecontroller.getLastName(order.getAgentId());

			orderMatrix[i][0] = String.valueOf(order.getOrderId());
			orderMatrix[i][1] = order.getDateTime();
			orderMatrix[i][2] = String.valueOf(agent_name);
			orderMatrix[i][3] = String.valueOf(client_name);
			orderMatrix[i][4] = String.valueOf(order.getCar().toString());
			orderMatrix[i][5] = priceFormatter(order.getFinalPrice());

		}
		return orderMatrix;
	}

	public void updateOrder(int id, Order updated_order) {
		for (Order order : orderdb) {
			if (order.getOrderId() == id) {
				order = updated_order;
				System.out.println("Order ID " + order.getOrderId() + " was updated successfully");
				updateDB();
				return;
			}
		}
	}

	public void createOrder(int clientId, int agentId, String make, String model, String trim, String color,
			int basePrice, int totalPrice, int discount, int finalPrice, int warrantyPrice, int mobileEyePrice,
			int reverseSensorsPrice, int windowLiftersPrice) {

		int orderId = serializer.getNextId("orderId");
		String type = carpropscontroller.getType(model);
		Car new_car = new Car(type, make, model, trim, color);
		Order new_order = new Order(orderId, clientId, agentId, new_car, basePrice, totalPrice, discount, finalPrice,
				warrantyPrice, mobileEyePrice, reverseSensorsPrice, windowLiftersPrice);
		inventoryController.remove(make, model, trim, color, 1);
		createOrder(new_order);
	}

	private void createOrder(Order new_order) {
		orderdb.add(new_order);
		System.out.println("Order No. " + new_order.getOrderId() + " successfully added to DB");
		updateDB();
	}

	private void updateDB() {
		serializer.save("OrderDB", orderdb);
		System.out.println("OrderDB successfully updated");
	}

	public String priceFormatter(int num) {

		String formatted_string = NumberFormat.getIntegerInstance().format(num) + "₪";
		return formatted_string;
	}
}

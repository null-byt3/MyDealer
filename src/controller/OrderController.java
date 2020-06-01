package controller;

import java.util.ArrayList;

import model.client.Client;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;

public class OrderController {

	
	private OrderDB orderdb;
	private Serializer serializer;
	
	
	public OrderController() {
		serializer = Serializer.getInstance();
		orderdb = (OrderDB)serializer.load("OrderDB");		
	}
	
	
	public ArrayList<Order> getOrdersList() {
		return orderdb;
	}
	
	
	public Order getOrder(int id) {
		Order selected_order = null;
		
		for (Order order : orderdb) {
			if (order.getId() == id) {
				selected_order = order;
			}
		}
		return selected_order;
	}
	
	public String[][] getOrderMatrix() {
		String[][] orderMatrix;
		int size = orderdb.size();
		orderMatrix = new String[size][];
		for (int i = 0 ; i < size; i++ ) {
			orderMatrix[i] = new String[4];
			Order order = orderdb.get(i);
			orderMatrix[i][0] = String.valueOf(order.getId());
			orderMatrix[i][1] = String.valueOf(order.getClientId());
			orderMatrix[i][2] = String.valueOf(order.getAgentId());
			//orderMatrix[i][3] = String.valueOf(order.getCarId());
		}
		return orderMatrix;
	}
	
	public void updateOrder(int id, Order updated_order) {
		for (Order order : orderdb) {
			if (order.getId() == id) {
				order = updated_order;
				System.out.println("Order ID " + order.getId() + " was updated successfully");
				updateDB();
				return;
			}
		}
	}
	
	
	public void createOrder() {
		Order new_order = new Order();
		createOrder(new_order);
	}
	
	private void createOrder(Order new_order) {
		orderdb.add(new_order);
		System.out.println("Order No. " + new_order.getId() + " successfully added to DB");
		updateDB();
	}
	
	private void updateDB() {
		serializer.save("OrderDB", orderdb);
		System.out.println("OrderDB successfully updated");
	}
}

package Order;

import java.io.Serializable;

public class Order implements Serializable {
	
	protected int orderId;
	private int orderDay;
	private int orderMonth;
	private int orderYear;
	private int clientId;
	private int agentId;
	private int carId;
	private static int idCounter = 1000;
	
	public Order() {
		this.orderId=idCounter++;
		this.orderDay=1;
		this.orderMonth=1;
		this.orderYear=1990;
		this.clientId=0;
		this.agentId=0;
		this.carId=0;
	}
	
	public Order(int orderDay, int orderMonth, int orderYear, int clientId, int agentId, int carId) {
		this.orderId=idCounter++;
		this.orderDay=orderDay;
		this.orderMonth=orderMonth;
		this.orderYear=orderYear;
		this.clientId=clientId;
		this.agentId=agentId;
		this.carId=carId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(int orderDay) {
		this.orderDay = orderDay;
	}

	public int getOrderMonth() {
		return orderMonth;
	}

	public void setOrderMonth(int orderMonth) {
		this.orderMonth = orderMonth;
	}

	public int getOrderYear() {
		return orderYear;
	}

	public void setOrderYear(int orderYear) {
		this.orderYear = orderYear;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	/*public String toString() {
		return "Car " + this.carId + ": Make= " + this.make + ", Model= " + this.model + ", Trim= "
				+ this.trim + ", Color= " + this.color + ", Location= " + this.location + ", Status= " + this.status + "\n";
	}*/
	
	


}

package Order;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
	
	protected int orderId;
	private String clientName;
	private String agentName;
	private int carId;
	private String orderDate;
	private static int idCounter = 1000;
	LocalDate today = LocalDate.now();
	
	public Order() {
		this.orderId=idCounter++;
		this.orderDate=null;
		this.clientName=null;
		this.agentName=null;
		this.carId=0;
	}
	
	public Order(String clientName, String agentName, int carId) {
		this.orderId=idCounter++;
		this.orderDate=today.toString();
		this.clientName=clientName;
		this.agentName=agentName;
		this.carId=carId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}
	
	/*public String toString() {
		return "Car " + this.carId + ": Make= " + this.make + ", Model= " + this.model + ", Trim= "
				+ this.trim + ", Color= " + this.color + ", Location= " + this.location + ", Status= " + this.status + "\n";
	}*/
	
	


}

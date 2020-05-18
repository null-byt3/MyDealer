package model.order;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
	
	private static int idCounter = 1000;
	protected int orderId;
	private int clientId;
	private int agentId;
	private int carId;
	
	public Order() {
		this.orderId=idCounter++;
		this.clientId=0;
		this.agentId=0;
		this.carId=0;
	}
	
	public Order(int clientId, int agentId, int carId) {
		this.orderId=idCounter++;
		this.clientId = clientId;
		this.agentId = agentId;
		this.carId = carId;
		
	}

	public int getId() {
		return orderId;
	}

	public void setId(int orderId) {
		this.orderId = orderId;
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

	
	


}

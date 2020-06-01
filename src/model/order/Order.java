package model.order;

import java.io.Serializable;
import java.time.LocalDateTime;

import model.car.Car;

public class Order implements Serializable {
	
	protected int orderId;
	private int clientId;
	private int agentId;
	private Car car;
	private LocalDateTime dateTime;
	int basePrice;
	int finalPrice;
	int discount;
	
	// OPTIONS
	private boolean isExtendedWarranty;
	int warrantyPrice;
	private boolean isMobileEyeIncluded;
	int mobileEyePrice;
	private boolean isReverseSensors;
	int reverseSensorsPrice;
	
	public Order() {
		this.orderId=0;
		this.clientId=0;
		this.agentId=0;
		this.car = null;
		this.dateTime = null;
	}
	
	public Order(int orderId, int clientId, int agentId, Car car, int basePrice, int warrantyPrice, int mobileEyePrice) {
		this.orderId=orderId;
		this.clientId = clientId;
		this.agentId = agentId;
		this.car = car;
		this.dateTime = LocalDateTime.now();
		this.basePrice = basePrice;
		this.warrantyPrice = warrantyPrice;
		this.isExtendedWarranty = warrantyPrice != 0 ? true : false;
		this.mobileEyePrice = mobileEyePrice;
		this.isMobileEyeIncluded = mobileEyePrice != 0 ? true : false;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public LocalDateTime getDateTime() {
		return this.dateTime;
	}


}

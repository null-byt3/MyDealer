package model.order;

import java.io.Serializable;
import java.time.LocalDateTime;

import model.InputValidation.InputValidationException;
import model.car.Car;

public class Order implements Serializable {

	private static final long serialVersionUID = -1029436909808753401L;
	protected int orderId;
	private int clientId;
	private int agentId;
	private Car car;
	private LocalDateTime dateTime;
	int basePrice;
	int totalPrice;
	int finalPrice;
	int discount;

	// OPTIONS
	private boolean isExtendedWarranty;
	private int ExWarrantyPrice;
	private boolean isMobileEyeIncluded;
	private int mobileEyePrice;
	private boolean isReverseSensors;
	private int reverseSensorsPrice;
	private boolean isWindowLifters;
	private int windowLiftersPrice;

	public Order() {
		this.orderId = 0;
		this.clientId = 0;
		this.agentId = 0;
		this.car = null;
		this.dateTime = null;
	}

	private Order(int orderId, int clientId, int agentId, Car car, int basePrice, int totalPrice, int discount,
			int finalPrice, int warrantyPrice, int mobileEyePrice, int reverseSensorsPrice, int windowLiftersPrice) {
		this.orderId = orderId;
		this.clientId = clientId;
		this.agentId = agentId;
		this.car = car;
		this.dateTime = LocalDateTime.now();
		this.basePrice = basePrice;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.finalPrice = finalPrice;
		this.ExWarrantyPrice = warrantyPrice;
		this.isExtendedWarranty = warrantyPrice != 0 ? true : false;
		this.mobileEyePrice = mobileEyePrice;
		this.isMobileEyeIncluded = mobileEyePrice != 0 ? true : false;
		this.reverseSensorsPrice = reverseSensorsPrice;
		this.isReverseSensors = reverseSensorsPrice != 0 ? true : false;
		this.windowLiftersPrice = windowLiftersPrice;
		this.isWindowLifters = windowLiftersPrice != 0 ? true : false;

	}

	public static Order createOrder(int orderId, int clientId, int agentId, Car car, int basePrice, int totalPrice, int discount,
			int finalPrice, int warrantyPrice, int mobileEyePrice, int reverseSensorsPrice, int windowLiftersPrice) throws InputValidationException {
		
		OrderValidator.validateInput();
		Order order = new Order(orderId, clientId, agentId, car, basePrice, totalPrice, discount, finalPrice, warrantyPrice, mobileEyePrice, reverseSensorsPrice, windowLiftersPrice);
		return order;
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

	public String getDateTime() {

		int day = this.dateTime.getDayOfMonth();
		int month = this.dateTime.getMonthValue();
		int year = this.dateTime.getYear();

		int hour = this.dateTime.getHour();
		int minute = this.dateTime.getMinute();

		String fullDateTime = day + "/" + month + "/" + year + " | " + hour + ":" + minute;

		return fullDateTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isExtendedWarranty() {
		return isExtendedWarranty;
	}

	public void setExtendedWarranty(boolean isExtendedWarranty) {
		this.isExtendedWarranty = isExtendedWarranty;
	}

	public int getExWarrantyPrice() {
		return ExWarrantyPrice;
	}

	public void setExWarrantyPrice(int exWarrantyPrice) {
		ExWarrantyPrice = exWarrantyPrice;
	}

	public boolean isMobileEyeIncluded() {
		return isMobileEyeIncluded;
	}

	public void setMobileEyeIncluded(boolean isMobileEyeIncluded) {
		this.isMobileEyeIncluded = isMobileEyeIncluded;
	}

	public int getMobileEyePrice() {
		return mobileEyePrice;
	}

	public void setMobileEyePrice(int mobileEyePrice) {
		this.mobileEyePrice = mobileEyePrice;
	}

	public boolean isReverseSensors() {
		return isReverseSensors;
	}

	public void setReverseSensors(boolean isReverseSensors) {
		this.isReverseSensors = isReverseSensors;
	}

	public int getReverseSensorsPrice() {
		return reverseSensorsPrice;
	}

	public boolean isWindowLifters() {
		return isWindowLifters;
	}

	public int getWindowLiftersPrice() {
		return windowLiftersPrice;
	}

}

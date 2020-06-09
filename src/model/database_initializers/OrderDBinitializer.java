package model.database_initializers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import controller.CarPropertiesController;
import controller.ClientController;
import controller.EmployeeController;
import model.car.Car;
import model.database.OrderDB;
import model.database.Serializer;
import model.order.Order;

public class OrderDBinitializer {

	public static OrderDB getDB() {

		Serializer serializer = Serializer.getInstance();

		OrderDB orderdb = new OrderDB();
		int size = 100;
		Car car_array[] = new Car[size];
		Order order_array[] = new Order[size];
		
		
		for (int i = 0; i < size ; i++) {
			car_array[i] = randomCar();
		}
		
		
		for (int i = 0; i < size ; i++) {
			order_array[i] = generateOrder(serializer.getNextId("orderId"),car_array[i]);
			orderdb.add(order_array[i]);
		}

		return orderdb;

	}
	
	public static Car randomCar() {
		
		CarPropertiesController carpropscontroller = new CarPropertiesController();
		
		List<String> allModels = carpropscontroller.getAllModelNames();
		Random rand = new Random();
		String model = allModels.get(rand.nextInt(allModels.size()));
		

		List<String> allTrims = carpropscontroller.getAllTrims(model);	
		rand = new Random();
		String trim = allTrims.get(rand.nextInt(allTrims.size()));
		
		List<String> allColors = carpropscontroller.getColors(model);
		rand = new Random();
		String color = allColors.get(rand.nextInt(allColors.size()));
		
		String type = carpropscontroller.getType(model);
		String make = carpropscontroller.getMake(model);
	
		Car car = new Car(type, make, model, trim, color);

		return car;
	}
	
	public static Order generateOrder(int orderId, Car car) {
		
		ClientController clientcontroller = new ClientController();
		CarPropertiesController carpropscontroller = new CarPropertiesController();
		EmployeeController employeecontroller = new EmployeeController();
		
		List<Integer> allClientIds = clientcontroller.getAllClientIds(0);
		Random rand = new Random();
		int client_id = allClientIds.get(rand.nextInt(allClientIds.size()));
		int basePrice = carpropscontroller.getPrice(car.getModel(), car.getTrim());
		
		List<Integer> warranty_values = new ArrayList<Integer>(Arrays.asList(0, 3500));		
		List<Integer> mobileEye_values = new ArrayList<Integer>(Arrays.asList(0, 3000));
		List<Integer> reverseSensors_values = new ArrayList<Integer>(Arrays.asList(0, 3000));
		List<Integer> windowLifters_values = new ArrayList<Integer>(Arrays.asList(0, 2500));
		
		rand = new Random();
		int warranty = warranty_values.get(rand.nextInt(warranty_values.size()));
		rand = new Random();
		int mobileEye = warranty_values.get(rand.nextInt(mobileEye_values.size()));
		rand = new Random();
		int reverseSensors = warranty_values.get(rand.nextInt(reverseSensors_values.size()));
		rand = new Random();
		int windowLifters = warranty_values.get(rand.nextInt(windowLifters_values.size()));
		
		int totalPrice = basePrice + warranty + mobileEye + reverseSensors + windowLifters;
		int finalPrice = totalPrice;
		int discount = 0;
		List<Integer> allAgentIds = employeecontroller.getAllAgentIds();
		rand = new Random();
		int agentId = allAgentIds.get(rand.nextInt(allAgentIds.size()));
		
		
		Order order = new Order(orderId, client_id,agentId, car, basePrice, totalPrice, discount, finalPrice, warranty, mobileEye, reverseSensors, windowLifters );
		return order;
	}
	
}
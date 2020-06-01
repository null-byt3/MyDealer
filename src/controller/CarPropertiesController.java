package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.car.CarProperties;
import model.database.CarPropertiesDB;
import model.database.Serializer;

public class CarPropertiesController {

	private CarPropertiesDB carpropsDB;
	private Serializer serializer;
	private CarProperties carprop = null;

	public CarPropertiesController() {
		this.serializer = Serializer.getInstance();
		carpropsDB = (CarPropertiesDB) serializer.load("CarPropertiesDB");
	}

	public String getMake(String model) {
		setModel(model);
		String make = carprop.getMake();
		return make;
	}

	public String getType(String model) {
		setModel(model);
		String type = carprop.getType();
		return type;
	}

	public int getNumOfTrims(String model) {
		setModel(model);
		int num = carprop.getTrims().size();
		return num;
	}

	public Map<String, Integer> getTrimsMap(String model) {
		setModel(model);
		Map<String, Integer> trims = carprop.getTrims();
		return trims;
	}

	public int getPrice(String model, String trim) {

		int price = 0;
		Map<String, Integer> trims = getTrimsMap(model);

		for (Map.Entry<String, Integer> entry : trims.entrySet()) {
			if (entry.getKey().equals(trim)) {
				price = entry.getValue();
				break;
			}
		}

		return price;
	}

	public List<String> getColors(String model) {
		setModel(model);
		List<String> colors = carprop.getColors();
		return colors;
	}

	public int getNumOfColors(String model) {
		setModel(model);
		int num = carprop.getColors().size();
		return num;
	}
	
	public String getDefaultColor(String model) {
		setModel(model);
		String default_color = carprop.getDefault_color();
		return default_color;
	}
	
	public int getColorPrice(String model) {
		int cheapest = Integer.MAX_VALUE;
		Map<String, Integer> trims = getTrimsMap(model);

		
		for (Map.Entry<String, Integer> entry : trims.entrySet()) {
			if (entry.getValue() < cheapest) {
				cheapest = entry.getValue();
			}
		}
		
		int color_price = (int) (Math.ceil(cheapest*0.02/500.0))*500;
		
		return color_price;
	}

	public String getModelType(String model) {
		setModel(model);
		String type = carprop.getType();
		return type;
	}

	public ArrayList<String> getAllModelNames() {
		ArrayList<String> model_names = new ArrayList<String>();

		for (CarProperties carProp : carpropsDB) {
			model_names.add(carProp.getModel());
		}

		return model_names;
	}

	public ArrayList<String> getAllMakeNames() {
		ArrayList<String> make_names = new ArrayList<String>();

		for (CarProperties carProp : carpropsDB) {
			String make = carProp.getMake();
			if (!make_names.contains(make)) {
				make_names.add(make);
			}
		}

		return make_names;
	}

	public ArrayList<String> getModelsByType(String type) {
		ArrayList<String> model_names = new ArrayList<String>();

		for (CarProperties carProp : carpropsDB) {
			if (carProp.getType().equals(type)) {
				model_names.add(carProp.getModel());
			}
		}

		return model_names;
	}

	public ArrayList<String> getModelsByMaker(String make) {
		ArrayList<String> model_names = new ArrayList<String>();

		for (CarProperties carProp : carpropsDB) {
			if (carProp.getMake().equals(make)) {
				model_names.add(carProp.getModel());
			}
		}

		return model_names;
	}

	public ArrayList<String> getAllCarTypes() {
		ArrayList<String> car_types = new ArrayList<String>();

		for (CarProperties carProp : carpropsDB) {
			// System.out.println("CarPropertiesController | getAllCarTypes | " +
			// carProp.getModel());
			String car_type = carProp.getType();
			if (!car_types.contains(car_type)) {
				car_types.add(car_type);
			}
		}

		return car_types;
	}

	public void updateModel(String model, Map<String, Integer> trims, List<String> colors) {
		for (CarProperties carprop : carpropsDB) {
			if (carprop.getModel().equals(model)) {
				carprop.setTrims(trims);
				carprop.setColors(colors);
				updateDB();
			}
		}
	}

	public void addModel(String type, String make, String model, Map<String, Integer> trims, List<String> colors) {
		CarProperties new_carprop = new CarProperties(type, make, model, trims, colors);
		addModel(new_carprop);
	}

	private void addModel(CarProperties carproperty) {
		carpropsDB.add(carproperty);
		updateDB();
	}

	public void deleteModel(String model) {
		setModel(model);
		carpropsDB.remove(carprop);
		updateDB();
	}

	private ArrayList<CarProperties> getCarPropsList() {
		return carpropsDB;
	}

	private void updateDB() {
		serializer.save("CarPropertiesDB", carpropsDB);
		System.out.println("Controller | CarPropertiesDB Successfully updated");
	}

	private void setModel(String model) {

		if (carprop != null && carprop.getModel().equals(model)) {
			return;
		}

		for (CarProperties carProp : carpropsDB) {
			if (carProp.getModel().equals(model)) {
				this.carprop = carProp;
				return;
			}
		}
	}
}

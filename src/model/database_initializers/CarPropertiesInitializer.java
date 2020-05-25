package model.database_initializers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.car.CarProperties;
import model.database.CarPropertiesDB;
import model.database.Serializer;

public class CarPropertiesInitializer {

	public static CarPropertiesDB getDB() {

		Serializer serializer = Serializer.getInstance();
		CarPropertiesDB carprops = new CarPropertiesDB();
				
		// Hyundai i10
		Map<String, Integer> i10_trims = new HashMap<String,Integer>();

		
		i10_trims.put("Intense", 69900);
		i10_trims.put("Inspire", 79900);
		i10_trims.put("Prime", 83900);
		i10_trims.put("Supreme", 83990);

		List<String> i10_colors = new ArrayList<String>();
		i10_colors.add("Polar White");
		i10_colors.add("Phantom Black");
		i10_colors.add("Metallic Grey");
		i10_colors.add("Sleek Silver");
		i10_colors.add("Champion Blue");
		i10_colors.add("Aqua Turquoise");
		i10_colors.add("Dragon Red");
				
		CarProperties carprop1 = new CarProperties("Compact","Hyundai","i10", i10_trims,i10_colors);
		carprops.add(carprop1);

		// Hyundai i20
		Map<String, Integer> i20_trims = new HashMap<String,Integer>();

		i20_trims.put("Intense", 95900);
		i20_trims.put("Prestige", 102990);
		i20_trims.put("Supreme", 106990);
		i20_trims.put("Supreme Plus", 108900);

		List<String> i20_colors = new ArrayList<String>();
		
		i20_colors.add("Polar White");
		i20_colors.add("Sleek Silver");
		i20_colors.add("Phantom Black");
		i20_colors.add("Champion Blue");
		i20_colors.add("Red Passion");
		i20_colors.add("Aqua Sparkling");
		i20_colors.add("Tomato Red");

		CarProperties carprop2 = new CarProperties("Compact","Hyundai","i20", i20_trims,i20_colors);
		carprops.add(carprop2);
		
		// Hyundai i30
		Map<String, Integer> i30_trims = new HashMap<String,Integer>();

		i30_trims.put("Premium", 131900);
		i30_trims.put("Luxury", 137900);

		List<String> i30_colors = new ArrayList<String>();
		
		i30_colors.add("Polar White");
		i30_colors.add("Phantom Black");
		i30_colors.add("White Sand");
		i30_colors.add("Stellar Blue");
		i30_colors.add("Micron Grey");
		i30_colors.add("Platinum Silver");

		CarProperties carprop3 = new CarProperties("Family","Hyundai","i30", i30_trims,i30_colors);
		carprops.add(carprop3);
		
		// Hyundai Accent
		Map<String, Integer> accent_trims = new HashMap<String,Integer>();

		accent_trims.put("Inspire 1.4", 117900);
		accent_trims.put("Inspire 1.6", 119900);

		List<String> accent_colors = new ArrayList<String>();
		
		accent_colors.add("Polar White");
		accent_colors.add("Phantom Black");
		accent_colors.add("Sleek Silver");
		accent_colors.add("Mouse Grey");
		accent_colors.add("Marina Blue");

		CarProperties carprop4 = new CarProperties("Family","Hyundai","Accent", accent_trims,accent_colors);
		carprops.add(carprop4);
		
		// Hyundai Elantra
		Map<String, Integer> elantra_trims = new HashMap<String,Integer>();

		elantra_trims.put("Inspire SR", 134900);

		List<String> elantra_colors = new ArrayList<String>();
		
		elantra_colors.add("Polar White");
		elantra_colors.add("Phantom Black");
		elantra_colors.add("Sparkling Metal");
		elantra_colors.add("Iron Gray");
		elantra_colors.add("Stargazing Blue");
		elantra_colors.add("Platinum Silver");

		CarProperties carprop5 = new CarProperties("Big Sedan","Hyundai","Elantra", elantra_trims,elantra_colors);
		carprops.add(carprop5);
		
		
		// Hyundai Ioniq
		Map<String, Integer> ioniq_trims = new HashMap<String,Integer>();

		ioniq_trims.put("Premium", 141900);
		ioniq_trims.put("Supreme", 142900);
		ioniq_trims.put("EV Premium", 159900);


		List<String> ioniq_colors = new ArrayList<String>();
		
		ioniq_colors.add("Polar White");
		ioniq_colors.add("Phantom Black");
		ioniq_colors.add("Electric Grey");
		ioniq_colors.add("Fluidic Silver");
		ioniq_colors.add("Iron Gray");
		ioniq_colors.add("Intense Blue");
		ioniq_colors.add("Liquid Sand");

		CarProperties carprop6 = new CarProperties("Big Sedan","Hyundai","Ioniq", ioniq_trims, ioniq_colors);
		carprops.add(carprop6);
		
		// Hyundai Kona
		Map<String, Integer> kona_trims = new HashMap<String,Integer>();

		kona_trims.put("Premium", 126900);
		kona_trims.put("Prestige", 133900);
		kona_trims.put("Supreme", 136900);
		kona_trims.put("Hybrid Premium", 139900);
		kona_trims.put("Hybrid Prestige", 142900);


		List<String> kona_colors = new ArrayList<String>();
		
		kona_colors.add("Phantom Black");
		kona_colors.add("Dark Night");
		kona_colors.add("Chalk White");
		kona_colors.add("Lake Silver");
		kona_colors.add("Tangerine Comet");
		kona_colors.add("Acid Yellow");
		kona_colors.add("Ceramic Blue");
		kona_colors.add("Blue Lagon");


		CarProperties carprop7 = new CarProperties("SUV","Hyundai","Kona", kona_trims, kona_colors);
		carprops.add(carprop7);
		
		
		
		// Hyundai Tucson
		Map<String, Integer> tucson_trims = new HashMap<String,Integer>();

		tucson_trims.put("Prime Plus", 152900);
		tucson_trims.put("Panoramic", 165900);
		tucson_trims.put("Elite", 173900);
		tucson_trims.put("Elite Turbo", 182900);


		List<String> tucson_colors = new ArrayList<String>();
		
		tucson_colors.add("Polar White");
		tucson_colors.add("Phantom Black");
		tucson_colors.add("Stellar Blue");
		tucson_colors.add("Fiery Red");
		tucson_colors.add("Platinum Silver");
		tucson_colors.add("Micron Grey");
		tucson_colors.add("White Sand");

		CarProperties carprop8 = new CarProperties("SUV","Hyundai","Tucson", tucson_trims, tucson_colors);
		carprops.add(carprop8);
		
		
		// Hyundai Santa Fe
		Map<String, Integer> santaFe_trims = new HashMap<String,Integer>();

		santaFe_trims.put("Premium 4X4", 251900);
		santaFe_trims.put("Supreme 4X2", 279900);
		santaFe_trims.put("Luxury 4X4", 276900);
		santaFe_trims.put("Luxury 4X4 TD", 299900);


		List<String> santaFe_colors = new ArrayList<String>();
		
		santaFe_colors.add("White Cream");
		santaFe_colors.add("Phantom Black");
		santaFe_colors.add("Typhoon Silver");
		santaFe_colors.add("Earthy Bronze");
		santaFe_colors.add("Magnetic Force");
		santaFe_colors.add("Wild Grey");

		CarProperties carprop9 = new CarProperties("SUV","Hyundai","Santa Fe", santaFe_trims, santaFe_colors);
		
		carprops.add(carprop9);
		
		return carprops;
	}
	
}

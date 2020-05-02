package database;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
	
	public Serializer() {

	}

	public void serialize(String fileName, Object data) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
		    System.out.println(fileName + " saved successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public Object deserialize(String fileName) {
		Object data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);

			data = ois.readObject();

			ois.close();
			fis.close();
			System.out.println(fileName + " opened successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}

		return data;
	}
	
	
}

package advanced_programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\config.properties");

		// create object of Properties class
		Properties ppty = new Properties();
		// Loading properties file
		ppty.load(file);

		// Reading data from properties file
		String url = ppty.getProperty("appurl");
		String email = ppty.getProperty("email");
		String pwd = ppty.getProperty("password");
		String orderid = ppty.getProperty("orderid");
		String customerid = ppty.getProperty("customerid");

		System.out.println(url + "\t" + email + "\t" + pwd + "\t" + orderid + "\t" + customerid);

		// Reading all the keys from properties file
		Set<String> keys = ppty.stringPropertyNames();
		System.out.println(keys);
		
		//or 
		Set<Object> keysss = ppty.keySet();
		System.out.println(keysss);

		// Reading all the values from properties file
		Collection<Object> values = ppty.values();
		System.out.println(values);
		
		file.close();
	}

}

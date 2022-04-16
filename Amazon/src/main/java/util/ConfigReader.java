package util;


import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties initProperties() {

		prop = new Properties();

		try {
			InputStream fip = ClassLoader.getSystemResourceAsStream("config/config.properties");
			prop.load(fip);
		} catch (Exception e) {

		}
		return prop;
	}

}

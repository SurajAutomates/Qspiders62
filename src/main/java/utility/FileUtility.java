package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
		InputStream fis = FileUtility.class.getClassLoader().getResourceAsStream("ConfigData.properties");
		Properties property = new Properties();
		property.load(fis);
		String value = property.get(key).toString();
		return value;
	}
}

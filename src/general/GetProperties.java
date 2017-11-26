package general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

	private Properties prop;
	private InputStream inputStream;

	public GetProperties() throws IOException {
		this("resources/test.properties");
		
		
	}
	
	public GetProperties(String propFileName) {
		prop=new Properties();
		try {
			inputStream=new FileInputStream(propFileName);
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
 public String getProperty(String key) {
	 
	 return prop.getProperty(key);
	 
 }
	
}

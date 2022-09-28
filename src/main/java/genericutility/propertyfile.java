package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyfile
{
public  String getpropertyfiles(String propertyfiles,String key) {
	FileInputStream prp=null;
	try {
		prp = new FileInputStream(propertyfiles);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Properties property = new Properties();
	try {
		property.load(prp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String values = property.getProperty(key);
	return values;
}
	
}

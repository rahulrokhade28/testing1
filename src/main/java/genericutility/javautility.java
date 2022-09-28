package genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javautility  {
	public Object convertStringToanySataType(String value,datatypes strategy) {
		Object obj=null;
		if (strategy.toString().equalsIgnoreCase("long")) {
			obj=Long.parseLong(value);	
			}
		if (strategy.toString().equalsIgnoreCase("int")) {
			obj=Integer.parseInt(value);
		}
		if (strategy.toString().equalsIgnoreCase("DOUBLE")) {
			obj=Double.parseDouble(value);
	}
		return obj;
	}
	/*
	 * this method is used to convert int to string
	 */
	public String convertIntToString(int i) {
		String value = Integer.toString(i);
		return value;
	}
	/*
	 * this method is used to get system date
	 */
public String getSystemsate() {
	Date date = new Date();
	return date.toString();
}
public String currenttime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
	String actualdate=sdf.format(date);
	return actualdate;
}
	/*
	 *  this method is used to get randomno
	 */
public int getRandomno(int limit) {
 return new Random().nextInt(limit);
	}
}


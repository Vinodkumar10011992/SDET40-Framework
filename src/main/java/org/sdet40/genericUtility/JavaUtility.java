package org.sdet40.genericUtility;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consist all Java reusable actions 
 * @author lenovo
 *
 */

public class JavaUtility {
	
	/**
	 * THis method is used to generete the random number 
	 * @param limit
	 * @return
	 */

	public int getRandomNumber(int limit) {
		
		return new Random().nextInt(limit);
		
	}
	/**
	 * This Method is used to convert string to any datatype based on strategy
	 * @param data
	 * @return
	 */
	
	public Object convertStringIntoAnyDatatype(String data, DataType strategy) {
		Object obj=null;
		
		if(strategy.toString().equalsIgnoreCase("Long")) {
			
			obj=Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj=Integer.parseInt(data);
		}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj=Double.parseDouble(data);
		}
		return obj;
	}
	
	/**
	 * 
	 * @return
	 */
	public String currentTime() {
	Date date= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actualDate=sdf.format(date);
		return actualDate;
	}
}

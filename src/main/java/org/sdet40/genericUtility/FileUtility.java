package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists resuable method to handle property file
 * 
 * @author lenovo
 *
 */
public class FileUtility {
	Properties properties;
	/**
	 * This method is used to fetch the Data from property file
	 * @param string 
	 * 
	 * @param propertyFilePath
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getDataFromPropertyFile(String Key) {
	String value = null;
	try {
		value = properties.getProperty(Key).trim();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;
	}
	/**
	 * This method is used to Initialize the property file
	 * @param propertyFilePath 
	 * @author lenovo
	 * @throws IOExecption 
	 */
	
public void intiallizePropertyFile(String propertyFilePath) throws IOException{
	FileInputStream fis = new FileInputStream(propertyFilePath);
	properties = new Properties();
	properties.load(fis);
}
}

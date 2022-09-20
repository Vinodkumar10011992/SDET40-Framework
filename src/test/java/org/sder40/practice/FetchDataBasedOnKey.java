package org.sder40.practice;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataBasedOnKey {

	public static void main(String[] args) throws Throwable {
		
		ExcelUtility excelUtility = new ExcelUtility();
				excelUtility.openExcel(IConstantPath.EXCEL_PATH);
String lastName = excelUtility.getDataFromExcel("Registration", "lastname");
String firstname = excelUtility.getDataFromExcel("Registration", "firstname");
System.out.println(lastName);
System.out.println(firstname);
	}
	
}

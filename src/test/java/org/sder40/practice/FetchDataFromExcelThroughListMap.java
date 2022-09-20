package org.sder40.practice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughListMap {
	
	public static void main(String[] args) throws Throwable {
		
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		List<Map<String, String>> list= excelUtility.getDataFromExcelInList("Registration");
		System.out.println(list.get(1).get("firstname"));
			
		
	}

}

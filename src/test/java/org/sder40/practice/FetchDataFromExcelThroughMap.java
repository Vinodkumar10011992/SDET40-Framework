package org.sder40.practice;

import java.util.Map;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {
	
	public static void main(String[] args) throws Throwable {
		
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		Map<String, String> map=excelUtility.getDataFromExcelInMap("Registration");
		System.out.println(map.get("address"));
	}

}

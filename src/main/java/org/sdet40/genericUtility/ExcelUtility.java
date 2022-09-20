package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * This class consists of all common actions on excel
 * @author lenovo
 *
 */
public class ExcelUtility {
	//access Specifier modifier return type methodName(parameter){}
	//access Specifier --> public,private,protected,default
	//modifier --> static, non static 
	//return type--> primitive & class type
	// methodName--> follow camelCase--> give meaningfull name 
	//parameter---> optional--> based on statement input
	
	Workbook workbook = null;
	/**
	 * This method is used to initialize and open the excel workbook 
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void openExcel(String excelPath) throws IOException
	{
		FileInputStream fisExcel= new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fisExcel);
	}
	
	/**
	 * This method is used to fetch the data from the Excel
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws IOException
	 * 
	 */
	
public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
	
  Sheet sheet = workbook.getSheet(sheetName);
  String data= new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
  return data;
	
}


/**
 * This method is used to close the Workbook 
 * @throws IOException
 */
public void closeExcelWorkBook() throws IOException{
workbook.close();	
	
}
/**
 * THis method is used to fetch the data from the excel and stored in <map>
 * @param sheetName
 * @return
 */

public Map<String, String> getDataFromExcelInMap(String sheetName) {
	
	Sheet sheet = workbook.getSheet(sheetName);
	DataFormatter df= new DataFormatter();
	Map<String, String>map=new HashMap();
	for (int i = 0; i <=sheet.getLastRowNum(); i++) {
		map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
	return map;
}


public String getDataFromExcel(String sheetName,String requiredKey) {
	
	 	Sheet sheet = workbook.getSheet(sheetName);
			String value=null;
			for (int i = 0; i <=sheet.getLastRowNum(); i++) {
				String actualKey= sheet.getRow(i).getCell(0).getStringCellValue();
				if (actualKey.equalsIgnoreCase(requiredKey)) {
					value=sheet.getRow(i).getCell(1).getStringCellValue();
					break;
				}
			} 
			return value;

}

public  List<Map<String, String>> getDataFromExcelInList(String sheetName) {
	

 Sheet sheet = workbook.getSheet(sheetName);
List<Map<String, String>> list= new ArrayList<>();
DataFormatter df= new DataFormatter();

for (int k = 0; k <=sheet.getRow(0).getLastCellNum(); k++)
{
	Map<String, String> map= new HashMap<>();
	for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
	}
		list.add(map);
	}
return list;
}

}

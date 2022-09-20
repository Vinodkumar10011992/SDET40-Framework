package org.sder40.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step-->1 Convert the Physical file into Java Readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Excelfiledata.xlsx");

		// Step2--->Open the the Excelwork Book
		Workbook wb = WorkbookFactory.create(fis);

		// Step---> Get controlon Sheet
		Sheet sheet = wb.getSheet("Log-In ");

		// Step--->4 Get control on row for new row
		Row row = sheet.getRow(9);

		// Step--->5 Create the cell
		Cell cell = row.createCell(3);

		// Step--->6 Update the status/Set the data
		cell.setCellValue("Pass");

		// Step--->7 Write the Data into excel(Save as action)
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Excelfiledata.xlsx");

		// Step---> 8 Write the data into Excel sheet
		wb.write(fos);
		System.out.println("Data updated succefully");

		// Step--->9 CLose the workbook
		wb.close();

	}

}

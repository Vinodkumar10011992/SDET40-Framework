package org.sdet40.genericUtility;
/**
 * This interface consists all the external file paths 
 * @author lenovo
 * 
 * 
 */
public interface IConstantPath {
	
		// Variable, method name=camelcase
		// interface, class, enum, annotation= Pascel Case
		//static final member==> CAPITAL
	String PROJECT_PATH= System.getProperty("user.dir");
	String EXCEL_PATH= PROJECT_PATH+"/src/test/resources/Excelfiledata.xlsx";
	String PROPERTY_FILE_PATH=PROJECT_PATH+"/src/test/resources/CommonData.properties";
	String DB_URL="jdbc:mysql://localhost:3306/tyss";
		

}

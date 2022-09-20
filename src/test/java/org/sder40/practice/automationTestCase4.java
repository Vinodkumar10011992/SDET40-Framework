// Test Scenario----> User Portal-->New User registration---> and log in admin portal----> delte the user.
package org.sder40.practice;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import ObjectRepository.RegistrationPage;
import ObjectRepository.TabNames;
import ObjectRepository.UserLogOutPage;

public class automationTestCase4 extends BaseClass {

	@Test
	public void testcase1Test() throws IOException {
		String url = fileUtility.getDataFromPropertyFile("url");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");

		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);

		Newusername = excelUtility.getDataFromExcel("CommonData ", 9, 1);
		firstname = excelUtility.getDataFromExcel("CommonData ", 10, 1);
		lastname = excelUtility.getDataFromExcel("CommonData ", 11, 1);
		email = excelUtility.getDataFromExcel("CommonData ", 12, 1);
		phone = excelUtility.getDataFromExcel("CommonData ", 13, 1);
		NewUserpassword = excelUtility.getDataFromExcel("CommonData ", 14, 1);
		cpassword = excelUtility.getDataFromExcel("CommonData ", 15, 1);
		address = excelUtility.getDataFromExcel("CommonData ", 16, 1);

		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		reg = new RegistrationPage(driver);
		reg.ClickOnRegister();
		reg.registrationAction(Newusername + randomNumner, firstname, lastname, email, phone, NewUserpassword,
				cpassword, address);

		System.out.println("Sucessfully Registred New User");

		longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		// initiallize the object Repo class

	
		loginPage.loginAction(Newusername + randomNumner, NewUserpassword);

		System.out.println("Successfully Log-in with NewUser");
		userlogout = new UserLogOutPage(driver);
		userlogout.UserLogOutClickAction();

		longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);

		loginPage.adminLogInAction(adnusername, adnpassword);

		commonPage.clickRequiredTab(TabNames.Users, webDriverUtility);
		adminuserpage.clickDeleteTab(Newusername + randomNumner, webDriverUtility);
		logoutpage.logOutAction();

		System.out.println("User deleted sucessfully");

	}

}

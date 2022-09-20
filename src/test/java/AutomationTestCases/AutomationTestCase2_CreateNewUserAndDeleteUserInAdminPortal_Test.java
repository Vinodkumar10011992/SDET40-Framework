package AutomationTestCases;

import java.io.IOException;
import java.util.Map;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.testng.annotations.Test;

import ObjectRepository.RegistrationPage;
import ObjectRepository.TabNames;
import ObjectRepository.UserLogOutPage;

public class AutomationTestCase2_CreateNewUserAndDeleteUserInAdminPortal_Test extends BaseClass {
	@Test(groups = "Sanity")

	public void testcase2Test() throws IOException {
		String url = fileUtility.getDataFromPropertyFile("url");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		Map<String, String> map = excelUtility.getDataFromExcelInMap("CommonData ");
		Newusername = map.get("Newusername");
		firstname = map.get("firstname");
		lastname = map.get("lastname");
		email = map.get("email");
		phone = map.get("phone");
		NewUserpassword = map.get("NewUserpassword");
		cpassword = map.get("cpassword");
		address = map.get("address");
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		reg = new RegistrationPage(driver);
		reg.ClickOnRegister();
		reg.registrationAction(Newusername + randomNumner, firstname, lastname, email, phone, NewUserpassword,
				cpassword, address);
		loginPage.newUserLogInAction(Newusername + randomNumner, NewUserpassword);
		userlogout = new UserLogOutPage(driver);
		userlogout.UserLogOutClickAction();
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);
		loginPage.adminLogInAction(adnusername, adnpassword);
		commonPage.clickRequiredTab(TabNames.Users, webDriverUtility);
		adminuserpage.clickDeleteTab(Newusername + randomNumner, webDriverUtility);
		logoutpage.logOutAction();
		

	}
}

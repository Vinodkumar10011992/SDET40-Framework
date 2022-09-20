package BackUpTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

import ObjectRepository.LoginPage;
import ObjectRepository.RegistrationPage;

public class automationTestcase4 {
	
	public static void main(String[] args) throws IOException {
		FileUtility fileUtility = new FileUtility();
		fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		String browser = fileUtility.getDataFromPropertyFile("browser");
		String url = fileUtility.getDataFromPropertyFile("url");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
		String Timeouts = fileUtility.getDataFromPropertyFile("Timeouts");

		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);

		String Newusername = excelUtility.getDataFromExcel("CommonData ", 9, 1);
		String firstname = excelUtility.getDataFromExcel("CommonData ", 10, 1);
		String lastname = excelUtility.getDataFromExcel("CommonData ", 11, 1);
		String email = excelUtility.getDataFromExcel("CommonData ", 12, 1);
		String phone = excelUtility.getDataFromExcel("CommonData ", 13, 1);
		String NewUserpassword = excelUtility.getDataFromExcel("CommonData ", 14, 1);
		String cpassword = excelUtility.getDataFromExcel("CommonData ", 15, 1);
		String address = excelUtility.getDataFromExcel("CommonData ", 16, 1);

		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.launchBrowser(browser);
		JavaUtility javaUtility = new JavaUtility();
		int randomNumner = javaUtility.getRandomNumber(1000);

		long longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);

		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		RegistrationPage RegistrationPage = new RegistrationPage(driver);
		RegistrationPage.registrationAction(Newusername + randomNumner, firstname, lastname, email, phone, NewUserpassword, cpassword, address);
		
		/*
		 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys(
		 * Newusername + randomNumner);
		 * driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname
		 * );
		 * driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		 * driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		 * driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys(
		 * NewUserpassword);
		 * driver.findElement(By.xpath("//input[@name='cpassword']")).sendKeys(cpassword
		 * );
		 * driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(address)
		 * ; driver.findElement(By.xpath("//input[@value='Register']")).click();
		 */
		System.out.println("Sucessfully Registred New User");

		longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		// initiallize the object Repo class

		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginAction(Newusername + randomNumner, NewUserpassword);

		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(
		 * Newusername+randomNumner);
		 * driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(
		 * NewUserpassword); driver.findElement(By.id("buttn")).click();
		 * 
		 */ System.out.println("Successfully Log-in with NewUser");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);

		LoginPage.loginAction(adnusername, adnpassword);
		/*
		 * driver.findElement(By.name("username")).sendKeys(adnusername);
		 * driver.findElement(By.name("password")).sendKeys(adnpassword);
		 * 
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 */
		driver.findElement(By.xpath("//span[text()='Users']")).click();

		String deleteusername = Newusername + randomNumner;
		driver.findElement(By.xpath("//tbody//tr//td[.='" + deleteusername
				+ "']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();

		System.out.println("User deleted sucessfully");
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
		webDriverUtility.closeBrowser(driver);

}}

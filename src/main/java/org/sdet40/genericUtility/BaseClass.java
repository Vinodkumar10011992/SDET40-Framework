package org.sdet40.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;



import ObjectRepository.CommonPage;
import ObjectRepository.LoginPage;
import ObjectRepository.RegistrationPage;
import ObjectRepository.UserLogOutPage;
import ObjectRepository.adminUserPage;
import ObjectRepository.logOutPage;

public class BaseClass {
	protected WebDriver driver;
	protected RegistrationPage reg;
	protected LoginPage loginPage;
	protected UserLogOutPage userlogout;
	protected CommonPage commonPage;
	protected adminUserPage adminuserpage;
	protected logOutPage logoutpage;
	protected String browser;
	protected String url;
	protected String admurl;
	protected String adnusername;
	protected String adnpassword;
	protected String Timeouts;
	protected long longTimeOut;
	protected int randomNumner;
	protected String Newusername;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String phone;
	protected String NewUserpassword;
	protected String cpassword;
	protected String address;
	protected FileUtility fileUtility;
	protected ExcelUtility excelUtility;
	protected  WebDriverUtility webDriverUtility;
	protected JavaUtility javaUtility;
	protected SoftAssert soft;
	public static JavaUtility sjavaUtility;
	public static WebDriver sdriver;

	
	/**
	 * Intialize the all Utility class Open the Excel, PropertyFile Read the
	 * Commondata Create the instance for the browser(launch browser) maximize,
	 * implicit wait open the application Initiallize jsexcecutor, action,
	 * webdriverwait create the instance for common repo
	 * 
	 * @throws IOException
	 */
	@BeforeClass(groups="regression")
	public void ClassSetUp() throws IOException {
		// Create instance for Generic Utility
		fileUtility = new FileUtility();
		
		webDriverUtility = new WebDriverUtility();
		
		javaUtility = new JavaUtility();
		
		sjavaUtility=new JavaUtility();

		// Initiallize the property file and Excel File
		fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		

		// Fetch the Data From propertyfile
		browser = fileUtility.getDataFromPropertyFile("browser");
		Timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);

		randomNumner = javaUtility.getRandomNumber(1000);

		// Launch the browser and doing somw browser setting
		
		WebDriver driver = webDriverUtility.launchBrowser(browser);
		sdriver=driver;
		// create object for common POM repo
	
		loginPage = new LoginPage(driver);
		userlogout = new UserLogOutPage(driver);
		commonPage = new CommonPage(driver);
		adminuserpage = new adminUserPage(driver);
		logoutpage = new logOutPage(driver);
		adminuserpage = new adminUserPage(driver);
		soft=new SoftAssert();
	}

	// Login to the browser
	/**
	 * Whenever we create the testscript class for module and test annotation method
	 * for testcase create instance for the browser(launch browser) maximize,
	 * implicit wait initialize the instance for common object repo(driver) login to
	 * the app
	 */
	@BeforeMethod
	public void methodSetup1() {
	
	}
	@AfterMethod
	public void methodTearDown() {
		
		
	}

	@AfterClass
	public void ClassTearDown() {
		webDriverUtility.closeBrowser(driver);

	}
}

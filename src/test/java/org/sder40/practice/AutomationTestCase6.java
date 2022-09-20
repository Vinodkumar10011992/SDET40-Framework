package org.sder40.practice;

import java.io.IOException;
import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;
import ObjectRepository.CommonPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.UserLogOutPage;

public class AutomationTestCase6 extends BaseClass {
@Test
	public  void testCase2Test() throws IOException  {

		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginAction(username, password);
		HomePage homepage = new HomePage(driver);
		String dishName = "Stuffed Jacket Potatoes";
		homepage.selectDish(dishName, webDriverUtility);
		homepage.addToCart(dishName, webDriverUtility);
		CommonPage commonpage= new CommonPage(driver);
		commonpage.clickOnCheckOutButton();
		commonpage.clickOnOrderNowButton();
		webDriverUtility.alertPOPUPHandling(driver);
		webDriverUtility.alertPOPUPHandling(driver);
		UserLogOutPage userlogout = new UserLogOutPage(driver);
		userlogout.UserLogOutClickAction();
		System.out.println("Food Ordered Successfully");
	}
}

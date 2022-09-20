//user login ---> click on restaurant---> picck restaurant---> select dish----> order---> My Cart ----> delete the ordered food and logout 
package AutomationTestCases;

import java.io.IOException;
import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;
import ObjectRepository.HomePage;
import ObjectRepository.MyOrders;
import ObjectRepository.RestaurantPage;
import ObjectRepository.UserLogOutPage;

public class AutomationTestCase1_ClickRestaurantOrderTheFoodTest extends BaseClass {
	@Test

	public void TestCase1Test() throws IOException {
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		driver=webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		loginPage.loginAction(username, password);
		String expectedText="Login to your account";
		webDriverUtility.verifyPage(soft, loginPage.getloginToYourAccountText(), expectedText);
		RestaurantPage restaurant = new RestaurantPage(driver);
		restaurant.clickOnRestaurantLink();
		String restaurantName = "Eataly";
		restaurant.clickOnRestaurant(restaurantName, webDriverUtility);
		String dishName = "Cheesy Mashed Potato";
		HomePage homePage = new HomePage(driver);
		homePage.addToCart(dishName, webDriverUtility);
		commonPage.clickOnCheckOutButton();
		commonPage.clickOnOrderNowButton();
		webDriverUtility.alertPOPUPHandling(driver);
		webDriverUtility.alertPOPUPHandling(driver);
		System.out.println("Ordered Food Successfully");
		MyOrders myorders = new MyOrders(driver);
		myorders.clickOnMyOrdersLink();
		myorders.clickOnDeleteIcon(dishName, webDriverUtility);
		webDriverUtility.alertPOPUPHandling(driver);
		UserLogOutPage userlogout = new UserLogOutPage(driver);
		userlogout.UserLogOutClickAction();
		System.out.println("Ordered food deleted suceessfully");
		webDriverUtility.verifyAssert(soft);
	}
}
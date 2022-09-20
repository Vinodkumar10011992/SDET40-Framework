//Select Restaruant--- Select Dish--- order--- Click on My cart--- Delete food 
package org.sder40.practice;

import java.io.IOException;
import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;
import ObjectRepository.HomePage;
import ObjectRepository.MyOrders;
import ObjectRepository.RestaurantPage;
import ObjectRepository.UserLogOutPage;

public class TestCase2 extends BaseClass {
	@Test
	public void TestCase2Test() throws IOException {
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		loginPage.loginAction(username, password);
		RestaurantPage restaurant = new RestaurantPage(driver);
		restaurant.clickOnRestaurantLink();
		String restaurantName = "Highlands Bar & Grill";
		restaurant.clickOnRestaurant(restaurantName, webDriverUtility);
		String dishName = "Chicken Madeira";
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
	}

}

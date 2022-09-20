// Test Scenario : Login as user->Place order->Logout ->Login as admin->Go to order->Change order status->Confirm order status->Logout

package org.sder40.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.genericUtility.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.RestaurantPage;
import ObjectRepository.TabNames;
import ObjectRepository.UserLogOutPage;

public class AutomationTestCase5 extends BaseClass{

	public void testCase4Test() {
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
		driver= webDriverUtility.openBrowserWithApplication( longTimeOut, url);
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginAction(username, password);
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
		UserLogOutPage userlogout = new UserLogOutPage(driver);
		userlogout.UserLogOutClickAction();
			
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);
		LoginPage.adminLogInAction(adnusername, adnpassword);
		commonPage.clickRequiredTab(TabNames.Orders, webDriverUtility);
		commonPage.clickOnEditIcon();
		
	
		//driver.findElement(By.xpath("//tbody//tr[last()]//td//i[@class='fa fa-edit']")).click();
		driver.findElement(By.linkText("Update Order Status")).click();
	
		String ParentWindow1 = driver.getWindowHandle();
		String SubWindowHandler1 = null;
		Set<String> Handles1 = driver.getWindowHandles();
		Iterator<String> it1 = Handles1.iterator();
		while (it1.hasNext()) {
			SubWindowHandler1 = it1.next();
		}
		driver.switchTo().window(SubWindowHandler1);

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.close();
		driver.switchTo().window(ParentWindow1);
		driver.findElement(By.linkText("Update Order Status")).click();
		String ParentWindow2 = driver.getWindowHandle();
		String SubWindowHandler2 = null;
		Set<String> Handles2 = driver.getWindowHandles();
		Iterator<String> it2 = Handles2.iterator();
		while (it2.hasNext()) {
			SubWindowHandler2 = it2.next();
		}
		driver.switchTo().window(SubWindowHandler2);
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByVisibleText("Delivered");

		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order is On the way");
	
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")).click();
		driver.switchTo().window(ParentWindow2);
		driver.findElement(By.linkText("Orders")).click();
		String status = driver.findElement(By.xpath("//tbody//tr[last()]//button[@type='button']")).getText();
		System.out.println("Order status is :" + status);
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();

		webDriverUtility.closeBrowser(driver);
	}
}

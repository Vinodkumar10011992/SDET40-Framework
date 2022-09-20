package org.sder40.practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

import ObjectRepository.CommonPage;
import ObjectRepository.LoginPage;
import ObjectRepository.RestaurantPage;
import ObjectRepository.TabNames;

public class AutomationTestCase3 extends BaseClass{

	public void testCase4Test() {
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
	
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);
		loginPage.adminLogInAction(adnusername, adnpassword);
		commonPage.clickRequiredTab(TabNames.Restaurant, webDriverUtility);
		RestaurantPage restaurant = new RestaurantPage(driver);
		restaurant.adminClickOnRAddCategory();
		String categoryName= "frgsdfgfdsgfrgsdfgfdsgaddffsdAfrican";
		commonPage.editCategoryName(categoryName, webDriverUtility);
		commonPage.pickcategoryName();
		String updatedCategoryName= "African";
		commonPage.updateCategoryName(updatedCategoryName);
		System.out.println("Category updated successfully");
		logoutpage.logOutAction();
		
		
		
		
		
		/*
		 * FileUtility fileUtility=new FileUtility();
		 * fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		 * 
		 * String browser =fileUtility.getDataFromPropertyFile("browser"); String admurl
		 * = fileUtility.getDataFromPropertyFile("admurl"); String adnusername =
		 * fileUtility.getDataFromPropertyFile("adnusername"); String adnpassword =
		 * fileUtility.getDataFromPropertyFile("adnpassword"); String Timeouts =
		 * fileUtility.getDataFromPropertyFile("Timeouts");
		 * 
		 * WebDriverUtility webDriverUtility = new WebDriverUtility(); WebDriver driver
		 * = webDriverUtility.launchBrowser(browser); JavaUtility javaUtility = new
		 * JavaUtility();
		 * 
		 * long longTimeOut =(long) javaUtility.convertStringIntoAnyDatatype(Timeouts,
		 * DataType.LONG); driver= webDriverUtility.openBrowserWithApplication(browser,
		 * longTimeOut, admurl);
		 * 
		 * driver.findElement(By.name("username")).sendKeys(adnusername);
		 * driver.findElement(By.name("password")).sendKeys(adnpassword);
		 * driver.findElement(By.xpath("//input[@value='Login']")).click();
		 */
				
				//driver.findElement(By.xpath("//a[@class='has-arrow  ']//span[text()='Restaurant']")).click();
				//driver.findElement(By.xpath("//a[text()='Add Category']")).click();
				
				//String CategoryName= "frgsdfgfdsgfrgsdfgfdsgaddffsdAfrican";
				//driver.findElement(By.xpath("//tbody//tr//td[text()='"+CategoryName+"']//ancestor::tr//td//i[@class='fa fa-edit']")).click();
				
				//driver.findElement(By.xpath("//input[@placeholder='Category Name']")).clear();
				//driver.findElement(By.xpath("//input[@placeholder='Category Name']")).sendKeys("African");
				
				//System.out.println("Category updated successfully");
				//driver.findElement(By.xpath("//input[@name='submit']")).click();
				//driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
				//driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
				
			//	webDriverUtility.closeBrowser(driver);
	}

}

//Place Order through restaurant 
package org.sder40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTestCase7 {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fileUtility = new FileUtility();
		fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);

		String browser = fileUtility.getDataFromPropertyFile("browser");
		String url = fileUtility.getDataFromPropertyFile("url");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String Timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		
		WebDriver driver = webDriverUtility.launchBrowser(browser);
		JavaUtility javaUtility = new JavaUtility();
		long longTimeOut = (long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver = webDriverUtility.openBrowserWithApplication(longTimeOut, url);
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginAction(username, password);
		
		//driver.findElement(By.linkText("Login")).click();
	
	
			driver.findElement(By.xpath("(//a[text()='Restaurants ']")).click();
			
			String restaurantName = "North Street Tavern";
			driver.findElement(By.xpath("(//a[text()='North Street Tavern']//ancestor::div[@class='bg-gray restaurant-entry']//a[text()='North Street Tavern']//following::a[@href=\"dishes.php?res_id=1\"]")).click();
			
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
		    driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg active']")).click();	
		 
		 driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
		   Alert a = driver.switchTo().alert();	
		      a.accept();	
			    Thread.sleep(2000);
		     Alert a1 = driver.switchTo().alert();	
		     a1.accept();
			   
		    driver.findElement(By.xpath("(//a[@class='nav-link active'])[4]")).click();	
		   
		}

	}



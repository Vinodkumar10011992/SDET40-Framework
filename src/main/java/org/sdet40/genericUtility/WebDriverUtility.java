package org.sdet40.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	WebDriver driver = null;

	/**
	 * This method is used to launch the browser
	 * 
	 * @param browser
	 * @return
	 * @return
	 */

	public WebDriver launchBrowser(String browser) {

		switch (browser) {
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		}
		return driver;

	}

	/**
	 * This method is used to wait till the page load
	 * 
	 * @param driver
	 * @param longTimeout
	 */
	public void waitTillPageLoad(WebDriver driver, long longTimeout) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * This Method is used to open the applocation
	 * 
	 * @param driver
	 * @param url
	 */

	public void navigateApplication(WebDriver driver, String url) {

		driver.get(url);
	}

	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 */
	public WebDriver openBrowserWithApplication(long longTimeout, String url) {
		maximizeBrowser(driver);
		waitTillPageLoad(driver, longTimeout);
		navigateApplication(driver, url);
		return driver;
	}

	/**
	 * This Method is used to close the browser instance
	 * 
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method is used to convert the dynamic Xpath into WebElement
	 * 
	 * @param dynamicXpath
	 * @param deleteUserName
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}

	/**
	 * This method is used to convert the dynamic xpath into By locator
	 * 
	 * @param dynamicXpath
	 * @param deleteUserName
	 * @param driver
	 * @return
	 */

	public By convertDynamicXpathIntoByClass(String dynamicXpath, String deleteUserName, WebDriver driver) {

		String deleteUseraName = String.format(dynamicXpath, deleteUserName);
		By element = By.xpath(deleteUseraName);
		return element;
	}

	/**
	 * This method is used to handle the alert POPUP
	 * 
	 * @param driver
	 */
	public void alertPOPUPHandling(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	/**
	 * \ This method is used to wait till the element is visible
	 * 
	 * @param element
	 * @param driver
	 * @param longTimeOut
	 * @param expectedText
	 */
	public void verifyWebpage(WebElement element, WebDriver driver, long longTimeOut, String expectedText) {
		for (;;) {
			try {
				Assert.assertEquals(element.getText(), expectedText);
				break;
			} catch (Exception e) {
				waitTillElementVisible(driver, longTimeOut, element);
			}
		}

	}

	/**
	 * 
	 * @param driver
	 * @param longTimeOut
	 * @param element
	 */
	private void waitTillElementVisible(WebDriver driver, long longTimeOut, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to verify the page
	 * 
	 * @param soft
	 * @param actualText
	 * @param expectedText
	 */
	public void verifyPage(SoftAssert soft, String actualText, String expectedText) {
		soft.assertEquals(actualText, expectedText);
	}

	/**
	 * This method is used to verify the result
	 * 
	 * @param soft
	 * @param actualText
	 * @param expectedText
	 */

	public void verifyResult(SoftAssert soft, String actualText, String expectedText) {
		soft.assertEquals(actualText, expectedText);
	}

	/**
	 * This method is used to verify the assert
	 * 
	 * @param soft
	 */
	public void verifyAssert(SoftAssert soft) {
		soft.assertAll();
	}

	/**
	 * This method is take to take the screenshot of the page
	 * 
	 * @param driver
	 * @param javaUtility
	 * @param className
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver, JavaUtility javaUtility, String className) {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/" + className + "_" + currentTime + ".png");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dst.getAbsolutePath();
	}

	public String takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		System.out.println("path: "+tempPath);
		return tempPath;
	}
}

package org.sder40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchdDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		// Step1 --> Convert the Physical File into Java Reachable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

		// Step2--> create the object for properties
		Properties property = new Properties();

		// Step3--> Load all the keys
		property.load(fis);

		// Step4--> Fetch the data

		String url = property.getProperty("url").trim().trim();
		String browser = property.getProperty("browser").trim();
		String username = property.getProperty("username").trim();
		String password = property.getProperty("password").trim();

		WebDriver driver = null;
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();

		driver.findElement(By.xpath(
				"//div[@class='container']/following::div[@class='content']/following::div[@class='price-btn-block']/following::span[@class='price' and  text()='$23.00'and'Order Now']"))
				.click();

//		driver.findElement(By.linkText("Highlands Bar & Grill")).click();	driver.findElement(By.xpath("(//input[@value='Add To Cart'])[3]")).click();

		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-block']")).click();

		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Logout")).click();

	}

}

package BackUpTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2BackUp {
	public static void main(String[] args) throws IOException {

		// Step1 --> Convert the Physical File into Java Reachable Object
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

		// Step2--> create the object for properties
		Properties property = new Properties();

		// Step3--> Load all the keys
		property.load(fis);

		// Step4--> Fetch the data

		String url = property.getProperty("url").trim();
		String username = property.getProperty("username").trim();
		String password = property.getProperty("password");
		
		WebDriver driver = null;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.findElement(By.linkText("Highlands Bar & Grill")).click();
		driver.findElement(By.xpath("(//input[@value='Add To Cart'])[3]")).click();

		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-success btn-block']")).click();
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("My Orders")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.linkText("Logout")).click();
		

	}

}

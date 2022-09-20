package org.sder40.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenPractice1Test {
	@Test
	public void step1Test() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
}
}

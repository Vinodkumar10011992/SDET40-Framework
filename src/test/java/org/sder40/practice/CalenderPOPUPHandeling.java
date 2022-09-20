package org.sder40.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPOPUPHandeling {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requireDate = "20";  //---DD
		String requiredMonth = "January";   //--MMMM---January, MM-02, MMM-Jan
		String requiredYear = "2022";
		
		 int requiredMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		 
		 int requiredYearInNum = Integer.parseInt(requiredYear);
		 
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		//driver.findElement(By.xpath(""))
	}

}

package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class HomePage {
	// Decclaration 
	WebDriver driver;
	// Vinodkumar Bogar
	
	 private String dynamicXpath="//a[text()='%s']/ancestor::div[@class='content']//div/following-sibling::div//a[text()='Order Now']";  //---> %S ProductName
	 private String dynamicXpath1="//a[.='%s']/ancestor::div/following-sibling::div//span[@class='price pull-left']/following-sibling::input[@class='btn theme-btn']";  //---> %S ProductName
	
	 
		// initialization all element variable
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);	
		}
		
		
		// Business Library
		public void selectDish (String dishName, WebDriverUtility webDriverUtility) {
			webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, dishName, driver).click();
			
		}

		public void addToCart(String dishName, WebDriverUtility webDriverUtility) {
			webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath1, dishName, driver).click();
		}
		
}
 	
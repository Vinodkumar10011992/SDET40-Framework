package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class MyOrders {
	WebDriver driver;

@FindBy(xpath="//a[text()='My Orders']")
	private WebElement clickOnMyOders;

private String dynamicxpath="//td[text()=' %s']//ancestor::tr//td//a//i[@class='fa fa-trash-o']";//------> %s---> Select Dish to delete 

public MyOrders(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
public void clickOnMyOrdersLink() {
	clickOnMyOders.click();
}

public void clickOnDeleteIcon(String dishName, WebDriverUtility webDriverUtility) {
	webDriverUtility.convertDynamicXpathIntoWebElement(dynamicxpath, dishName, driver).click();
}
}
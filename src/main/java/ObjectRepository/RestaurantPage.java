package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class RestaurantPage {
	WebDriver driver;


@FindBy(xpath="//a[text()='Restaurants ']")
	private WebElement clickOnRestaurantLink;

private String dynamicxpath="//a[text()='%s']";//---->%s ---> click on restarunt link  


@FindBy(xpath="//a[text()='Add Category']")
private WebElement clickOnRAddCategory;

public RestaurantPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
public void clickOnRestaurantLink() {
	clickOnRestaurantLink.click();
}

public void clickOnRestaurant (String restaurantName, WebDriverUtility webDriverUtility) {
	
	webDriverUtility.convertDynamicXpathIntoWebElement(dynamicxpath, restaurantName, driver).click();
	
}

public void adminClickOnRAddCategory() {
	clickOnRAddCategory.click();
}
}

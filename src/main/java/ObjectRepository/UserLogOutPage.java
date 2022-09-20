package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogOutPage {
	WebDriver driver;
	
	// Declaration 
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement userlogoutbutton;
	
	// initiallization 
	public UserLogOutPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
// Business library 
	public void UserLogOutClickAction() {
	userlogoutbutton.click();
}
	}

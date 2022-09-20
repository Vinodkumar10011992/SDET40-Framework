package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logOutPage {
	WebDriver driver;
	// Decclaration 
@FindBy(xpath="//img[@class='profile-pic']")
private WebElement profileIcon;


@FindBy(xpath="//i[@class='fa fa-power-off']")
private WebElement logOutIcon;


//initialization all element variable
	public logOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	
	// bussiness Library or getter
	public void logOutAction()
{
profileIcon.click();
logOutIcon.click();
}
	
	
	
	}




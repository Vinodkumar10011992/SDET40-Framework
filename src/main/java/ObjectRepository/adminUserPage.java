package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class adminUserPage {
	WebDriver driver;
	// Decclaration 
private String dynamicXpath="//tbody//tr//td[.='%s']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']";//---> %S Username 
@FindBy(xpath="//tbody//tr//td[.='%s']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")
private WebElement clickOnDeleteIcon;

// initialization all element variable
public adminUserPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//users name -Vinod 
//Bogar Vinod 
// hi
public void clickDeleteTab(String userName, WebDriverUtility webDriverUtility) {
	webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, userName, driver).click();
	System.out.println("User deleted sucessfully");
}



// Business Library

  public void clickUsDeleteTab(String userName, WebDriverUtility webDriverutility) {
  
  webDriverutility.convertDynamicXpathIntoWebElement(dynamicXpath, userName, driver).click(); 
 
 }
}

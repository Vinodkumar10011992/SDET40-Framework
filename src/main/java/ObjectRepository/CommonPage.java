package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebDriverUtility;

public class CommonPage {
	WebDriver driver;
	// Decclaration 
private String dynamicXpath="//span[text()='%s']";//---> %S userclick
@FindBy(xpath="//tbody//tr//td[.='%s']/following-sibling::td//a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")
private WebElement clickOnRequiredTab;

private String dynamicXpath1="//tbody//tr//td[text()='%s']//ancestor::tr//td//i[@class='fa fa-edit']";//---> %S edit category

@FindBy(xpath="//a[text()='Checkout']")
private WebElement clickOnCheckOutButton;

@FindBy(xpath="//input[@name='submit']")
private WebElement clickOnOrderNowButton;


@FindBy(xpath="//tbody//tr[last()]//td//i[@class='fa fa-edit']")
private WebElement clickOnEditIcon;


@FindBy(xpath="//button[text()='Update Order Status']")
private WebElement clickOnUpdateOrderStatus;


@FindBy(xpath="//input[@placeholder='Category Name']")
private WebElement pickcategoryName;


@FindBy(xpath="//input[@placeholder='Category Name']")
private WebElement updateCategoryName;


@FindBy(xpath="//input[@name='submit']")
private WebElement clickOnSavecategory;


// initialization all element variable
public CommonPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickRequiredTab(TabNames  tabName, WebDriverUtility webDriverUtility) {
	webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, tabName.toString(), driver).click();
	
}




// Business Library

  public void ClickUsersTab(TabNames  tabName, WebDriverUtility webDriverutility) {
  
  webDriverutility.convertDynamicXpathIntoWebElement(dynamicXpath, tabName.toString(), driver).click(); 
 
 }

  public void clickOnCheckOutButton() {
  clickOnCheckOutButton.click();}


  public void clickOnOrderNowButton() {
	  clickOnOrderNowButton.click();
  }
  
  public void clickOnEditIcon() {
	  clickOnEditIcon.click();
  }
  
  public void clickOnUpdateOrderStatus() {
	  clickOnUpdateOrderStatus.click();
}
 
  public void editCategoryName(String categoryName, WebDriverUtility webDriverutility) {
	  
	  webDriverutility.convertDynamicXpathIntoWebElement(dynamicXpath1, categoryName, driver).click();  
  }
  
  public void pickcategoryName() {
	  pickcategoryName.clear();
  }
  
  public void updateCategoryName(String updatedCategoryName) {
	  updateCategoryName.sendKeys(updatedCategoryName);
  }

  public void clickOnSavecategory() {
	  clickOnSavecategory.click();
  }
}
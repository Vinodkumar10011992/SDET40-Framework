package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
// Declaration 
	WebDriver driver;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement clickOnRegisterIcon;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement newUserNmaeTextField;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstnameTextField;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumberTextField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement newUserPasswordTextField;

	@FindBy(xpath = "//input[@name='cpassword']")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement addressTextField;
	

	

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;


	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public void ClickOnRegister() {
		clickOnRegisterIcon.click();
	}
	
	public void registrationAction(String username, String firstName, String lastname, String email, String phone, String password, String cpassword, String address)
	
	{
		newUserNmaeTextField.sendKeys(username);
		firstnameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastname);
		emailTextField.sendKeys(email);
		phoneNumberTextField.sendKeys(phone);
		newUserPasswordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(cpassword);
		addressTextField.sendKeys(address);
		registerButton.click();
		System.out.println("Sucessfully Registred New User");
		
	}
	
	
	
	
}

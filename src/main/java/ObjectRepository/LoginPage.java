package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// Decclaration 
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginiconclick;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTextField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//h2[text()='Login to your account']")
	private WebElement loginToYourAccountText;
	
	public String getloginToYourAccountText() {
		return loginToYourAccountText.getText();
		
	}

	/*
	 * // bussiness library is used instead of Library to reduce the lines in the
	 * script public WebElement getUserNameTextField() { return userNameTextField; }
	 * 
	 * public WebElement getPasswordTextField() { return passwordTextField; }
	 * 
	 * public WebElement getLoginButton() { return loginButton; }
	 */
	// initialization all element variable
	

	// bussiness Library or getter
	public void loginAction(String userName, String password) {
		loginiconclick.click();
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}

	public void adminLogInAction(String adnusername, String adnpassword) {
		userNameTextField.sendKeys(adnusername);
		passwordTextField.sendKeys(adnpassword);
		loginButton.click();
	}
	
	public void newUserLogInAction(String userName, String password) {
		loginiconclick.click();
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
		System.out.println("Successfully Log-in with NewUser");
	}

}

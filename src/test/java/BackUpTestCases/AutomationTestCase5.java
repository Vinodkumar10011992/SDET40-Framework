package BackUpTestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.sdet40.genericUtility.DataType;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantPath;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebDriverUtility;

public class AutomationTestCase5 {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fileUtility=new FileUtility();
		fileUtility.intiallizePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		
		String browser =fileUtility.getDataFromPropertyFile("browser");
		String url = fileUtility.getDataFromPropertyFile("url");
		String username = fileUtility.getDataFromPropertyFile("username");
		String password = fileUtility.getDataFromPropertyFile("password");
		String admurl = fileUtility.getDataFromPropertyFile("admurl");
		String adnusername = fileUtility.getDataFromPropertyFile("adnusername");
		String adnpassword = fileUtility.getDataFromPropertyFile("adnpassword");
		String Timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.launchBrowser(browser);
		JavaUtility javaUtility = new JavaUtility();
		
		long longTimeOut =(long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver= webDriverUtility.openBrowserWithApplication( longTimeOut, url);
		
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.findElement(By.linkText("Restaurants")).click();
		driver.findElement(By.linkText("View Menu")).click();
		driver.findElement(By.xpath("(//input[@class='btn theme-btn'])[1]")).click();
		driver.findElement(By.linkText("Checkout")).click();
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		longTimeOut =(long) javaUtility.convertStringIntoAnyDatatype(Timeouts, DataType.LONG);
		driver= webDriverUtility.openBrowserWithApplication(longTimeOut, admurl);
		
		driver.findElement(By.name("username")).sendKeys(adnusername);
		driver.findElement(By.name("password")).sendKeys(adnpassword);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Orders")).click();
		driver.findElement(By.xpath("//tbody//tr[last()]//td//i[@class='fa fa-edit']")).click();
		driver.findElement(By.linkText("Update Order Status")).click();
		Thread.sleep(3000);
		String ParentWindow1 = driver.getWindowHandle();
		String SubWindowHandler1 = null;
		Set<String> Handles1 = driver.getWindowHandles();
		Iterator<String> it1 = Handles1.iterator();
		while (it1.hasNext()) {
			SubWindowHandler1 = it1.next();
		}
		driver.switchTo().window(SubWindowHandler1);

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("buttn")).click();
		driver.close();
		driver.switchTo().window(ParentWindow1);
		driver.findElement(By.linkText("Update Order Status")).click();
		String ParentWindow2 = driver.getWindowHandle();
		String SubWindowHandler2 = null;
		Set<String> Handles2 = driver.getWindowHandles();
		Iterator<String> it2 = Handles2.iterator();
		while (it2.hasNext()) {
			SubWindowHandler2 = it2.next();
		}
		driver.switchTo().window(SubWindowHandler2);
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByVisibleText("Delivered");

		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Order is On the way");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//input[@class='btn btn-danger']")).click();
		driver.switchTo().window(ParentWindow2);
		driver.findElement(By.linkText("Orders")).click();
		String status = driver.findElement(By.xpath("//tbody//tr[last()]//button[@type='button']")).getText();
		System.out.println("Order status is :" + status);
		driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();

		webDriverUtility.closeBrowser(driver);
}
	}

package org.sder40.practice;


import org.sdet40.genericUtility.WebDriverUtility;
import org.testng.annotations.Test;

public class MavenPractice2Test {
@Test
	public void step2Test() {

		String browser = System.getProperty("b");
		String url = System.getProperty("u");
		System.out.println("Browser name is --- "+browser);
		System.out.println("url name is --- "+url);
		
		WebDriverUtility webDriverUtility= new WebDriverUtility();
		webDriverUtility.launchBrowser(browser);
		webDriverUtility.openBrowserWithApplication(10l, url);
		
		
	}
}

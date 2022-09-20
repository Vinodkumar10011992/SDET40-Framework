package org.sder40.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class TestNGPractice {

@Test(groups="regression", retryAnalyzer = org.sdet40.genericUtility.RetryImplementation.class)
public void beforeSuits()
	{
	Assert.fail();
		System.out.println("Database Connected");
	}

@Test(groups={"sanity","regression"})
	public void beforeTest()
	{
	Assert.fail();
		System.out.println("Type of excecution");
	}
	
@Test
	public void beforeClass()
	{
		System.out.println("Browser launched");
	}
@Test	
	public void beforeMethod()
	{
		Reporter.log("Browser Opened");
	}
	

@Test	
public void AfterMethod()
{
	Reporter.log("Browser launched");
}
	

	
@Test
	public void afterClass()
	{
		System.out.println("Browser closed");
	}
	
@Test	
	public void afterTest()
	{
		System.out.println("Excecution done");
	}
@Test
	public void afterSuits()
	{
		System.out.println("Database Connection closed");
	}

	
}



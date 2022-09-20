package org.sder40.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertionPractice {
@Test
	public void test1() {
		String actual="Hi";
		String expected="Hi";
		Reporter.log("test 1", true);
		Assert.assertEquals(actual, expected);
		Reporter.log("test 11",true);
		Reporter.log(expected);
	
	}
@Test
public void test2() {
	Reporter.log("Test 2", true);
}
}

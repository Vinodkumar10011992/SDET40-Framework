package org.sder40.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice2 {
	@Test
	public void test1() {
SoftAssert soft=new SoftAssert();
String actual="Hi"
		+ "";
String expected= "Hi";
Reporter.log("test1", true);
soft.assertEquals(actual, expected);
Reporter.log("Test 11", true);
soft.assertTrue(1==1 && actual.contains(expected) && actual.equals(expected), "Verify 1 with 4 and wether actual cantains expected");
soft.assertAll();
soft.assertEquals('A', 'B');
Reporter.log("Test 12", true);
	
	}
}

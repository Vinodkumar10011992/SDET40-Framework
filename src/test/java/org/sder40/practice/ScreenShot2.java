package org.sder40.practice;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenShot2 extends BaseClass {

@Test
		
	public void  ScreenShot() {
		ListenerImplementation.stest.assignAuthor("Vinod");
		ListenerImplementation.stest.assignCategory("regression");
		Assert.fail();
}

	}
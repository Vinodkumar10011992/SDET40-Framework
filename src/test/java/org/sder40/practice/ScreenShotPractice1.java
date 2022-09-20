package org.sder40.practice;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.ListenerImplementation;
import org.testng.annotations.Test;

class ScreenShotPractice1 extends BaseClass {
	@Test
	
public void ScreenShot() {
	ListenerImplementation.stest.assignAuthor("Ritesh");
	ListenerImplementation.stest.assignCategory("smoke");
	
}
}
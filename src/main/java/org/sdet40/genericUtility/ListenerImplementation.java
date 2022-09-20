package org.sdet40.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerImplementation implements ITestListener {

	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark= new ExtentSparkReporter("./extentreport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-SDET 40");
		spark.config().setReportName("Report Name-SDET 40");
		spark.config().setTheme(Theme.DARK);
		
		reports= new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Vinod");
		reports.setSystemInfo("OS", "Win 07");
		reports.setSystemInfo("Browser", "chrome");
	}
	

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
	}
	

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"pass");
		
	}
	
	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"fail");
		test.fail(result.getThrowable());
		//)
		String path = new WebDriverUtility().takeScreenshot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);

	}
	
	public void onTestSkipeed(ITestResult result) {
	
		test.skip(result.getMethod().getMethodName()+"skip");
		test.fail(result.getThrowable());
	}
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	
	public void onFinish(ITestContext context) {
		reports.flush();
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


}

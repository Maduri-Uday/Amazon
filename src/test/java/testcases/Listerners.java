package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSingle;
import resources.Base;
import resources.ExtentReports;


public class Listerners extends Base implements ITestListener{
	
	
	ExtentTest test;
	com.aventstack.extentreports.ExtentReports extent =ExtentReports.getReportObject();
	ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();
	
	

	public void onTestStart(ITestResult result) {
	
		
		 test = extent.createTest(result.getMethod().getMethodName());
		 local.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		local.get().log(Status.PASS,"Test got Passed");

	}

	public void onTestFailure(ITestResult result) {
		local.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String failmethod = result.getMethod().getMethodName();
	try {
	
		driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		local.get().addScreenCaptureFromPath(screenshot(failmethod, driver),result.getMethod().getMethodName());
	} catch (Exception e) {
		
	}
		
		try {
			screenshot(failmethod,driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}

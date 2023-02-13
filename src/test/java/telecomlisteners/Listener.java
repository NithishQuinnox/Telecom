package telecomlisteners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilites.ScreenCapture;




public class Listener  implements ITestListener{


	ExtentTest extentTest;
	ExtentReports extentReport;
	private static WebDriver driver;


	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Listener.driver = driver;
	}



	public void onTestStart(ITestResult result) {
		System.out.println("Test Started  "+result.getName());
		extentTest=extentReport.createTest(result.getMethod().getMethodName(), result.getName());

	}


	public void onTestSuccess(ITestResult result) {
		try {
			extentTest.addScreenCaptureFromPath( ScreenCapture.capture(Listener.driver)).log(Status.PASS, "Submit",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
			System.out.println("Test Passed  " +result.getMethod().getMethodName());
		}
		catch(Exception e) {
			System.out.println("Error Message  "+e.getMessage());
		}

	}


	
	public void onTestFailure(ITestResult result) {
		try {
			Throwable throwvar=result.getThrowable();
			extentTest.addScreenCaptureFromPath(ScreenCapture.capture(Listener.driver)).log(Status.FAIL, throwvar.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
			System.out.println("Test failed" +result.getMethod().getMethodName());

		}
		catch(Exception e) {
			System.out.println("Error Message  "+e.getMessage());
		}
	}


	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped  "+result.getName());

	}



	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("extentReports.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		System.out.println("Test Started");
	}


	public void onFinish(ITestContext context) {
		extentTest=extentReport.createTest(context.getName());
		try {
			extentTest.addScreenCaptureFromPath(ScreenCapture.capture(Listener.driver)).log(Status.PASS, "Submit",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
			System.out.println("Test Passed  " +context);
		}
		catch(Exception e) {
			System.out.println("Error Message  "+e.getMessage());
		}


		System.out.println("Test finished  "+context.getName());
		extentReport.flush();
	}
}

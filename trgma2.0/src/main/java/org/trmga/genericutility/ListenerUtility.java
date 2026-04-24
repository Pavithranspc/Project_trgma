package org.trmga.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.trmga.bussinessutility.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerUtility implements ITestListener,ISuiteListener {
	
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("onStart",true);
		
		JavaUtility jutil = new JavaUtility();
		String time = jutil.getTimeStamp();
		
		//Step 1: create object for ExtentSparkReporter class
		spark = new ExtentSparkReporter("./reports/report"+time+".html");
		
		//Step 2: create object for ExtentReports
		report = new ExtentReports();
		
		//Step 3: attach spark to report
		report.attachReporter(spark);

		//Step 4: create the report using createTest() from ExtentReport
		test = report.createTest(suite.getName());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		Reporter.log("onFinish",true);
		
		//Step 6: flush the report
		report.flush();
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		Reporter.log("onTestSuccess",true);
		
		//information
		test.info(result.getMethod().getMethodName());
		
		//Step 5: log() the report
		test.log(Status.PASS,result.getName());
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("onTestFailure",true);
		
		//type cast
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./screenshots/img.png");
		
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.info(result.getMethod().getMethodName());
		
		//Step 5: log() the report
		test.log(Status.FAIL, result.getName());

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("onTestSkipped",true);
		
		test.info(result.getMethod().getMethodName());
		
		//Step 5: log() the report
		test.log(Status.SKIP, result.getName());

		
	}

}

package com.crm.Vtiger.Framework.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.Vtiger.Framework.Base.BaseClass;

public class ListenerImplementation implements ITestListener ,ISuiteListener  {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) { //execute beforesuite config
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark=new ExtentSparkReporter("./Adavance report/report_"+time+".html");
		spark.config().setDocumentTitle("CRM test results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Environment info and create test
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("browser", "CHROME-100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("======="+result.getMethod().getMethodName()+"====Start========");
		test=report.createTest(result.getMethod().getMethodName());
		//UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=====started====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("======="+result.getMethod().getMethodName()+"====End========");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===>completed<====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getMethod().getMethodName();
		
		TakesScreenshot eDriver= (TakesScreenshot) BaseClass.sdriver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
	
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);
	    test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED<===");
			
	
			
		}
	

	@Override
	public void onTestSkipped(ITestResult result) {
	 
		 test.log(Status.SKIP, result.getMethod().getMethodName()+"==> SKIPPED<===");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
	
}

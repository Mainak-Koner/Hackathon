package com.policybazaar.extentreports;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	
	@BeforeSuite
	public void startReport() {
		
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target\\ExtentReports\\index.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Extent Report");
        spark.config().setReportName("Policybazaar.com");
        extent.attachReporter(spark);
		
	}
	
	public static ExtentTest extentReport(String testName) {
		
		test = extent.createTest(testName);
		return test;
		
	}
		
	@AfterSuite
	public void flushReport() {
		
		extent.flush();
		
	}
	
}

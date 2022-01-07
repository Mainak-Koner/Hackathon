package com.policybazaar.smoke;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.configurations.DriverSetup;
import com.policybazaar.extentreports.ExtentReport;
import com.policybazaar.pageobjectmodel.HomePage;

public class HealthInsurance {
    
    static WebDriver driver;
    static ExtentTest test;
    HomePage home;
    
    @BeforeClass
    public void setDriver() throws IOException {
    	
		try {
			test = ExtentReport.extentReport("Health Insurance - Smoke");
			
			FileInputStream readFile = new FileInputStream("src\\test\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(readFile);
			
			String browser = prop.getProperty("browser");
			String URL = prop.getProperty("baseURL");
			
			driver = DriverSetup.getWebDriver(browser);
			test.info("Driver Started ...");
			
			DriverSetup.getURL(URL);
			test.info("URL Loaded ...");
			
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(URL.equals(currentURL));
		}
		catch (IOException e) {
			
			test.fail("Unable to read config.properties - IOException");
		}
		catch (AssertionError e) {
			
			test.fail("URL does not match");
		}

    }
    
    //To get the list of health insurance
    @Test
    public void gethealthInsuranceList() {
	    try {
	    	
	        home = new HomePage(driver);
	        Actions act = new Actions(driver);
	        WebElement insuranceProduct = home.insuranceProduct();
	        act.moveToElement(insuranceProduct).build().perform();
	        List<WebElement>healthInsuranceList = driver.findElements(home.healthInsuranceList);
	        test.info("Available health insurance options are: ");
	        
	        for (WebElement healthInsurance : healthInsuranceList) {
	            test.info(healthInsurance.getText());
	        }
	        
	        test.pass("Test Case For Health Insurance Passed");
    	}
    	catch (Exception e) {
    		
    		test.fail("Health insurance options are not printed");
    	}
    }
    
    @AfterClass
    public void closeBrowser() {
    	DriverSetup.quitDriver();
		test.info("Driver closed ...");
    }
}

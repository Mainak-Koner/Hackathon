package com.policybazaar.smoke;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.configurations.DriverSetup;
import com.policybazaar.extentreports.ExtentReport;
import com.policybazaar.pageobjectmodel.*;

public class TravelInsurance {
	
	static WebDriver driver;
	int sheetRowNum = 1;
	static ExtentTest test;
	HomePage home;
	TravelInsuranceEntryPage travel;
	InsurancePlansPage plans;
	
	@BeforeClass
	public void setDriver() {
		
		try {
			test = ExtentReport.extentReport("Travel Insurance - Smoke");
			
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
	
	// To click travel insurance from home page
	@Test
	public void searchForTravelInsurance() {
		
		home = new HomePage(driver);
		home.travelInsurance().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		travel = new TravelInsuranceEntryPage(driver);
		
	}
	
	public String[] getExcelData(int rowNum) throws IOException {
		
		return ExcelData.readExcelData("Travel Insurance", sheetRowNum);
		
	}
	
	// To select the country of destination
	@Test(priority = 1)
	public void selectDestination() throws IOException {
		
		String country = getExcelData(sheetRowNum)[0];
		travel.searchBoxCountry().sendKeys(country);
		waitUntilClickable(15, travel.firstCountry());
		travel.firstCountry().click();
		clickNext();
		
	}
	
	// To select start and end date of the journey
	@Test(priority = 2)
	public void selectDates() throws IOException, ParseException {
		
		travel.startDate().click();
		String startDate = getExcelData(sheetRowNum)[1];
		String endDate = getExcelData(sheetRowNum)[2];
		
		validateDates(startDate, endDate);
		String formattedStartDate = formatDate(startDate);
		String formattedEndDate = formatDate(endDate);
		
		String month1 = formattedStartDate.substring(0, 3);
		String year1 = formattedStartDate.substring(formattedStartDate.length()-4);
		String month2 = formattedEndDate.substring(0, 3);
		String year2 = formattedEndDate.substring(formattedEndDate.length()-4);
		
		boolean isSuccessful = false;
		
		while (!isSuccessful) {
			
			String currentMonth = travel.firstCalenderHead().getText();
			if (currentMonth.endsWith(year1) && currentMonth.startsWith(month1)) {
				
				waitUntilClickable(15, travel.startBtn(formattedStartDate));
				travel.startBtn(formattedStartDate).click();
				
				while (!isSuccessful) {
					
					currentMonth = travel.firstCalenderHead().getText();
					if (currentMonth.endsWith(year2) && currentMonth.startsWith(month2)) {
						
						waitUntilClickable(15, travel.endBtn(formattedEndDate));
						travel.endBtn(formattedEndDate).click();
						isSuccessful = true;
					}
					else {
						
						travel.nextArrowCalendar().click();
					}
				}
			}
			else {

				travel.nextArrowCalendar().click();
			}
		}
		
		clickNext();

	}
	
	public void validateDates(String startDate, String endDate) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		Date today = dateFormat.parse(dateFormat.format(date));
		Date date1 = dateFormat.parse(startDate);
		Date date2 = dateFormat.parse(endDate);
		
		int comparison1 = date1.compareTo(today);
		int comparison2 = date2.compareTo(date1);
		
		Assert.assertTrue(comparison1 >= 0);
		Assert.assertTrue(comparison2 > 0);
		
	}
	
	public String formatDate(String date) throws ParseException {
		
		Date dateObj = new SimpleDateFormat("MM/dd/yy").parse(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		String formattedDate = dateFormat.format(dateObj);
		
		if (formattedDate.indexOf("0") == 4) {
			
			formattedDate = formattedDate.replaceFirst("0", "");
			
		}
		
		return formattedDate;
		
	}
	
	// To select the age of the two travelers
	@Test(priority = 3)
	public void selectNoOfPeople() throws IOException {
		
		travel.forTwoPeople().click();
		String age1 = getExcelData(sheetRowNum)[3];
		String age2 = getExcelData(sheetRowNum)[4];
		
		new Select(travel.ageSelection1st()).selectByValue(age1);
		new Select(travel.ageSelection2nd()).selectByValue(age2);
		
		clickNext();
		
	}
	
	// To select if there is any pre-existing medical condition
	@Test(priority = 4)
	public void selectMedicalCondition() {
		
		travel.noRadio().click();
		
	}
	
	// To enter the mobile number
	@Test(priority = 5)
	public void enterMobileNumber() throws IOException {
		
		String mobile = getExcelData(sheetRowNum)[5];
		travel.inputMobileNo().sendKeys(mobile);
		clickNext();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public void clickNext() {
		
		waitUntilClickable(10, travel.nextButton());
		travel.nextButton().click();
		
	}
	
	// To sort the insurance plan by price low to high
	@Test(priority = 6)
	public void sortByLowToHigh() {
		
		plans = new InsurancePlansPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(plans.wholePage())));
		plans.sortBy().click();
		plans.lowToHigh().click();
		plans.applyBtn().click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(plans.coverageList()));
		
	}
	
	// To display the top three insurance plans from the list
	@Test(priority = 7)
	public void displayTopThree() {
		
		List<WebElement> insurances = driver.findElements(plans.insurancePlans);
		List<WebElement> prices = driver.findElements(plans.planPremium);
		
		test.info("\nThe Top Three Insurance Providers:");
		for (int i = 0; i < 3; i ++) {
			
			test.info(insurances.get(i).getText() + " - Rs. " + prices.get(i).getText().substring(1));
		}
		
		test.pass("Test Case Passed");
		
	}
	
	public void waitUntilClickable(int seconds, WebElement element) {
		
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	@AfterClass
	public void quitBrowser() {
		
		DriverSetup.quitDriver();
		test.info("Driver closed ...");
		
	}
	
}

package com.policybazaar.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
import com.policybazaar.pageobjectmodel.HomePage;
import com.policybazaar.pageobjectmodel.InsurancePlansPage;
import com.policybazaar.pageobjectmodel.TravelInsuranceEntryPage;

public class TravelInsurance {
	
	static WebDriver driver;
	static String URL;
	static ExtentTest test;
	HomePage home;
	TravelInsuranceEntryPage travel;
	InsurancePlansPage plans;
	
	@BeforeClass
	public void setDriver() {
		
		try {
			test = ExtentReport.extentReport("Travel Insurance - Regression");
			
			FileInputStream readFile = new FileInputStream("src\\test\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(readFile);
			
			String browser = prop.getProperty("browser");
			URL = prop.getProperty("baseURL");
			
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
	
	@DataProvider(name = "Travel-Details")
	public Object[][] getTravelDetails() throws IOException {
		
		return ExcelData.readExcelData("Travel Insurance");
		
	}
	
	@Test(dataProvider = "Travel-Details")
	public void searchForTravelInsurance(String country, String startDate, String endDate, String age1, String age2, String condition1, String condition2, String mobile) throws ParseException {
		
		home = new HomePage(driver);
		home.travelInsurance().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		travel = new TravelInsuranceEntryPage(driver);
		
		try {
			selectDestination(country);
			try {
				selectDates(startDate, endDate);
				try {
					selectNoOfPeople(age1, age2);
					try {
						selectMedicalCondition(condition1, condition2);
						try {
							enterMobileNumber(mobile);
							try {
								sortByLowToHigh();
								displayTopThree();
							} catch (Exception e) {
								test.fail("Failed to get insurance plans");
							}
						} catch (TimeoutException e) {
							test.fail("Invalid mobile number");
						}
					} catch (Exception e) {
						test.fail("Failed select pre-existing medical conditions");
					}
				} catch (Exception e) {
					test.fail("Failed to select number of travelers");
				}
			} 
			catch (AssertionError e) {
				test.fail("Past dates are not selectable, and there must be atleast 1 day between start and end date");
			}
			catch (ElementClickInterceptedException e) {
				test.fail("Days between two dates must be less than 180");
			}
		}
		catch (Exception e) {
			test.fail("Failed to select destination");
		}
		
		navigateToHome();
		
	}
	
	// To select the country of destination
	public void selectDestination(String country) {
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				travel.searchBoxCountry().sendKeys(country);
				waitUntilClickable(30, travel.firstCountry());
				travel.firstCountry().click();
				clickNext();
				onNextScreen = true;
			} catch (TimeoutException e) {}
		}
		
	}
	
	// To select start and end date of the journey
	public void selectDates(String startDate, String endDate) throws ParseException {
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				travel.startDate().click();
				onNextScreen = true;
			} catch (NoSuchElementException e) {
				
				clickNext();
				onNextScreen = true;
			}
		}
		
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
	public void selectNoOfPeople(String age1, String age2) {
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				travel.forTwoPeople().click();
				onNextScreen = true;
			} catch (NoSuchElementException e) {
				
				clickNext();
				onNextScreen = true;
			}
		}
		
		new Select(travel.ageSelection1st()).selectByValue(age1);
		new Select(travel.ageSelection2nd()).selectByValue(age2);
		
		clickNext();
		
	}
	
	// To select if there is any pre-existing medical condition
	public void selectMedicalCondition(String condition1, String condition2) {
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				if (condition1.equalsIgnoreCase("No") && condition2.equalsIgnoreCase("No")) {
					
					travel.noRadio().click();
					onNextScreen = true;
				}
				else {
					
					travel.yesRadio().click();
					onNextScreen = true;

					if (condition1.equalsIgnoreCase("Yes")) {
						
						travel.checkBoxForFirst().click();
					}
					
					if (condition2.equalsIgnoreCase("Yes")) {
						
						travel.checkBoxForSecond().click();
					}
					
					clickNext();
				}
			} catch (NoSuchElementException e) {
				
				clickNext();
				onNextScreen = true;
			}
		}
		
	}
	
	// To enter the mobile number
	public void enterMobileNumber(String mobile) {
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				travel.inputMobileNo().sendKeys(mobile);
				onNextScreen = true;
			} catch (NoSuchElementException e) {
				
				clickNext();
				onNextScreen = true;
			}
		}
		
		clickNext();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public void clickNext() {
		
		waitUntilClickable(10, travel.nextButton());
		travel.nextButton().click();
		
	}
	
	// To sort the insurance plan by price low to high
	public void sortByLowToHigh() {
		
		plans = new InsurancePlansPage(driver);
		
		Boolean onNextScreen = false;
		while (!onNextScreen) {
			try {
				
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(plans.wholePage())));
				plans.sortBy().click();
				onNextScreen = true;
			} catch (NoSuchElementException e) {
				
				clickNext();
				onNextScreen = true;
			}
		}
		plans.lowToHigh().click();
		plans.applyBtn().click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(plans.coverageList()));
		
	}
	
	// To display the top three insurance plans from the list
	public void displayTopThree() {
		
		List<WebElement> insurances = driver.findElements(plans.insurancePlans);
		List<WebElement> prices = driver.findElements(plans.planPremium);
		
		test.info("\nThe Top Three Insurance Providers:");
		
		for (int i = 0; i < 3; i ++) {
			
			test.info(insurances.get(i).getText() + " - Rs. " + prices.get(i).getText().substring(1));
		}
		
		test.pass("1 Test Case Passed");
		
	}
	
	public void waitUntilClickable(int seconds, WebElement element) {
		
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	// Redirect to the home page
	public void navigateToHome() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}
	
	@AfterClass
	public void quitBrowser() {
		
		DriverSetup.quitDriver();
		test.info("Driver closed ...");
		
	}
	
}

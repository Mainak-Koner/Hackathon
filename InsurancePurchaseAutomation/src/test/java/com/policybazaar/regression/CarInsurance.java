package com.policybazaar.regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.configurations.DriverSetup;
import com.policybazaar.extentreports.ExtentReport;
import com.policybazaar.pageobjectmodel.CarInsuranceEntryPage;
import com.policybazaar.pageobjectmodel.HomePage;

public class CarInsurance {
	static WebDriver driver;
	static ExtentTest test;
	static int num = 1;
	static String URL;
	HomePage home;
	CarInsuranceEntryPage car;

	@BeforeClass
	public void setDriver() throws IOException {

		try {
			test = ExtentReport.extentReport("Car Insurance - Regression");

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
		} catch (IOException e) {

			test.fail("Unable to read config.properties - IOException");
		} catch (AssertionError e) {

			test.fail("URL does not match");
		}

	}

	@DataProvider(name = "Car-Details")
	public Object[][] getCarDetails() throws IOException {

		return ExcelData.readExcelData("Car Insurance");

	}

	@Test(dataProvider = "Car-Details")
	public void searchForCarInsurance(String city, String rto, String carBrand, String modelName, String fuelType,
			String carVariant, String year, String name, String mail, String phno) throws ParseException, IOException {

		home = new HomePage(driver);
		home.carInsurance().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		car = new CarInsuranceEntryPage(driver);

		carNumber(city, rto, carBrand, modelName);
		fuel(fuelType, carVariant, year);
		fillDetails(name, mail, phno);

		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.policybazaar.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	// Click to proceed without car number
	public void carNumber(String city, String rto, String carBrand, String modelName) throws IOException {

		car.withoutcarno().click();

		car.inputtextbox().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		car.inputtextbox().sendKeys(city); // Select city
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(car.rto(rto)));
		car.rto(rto).click(); // select rto from suggestion

		new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(car.inputtextbox())));

		car.inputtextbox().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		car.inputtextbox().sendKeys(carBrand); // select car brand
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(car.carModel(modelName)));
		car.carModel(modelName).click(); // select car model from suggestion

	}

	// select fuel-type and car variant
	public void fuel(String fuelType, String carVariant, String year) throws IOException {

		car.carFuel(fuelType).click();
		car.variantType(carVariant).click();

		if (year.equalsIgnoreCase("brand new car")) {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(car.brandNewCar())));
			car.brandNewCar().click();
		} else {
			car.year(year).click();
		}
	}

	// fill the details
	public void fillDetails(String name, String email, String phno) {

		String URL = driver.getCurrentUrl();
		WebElement Fullname = car.name_textbox();
		WebElement emailId = car.email_textbox();
		WebElement phnum = car.mobileNo_textbox();

		try {

			new WebDriverWait(driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(car.name_textbox),
							ExpectedConditions.elementToBeClickable(car.name_textbox())));

			Fullname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

			if (name.isEmpty() == false) {
				Fullname.sendKeys(name);
			}

			emailId.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

			if (email.isEmpty() == false) {
				emailId.sendKeys(email);
			}

			phnum.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

			if (phno.isEmpty() == false) {
				phnum.sendKeys(phno);
			}

			car.viewPlans().click();
			String err = car.errorMsg().getText();
			test.info(err);

			takeScreenshot("screenshot_regression" + num);
			test.pass("1 Test Case Passed");
			num++;

		} catch (Exception e) {

			test.info("Each input is valid");
			driver.navigate().to(URL);

			for (int i = 0; i <= 5; i++) {
				car.rightbutton().click();
			}
		}

	}

	public void takeScreenshot(String name) throws InterruptedException {

		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Thread.sleep(2000);

		try {
			FileUtils.copyFile(ss, new File("target\\ExtentReports\\screenshots\\" + name + ".png"));
			test.pass("Screenshot captured successfully");
		} catch (Exception e) {
			test.pass("error");
		}

		Thread.sleep(2000);
	}

	@AfterClass
	public void quitBrowser() {

		DriverSetup.quitDriver();
		test.info("Driver closed ...");

	}

}
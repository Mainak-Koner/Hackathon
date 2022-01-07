package com.policybazaar.smoke;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	int sheetRowNum = 1;
	HomePage home;
	CarInsuranceEntryPage car;

	@BeforeClass
	public void setDriver() throws IOException {

		try {
			test = ExtentReport.extentReport("Car Insurance - Smoke");

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
		} catch (IOException e) {

			test.fail("Unable to read config.properties - IOException");
		} catch (AssertionError e) {

			test.fail("URL does not match");
		}

	}

	@Test
	public void searchForCarInsurance() {

		home = new HomePage(driver);
		home.carInsurance().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		car = new CarInsuranceEntryPage(driver);
	}

	public String[] getExcelData(int rowNum) throws IOException {
		return ExcelData.readExcelData("Car Insurance", rowNum);

	}

	// Click to proceed without car number
	@Test(priority = 1)
	public void carNumber() throws IOException {

		String city = getExcelData(sheetRowNum)[0];
		String RTO = getExcelData(sheetRowNum)[1];
		String carBrand = getExcelData(sheetRowNum)[2];
		String modelName = getExcelData(sheetRowNum)[3];

		car.withoutcarno().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		car.inputtextbox().sendKeys(city); // Select city
		car.rto(RTO).click(); // select rto from suggestion
		new WebDriverWait(driver, Duration.ofSeconds(60))
				.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(car.inputtextbox())));
		car.inputtextbox().sendKeys(carBrand); // select car brand
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(car.carModel(modelName)));
		car.carModel(modelName).click(); // select car model from suggestion

	}

	// select fuel-type and car variant
	@Test(priority = 2)
	public void fuel() throws IOException {

		String fuelType = getExcelData(sheetRowNum)[4];
		String carVariant = getExcelData(sheetRowNum)[5];
		String regYear = getExcelData(sheetRowNum)[6];

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		car.carFuel(fuelType).click();
		car.variantType(carVariant).click();

		if (regYear.equalsIgnoreCase("brand new car")) {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(car.brandNewCar())));
			car.brandNewCar().click();
		} else {
			car.year(regYear).click();
		}

	}

	@DataProvider(name = "details")
	public Object[][] readExcelData() throws IOException {

		Object[][] data = null;
		FileInputStream fis = new FileInputStream("src\\test\\resources\\SmokeTestDetails.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Form Validation");

		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();

		data = new Object[lastRow][lastCell];

		for (int i = 1; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < lastCell; j++) {

				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String val = dft.formatCellValue(cell);
				data[i - 1][j] = val;
			}
		}
		wb.close();
		return data;

	}

	// fill the details
	@Test(dataProvider = "details", priority = 3)
	public void fillDetails(String name, String email, String phno) throws InterruptedException {

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

			takeScreenshot("screenshot" + num);
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
	public void closeBrowser() {
		DriverSetup.quitDriver();
		test.info("Driver closed ...");
	}
}

package com.policybazaar.configurations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	private static WebDriver driver;

	public static WebDriver getWebDriver(String browser) {

		switch (browser) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		}

		return driver;

	}
	
	public static void getURL(String URL) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(URL);
		
	}
	
	public static void quitDriver() {
		
		driver.quit();
		
	}

}

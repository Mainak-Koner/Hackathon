package com.policybazaar.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarInsuranceEntryPage {
	
    WebDriver driver;

    // Page Logo
    By logo = By.className("desktop_logo");

    // Advertisement image of Akshay Kumar
    By img = By.className("akshay_img");

    // Customer support toll free numbers.
    By tollfree = By.className("tollFree");

    // Advertisement of discounts.
    By discountad = By.className("save_text");

    // Enter the car number text box.
    By CarNotextbox = By.id("regNoTextBox");

    // Click on the button to view prices
    By ViewPricesbutton = By.id("btnGetQuotes");

    // To enter without car number
    By withoutcarno = By.linkText("Proceed without car number");

    // For Brand New Cars
    By brandnewcar = By.xpath("//li[@class='col-sm-4 col-6'][1]");

    // Website footer
    By footer = By.className("legalinfo");

    // left navigation button
    By leftbutton = By.className("l_arrowicon");

    // Right navigation button
    By rightButton = By.xpath("//span[@class='r_arrowicon ']");

    // Search input text box for cars
    By inputtextbox = By.className("react-autosuggest__input");

    // City name buttons
    By cityNames = By.xpath("//ul[@class='rto-list ClaimAssistnace']");

    // list car brands
    By listbrand = By.xpath("//div[@class='row brands']");

    // list of car models belong to the brands
    By carmodels = By.xpath("//*[@id=\"dvModel\"]/div/div[2]");

    // Fuel type of the car
    By fueltype = By.xpath("//*[@id=\"dvFuelType\"]");

    // Varients of the car
    By carvarients = By.xpath("//*[@id=\"dvVariant\"]/div[2]/ul");

    By varient_tab = By.xpath("//ul[@class='varient_tab']");

    // Car model year
    By year = By.xpath("//*[@id=\"dvRegYear\"]/ul");

    // fill the name
    public By name_textbox = By.id("name");

    // fill the email id
    By email_textbox = By.id("email");

    // fill the mobile no
    By mobileNo_textbox = By.id("mobileNo");

    // For mobile no error message
    By errorMsg = By.xpath("//div[@class='msg-error show']");

    // Click on the submit button
    By submitbutton = By.id("btnLeadDetail");

    // click to read the terms and conditions
    By termsandconditions = By.className("privacy");

    // For more details whatsapp contact
    By whatsapp = By.className("form-whatsapp");

    //view plans button
    By viewPlans = By.xpath("//*[@name='next']");
    
    //brand new car button
    By brandNewCar = By.xpath("//div[@class='row']/li[1]/*/*");
    
    
    public CarInsuranceEntryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logo() {
        return driver.findElement(logo);
    }

    public WebElement tollfree() {
        return driver.findElement(tollfree);
    }

    public WebElement discountad() {
        return driver.findElement(discountad);
    }

    public WebElement CarNotextbox() {
        return driver.findElement(CarNotextbox);
    }

    public WebElement ViewPricesbutton() {
        return driver.findElement(ViewPricesbutton);
    }

    public WebElement withoutcarno() {
        return driver.findElement(withoutcarno);
    }

    public WebElement brandnewcar() {
        return driver.findElement(brandnewcar);
    }

    public WebElement footer() {
        return driver.findElement(footer);
    }

    public WebElement leftbutton() {
        return driver.findElement(leftbutton);
    }

    public WebElement rightbutton() {
        return driver.findElement(rightButton);
    }

    public WebElement inputtextbox() {
        return driver.findElement(inputtextbox);
    }

    public WebElement cityNames() {
        return driver.findElement(cityNames);
    }

    public WebElement listbrand() {
        return driver.findElement(listbrand);
    }

    public WebElement carmodels() {
        return driver.findElement(carmodels);
    }

    public WebElement fueltype() {
        return driver.findElement(fueltype);
    }

    public WebElement carvarients() {
        return driver.findElement(carvarients);
    }

    public WebElement varient_tab() {
        return driver.findElement(varient_tab);
    }

    public WebElement year() {
        return driver.findElement(year);
    }

    public WebElement name_textbox() {
        return driver.findElement(name_textbox);
    }

    public WebElement email_textbox() {
        return driver.findElement(email_textbox);
    }

    public WebElement mobileNo_textbox() {
        return driver.findElement(mobileNo_textbox);
    }

    public WebElement errorMsg() {
        return driver.findElement(errorMsg);
    }

    public WebElement submitbutton() {
        return driver.findElement(submitbutton);
    }

    public WebElement termsandconditions() {
        return driver.findElement(termsandconditions);
    }

    public WebElement whatsapp() {
        return driver.findElement(whatsapp);
    }
    public WebElement viewPlans() {
        return driver.findElement(viewPlans);
    }
    
    public WebElement brandNewCar() {
        return driver.findElement(brandNewCar);
    }
    
    public WebElement rto(String RTO) {
        return driver.findElement(By.xpath("//*[starts-with(text(),'" + RTO + "')]"));
    }

    public WebElement carModel(String modelName) {
        return driver.findElement(By.xpath("//*[text()='" + modelName + "']"));
    }

    public WebElement carFuel(String fuelType) {
        return driver.findElement(By.xpath("//*[@id='" + fuelType + "']"));
    }

    public WebElement variantType(String carVariant) {
        return driver.findElement(By.xpath("//*[text()='" + carVariant + "']"));
    }

    public WebElement year(String regYear) {
        return driver.findElement(By.xpath("//*[text()='" + regYear + "']"));
    }
	
    
}

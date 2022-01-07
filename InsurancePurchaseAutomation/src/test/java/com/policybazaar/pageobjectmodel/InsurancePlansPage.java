package com.policybazaar.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsurancePlansPage {

	WebDriver driver;

	// travel profile in header
	By travelHeader = By.className("header__travelProfile");

	// edit in travel profile
	By edit = By.className("hideSmall");

	// country details in edit
	By countryDetails = By.className("country-selector");

	// search country in country details
	By searchBoxCountry = By.id("country");

	// listbox for choosing country
	By searchList = By.className("search-list");

	// favorite-country
	By favoriteCountry = By.id("search-country");

	// save changes button in edit details country

	By saveChanges = By.id("travel_main_cta");

	// travelling dates in edit

	By travellingDates = By.xpath("//*[@id=\"edit-modal\"]/div[2]/div[2]");

	// travellers in edit

	By travellers = By.xpath("//*[@id=\"edit-modal\"]/div[2]/div[3]");

	// start date in travellers

	By startDate = By.xpath("//*[@id=\"date-range-picker\"]/div/div[1]/div/div/input");

	// end date in travellers

	By endDate = By.xpath("//*[@id=\"date-range-picker\"]/div/div[2]/div/div/input");

	// previous month in calender

	By previousMonth = By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/button[1]");// button[1]/span[1]/svg

	// next month in calender

	By nextMonth = By.xpath("/html/body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/button[2]");

	// days in calender

	By weekDay = By.className("MuiPickersCalendar-daysHeader");

	// calender dates as grid

	By calenderDates = By.className("MuiPickersCalendar-weekContainer");

	// cancel button in calender

	By cancelBtn = By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[1]/span[1]");

	// OK button in calender

	By okBtn = By.xpath("/html/body/div[2]/div[3]/div/div[2]/button[2]/span[1]");

	// age selection in drop down for traveller1
	By ageSelection1 = By.xpath("//*[@id=\"feet_0\"]");

	// traveller 1
	By traveller1 = By.id("feet_0");

	// traveller 2
	By traveller2 = By.id("feet_1");

	// age selection in drop down for traveller2
	By ageSelection2 = By.xpath("//*[@id=\"feet_1\"]");

	// medical condition checkbox for traveller1
	By medicalConditionChkBox1 = By.id("ped_checkbox_0");

	// medical condition checkbox for traveller2
	By medicalConditionChkBox2 = By.id("ped_checkbox_1");

	// add and remove traveller
	By addAndRemove = By.cssSelector(".addRemoveTraveller.add");

	// email in header
	By emailHeader = By.className("headerEmail");

	// enter your email id textbox
	By emailTextBox = By.id("emailQuotes");

	// cancel button in email
	By cancelEmailBtn = By.cssSelector(".travel_main_cta.secondaryCta.hideSmall");

	// call me in header
	By callMe = By.className("headerCall");

	// Looking for other plans block
	By otherPlans = By.className("otherPlansBlock");

	// sum insured
	By sumInsured = By.linkText("Sum Insured");

	// sum insured drop doen list
	By sumInsuredList = By.className("quotesFilters__window");

	// sort by
	By sortBy = By.linkText("Sort by");

	// sort by options
	By sortByOptions = By.className("options_box_wrapper");

	// apply button
	By applyBtn = By.xpath("//button[text()='Apply']");

	// default in sortBy
	By defaultOpt = By.id("relevance");

	// premium low to high
	By lowToHigh = By.id("low");

	// premium high to low
	By highToLow = By.id("high");

	// insurer
	By insurer = By.linkText("Insurer");

	// insureLists
	By insurerLists = By.cssSelector(".quotesFilters__window.insurerFilterWindow");

	// visa type
	By visaType = By.linkText("Visa Type");

	// visa type lists
	By visaListType = By.className("options_box_wrapper");

	// coverages
	By coverages = By.linkText("Coverages");

	// coverages list
	By coverageList = By.className("quotesFilters__window");

	// all filters
	By allFilters = By.linkText("All filters");

	// covid banner
	By covidBanner = By.className("quotesCovidBanner");

	// footer
	By footer = By.className("footer");

	// footer for need help
	By needHelpFooter = By.className("footer__needHelp");

	// call me for footer
	By callMENowFooter = By.cssSelector(".travel_main_cta.outlinedCta");

	// insurance list
	public By insurancePlans = By.cssSelector("div.quotesCard__planName.hideSmall > p.quotesCard--insurerName");

	// plan premium
	public By planPremium = By.xpath("//*[@class='quotesCard__cta']/p/span");

	// buy now button
	By buyNowBtn = By.cssSelector("//*[@class='quotesCard__cta']/button");

	// View Product Details
	By viewProductDetails = By.linkText("View Product Details");

	// more options in insurance
	By moreOption = By.cssSelector("//*[@class='quotesCardWrapper__showMore']");

	// wholePage
	By wholePage = By.cssSelector(".row_wrap.flexRow.contentWrapper");

	public InsurancePlansPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement travelHeader() {
		return driver.findElement(travelHeader);
	}

	public WebElement edit() {
		return driver.findElement(edit);
	}

	public WebElement countryDetails() {
		return driver.findElement(countryDetails);
	}

	public WebElement searchBoxCountry() {
		return driver.findElement(searchBoxCountry);
	}

	public WebElement searchList() {
		return driver.findElement(searchList);
	}

	public WebElement favoriteCountry() {
		return driver.findElement(favoriteCountry);
	}

	public WebElement saveChanges() {
		return driver.findElement(saveChanges);
	}

	public WebElement travellingDates() {
		return driver.findElement(travellingDates);
	}

	public WebElement travellers() {
		return driver.findElement(travellers);
	}

	public WebElement startDate() {
		return driver.findElement(startDate);
	}

	public WebElement endDate() {
		return driver.findElement(endDate);
	}

	public WebElement previousMonth() {
		return driver.findElement(previousMonth);
	}

	public WebElement nextMonth() {
		return driver.findElement(nextMonth);
	}

	public WebElement weekDay() {
		return driver.findElement(weekDay);
	}

	public WebElement calenderDates() {
		return driver.findElement(calenderDates);
	}

	public WebElement cancelBtn() {
		return driver.findElement(cancelBtn);
	}

	public WebElement okBtn() {
		return driver.findElement(okBtn);
	}

	public WebElement ageSelection1() {
		return driver.findElement(ageSelection1);
	}

	public WebElement traveller1() {
		return driver.findElement(traveller1);
	}

	public WebElement traveller2() {
		return driver.findElement(traveller2);
	}

	public WebElement ageSelection2() {
		return driver.findElement(ageSelection2);
	}

	public WebElement medicalConditionChkBox1() {
		return driver.findElement(medicalConditionChkBox1);
	}

	public WebElement medicalConditionChkBox2() {
		return driver.findElement(medicalConditionChkBox2);
	}

	public WebElement addAndRemove() {
		return driver.findElement(addAndRemove);
	}

	public WebElement emailHeader() {
		return driver.findElement(emailHeader);
	}

	public WebElement emailTextBox() {
		return driver.findElement(emailTextBox);
	}

	public WebElement cancelEmailBtn() {
		return driver.findElement(cancelEmailBtn);
	}

	public WebElement callMe() {
		return driver.findElement(callMe);
	}

	public WebElement otherPlans() {
		return driver.findElement(otherPlans);
	}

	public WebElement sumInsured() {
		return driver.findElement(sumInsured);
	}

	public WebElement sumInsuredList() {
		return driver.findElement(sumInsuredList);
	}

	public WebElement sortBy() {
		return driver.findElement(sortBy);
	}

	public WebElement sortByOptions() {
		return driver.findElement(sortByOptions);
	}

	public WebElement applyBtn() {
		return driver.findElement(applyBtn);
	}

	public WebElement defaultOpt() {
		return driver.findElement(defaultOpt);
	}

	public WebElement lowToHigh() {
		return driver.findElement(lowToHigh);
	}

	public WebElement highToLow() {
		return driver.findElement(highToLow);
	}

	public WebElement insurer() {
		return driver.findElement(insurer);
	}

	public WebElement insurerList() {
		return driver.findElement(insurerLists);
	}

	public WebElement visaType() {
		return driver.findElement(visaType);
	}

	public WebElement visaListType() {
		return driver.findElement(visaListType);
	}

	public WebElement coverages() {
		return driver.findElement(coverages);
	}

	public WebElement coverageList() {
		return driver.findElement(coverageList);
	}

	public WebElement allFilters() {
		return driver.findElement(allFilters);
	}

	public WebElement covidBanner() {
		return driver.findElement(covidBanner);
	}

	public WebElement footer() {
		return driver.findElement(footer);
	}

	public WebElement needHelpFooter() {
		return driver.findElement(needHelpFooter);
	}

	public WebElement callMENowFooter() {
		return driver.findElement(callMENowFooter);
	}

	public WebElement insurancePlans() {
		return driver.findElement(insurancePlans);
	}

	public WebElement planPremium() {
		return driver.findElement(planPremium);
	}

	public WebElement buyNowBtn() {
		return driver.findElement(buyNowBtn);
	}

	public WebElement viewProductDetails() {
		return driver.findElement(viewProductDetails);
	}

	public WebElement moreOption() {
		return driver.findElement(moreOption);
	}

	public WebElement wholePage() {
		return driver.findElement(wholePage);
	}

}

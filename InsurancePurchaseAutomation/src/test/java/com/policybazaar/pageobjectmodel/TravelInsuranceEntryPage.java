package com.policybazaar.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelInsuranceEntryPage {

	WebDriver driver;
	
	// logo
	By logo = By.cssSelector("a.hideSmall");
	// callUs
	By callUs = By.cssSelector("span.pqHeader__callUs.hideSmall");
	// to get a text in reasons
	By reason = By.xpath("//div[@class='reason-content wrapper']");
	// footer text
	By footer = By.className("footer__text");
	// inputbox for country
	By searchBoxCountry = By.id("country");
	// listbox for choosing country
	By searchList = By.className("search-list");
	// first list item in the suggested countries
	By firstCountry = By.cssSelector("ul.search-list > li:first-child");
	// next button after choosing country
	By next = By.className("travel_main_cta");
	// header
	By heading = By.className("pqHeading__title");
	// back button
	By back = By.xpath("//*[@id='prequote-wrapper']/span");
	// input box for start date
	By startDate = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input");
	// input box for end date
	By endDate = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[2]/div/div/input");
	// previous arrow in calendar
	By previousArrowCalendar = By
			.xpath("//div[@role='tooltip']/descendant::button[@data-mui-test='previous-arrow-button'][1]");
	// text of month in startdate
	By calenderHead1 = By.xpath(
			"//div[@class='MuiPickersArrowSwitcher-root MuiPickersDesktopDateRangeCalendar-arrowSwitcher']/preceding::h6");
	// Header of days for start date
	By dayHeaderOfStartDate = By.xpath("//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[1]/div[2]");
	// week container for start date
	By gridOfStartDate = By.xpath("//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[1]/div[3]");
	// next arrow in calendar;
	By nextArrowCalendar = By.xpath("//div[@role='tooltip']/descendant::button[@data-mui-test='next-arrow-button'][2]");
	// text of enddate month
	By calenderHead2 = By.xpath(
			"//div[@class='MuiPickersArrowSwitcher-root MuiPickersDesktopDateRangeCalendar-arrowSwitcher']/following::h6");
	// header of days for end date
	By dayHeaderOfEndDate = By.xpath("//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[2]/div[2");
	// week container for end date
	By gridOfEndDate = By
			.xpath("//div[@class='MuiPickersDesktopDateRangeCalendar-root']/div[1]/following::div[@role='grid']");
	// travel days
	By travelDays = By.xpath("//p[@class='travelDays']");
	// for one people
	By forOnePeople = By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/label");
	// for two people
	By forTwoPeople = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[1]/div[2]/label");
	// for three people
	By forThreePeople = By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div[3]/label");
	// for four plus people
	By forFourPlusPeople = By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]/label");
	// click for first traveller to enter age
	By firstTravellerAge = By.xpath("//div[@class='pqMembersAgeWrap']/div[1]/div");
	// click for second traveller to enter age
	By secondTravellerAge = By.xpath("//div[@class='pqMembersAgeWrap']/div[2]/div");
	// click for Third traveller to enter age
	By thirdTravellerAge = By.xpath("//div[@class='pqMembersAgeWrap']/div[3]/div");
	// click for fourth traveller to enter age
	By fourthTravellerAge = By.xpath("//div[@class='pqMembersAgeWrap']/div[4]/div");
	// for selecting age for 1st traveller
	By ageSelection1st = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[2]/div[1]/div/select");
	// for selecting age for 2nd traveller
	By ageSelection2nd = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[2]/div[2]/div/select");
	// for selecting age for 3rd traveller
	By ageSelection3rd = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[2]/div[3]/div/select");
	// for selecting age for 4th traveller
	By ageSelection4th = By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[2]/div[4]/div/select");
	// to increase travellers
	By increaseTraveller = By.xpath("//p/button[2]");
	// to decrease travellers
	By decreaseTraveller = By.xpath("//p/button[1]");
	// to get no of traveller text
	By noOfTraveller = By.xpath("//div[@class='traveller-counter']/span");
	// count
	By count = By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[2]/p/span");
	// radiobutton for no
	By noRadio = By.id("ped_no");
	// radiobutton for yes
	By yesRadio = By.id("ped_yes");
	// checkbox for firstperson
	By checkBoxForFirst = By.id("ped_yes_traveller_0");
	// checkbox for second person
	By checkBoxForSecond = By.id("ped_yes_traveller_1");
	// checkbox for Thirdperson
	By checkBoxForThird = By.id("ped_yes_traveller_2");
	// checkbox for second person
	By checkBoxForFourth = By.id("ped_yes_traveller_3");
	// input for mobile number
	By inputMobileNo = By.id("mobileNumber");

	public TravelInsuranceEntryPage(WebDriver driver) {
	this.driver=driver;
	}

	// return logo
	public WebElement logo() {
		return driver.findElement(logo);
	}

	// return callus
	public WebElement callUs() {
		return driver.findElement(callUs);
	}

	// return reason
	public WebElement reason() {
		return driver.findElement(reason);
	}

	// return footer
	public WebElement footer() {
		return driver.findElement(footer);
	}

	// return searchbox
	public WebElement searchBoxCountry() {
		return driver.findElement(searchBoxCountry);
	}

	// return searchlist
	public WebElement searchList() {
		return driver.findElement(searchList);
	}

	public WebElement firstCountry() {
		return driver.findElement(firstCountry);
	}
	
	// return nextbutton
	public WebElement nextButton() {
		return driver.findElement(next);
	}

	// return heading
	public WebElement heading() {
		return driver.findElement(heading);
	}

	// return backbutton
	public WebElement back() {
		return driver.findElement(back);
	}

	// return startDate
	public WebElement startDate() {
		return driver.findElement(startDate);
	}

	// return endDate
	public WebElement endDate() {
		return driver.findElement(endDate);
	}

	// return previous arrow
	public WebElement previousArrowCalendar() {
		return driver.findElement(previousArrowCalendar);
	}

	// return month of start date
	public WebElement firstCalenderHead() {
		return driver.findElement(calenderHead1);
	}

	// return header of days in startdate
	public WebElement dayHeaderOfStartDate() {
		return driver.findElement(dayHeaderOfStartDate);
	}

	// return grid of start date
	public WebElement gridOfStartDate() {
		return driver.findElement(gridOfStartDate);
	}

	// return nextArrowCalendar
	public WebElement nextArrowCalendar() {
		return driver.findElement(nextArrowCalendar);
	}

	// return monthOfEndDate
	public WebElement secondCalenderHead() {
		return driver.findElement(calenderHead2);
	}

	// return dayHeaderOfEndDate
	public WebElement dayHeaderOfEndDate() {
		return driver.findElement(dayHeaderOfEndDate);
	}

	// return gridOfEndDate
	public WebElement gridOfEndDate() {
		return driver.findElement(gridOfEndDate);
	}

	public WebElement startBtn(String stdate) {
		return driver.findElement(By.xpath("//button[@aria-label='" + stdate +"']/parent::div"));
	}
	
	public WebElement endBtn(String retdate) {
		return driver.findElement(By.xpath("//button[@aria-label='" + retdate +"']/parent::div"));
	}
	
	// return travelDays
	public WebElement travelDays() {
		return driver.findElement(travelDays);
	}

	// return foronepeople
	public WebElement forOnePeople() {
		return driver.findElement(forOnePeople);
	}

	// return forTwopeople
	public WebElement forTwoPeople() {
		return driver.findElement(forTwoPeople);
	}

	// return forThreepeople
	public WebElement forThreePeople() {
		return driver.findElement(forThreePeople);
	}

	// return forThreepeople
	public WebElement forFourPlusPeople() {
		return driver.findElement(forFourPlusPeople);
	}

	// return firstTravellerAge
	public WebElement firstTravellerAge() {
		return driver.findElement(firstTravellerAge);
	}

	// return secondTravellerAge
	public WebElement secondTravellerAge() {
		return driver.findElement(secondTravellerAge);
	}

	// return thirdTravellerAge
	public WebElement thirdTravellerAge() {
		return driver.findElement(thirdTravellerAge);
	}

	// return fourthTravellerAge
	public WebElement fourthTravellerAge() {
		return driver.findElement(fourthTravellerAge);
	}

	// return ageSelection1st
	public WebElement ageSelection1st() {
		return driver.findElement(ageSelection1st);
	}

	// return ageSelection2nd
	public WebElement ageSelection2nd() {
		return driver.findElement(ageSelection2nd);
	}

	// return ageSelection3rd
	public WebElement ageSelection3rd() {
		return driver.findElement(ageSelection3rd);
	}

	// return ageSelection4th
	public WebElement ageSelection4th() {
		return driver.findElement(ageSelection4th);
	}

	// return increaseTraveller
	public WebElement increaseTraveller() {
		return driver.findElement(increaseTraveller);
	}

	// return decreaseTraveller
	public WebElement decreaseTraveller() {
		return driver.findElement(decreaseTraveller);
	}

	// return noOfTraveller
	public WebElement noOfTraveller() {
		return driver.findElement(noOfTraveller);
	}

	// return count
	public WebElement count() {
		return driver.findElement(count);
	}

	// return noRadio
	public WebElement noRadio() {
		return driver.findElement(noRadio);
	}

	// return yesRadio
	public WebElement yesRadio() {
		return driver.findElement(yesRadio);
	}

	// return checkBoxforFirst
	public WebElement checkBoxForFirst() {
		return driver.findElement(checkBoxForFirst);
	}

	// return checkBoxforSecond
	public WebElement checkBoxForSecond() {
		return driver.findElement(checkBoxForSecond);
	}

	// return checkBoxforThird
	public WebElement checkBoxForThird() {
		return driver.findElement(checkBoxForThird);
	}

	// return checkBoxforFourth
	public WebElement checkBoxForFourth() {
		return driver.findElement(checkBoxForFourth);
	}

	// return inputMobileNumber
	public WebElement inputMobileNo() {
		return driver.findElement(inputMobileNo);
	}

}

package com.policybazaar.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	// for menu bar
	By menu = By.id("hamburger-menu");
	// for logo
	By logo = By.className("logo");
	// for signin button
	By signIn = By.linkText("Sign In");
	// for akshay image
	By akshayImg = By.xpath("//div[@class='right']/img");
	// for term life insurance
	By termLifeInsurance = By.xpath("//div[@class='prd-block'][1]");
	// for health insurance
	By healthInsurance = By.xpath("//div[@class='prd-block'][2]");
	// for investment
	By investment = By.xpath("//div[@class='prd-block'][3]");
	// for car insurance
	By carInsurance = By.xpath("//div[@class='prd-block'][4]");
	// for 2 wheeler insurance
	By twoWheelerInsurance = By.xpath("//div[@class='prd-block'][5]");
	// for family health insurance
	By familyHealthInsurance = By.xpath("//div[@class='prd-block'][6]");
	// for guaranteed return plan
	By guaranteedReturnPlan = By.xpath("//div[@class='prd-block'][7]");
	// for saral jeevan bima
	By saralJeevanBima = By.xpath("//div[@class='prd-block mrtop20'][1]");
	// for travel insurance
	By travelInsurance = By.xpath("//div[@class='prd-block mrtop20'][2]");
	// for child savings plans
	By childSavingsPlans = By.xpath("//div[@class='prd-block mrtop20'][3]");
	// for retirement plans
	By retirementPlans = By.xpath("//div[@class='prd-block mrtop20'][4]");
	// for group health insurance
	By groupHealthInsurance = By.xpath("//div[@class='prd-block mrtop20'][5]");
	// for 1 cr health insurance
	By oneCrHealthInsurance = By.xpath("//div[@class='prd-block mrtop20'][6]");
	// for view all products
	By viewAllProducts = By.xpath("//div[@class='//div[@class='prd-block mrtop20 mobile']");
	// for more products
	By alsoBuy = By.className("more-products");
	// for return of premium
	By returnOfPremium = By.xpath("//div[@class='prd-links']/a[1]");
	// for non working spouse plan
	By nonWorkingSpousePlan = By.xpath("//div[@class='prd-links']/a[2]");
	// for corona virus health insurance
	By coronavirusHealthInsurance = By.xpath("//div[@class='prd-links']/a[3]");
	// for arogya sanjeevani
	By arogyaSanjeevani = By.xpath("//div[@class='prd-links']/a[4]");
	// for home building
	By homeBuilding = By.xpath("//div[@class='prd-links']/a[5]");
	// for commercial vehicles
	By commercialVehicles = By.xpath("//div[@class='prd-links']/a[6]");
	// for pet insurance
	By petInsurance = By.xpath("//div[@class='prd-links']/a[7]");
	// for insurance product
	By insuranceProduct = By.xpath("//li[@class='ruby-menu-mega shade']");
	// for save tax investment plans
	By saveTaxInvestmentplans = By.xpath("//a[4]/article");
	// for save tax health insurance
	By saveTaxHealthInsurance = By.xpath("//a[5]/article");
	// for save tax home insurance
	By saveTaxHomeInsurance = By.xpath("//a[6]/article");
	// for save tax ask PB
	By saveTaxAskPb = By.xpath("//a[7]/article");
	// for text review
	By textReview = By.cssSelector(".txt-block.opacity-1");
	// for text feedback
	By textFeedback = By.className("info-box");
	// for text rating
	By textRating = By.cssSelector(".info-box.insurer");
	// for price rating
	By priceRating = By.cssSelector(".info-box.lowest-price");
	// for claim rating
	By claimRating = By.cssSelector(".info-box.claims");
	// for feature box
	By featurebox = By.cssSelector(".blk-prd.featurebox");
	// for tax feature box
	By taxFeature = By.xpath("//div[4]/a/img");
	// for health tax feature box
	By healthTax = By.xpath("//div[5]/a/img");
	// for claim tax feature box
	By claimTax = By.xpath("//div[6]/a/img");
	// for policy bazaar feature box
	By policybazaarFeature = By.xpath("//div[7]/a/img");
	// for ask PB feature box
	By askPb = By.xpath("//div[8]/a/img");
	// for made in India feature box
	By indiaFeature = By.xpath("//div[9]/img");
	// for fraudsters feature box
	By fraudstersFeature = By.xpath("//div[10]/a/img");
	// for home banner
	By homebanner = By.className("home-banner");
	// for PB Advantage
	By pbAdvantage = By.className("list");
	// for get the app
	By getTheApp = By.cssSelector("img[class='lazy app store']");
	// for google play
	By googlePlay = By.cssSelector("a[class='play-store googleplay download-app1']");
	// for app store
	By appStore = By.cssSelector("a[class='play-store ios install-now']");
	// for Ribbit capital investors
	By ribbitCapitalInvestors = By.cssSelector(".investor-sprite.ribbit");
	// for SoftBank investors
	By softbankInvestors = By.cssSelector(".investor-sprite.softbank");
	// for true north investors
	By trueNorthInvestors = By.cssSelector(".investor-sprite.truenorth");
	// for ICP investors
	By icpInvestors = By.cssSelector(".investor-sprite.icp");
	// for Chiratae investors
	By chiratae = By.cssSelector(".investor-sprite.chiratae");
	// for Steadview investors
	By steadView = By.cssSelector(".investor-sprite.steadview");
	// for Temasek investors
	By temasek = By.cssSelector(".investor-sprite.temasek");
	// for Premji investors
	By premjiInvestors = By.cssSelector(".investor-sprite.premji");
	// for InfoEdge investors
	By infoedge = By.cssSelector(".investor-sprite.infoedge");
	// for tiger investors
	By tigerInvestors = By.cssSelector(".investor-sprite.tiger");
	// for our partners
	By ourPartners = By.cssSelector(".partnerLogo.plr");
	// for general enquiries
	By generalEnquiries = By.xpath("(//a[@class='btn'])");
	// for customer sales enquiries
	By customerSalesEnquiries = By.xpath("(//a[@class='btn no-margin'])");
	// for group brands
	By groupBrands = By.className("co-logo");
	// for doc prime
	By docPrime = By.cssSelector(".co-logo-sprite.doc-prime");
	// for quick fix cars
	By quickFixCars = By.cssSelector(".co-logo-sprite.quick-fix-cars");
	// for policy bazaar
	By policyBazaar = By.cssSelector(".co-logo-sprite.policy-bazaar");
	// for paisa bazaar
	By paisaBazaar = By.cssSelector(".co-logo-sprite.paisa-bazaar");
	// for pb partners
	By pbPartners = By.cssSelector(".co-logo-sprite.pb-partner");
	// for pb fintech
	By pbFintech = By.cssSelector(".co-logo-sprite.fintech");
	// for Agon Life
	By agonLife = By.cssSelector(".logo-icon.agon");
	// for ICICI
	By icici = By.cssSelector(".logo-icon.icicipru");
	// for ICICI Lombard
	By iciciLombard = By.cssSelector(".logo-icon.icicilombard");
	// for MAX Life
	By maxLife = By.cssSelector(".logo-icon.maxlife");
	// for Manipal Cigna
	By manipalCigna = By.cssSelector(".logo-icon.cigna");
	// for HDFC life
	By hdfcLife = By.cssSelector(".logo-icon.hdfclife");
	// for TATA Aig
	By tataAig = By.cssSelector(".logo-icon.tataaig");
	// for Kotak life
	By kotakLife = By.cssSelector(".logo-icon.kotak");
	// for Bajaj life
	By bajajLifeGoals = By.cssSelector(".logo-icon.bajajlife");
	// for bajaj allianz
	By bajajAllianz = By.cssSelector(".logo-icon.bajajgen");
	// for niva
	By niva = By.cssSelector(".logo-icon.maxhealth");
	// for SBI life
	By sbiLife = By.cssSelector(".logo-icon.sbilife");
	// for SBI general
	By sbiGeneral = By.cssSelector(".logo-icon.sbigen");
	// for reliance general
	By relianceGeneral = By.cssSelector(".logo-icon.reliancegen");
	// for reliance life
	By relianceLife = By.cssSelector(".logo-icon.reliancelife");
	// for TATA Aia
	By tataAia = By.cssSelector(".logo-icon.tataaia");
	// for pnb Met life
	By pnbMetLife = By.cssSelector(".logo-icon.pnbmetlife");
	// for birla capital
	By birlaCapital = By.cssSelector(".logo-icon.birlasunlife");
	// for Canara HSBC
	By canaraHSBC = By.cssSelector(".logo-icon.canerahsbc");
	// for aviva
	By aviva = By.cssSelector(".logo-icon.aviva");
	// for digit
	By digit = By.cssSelector(".logo-icon.digit");
	// for care
	By care = By.cssSelector(".logo-icon.religare");
	// for star
	By star = By.cssSelector(".logo-icon.star");
	// for ageas federal
	By ageasFederal = By.cssSelector(".logo-icon.idbifedrel");
	// for exide life
	By exideLife = By.cssSelector(".logo-icon.exidelife");
	// for pramerica
	By pramerica = By.cssSelector(".logo-icon.dhfl");
	// for navi insurance
	By naviInsurance = By.cssSelector(".logo-icon.dhflgen");
	// for liberty
	By liberty = By.cssSelector(".logo-icon.liberty");
	// for IFFCO tokio
	By iffcoTokio = By.cssSelector(".logo-icon.iffcotokio");
	// for bharti axa
	By bhartiAxa = By.cssSelector(".logo-icon.bhartiaxa");
	// for future generali
	By futureGenerali = By.cssSelector(".logo-icon.futuregenerali");
	// for royal sundaram
	By royalSundaram = By.cssSelector(".logo-icon.royalsundaram");
	// for oriental insurance
	By orientalInsurance = By.cssSelector(".logo-icon.orientalinsurance");
	// for united india insurance
	By unitedIndiaInsurance = By.cssSelector(".logo-icon.unitedindiainsurance");
	// for new india health
	By newIndiaHealth = By.cssSelector(".logo-icon.newindiainsurance");
	// for shriram
	By shriram = By.cssSelector(".logo-icon.shriram");
	// for edel weiss tokio
	By edelweisstokio = By.cssSelector(".logo-icon.edelwise");
	// for national health
	By nationalHealth = By.cssSelector(".logo-icon.national");
	// for universal sompo
	By universalSompo = By.cssSelector(".logo-icon.universalsomplo");
	// for magma HDI
	By magmaHDI = By.cssSelector(".logo-icon.magmahdi");
	// for raheja QBE
	By rahejaQBE = By.cssSelector(".logo-icon.rahejaqbe");
	// for edelweiss
	By edelweiss = By.cssSelector(".logo-icon.edelwisegen");
	// for india first
	By indiaFirst = By.cssSelector(".logo-icon.indiafirst");
	// for kotak
	By kotak = By.cssSelector(".logo-icon.kotakgeneral");
	// for aditya birla
	By adityaBirla = By.cssSelector(".logo-icon.adityabirla");
	// for chola MS
	By cholaMS = By.cssSelector(".logo-icon.cholams");
	// for footer-icon general-insurance
	By GeneralInsurance = By.xpath("//ul[@class='allInsurance'][1]");
	// for footer car insurance
	By footerCarInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[2]");
	// for footer bike insurance
	By footerBikeInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[3]");
	// for footer motor insurance
	By footerMotorInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[4]");
	// for footer third party car insurance
	By footerThirdPartyCarInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[5]");
	// for footer third party bike insurance
	By footerThirdPartyBikeInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[6]");
	// for footer travel insurance
	By footerTravelInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[7]");
	// for footer commercial vehicle insurance
	By footerCommercialVehicleInsurance = By.xpath("//ul[@class='allInsurance'][1]/li[8]");
	// for footer-icon life insurance
	By LifeInsurance = By.xpath("//ul[@class='allInsurance blockbox head'][1]");
	// for footer term insurance
	By footerTermInsurance = By.xpath("//ul[@class='allInsurance blockbox head'][1]/li[2]");
	// for footer spouse term plan
	By footerSpouseTermPlan = By.xpath("//ul[@class='allInsurance blockbox head'][1]/li[3]");
	// for footer return of premium
	By footerReturnOfPremium = By.xpath("//ul[@class='allInsurance blockbox head'][1]/li[4]");
	// for footer-icon other insurance
	By OtherInsurance = By.xpath("//ul[@class='allInsurance blockbox ']");
	// for footer group health insurance
	By footerGroupHealthInsurance = By.xpath("//ul[@class='allInsurance blockbox ']/li[2]");
	// for footer other general insurance products
	By footerOtherGeneralInsuranceProducts = By.xpath("//ul[@class='allInsurance blockbox ']/li[3]");
	// for footer cancer insurance
	By footerCancerInsurance = By.xpath("//ul[@class='allInsurance blockbox ']/li[4]");
	// for footer home insurance
	By footerHomeInsurance = By.xpath("//ul[@class='allInsurance blockbox ']/li[5]");
	// for footer investment icon
	By InvestmentIcon = By.xpath("//ul[@class='allInsurance'][2]");
	// for footer investment plans
	By footerInvestmentPlans = By.xpath("//ul[@class='allInsurance'][2]/li[2]");
	// for footer child plans
	By footerChildPlans = By.xpath("//ul[@class='allInsurance'][2]/li[3]");
	// for footer pensions plans
	By footerPensionPlans = By.xpath("//ul[@class='allInsurance'][2]/li[4]");
	// for footer ULIPs
	By footerULIPs = By.xpath("//ul[@class='allInsurance'][2]/li[5]");
	// for footer money back policy
	By footerMoneyBackPolicy = By.xpath("//ul[@class='allInsurance'][2]/li[6]");
	// for footer endowment policy
	By footerEndowmentPolicy = By.xpath("//ul[@class='allInsurance'][2]/li[7]");
	// for footer guaranteed return policy
	By footerGuaranteedReturnPlans = By.xpath("//ul[@class='allInsurance'][2]/li[8]");
	// for footer tax saving plans
	By footerTaxSavingPlans = By.xpath("//ul[@class='allInsurance'][2]/li[9]");
	// for footer health insurance icon
	By HealthInsuranceIcon = By.xpath("//ul[@class='allInsurance'][3]");
	// for footer health insurance
	By footerHealthInsurance = By.xpath("//ul[@class='allInsurance'][3]/li[2]");
	// for footer one Cr health cover
	By footeroneCrHealthCover = By.xpath("//ul[@class='allInsurance'][3]/li[3]");
	// for footer family health insurance
	By footerFamilyHealthInsurance = By.xpath("//ul[@class='allInsurance'][3]/li[4]");
	// for footer senior citizen health insurance
	By footerSeniorCitizenHI = By.xpath("//ul[@class='allInsurance'][3]/li[5]");
	// for footer corona virus insurance
	By footerCoronaVirusInsurance = By.xpath("//ul[@class='allInsurance'][3]/li[6]");
	// for footer corona kavach policy
	By footerCoronakavachPolicy = By.xpath("//ul[@class='allInsurance'][3]/li[7]");
	// for footer corona rakshak policy
	By footerCoronaRakshakPolicy = By.xpath("//ul[@class='allInsurance'][3]/li[8]");
	// for footer arogya sanjeevani policy
	By footerArogyaSanjeevaniPolicy = By.xpath("//ul[@class='allInsurance'][3]/li[9]");
	// for footer-icon text
	By footerText = By.xpath("//section[@class='footerLegal']");
	// for footer link pcidss
	By footerLink = By.className("pcidss");
	// for renew your policy
	By renewYourPolicy = By.linkText("Renew Your Policy ");
	// for file a claim
	By FileAClaim = By.linkText("File a claim");
	// for support
	By support = By.linkText("Support");
	
	// Health Insurance Option
	public By healthInsuranceList = By.xpath("//div[@class='ruby-col-3 hidden-md'][2]/h3/following::ul[1]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement logo() {
		return driver.findElement(logo);
	}

	public WebElement signinButton() {
		return driver.findElement(signIn);
	}

	public WebElement akshayImage() {
		return driver.findElement(akshayImg);
	}

	public WebElement termLifeInsurance() {
		return driver.findElement(termLifeInsurance);
	}

	public WebElement healthInsurance() {
		return driver.findElement(healthInsurance);
	}

	public WebElement investment() {
		return driver.findElement(investment);
	}

	public WebElement carInsurance() {
		return driver.findElement(carInsurance);
	}

	public WebElement twoWheelerInsurance() {
		return driver.findElement(twoWheelerInsurance);
	}

	public WebElement familyHealthInsurance() {
		return driver.findElement(familyHealthInsurance);
	}

	public WebElement guaranteedReturnPlan() {
		return driver.findElement(guaranteedReturnPlan);
	}

	public WebElement saralJeevanBima() {
		return driver.findElement(saralJeevanBima);
	}

	public WebElement travelInsurance() {
		return driver.findElement(travelInsurance);
	}

	public WebElement childSavingsPlans() {
		return driver.findElement(childSavingsPlans);
	}

	public WebElement retirementPlans() {
		return driver.findElement(retirementPlans);
	}

	public WebElement groupHealthInsurance() {
		return driver.findElement(groupHealthInsurance);
	}

	public WebElement oneCrHealthInsurance() {
		return driver.findElement(oneCrHealthInsurance);
	}

	public WebElement viewAllProducts() {
		return driver.findElement(viewAllProducts);
	}

	public WebElement moreProducts() {
		return driver.findElement(alsoBuy);
	}

	public WebElement returnOfPremium() {
		return driver.findElement(returnOfPremium);
	}

	public WebElement nonWorkingSpousePlan() {
		return driver.findElement(nonWorkingSpousePlan);
	}

	public WebElement coronaVirusHealthInsurance() {
		return driver.findElement(coronavirusHealthInsurance);
	}

	public WebElement arogyaSanjeevani() {
		return driver.findElement(arogyaSanjeevani);
	}

	public WebElement homeBuilding() {
		return driver.findElement(homeBuilding);
	}

	public WebElement commercialVehicles() {
		return driver.findElement(commercialVehicles);
	}

	public WebElement petInsurance() {
		return driver.findElement(petInsurance);
	}

	public WebElement insuranceProduct() {
		return driver.findElement(insuranceProduct);
	}

	public WebElement saveTaxInvestmentPlans() {
		return driver.findElement(saveTaxInvestmentplans);
	}

	public WebElement saveTaxHealthInsurance() {
		return driver.findElement(saveTaxHealthInsurance);
	}

	public WebElement saveTaxHomeInsurance() {
		return driver.findElement(saveTaxHomeInsurance);
	}

	public WebElement saveTaxAskPb() {
		return driver.findElement(saveTaxAskPb);
	}

	public WebElement textReview() {
		return driver.findElement(textReview);
	}

	public WebElement textFeedback() {
		return driver.findElement(textFeedback);
	}

	public WebElement textRating() {
		return driver.findElement(textRating);
	}

	public WebElement priceRating() {
		return driver.findElement(priceRating);
	}

	public WebElement claimRating() {
		return driver.findElement(claimRating);
	}

	public WebElement featurebox() {
		return driver.findElement(featurebox);
	}

	public WebElement taxFeature() {
		return driver.findElement(taxFeature);
	}

	public WebElement healthTax() {
		return driver.findElement(healthTax);
	}

	public WebElement claimTax() {
		return driver.findElement(claimTax);
	}

	public WebElement policybazaarFeature() {
		return driver.findElement(policybazaarFeature);
	}

	public WebElement askPb() {
		return driver.findElement(askPb);
	}

	public WebElement indiaFeature() {
		return driver.findElement(indiaFeature);
	}

	public WebElement fraudstersFeature() {
		return driver.findElement(fraudstersFeature);
	}

	public WebElement homeBanner() {
		return driver.findElement(homebanner);
	}

	public WebElement pbAdvantage() {
		return driver.findElement(pbAdvantage);
	}

	public WebElement getTheApp() {
		return driver.findElement(getTheApp);
	}

	public WebElement googlePlay() {
		return driver.findElement(googlePlay);
	}

	public WebElement appStore() {
		return driver.findElement(appStore);
	}

	public WebElement ribbitCapitalInvestors() {
		return driver.findElement(ribbitCapitalInvestors);
	}

	public WebElement softBankInvestors() {
		return driver.findElement(softbankInvestors);
	}

	public WebElement trueNorthInvestors() {
		return driver.findElement(trueNorthInvestors);
	}

	public WebElement icpInvestors() {
		return driver.findElement(icpInvestors);
	}

	public WebElement chiratae() {
		return driver.findElement(chiratae);
	}

	public WebElement steadView() {
		return driver.findElement(steadView);
	}

	public WebElement temasek() {
		return driver.findElement(temasek);
	}

	public WebElement premjiInvestors() {
		return driver.findElement(premjiInvestors);
	}

	public WebElement infoEdge() {
		return driver.findElement(infoedge);
	}

	public WebElement tigerInvestors() {
		return driver.findElement(tigerInvestors);
	}

	public WebElement ourPartners() {
		return driver.findElement(ourPartners);
	}

	public WebElement generalEnquiries() {
		return driver.findElement(generalEnquiries);
	}

	public WebElement customerSalesEnquiries() {
		return driver.findElement(customerSalesEnquiries);
	}

	public WebElement groupBrands() {
		return driver.findElement(groupBrands);
	}

	public WebElement docPrime() {
		return driver.findElement(docPrime);
	}

	public WebElement quickFixCars() {
		return driver.findElement(quickFixCars);
	}

	public WebElement policyBazaar() {
		return driver.findElement(policyBazaar);
	}

	public WebElement paisaBazaar() {
		return driver.findElement(paisaBazaar);
	}

	public WebElement pbPartners() {
		return driver.findElement(pbPartners);
	}

	public WebElement pbFintech() {
		return driver.findElement(pbFintech);
	}

	public WebElement agonLife() {
		return driver.findElement(agonLife);
	}

	public WebElement iciciLink() {
		return driver.findElement(icici);
	}

	public WebElement iciciLombard() {
		return driver.findElement(iciciLombard);
	}

	public WebElement maxLife() {
		return driver.findElement(maxLife);
	}

	public WebElement manipalCigna() {
		return driver.findElement(manipalCigna);
	}

	public WebElement hdfcLife() {
		return driver.findElement(hdfcLife);
	}

	public WebElement tataAig() {
		return driver.findElement(tataAig);
	}

	public WebElement kotakLife() {
		return driver.findElement(kotakLife);
	}

	public WebElement bajajLifeGoals() {
		return driver.findElement(bajajLifeGoals);
	}

	public WebElement bajajAllianz() {
		return driver.findElement(bajajAllianz);
	}

	public WebElement nivaLink() {
		return driver.findElement(niva);
	}

	public WebElement sbiLife() {
		return driver.findElement(sbiLife);
	}

	public WebElement sbiGeneral() {
		return driver.findElement(sbiGeneral);
	}

	public WebElement relianceGeneral() {
		return driver.findElement(relianceGeneral);
	}

	public WebElement relianceLife() {
		return driver.findElement(relianceLife);
	}

	public WebElement tataAia() {
		return driver.findElement(tataAia);
	}

	public WebElement pnbMetLife() {
		return driver.findElement(pnbMetLife);
	}

	public WebElement birlaCapital() {
		return driver.findElement(birlaCapital);
	}

	public WebElement canaraHSBC() {
		return driver.findElement(canaraHSBC);
	}

	public WebElement avivaLink() {
		return driver.findElement(aviva);
	}

	public WebElement digitLink() {
		return driver.findElement(digit);
	}

	public WebElement careLink() {
		return driver.findElement(care);
	}

	public WebElement starLink() {
		return driver.findElement(star);
	}

	public WebElement ageasFederal() {
		return driver.findElement(ageasFederal);
	}

	public WebElement exideLife() {
		return driver.findElement(exideLife);
	}

	public WebElement pramerica() {
		return driver.findElement(pramerica);
	}

	public WebElement naviInsurance() {
		return driver.findElement(naviInsurance);
	}

	public WebElement liberty() {
		return driver.findElement(liberty);
	}

	public WebElement iffcoTokio() {
		return driver.findElement(iffcoTokio);
	}

	public WebElement bhartiAxa() {
		return driver.findElement(bhartiAxa);
	}

	public WebElement futureGenerali() {
		return driver.findElement(futureGenerali);
	}

	public WebElement royalSundaram() {
		return driver.findElement(royalSundaram);
	}

	public WebElement orientalInsurance() {
		return driver.findElement(orientalInsurance);
	}

	public WebElement unitedIndiaInsurance() {
		return driver.findElement(unitedIndiaInsurance);
	}

	public WebElement newIndiaHealth() {
		return driver.findElement(newIndiaHealth);
	}

	public WebElement shriram() {
		return driver.findElement(shriram);
	}

	public WebElement edelweissTokio() {
		return driver.findElement(edelweisstokio);
	}

	public WebElement nationalHealth() {
		return driver.findElement(nationalHealth);
	}

	public WebElement universalSompo() {
		return driver.findElement(universalSompo);
	}

	public WebElement magmaHDI() {
		return driver.findElement(magmaHDI);
	}

	public WebElement rahejaQBE() {
		return driver.findElement(rahejaQBE);
	}

	public WebElement edelweiss() {
		return driver.findElement(edelweiss);
	}

	public WebElement indiaFirst() {
		return driver.findElement(indiaFirst);
	}

	public WebElement kotakLink() {
		return driver.findElement(kotak);
	}

	public WebElement adityaBirla() {
		return driver.findElement(adityaBirla);
	}

	public WebElement cholaMS() {
		return driver.findElement(cholaMS);
	}

	public WebElement generalInsurance() {
		return driver.findElement(GeneralInsurance);
	}

	public WebElement footerCarInsurance() {
		return driver.findElement(footerCarInsurance);
	}

	public WebElement footerBikeInsurance() {
		return driver.findElement(footerBikeInsurance);
	}

	public WebElement footerMotorInsurance() {
		return driver.findElement(footerMotorInsurance);
	}

	public WebElement footerThirdPartyCarInsurance() {
		return driver.findElement(footerThirdPartyCarInsurance);
	}

	public WebElement footerThirdPartyBikeInsurance() {
		return driver.findElement(footerThirdPartyBikeInsurance);
	}

	public WebElement footerTravelInsurance() {
		return driver.findElement(footerTravelInsurance);
	}

	public WebElement footerCommercialVehicleInsurance() {
		return driver.findElement(footerCommercialVehicleInsurance);
	}

	public WebElement lifeInsurance() {
		return driver.findElement(LifeInsurance);
	}

	public WebElement footerTermInsurance() {
		return driver.findElement(footerTermInsurance);
	}

	public WebElement footerSpouseTermPlan() {
		return driver.findElement(footerSpouseTermPlan);
	}

	public WebElement footerReturnOfPremium() {
		return driver.findElement(footerReturnOfPremium);
	}

	public WebElement otherInsurance() {
		return driver.findElement(OtherInsurance);
	}

	public WebElement footerGroupHealthInsurance() {
		return driver.findElement(footerGroupHealthInsurance);
	}

	public WebElement footerOtherGeneralInsuranceProducts() {
		return driver.findElement(footerOtherGeneralInsuranceProducts);
	}

	public WebElement footerCancerInsurance() {
		return driver.findElement(footerCancerInsurance);
	}

	public WebElement footerHomeInsurance() {
		return driver.findElement(footerHomeInsurance);
	}

	public WebElement investmentIcon() {
		return driver.findElement(InvestmentIcon);
	}

	public WebElement footerInvestmentPlans() {
		return driver.findElement(footerInvestmentPlans);
	}

	public WebElement footerChildPlans() {
		return driver.findElement(footerChildPlans);
	}

	public WebElement footerPensionPlans() {
		return driver.findElement(footerPensionPlans);
	}

	public WebElement footerULIPs() {
		return driver.findElement(footerULIPs);
	}

	public WebElement footerMoneyBackPolicy() {
		return driver.findElement(footerMoneyBackPolicy);
	}

	public WebElement footerEndowmentPolicy() {
		return driver.findElement(footerEndowmentPolicy);
	}

	public WebElement footerGuaranteedReturnPlans() {
		return driver.findElement(footerGuaranteedReturnPlans);
	}

	public WebElement footerTaxSavingPlans() {
		return driver.findElement(footerTaxSavingPlans);
	}

	public WebElement healthInsuranceIcon() {
		return driver.findElement(HealthInsuranceIcon);
	}

	public WebElement footerHealthInsurance() {
		return driver.findElement(footerHealthInsurance);
	}

	public WebElement footerOneCrHealthCover() {
		return driver.findElement(footeroneCrHealthCover);
	}

	public WebElement footerFamilyHealthInsurance() {
		return driver.findElement(footerFamilyHealthInsurance);
	}

	public WebElement footerSeniorCitizenHI() {
		return driver.findElement(footerSeniorCitizenHI);
	}

	public WebElement footerCoronaVirusInsurance() {
		return driver.findElement(footerCoronaVirusInsurance);
	}

	public WebElement footerCoronaKavachPolicy() {
		return driver.findElement(footerCoronakavachPolicy);
	}

	public WebElement footerCoronaRakshakPolicy() {
		return driver.findElement(footerCoronaRakshakPolicy);
	}

	public WebElement footerArogyaSanjeevaniPolicy() {
		return driver.findElement(footerArogyaSanjeevaniPolicy);
	}

	public WebElement footerText() {
		return driver.findElement(footerText);
	}

	public WebElement footerLink() {
		return driver.findElement(footerLink);
	}

	public WebElement renewYourPolicy() {
		return driver.findElement(renewYourPolicy);
	}

	public WebElement fileAClaim() {
		return driver.findElement(FileAClaim);
	}

	public WebElement support() {
		return driver.findElement(support);
	}

}

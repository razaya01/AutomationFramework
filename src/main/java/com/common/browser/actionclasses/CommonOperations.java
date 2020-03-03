package com.common.browser.actionclasses;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.common.browser.WebDriverScrewfixBrowser;

import ReusableFunctions.XpathsConstants;

public class CommonOperations {
	WebDriver driver;
	protected WebDriverScrewfixBrowser browser = new WebDriverScrewfixBrowser();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void openStoreFront(WebDriver driver) throws Exception {

		browser.navigateToWebsite(driver, getUrl());

		driver.manage().window().maximize();
	}

	public void loginHomepage(WebDriver driver) throws Exception {

		WebElement userID = driver.findElement(By.id("user"));
		userID.sendKeys("service");

		browser.insertInput(driver, XpathsConstants.AGENT_PASSWORD, "Service123");

		browser.clickOnWebElement(driver, XpathsConstants.SIGN_IN);

		WebElement store = driver.findElement(By.xpath("//input[@id='location']"));
		store.clear();
		store.sendKeys(getStore());

		browser.clickOnWebElement(driver, XpathsConstants.VALIDER);
		Thread.sleep(5000);

		browser.clickOnWebElement(driver, XpathsConstants.CONTINUER);

		Thread.sleep(5000);
	}

	public void uptoBasket(WebDriver driver, String customer, String EAN) throws Exception {
		String visibleName = "Ajouter pour livraison à domicile";
		browser.insertInput(driver, XpathsConstants.CUSTOMER_TEXTBOX, customer);
		browser.clickOnWebElement(driver, XpathsConstants.CUSTOMER_SEARCH_BUTTON);
		browser.waitFor(11);
		browser.clickOnWebElement(driver, XpathsConstants.PRODUCT_BUTTON_BDFR);
		browser.insertInput(driver, XpathsConstants.EAN_SEARCHBOX, EAN);
		browser.clickOnWebElement(driver, XpathsConstants.EAN_SEARCH_BUTTON);
		browser.waitFor(10);
		browser.selectFromDropDown(driver, XpathsConstants.ACTION_BUTTON, visibleName);
		browser.waitFor(3);
		browser.clickOnWebElement(driver, XpathsConstants.PROCEED_BASKET);
		browser.waitUntillElementLoaded(driver, XpathsConstants.PAYER);
		browser.clickOnWebElement(driver, XpathsConstants.PAYER);
		browser.waitFor(5);

		if (driver.findElement(By.xpath(XpathsConstants.INCOMPLETE_ADDRESS)).isDisplayed()) {
			browser.clickOnWebElement(driver, XpathsConstants.INCOMPLETE_ADDRESS);
			browser.insertInput(driver, XpathsConstants.EDIT_CONTACT_NAME, "Yasin");
			browser.insertInput(driver, XpathsConstants.EDIT_LAST_NAME, "Raza");
			browser.insertInput(driver, XpathsConstants.ADD_LINE1, "KAIKHALI");
			browser.waitFor(2);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.clickOnWebElement(driver, XpathsConstants.SCROLL_DOWN);
			browser.insertInput(driver, XpathsConstants.EDIT_MOBILE_NUMBER, "0145478557");
			browser.clickOnWebElement(driver, XpathsConstants.EDIT_SUBMIT);

		}
	}

	public void launchAfaSuitInJenkinsWithDefinedUser(WebDriver driver) throws Throwable {
		openNewTab(driver, getJenkinsUrl_afa(), 1);
		// driver.get(getJenkinsUrl_afa());
		// driver.manage().window().maximize();
		browser.clickOnWebElement(driver, XpathsConstants.LOGIN_BUTTON);
		browser.insertInput(driver, XpathsConstants.USERID, "razaya01");
		browser.insertInput(driver, XpathsConstants.PASSWORD, "Kolfeb@0786");
		browser.clickOnWebElement(driver, XpathsConstants.JENKINS_SIGNIN);

	}

	public void openNewTab(WebDriver driver, String url, int position) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("tabs : " + tabs.size() + " >position: " + position + " >\t" + url);
		driver.switchTo().window(tabs.get(position));
		driver.get(url);

	}

	public void triggerScript(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Build with Parameters')]")).click();
		// driver.findElement(By.xpath("//*[@id='main-panel']/form/table/tbody[1]/tr[1]/td[3]/div/input[2]"))
		// .sendKeys(getOpco());

		driver.findElement(By.xpath("//button[contains(text(),'Build')]")).click();

	}

	public void changeOperationTimeStampDate(WebDriver driver, String orderId) {

		String query_1_initial = "<query-items item-descriptor=\"order\"> sapOrderId=\"1010521360\" </query-items>";
		;
		System.out.println(query_1_initial);
		String query_1 = query_1_initial.replace("1010521360", orderId);
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_1);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();
		String Print_1 = driver.findElement(By.xpath("//code")).getText();
		System.out.println(Print_1);

		int indexOfShippingGroupId = Print_1.indexOf("sg");
		System.out.println("index ShippingGroupId  is " + indexOfShippingGroupId);
		String ShippingGroupId = Print_1.substring(indexOfShippingGroupId, indexOfShippingGroupId + 11);
		System.out.println("ShippingGroupId is " + ShippingGroupId);
		String query_2 = "<print-item item-descriptor=\"shippingGroup\" id=" + "\'" + ShippingGroupId + "\'" + "/>";
		System.out.println(query_2);
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_2);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();

		String Print_2 = driver.findElement(By.xpath("//code")).getText();
		System.out.println(Print_2);

		int indexOfcollectionInfoId = Print_2.indexOf("collectionInfo");
		System.out.println("index collectionInfoId  is " + indexOfcollectionInfoId);
		String collectionInfoId = Print_2.substring(indexOfcollectionInfoId + 25, indexOfcollectionInfoId + 34);
		System.out.println("collectionInfoId is " + collectionInfoId);
		String query_3 = "<print-item item-descriptor=\"collectionInfo\" id=" + "\'" + collectionInfoId + "\'" + "/>";
		System.out.println(query_3);
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_3);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();

		String Print_3 = driver.findElement(By.xpath("//code")).getText();
		System.out.println("print 3 is :" + Print_3);

		int indexOfcollectionOperationId = Print_3.indexOf("collectionOperations");
		System.out.println("index collectionOperationId is " + indexOfcollectionOperationId);
		String collectionOperationId = Print_3.substring(indexOfcollectionOperationId + 40,
				indexOfcollectionOperationId + 48);
		System.out.println("collectionOperationId is " + collectionOperationId);
		String query_4 = "<print-item item-descriptor=\"collectionOperation\" id=" + "\'" + collectionOperationId + "\'"
				+ "/>";
		System.out.println(query_4);
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_4);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();

		String Print_4 = driver.findElement(By.xpath("//code")).getText();
		System.out.println("print 4 is :" + Print_4);

		int indexOfcollectionOperation = Print_4.indexOf("<add-item item-descriptor=\"collectionOperation\"");
		System.out.println("index collectionOperationId is " + indexOfcollectionOperation);
		String query_5 = Print_4.substring(indexOfcollectionOperation);
		System.out.println("collectionOperation query is " + query_5);

		int indexOfoperationTimeStampDate = query_5.indexOf("operationTimeStamp");
		System.out.println("index operationTimeStampDate is " + indexOfoperationTimeStampDate);
		String current_date = query_5.substring(indexOfoperationTimeStampDate + 29, indexOfoperationTimeStampDate + 39);
		System.out.println("operationTimeStampDate is " + current_date);

		String query_7 = query_5.replace(current_date, "1/1/2019");
		System.out.println("collectionOperation query to change operation time stamp date is " + query_7);
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).clear();
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_7);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();

	}

	// *************************** get environment url to login into
	// homepage********************************************
	public static String getUrl() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String Bdfrci_url = prop.getProperty("url");
		return Bdfrci_url;
	}

	// *****************************************get jenkins afa
	// url************************************************************
	public static String getJenkinsUrl_afa() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String jenkins_afa = prop.getProperty("jenkins_afa_suit_url");
		return jenkins_afa;
	}

	public static String getJenkinsUrl_newframework() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String jenkins_NF = prop.getProperty("jenkins_nf_suit_url");
		return jenkins_NF;
	}

	public static String getJenkinsUrl_radiator() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String jenkins_NF = prop.getProperty("jenkins_radiator");
		return jenkins_NF;
	}

	// ***************************************get jenkins
	// credentials**************************
	public static String getJenkins_userid() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String jenkins_id = prop.getProperty("jenkins_userid");
		return jenkins_id;
	}

	public static String getJenkins_password() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String jenkins_pswd = prop.getProperty("jenkins_pswd");
		return jenkins_pswd;
	}
	// *****************************get opco
	// name******************************************************************************

	public static String getOpco() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String opco_afa = prop.getProperty("opco");
		return opco_afa;
	}

	// *************************get
	// queries**************************************************************************************
	public static String getXmlQuery() throws Exception {
		FileReader reader = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String opco_afa = prop.getProperty("xmlQuery");
		return opco_afa;
	}

	// ***************************get store location which need to enter during
	// login*********************************************
	public static String getStore() throws Exception {
		FileReader read = new FileReader(
				"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
		Properties prop = new Properties();
		prop.load(read);
		String Bdfrci_storeLoc = prop.getProperty("store_location");
		return Bdfrci_storeLoc;
	}

}

package com.yasin.test.scripts;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.common.browser.actionclasses.CommonOperations;
 
import ReusableFunctions.WebActions;
import ReusableFunctions.XpathsConstants;
import cucumber.api.java.en.When;

public class CreatingExpiredOrder extends CommonOperations {
	WebDriver driver;
	String customer = "0069945274";
	String EAN = "5010305100355";  
	String profileId = "154369893";
    
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1, groups = "Brico agent-front")
	@When("^user hits agent-front url$")
	public void user_hits_agent_front_url() throws Throwable {
		openStoreFront(driver);
		System.out.println("store-front is loaded");

	}

	@Test(priority = 2, groups = "Brico agent-front")
	@When("^login into agent-front by valid credentials$")
	public void login_into_agent_front_by_valid_credentials() throws Throwable {
		loginHomepage(driver);
		browser.waitFor(2);
		System.out.println("we are landed on homepage og B&Q");
	}

	@Test(priority = 3, groups = "Brico agent-front")
	@When("^navigate upto checkout page through ccsd product and any valid customer$")
	public void navigate_upto_checkout_page_through_ccsd_product_and_any_valid_customer() throws Throwable {
		String visibleName = "Add for Click & Collect";
		browser.insertInput(driver, XpathsConstants.CUSTOMER_TEXTBOX, customer);
		browser.clickOnWebElement(driver, XpathsConstants.CUSTOMER_SEARCH_BUTTON);
		browser.waitUntillElementLoaded(driver, XpathsConstants.PRODUCT_BUTTON_BQUK);
		browser.clickOnWebElement(driver, XpathsConstants.PRODUCT_BUTTON_BQUK);
		browser.waitFor(5);
		browser.clickOnWebElement(driver, XpathsConstants.PRODUCT_TAB);
		browser.insertInput(driver, XpathsConstants.EAN_SEARCHBOX, EAN);
		browser.clickOnWebElement(driver, XpathsConstants.EAN_SEARCH_BUTTON);
		browser.waitFor(10);
		browser.selectFromDropDown(driver, XpathsConstants.ACTION_BUTTON, visibleName);
		browser.waitFor(5);
		browser.clickOnWebElement(driver, XpathsConstants.PROCEED_BASKET);
		browser.waitUntillElementLoaded(driver, XpathsConstants.SELECT_STORE);
		browser.clickOnWebElement(driver, XpathsConstants.SELECT_STORE);
		browser.insertInput(driver, XpathsConstants.SELECT_STORE_TEXTBOX, "1017");
		browser.clickOnWebElement(driver, XpathsConstants.SELECT_STORE_SUBMIT); 
		browser.waitFor(25);
		browser.waitUntillElementLoaded(driver, XpathsConstants.SELECT_FIRST_STORE);
		browser.clickOnWebElement(driver, XpathsConstants.SELECT_FIRST_STORE);
		browser.waitFor(5);
		browser.waitUntillElementLoaded(driver, XpathsConstants.PAYER);
		browser.clickOnWebElement(driver, XpathsConstants.PAYER);
		browser.waitUntillElementLoaded(driver, XpathsConstants.PLACE_ORDER);
		browser.clickOnWebElement(driver, XpathsConstants.PLACE_ORDER);
		browser.waitFor(5);

	}

	@Test(priority = 4, groups = "fulfillment test cases")
	@When("^user hit fulfillment tool url$")
	public void user_hit_fulfillment_tool_url() throws Throwable {

		String fft_url = "http:atg-aubqukci-aws-ful01.aws.gha.kfplc.com:8040/ff-testtools/refinedDispatchLines.jsp";
		openNewTab(driver, fft_url, 1);
		browser.waitFor(3);

	}

	@Test(priority = 5, groups = "fulfillment test cases")
	@When("^create So through fulfillment tool$")
	public void create_So_through_fulfillment_tool() throws Throwable {
		String action = "SO_CREATED";
		browser.insertInput(driver, XpathsConstants.PROFILE_ID_TEXTBOX, profileId);
		browser.clickOnWebElement(driver, XpathsConstants.PROFILE_ID_SUBMIT);
		browser.selectFromDropDown(driver, XpathsConstants.NEW_STATE, action);
		browser.clickOnWebElement(driver, XpathsConstants.UPDATE_ALL_ITEM);

	}

	@Test(priority = 6, groups = "Brico agent-front")
	@When("^validate user at homepage of agent-front$")
	public void validate_user_at_homepage_of_agent_front() throws Throwable {

		String visibleName1 = "Complete customer";
		String visibleName2 = "Logout";
		openNewTab(driver, getUrl(), 2);
		System.out.println("store-front is loaded again");
		browser.waitFor(3);
		browser.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, visibleName1);
		browser.waitFor(3);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);
		browser.waitFor(3);
		browser.selectFromDropDown(driver, XpathsConstants.AGENT_DROPDOWN, visibleName2);
		browser.waitFor(3);
		browser.clickOnWebElement(driver, XpathsConstants.SIGN_BACK);
		browser.waitFor(3);
		WebElement userID = driver.findElement(By.id("user"));
		userID.sendKeys("service");

		browser.insertInput(driver, XpathsConstants.AGENT_PASSWORD, "Service123");

		browser.clickOnWebElement(driver, XpathsConstants.SIGN_IN);
		
		browser.waitFor(3);

		WebElement store = driver.findElement(By.xpath("input[@id='location']"));
		store.clear();
		store.sendKeys("1017");

		browser.clickOnWebElement(driver, XpathsConstants.VALIDER);
		Thread.sleep(5000);

		browser.clickOnWebElement(driver, XpathsConstants.CONTINUER);

		Thread.sleep(5000);

	}

	@Test(priority = 7, groups = "Brico agent-front")
	@When("^perform allocation of ccsd product$")
	public void perform_allocation_of_ccsd_product() throws Throwable {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		String sapOrderId = browser.extractTextFromWeb(driver, XpathsConstants.SAP_ORDER_ID);
		System.out.println("order no is : " + sapOrderId);
		driver.switchTo().window(tabs.get(2));
		browser.waitFor(3);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_ALLOCATION_ORDER_BUTTON);
		System.out.println("Allocation started");
		browser.waitUntillElementLoaded(driver, XpathsConstants.AFA_STOCK_ALLOCATION_ORDER);
		browser.waitFor(3);
		browser.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_ORDER_NUMBER_INPUT, sapOrderId);
		browser.waitFor(5);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_FIND_BUTTON);
		browser.waitFor(5);
		browser.waitUntillElementLoaded(driver, XpathsConstants.AFA_PICKING);
		browser.clickOnWebElement(driver, XpathsConstants.AFA_PICKING);
		browser.waitUntillElementLoaded(driver, XpathsConstants.AFA_PICKED_QTY);
		browser.clearInputFromTextBox(driver, XpathsConstants.AFA_PICKED_QTY);
		browser.insertInput(driver, XpathsConstants.AFA_PICKED_QTY, "1");
		driver.findElement(By.xpath(XpathsConstants.AFA_PICKED_QTY)).sendKeys(Keys.TAB);
		browser.waitFor(3);
		browser.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_MANUAL_PICKING_BUTTON);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_MANUAL_PICKING_BUTTON);
		browser.waitFor(5);
		browser.clickOnWebElement(driver, XpathsConstants.AFA_CHECK_ITEM_BUTTON);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_PROCESS_ALLOCATION);
		browser.waitFor(2);
		System.out.println("Allocation completed ");

	}

	@Test(priority = 8, groups = "dyn-admin")
	@When("^user hits order repository in dyn admin$")
	public void user_hits_order_repository_in_dyn_admin() throws Throwable {

		String url = "http:atg-aubqukci-aws-app01.aws.gha.kfplc.com:8080/dyn/admin/nucleusatg/commerce/order/OrderRepository/";
		driver.get(url);
		//openNewTab(driver, url, 3);
		
		driver.manage().window().maximize();

	}

	@Test(priority = 9, groups = "dyn-admin")
	@When("^perform all the necessary query in order to change operationTimeStamp to any past date$")
	public void perform_all_the_necessary_query_in_order_to_change_operationTimeStamp_to_any_past_date()
			throws Throwable {
		String sapOrderId= "1010533456";
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(0));
//		String sapOrderId = browser.extractTextFromWeb(driver, XpathsConstants.SAP_ORDER_ID);
//		System.out.println("order no is : " + sapOrderId);
//		driver.switchTo().window(tabs.get(3));
		changeOperationTimeStampDate(driver, sapOrderId);

	}

	@Test(priority = 10, groups = "dyn-admin")
	@When("^user hits SendCollectionReminderScheduler url in dyn admin$")
	public void user_hits_SendCollectionReminderScheduler_url_in_dyn_admin() throws Throwable {
		String url = "http:atg-aubqukci-aws-afa01.aws.gha.kfplc.com:8030/dyn/admin/nucleuskf/csc/collection/scheduler/SendCollectionReminderScheduler/";
		//openNewTab(driver, url, 4);
		openNewTab(driver, url, 1);
	}

	@Test(priority = 11, groups = "dyn-admin")
	@When("^invoke the sendCollectionReminders method$")
	public void invoke_the_sendCollectionReminders_method() throws Throwable {

		browser.clickOnWebElement(driver, XpathsConstants.SEND_COLLECTION_REMINDERS);
		browser.clickOnWebElement(driver, XpathsConstants.INVOKE_METHOD);
		browser.waitFor(2);
	}

	@Test(priority = 12, groups = "Brico agent-front")
	@When("^user user go back to agent front$")
	public void user_user_go_back_to_agent_front() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));

	}

	@Test(priority = 13, groups = "Brico agent-front")
	@When("^validate expire order in application$")
	public void validate_expire_order_in_application() throws Throwable {

		browser.waitFor(5);

		String visibleName1 = "Complete collections";
		browser.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, visibleName1);
		browser.waitFor(3);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);
		browser.waitFor(5);

		browser.waitUntillElementLoaded(driver, XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);
		browser.clickOnWebElement(driver, XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);

		browser.waitFor(15);

		browser.clickOnWebElement(driver, XpathsConstants.EXPIRE_ORDER_CHECK);
		browser.clickOnWebElement(driver, XpathsConstants.EXPIRE_ORDER_SEARCH);

	}

}

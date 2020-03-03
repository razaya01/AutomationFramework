package masterSuit;

import org.testng.annotations.Test;

import ReusableFunctions.CommonlyUsedFunctionality;
import ReusableFunctions.WebActions;
import ReusableFunctions.XpathsConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import seleniumWebDriverLearning.PageFactoryLoginPageStoreFront;
import seleniumWebDriverLearning.ReadExcelFile;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ClearOrderFromAllocation extends CommonlyUsedFunctionality implements WebActions {

	WebDriver driver;
	PageFactoryLoginPageStoreFront loginpage;
	int i = 0;
	ReadExcelFile readexcelfile = new ReadExcelFile();
	
	String filePath = "D:\\yasin\\flatmates.xls";
	String fileName = "flatemates.xls";
	String sheetName = "ExcelBioData";
	String[] dataToWrite = { "totalOrderText", " " };
	
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@BeforeMethod
	public void declaration() {
		loginpage = PageFactory.initElements(driver, PageFactoryLoginPageStoreFront.class);

	}

	@Test(priority = 1)
	@Given("^user hits b&q agent-front$")
	public void user_hits_b_q_agent_front() throws Throwable {

		openStoreFront(driver);
		System.out.println("store-front is loaded");
		
	}
 
	@Test(priority = 2)
	@When("^user login into b&q homepage with agent id and password and by providing store code$")
	public void user_login_into_b_q_homepage_with_agent_id_and_password_and_by_providing_store_code() throws Throwable {
		//loginpage.loginStorefront("service", "Service123", getStore());
		 loginHomepage(driver);
		WebActions.waitFor(5);
		System.out.println("we are landed on homepage og B&Q");
		
	}

	// @SuppressWarnings("static-access")
	@Test(priority = 3)
	@When("^perform allocation and collection process for open order$")
	public void perform_allocation_and_collection_process_for_open_order() throws Throwable {
		System.out.println("enetered in test having priority 3");
		// ****************************************allocation****************************
		while (i < 5) {

			WebActions.clickOnWebElement(driver, readExcel(filePath, fileName, sheetName, 1));
			 WebActions.clickOnWebElement(driver,
			 XpathsConstants.BQUK_ALLOCATION_ORDER_BUTTON);
			System.out.println("Allocation started");
			WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_STOCK_ALLOCATION_ORDER);
			String totalOrderText = WebActions.extractTextFromWeb(driver, XpathsConstants.AFA_STOCK_ALLOCATION_ORDER);
			System.out.println("order text is : " + totalOrderText);
			String[] dataToWrite = { totalOrderText, " " };
			writeExcel(filePath, fileName, sheetName, dataToWrite);
			String orderNumberText = WebActions.extractTextFromWeb(driver, XpathsConstants.AFA_ORDER_NUMBER_ALLOCATION);
			System.out.println("order number text is: " + orderNumberText);
			WebActions.clickOnWebElement(driver, XpathsConstants.AFA_ALLOCATE_STOCK);
			WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_PICKING);
			WebActions.clickOnWebElement(driver, XpathsConstants.AFA_PICKING);
			WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_PICKED_QTY);
			WebActions.clearInputFromTextBox(driver, XpathsConstants.AFA_PICKED_QTY);
			WebActions.insertInput(driver, XpathsConstants.AFA_PICKED_QTY, "1");
			driver.findElement(By.xpath(XpathsConstants.AFA_PICKED_QTY)).sendKeys(Keys.TAB);
			WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_MANUAL_PICKING_BUTTON);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_MANUAL_PICKING_BUTTON);
			WebActions.waitFor(5); 
			WebActions.clickOnWebElement(driver, XpathsConstants.AFA_CHECK_ITEM_BUTTON);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STOCK_ALLOCATION_PROCESS_ALLOCATION);
			WebActions.waitFor(4);
			WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_STOCK_ALLOCATION_ORDER);
			WebActions.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, 1);
			WebActions.waitFor(4);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);

			System.out.println("Allocation completed ");
			WebActions.waitFor(4);
			// ***********************************************collection**************************************

			WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);
			System.out.println("collection started");
			WebActions.waitFor(7);
			WebActions.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_ORDER_NUMBER_INPUT, orderNumberText);

			WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_FIND_BUTTON);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_FIND_BUTTON);

			WebActions.waitUntillElementLoaded(driver, XpathsConstants.STATUS);
			WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_PROCESS_COLLECTION_BUTTON);
			WebActions.waitFor(8);
			if (driver.findElement(By.xpath(XpathsConstants.BQUK_STORE_COLLECTION_PAYMENT_VERIFIED_BUTTON))
					.isDisplayed()) {

				System.out.println("payment verification button is displaying");
				WebActions.waitUntillElementLoaded(driver,
						XpathsConstants.BQUK_STORE_COLLECTION_PAYMENT_VERIFIED_BUTTON);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_PAYMENT_VERIFIED_BUTTON);

				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT);
				WebActions.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT, "collector");
				WebActions.selectFromDropDown(driver, XpathsConstants.BQUK_STORE_COLLECTION_ID_SHOWN_DROPDOWN, 1);
				WebActions.clickOnWebElement(driver, XpathsConstants.AFA_CONFIRM_COLLECTION);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.waitFor(5);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_FINISH_DROPDOWN);
				WebActions.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, 1);
				WebActions.waitFor(4);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);

				System.out.println("collection completed");
				WebActions.waitFor(4);
			} else if (driver.findElement(By.xpath(XpathsConstants.BQUK_COLLECTION_CONTINUE_BUTTON)).isDisplayed()) {
				WebActions.waitFor(3);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_COLLECTION_CONTINUE_BUTTON);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_COLLECTION_CONTINUE_BUTTON);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_PROCEED_CHECKOUT);
				WebActions.clickOnWebElement(driver, XpathsConstants.AFA_PROCEED_CHECKOUT);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_REFUND_PLACE_ORDER);
				WebActions.clickOnWebElement(driver, XpathsConstants.AFA_REFUND_PLACE_ORDER);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_NEW);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_NEW);
				WebActions.waitFor(5); 
				WebActions.waitUntillElementLoaded(driver,
						XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK);
				System.out.println("collection started");
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_ORDER_NUMBER_INPUT);
				WebActions.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_ORDER_NUMBER_INPUT,
						orderNumberText);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_FIND_BUTTON);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_FIND_BUTTON);
				WebActions.waitFor(5);
				WebActions.waitUntillElementLoaded(driver,
						XpathsConstants.BQUK_STORE_COLLECTION_PROCESS_COLLECTION_BUTTON);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_STORE_COLLECTION_PROCESS_COLLECTION_BUTTON);
				WebActions.waitFor(5);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT);
				WebActions.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT, "collector");
				WebActions.selectFromDropDown(driver, XpathsConstants.BQUK_STORE_COLLECTION_ID_SHOWN_DROPDOWN, 1);
				WebActions.clickOnWebElement(driver, XpathsConstants.AFA_CONFIRM_COLLECTION);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.waitFor(5);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_FINISH_DROPDOWN);
				WebActions.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, 1);
				WebActions.waitFor(4);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);
				System.out.println("collection completed");
				WebActions.waitFor(4);
			} else if (driver.findElement(By.xpath(XpathsConstants.BQUK_PROCESS_COLLECTION_MODEL)).isDisplayed()) {
				WebActions.waitFor(5);

				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT);
				WebActions.insertInput(driver, XpathsConstants.BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT, "collector");
				WebActions.selectFromDropDown(driver, XpathsConstants.BQUK_STORE_COLLECTION_ID_SHOWN_DROPDOWN, 1);
				WebActions.clickOnWebElement(driver, XpathsConstants.AFA_CONFIRM_COLLECTION);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_FINISH_CUSTOMER_COLLECTION_PAGE);
				WebActions.waitFor(5);
				WebActions.waitUntillElementLoaded(driver, XpathsConstants.AFA_FINISH_DROPDOWN);
				WebActions.selectFromDropDown(driver, XpathsConstants.AFA_FINISH_DROPDOWN, 1);
				WebActions.waitFor(4);
				WebActions.clickOnWebElement(driver, XpathsConstants.BQUK_COMPLETE_COLLECTION_YES_BUTTON);
				System.out.println("collection completed");
				WebActions.waitFor(4);
			} else {
				System.out.println("collection failed");
			}
			i++;
		}
	}
}

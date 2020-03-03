package com.yasin.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.common.browser.actionclasses.CommonOperations;

import ReusableFunctions.XpathsConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CashPaymentDetailsForStoreOrder extends CommonOperations {
	 WebDriver driver;
	String customer = "0079198508";
	String EAN = "3086960241926";
	String EAN1 = "4003318532368";
	 
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
 
	}

	@Test(priority = 1)
	@Given("^navigate to agent front$")
	public void user_hits_b_q_agent_front() throws Throwable {

		openStoreFront(driver);
		System.out.println("store-front is loaded");

	}

	@Test(priority = 2)
	@When("^provide valid credentials$")
	public void provide_valid_credentials() throws Throwable {

		loginHomepage(driver);
		browser.waitFor(2);
		System.out.println("we are landed on homepage og B&Q");

	}

	@Test(priority = 3)
	@When("^navigate upto checkout page$")
	public void navigate_upto_checkout_page() throws Throwable {
		uptoBasket(driver, customer, EAN);
		browser.waitFor(2);

	}

	@Test(priority = 4)
	@When("^Launch script in jenkins with defined user$")
	public void launch_script_in_jenkins_with_defined_user() throws Throwable {
		launchAfaSuitInJenkinsWithDefinedUser(driver);

	}

	@Test(priority = 5)
	@And("^re-trigger failed scripts with same tabs$")
	public void re_trigger_failed_scripts_with_same_tabs() throws Throwable {
		if ((driver.findElement(By.xpath(XpathsConstants.FAILED_CONSOLE_STATUS)).isDisplayed())) {
			triggerScript(driver);
		} else if (driver.findElement(By.xpath(XpathsConstants.PASSED_CONSOLE_STATUS)).isDisplayed()) {
			System.out.println("script already got passed");

		}

	}
	@Test(priority = 6)
	@When("^Launch mock configration page in dyn admin$")
	public void Launch_mock_configration_page_in_dyn_admin() throws Throwable {
		driver.get("http://atg-aubdfrci-aws-app01.aws.gha.kfplc.com:8080/dyn/admin/nucleus/kf/commerce/mocks/MockConfiguration/");
		

	}

}

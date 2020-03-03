package com.yasin.test.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.common.browser.WebDriverScrewfixBrowser;
import com.common.browser.actionclasses.CommonOperations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AfaLoginTesting  {
  WebDriverScrewfixBrowser browser = new WebDriverScrewfixBrowser();
  CommonOperations common = new CommonOperations();
	WebDriver driver;
  
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	@Test(priority = 1)
	@Given("^hit agentfont url$")
	public void user_hits_b_q_agent_front() throws Throwable {

		common.openStoreFront(driver);
		System.out.println("store-front is loaded");
		
	}

	@Test(priority = 2)
	@When("provide user id and password")
	public void user_login_into_b_q_homepage_with_agent_id_and_password_and_by_providing_store_code() throws Throwable {
		//loginpage.loginStorefront("service", "Service123", getStore());
		common.loginHomepage(driver);
		browser.waitFor(5);
		browser.clearInputFromTextBox(driver, "xpaths");
		System.out.println("we are landed on homepage og B&Q");
		
	}


}

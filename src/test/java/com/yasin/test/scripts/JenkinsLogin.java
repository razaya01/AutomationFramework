package com.yasin.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.common.browser.WebDriverScrewfixBrowser;
import com.common.browser.actionclasses.CommonOperations;

import ReusableFunctions.XpathsConstants;

public class JenkinsLogin  {
	WebDriverScrewfixBrowser browser = new WebDriverScrewfixBrowser();
	CommonOperations common = new CommonOperations();
	WebDriver driver;
	@BeforeSuite  
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	@Test
	public void launchjenkinswithdefineduser() throws Throwable {
		   
		
		driver.get(
				"https://www.google.com/"); 
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='gb_B gb_sc' and @title='Google apps']")).click();
		WebElement iFrame= driver.findElement(By.tagName("iframe"));
		
	    driver.switchTo().frame(iFrame);
	    
	    WebElement googleMap= driver.findElement(By.xpath("//span[text()='Maps']"));
	    googleMap.click();

	    
	}

}

package seleniumWebDriverLearning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ReusableFunctions.ReadPropertyFile;
public class TestPageFactoryConcepts extends ReadPropertyFile{
	WebDriver driver;
	PageFactoryLoginPageStoreFront loginpage;
	 @BeforeSuite 
	 public void setupSeleniumWebDriver() {
	System.setProperty("webdriver.chrome.driver",
	 "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	 }
	 @BeforeMethod
	 public void declaration() {
		 loginpage=PageFactory.initElements(driver,PageFactoryLoginPageStoreFront.class);
		 
	 }
	 @Test
	 public void loginToHomepageOfAtg() throws Exception {
		 driver.get(getUrl());
		 driver.manage().window().maximize();
		 loginpage.loginStorefront("service", "Service123", getStore());
	 }

}

package masterSuit;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import ReusableFunctions.CommonlyUsedFunctionality;
import ReusableFunctions.WebActions;
import ReusableFunctions.XpathsConstants;

public class VerificationOfCustomizedCommands extends CommonlyUsedFunctionality implements WebActions {
	
	WebDriver driver;
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority=1)
	public void user_hits_b_q_agent_front() throws Throwable {

String URL = "https://www.ultimatix.net";
//"http://" + "1245330" + ":" + "Kolsept@0786" + "@" + "www.ultimatix.net";
driver.get(URL);

driver.manage().window().maximize();


		System.out.println("ultimatix is loaded");



	}
	@Test(priority=2)
	public void performFrameworkTests() throws InterruptedException {
		
		WebActions.insertInput(driver, XpathsConstants.USER_ID, "1245330");
		
	}

}

package seleniumWebDriverLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderConceptsInTestNg {
	WebDriver driver;

	@BeforeTest
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	@Test(dataProvider = "getDataFromDataprovider")
	public void testMethod(String author, String searchKey) throws InterruptedException {

		{
			driver.get("https://google.com");
			driver.manage().window().maximize();
			WebElement searchText = driver.findElement(By.name("q"));
			// search value in google searchbox
			searchText.sendKeys(searchKey);
			System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue + "::::" + searchKey);
			searchText.clear();

		}

	}

	@DataProvider
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };

	}
}
package seleniumWebDriverLearning;

import org.testng.annotations.Test;

import ReusableFunctions.CommonlyUsedFunctionality;
import ReusableFunctions.ReadPropertyFile;

import org.openqa.selenium.interactions.Action;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;

public class MouseAndKeyboardEvents {
	WebDriver driver;
	
	CommonlyUsedFunctionality readexcelfile;
  public void setupSeleniumWebDriver() { 
	  
		System.setProperty("webdriver.chrome.driver",
		 "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		 } 
  @Test(groups="ActionClass")
  public void learningActionClass() throws IOException {
	  readexcelfile = new ReadExcelFile();
	  String filePath = System.getProperty("user.dir")+"D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\java\\seleniumWebDriverLearning\\flatmates.xls";
	  String fileName = "flatemates.xls";
	  String sheetName ="ExcelBioData";
	  
	 
//	  driver.get("http://aubdfrci-afa.aws.gha.kfplc.com/agent-front/jsp/agent/login.jsp");
//	  WebElement expElement = driver.findElement(By.xpath("//input[@value='Se connecter']"));
//	  Actions builder = new Actions(driver);
//	  Action seriesOfAction = builder.moveToElement(expElement).build();
//	  seriesOfAction.perform();
//	  
  }
}

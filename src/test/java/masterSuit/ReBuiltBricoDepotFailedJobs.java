package masterSuit;

import org.testng.annotations.Test;

import ReusableFunctions.CommonlyUsedFunctionality;
import ReusableFunctions.XpathsConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class ReBuiltBricoDepotFailedJobs extends CommonlyUsedFunctionality{
	
	WebDriver driver;

	public static String[] scriptslinks = null;
	public static int linksCount = 0;
  
	 @BeforeSuite 
	 public void setupSeleniumWebDriver() {
	System.setProperty("webdriver.chrome.driver",
	 "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	 } 
	 
  @Test(description = "This a the re-buit job for afa-brico folder of aubdfrci which will open suite and login", priority = 8,groups = "frico-agent")

  
	@When("^Launch afa suite in jenkins with defined user$")
	public void launch_afa_suit_in_jenkins_with_defined_user() throws Throwable {
	  
		/*System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();*/
		driver.get(
				"http://jenkins-digital-qa-master.aws.ghanp.kfplc.com:8080/job/AutomatedTests/job/DynamicArea/job/BDFR/job/AUBDFRCI/job/Archive/job/Brico_Afa_Endeca/job/_BricoAfaEndecaSuiteSuite/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(text(),'log in')]")).click();
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("razaya01");// hussaa41
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("Kolfeb@0786");// Gandhi02
		driver.findElement(By.xpath("//button[contains(text(),'log in')]")).click();

	}
  @Test(description = "This a the re-buit job for afa-brico folder of aubdfrci which willre-trigger failed jobs", priority = 9,groups = "Brico-agent")
	@And("^re-trigger afa failed scripts with same tabs$")
	public void re_trigger_afa_failed_scripts_with_same_tabs() throws Throwable {
		List<WebElement> failedLinks = driver.findElements(
				By.xpath("//img[@alt='Failed']//following-sibling::a | //img[@alt='Aborted']//following-sibling::a"));
		linksCount = failedLinks.size();  
		scriptslinks = new String[linksCount];
		System.out.println("Total no of links Available: " + linksCount);
		for (int i = 0; i < linksCount; i++) {

			scriptslinks[i] = failedLinks.get(i).getAttribute("href");
			System.out.println(scriptslinks[i]);

		}
		try {
			for (int j = 0; j < linksCount; j++) {

				driver.get(scriptslinks[j]);
				triggerScript(driver);

			}

		}

		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();

		}

	}
  

	@Test(priority = 4,groups= "fulfillment test cases")
	@When("^Launch new framework suit in jenkins with defined user$")
	public void launch_new_framework_suit_in_jenkins_with_defined_user() throws Throwable {
		String fft_url = "http://atg-aubqukci-aws-ful01.aws.gha.kfplc.com:8040/ff-testtools/refinedDispatchLines.jsp";
		//openNewTab(driver,fft_url,1);
		driver.get(fft_url);

//		driver.get(
//				"http://jenkins-digital-qa-master.aws.ghanp.kfplc.com:8080/job/AutomatedTests/job/DynamicArea/job/BQUK/job/AUBQUKCI/job/PLATFORM/job/_Platform_Master_Suite/");
//		driver.manage().window().maximize();
		
	}
	@Test(description = "This a the re-buit job for newframwork folder of aubdfrci", priority = 4,groups = "new-framework")
	@And("^re-trigger new framework failed scripts with same tabs$")
	public void re_trigger_new_framework_failed_scripts_with_same_tabs() throws Throwable {
		List<WebElement> failedLinks = driver.findElements(
				By.xpath("//img[@alt='Failed']//following-sibling::a | //img[@alt='Aborted']//following-sibling::a"));
		linksCount = failedLinks.size();
		scriptslinks = new String[linksCount];
		System.out.println("Total no of links Available: " + linksCount);
		for (int i = 0; i < linksCount; i++) {

			scriptslinks[i] = failedLinks.get(i).getAttribute("href");
			System.out.println(scriptslinks[i]);

		}
		try {
			for (int j = 0; j < linksCount; j++) {

				driver.get(scriptslinks[j]);
				// triggerScript(driver);

			}

		}

		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();

		}

	}
	
	@Test(priority = 4,groups= "fulfillment test cases")

	public void user_hit_fulfillment_tool_url() throws Throwable {
		String fft_url = "http://atg-aubqukci-aws-ful01.aws.gha.kfplc.com:8040/ff-testtools/refinedDispatchLines.jsp";
		//openNewTab(driver,fft_url,1);
		driver.get(fft_url);
		
	   
	}

	


}



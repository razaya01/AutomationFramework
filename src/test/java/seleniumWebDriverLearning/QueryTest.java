package seleniumWebDriverLearning;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class QueryTest {
	WebDriver driver;
	@BeforeSuite
	public void setupSeleniumWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jebesh\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	} 
	@Test
	public void changeOperationTimeStampDate() {
		String url = "http://atg-aubqukci-aws-app01.aws.gha.kfplc.com:8080/dyn/admin/nucleus//atg/commerce/order/OrderRepository/";
		String query_1= "<query-items item-descriptor=\"order\"> sapOrderId=\"1010521360\" </query-items>";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_1);
		driver.findElement(By.xpath("//input[@value='Enter']")).click();
		String Print_1=driver.findElement(By.xpath("//code")).getText();
		System.out.println(Print_1);
		
		 int indexOfShippingGroupId = Print_1.indexOf("sg");
		 System.out.println("index ShippingGroupId  is "+indexOfShippingGroupId);
		 String ShippingGroupId = Print_1.substring(indexOfShippingGroupId,indexOfShippingGroupId+11);
		 System.out.println("ShippingGroupId is "+ShippingGroupId);
		 String query_2 = "<print-item item-descriptor=\"shippingGroup\" id="+"\'"+ShippingGroupId+"\'"+ "/>";
	     System.out.println(query_2);
		 driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_2);
		 driver.findElement(By.xpath("//input[@value='Enter']")).click();
		 
		 String Print_2=driver.findElement(By.xpath("//code")).getText();
		 System.out.println(Print_2);
		 
		 int indexOfcollectionInfoId = Print_2.indexOf("collectionInfo");
		 System.out.println("index collectionInfoId  is "+indexOfcollectionInfoId);
		 String collectionInfoId = Print_2.substring(indexOfcollectionInfoId+25,indexOfcollectionInfoId+34);
		 System.out.println("collectionInfoId is "+collectionInfoId);
		 String query_3= "<print-item item-descriptor=\"collectionInfo\" id="+"\'"+collectionInfoId+"\'"+ "/>";
		 System.out.println(query_3);
		 driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_3);
		 driver.findElement(By.xpath("//input[@value='Enter']")).click();
		 
		 String Print_3=driver.findElement(By.xpath("//code")).getText();
		 System.out.println("print 3 is :"+Print_3);

		 int indexOfcollectionOperationId = Print_3.indexOf("collectionOperations");
		 System.out.println("index collectionOperationId is "+indexOfcollectionOperationId);
		 String collectionOperationId = Print_3.substring(indexOfcollectionOperationId+40,indexOfcollectionOperationId+48);
		 System.out.println("collectionOperationId is "+collectionOperationId);
		 String query_4= "<print-item item-descriptor=\"collectionOperation\" id="+"\'"+collectionOperationId+"\'"+ "/>";
		 System.out.println(query_4);
		 driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_4);
		 driver.findElement(By.xpath("//input[@value='Enter']")).click();
		 
		 String Print_4=driver.findElement(By.xpath("//code")).getText();
		 System.out.println("print 4 is :"+Print_4);
		 
		 int indexOfcollectionOperation = Print_4.indexOf("<add-item item-descriptor=\"collectionOperation\"");
		 System.out.println("index collectionOperationId is "+indexOfcollectionOperation);
		 String query_5 = Print_4.substring(indexOfcollectionOperation);
		 System.out.println("collectionOperation query is "+query_5);
		 String query_6 = query_5.replace("10/15/2019", "1/1/2019");
		 System.out.println("collectionOperation query to change operation time stamp date is "+query_6);
		 driver.findElement(By.xpath("//textarea[@name='xmltext']")).clear();
		 driver.findElement(By.xpath("//textarea[@name='xmltext']")).sendKeys(query_6);
		 driver.findElement(By.xpath("//input[@value='Enter']")).click();
		 
		 
		 
		
		 
		 
		 
		 
		 
		 
		
		
	}

}

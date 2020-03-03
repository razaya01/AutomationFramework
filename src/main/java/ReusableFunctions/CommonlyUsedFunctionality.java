package ReusableFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumWebDriverLearning.ReadExcelFile;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonlyUsedFunctionality extends ReadPropertyFile implements WebActions {

	WebDriver driver;
	public String name = "yasin";

	// public CommonlyUsedFunctionality(WebDriver driver) {
	// this.driver=driver;
	// }
	public static void openStoreFront(WebDriver driver) throws Exception {
		driver.get(getUrl());

		driver.manage().window().maximize();
	}

	// ******************************************Login to homepage
	// function***********************************************

	public static void loginHomepage(WebDriver driver) throws Exception {

		WebElement userID = driver.findElement(By.id("user"));
		userID.sendKeys("service");

		WebActions.insertInput(driver, XpathsConstants.AGENT_PASSWORD, "Service123");

		WebActions.clickOnWebElement(driver, XpathsConstants.SIGN_IN);

		WebElement store = driver.findElement(By.xpath("//input[@id='location']"));
		store.clear();
		store.sendKeys(getStore());

		WebActions.clickOnWebElement(driver, XpathsConstants.VALIDER);
		Thread.sleep(5000);

		WebActions.clickOnWebElement(driver, XpathsConstants.CONTINUER);

		Thread.sleep(5000);
	}

	public static void uptoBasket(WebDriver driver) throws Exception {

		driver.findElement(By.xpath("//input[@id='details']")).sendKeys("0079202566");
		driver.findElement(By.xpath("//input[@type='submit' and @data-title='Customer']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Produits')]")).click();
		driver.findElement(By.xpath("//input[@id='quickbuy-search-product']")).sendKeys("4003318532368");

	} 

	public static void openNewTab(WebDriver driver, String url, int position) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("tabs : " + tabs.size() + " >position: " + position + " >\t" + url);
		driver.switchTo().window(tabs.get(position));
		driver.get(url);

	}

	public static void triggerScript(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Build with Parameters')]")).click();
		driver.findElement(By.xpath("//*[@id='main-panel']/form/table/tbody[1]/tr[1]/td[3]/div/input[2]"))
				.sendKeys(getOpco());
		// webdriver.findElement(By.xpath("//input[@name='label']")).clear();
		// webdriver.findElement(By.xpath("//input[@name='label']")).sendKeys("atg-liveShared-aws-dets13-4b431cd6");
		driver.findElement(By.xpath("//button[contains(text(),'Build')]")).click();

	}

	public String readExcel(String filePath, String fileName, String sheetName, int rowNo) throws Exception {

		FileInputStream inputStream = new FileInputStream(filePath);

		Workbook workbookObj = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xls")) {
			workbookObj = new HSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xlsx")) {
			workbookObj = new XSSFWorkbook(inputStream);

		}
		Sheet sheetobj = workbookObj.getSheet(sheetName);

		Row row = sheetobj.getRow(rowNo);

		String data = row.getCell(1).getStringCellValue();
		
System.out.println(data);
		return data; 

	}

	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);

		Workbook workbookObj = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xls")) {
			workbookObj = new HSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xlsx")) {
			workbookObj = new XSSFWorkbook(inputStream);

		}
		Sheet sheetobj = workbookObj.getSheet(sheetName);
		int rowCount = sheetobj.getLastRowNum() - sheetobj.getFirstRowNum();
		Row row = sheetobj.getRow(0);
		Row newRow = sheetobj.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {

			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);

		}

		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(filePath);

		workbookObj.write(outputStream);

		outputStream.close();

	}

}

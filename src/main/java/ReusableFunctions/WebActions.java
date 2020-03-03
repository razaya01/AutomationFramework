package ReusableFunctions;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public interface WebActions {
	

	public static void waitFor(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException("TODO - Handle this exception better", e);
		}
	}

	public static void waitUntillElementLoaded(WebDriver driver, String xpaths) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths)));

	}
	
	public static void clickOnWebElement(WebDriver driver, String xpaths) {
		
		
		 
			driver.findElement(By.xpath(xpaths)).click();
		
		
	}
	public static void insertInput(WebDriver driver,String xpaths,String text) {
		
		if(driver.findElement(By.xpath(xpaths)).isDisplayed()) {
			driver.findElement(By.xpath(xpaths)).sendKeys(text);
		}
	}
	public static void selectFromDropDown(WebDriver driver,String xpaths, int index) {
		
		 
		
			Select element = new Select(driver.findElement(By.xpath(xpaths)));
			element.selectByIndex(index);
		
	}

	public static void clearInputFromTextBox(WebDriver driver, String xpaths) {
		
		if(driver.findElement(By.xpath(xpaths)).isDisplayed()) {
			driver.findElement(By.xpath(xpaths)).clear();
		}
	}
	public static String  extractTextFromWeb(WebDriver driver, String xpaths) {
		
		String text=driver.findElement(By.xpath(xpaths)).getText();
		return text;
	}
	
	public static void mouseActions(WebDriver driver, WebElement xpaths) {
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(xpaths).click().build();
		
	}
}

package com.common.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverScrewfixBrowser implements ScrewfixBrowser {

	public void waitFor(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException("TODO - Handle this exception better", e);
		}
	}

	public void waitUntillElementLoaded(WebDriver driver, String xpaths) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths)));

	}

	public void clickOnWebElement(WebDriver driver, String xpaths) {

		

		driver.findElement(By.xpath(xpaths)).click();

	}

	public void insertInput(WebDriver driver, String xpaths, String text) {

		waitUntillElementLoaded(driver, xpaths);

		driver.findElement(By.xpath(xpaths)).sendKeys(text);

	}

	public void selectFromDropDown(WebDriver driver, String xpaths, String visibleName) {
		
 
		Select element = new Select(driver.findElement(By.xpath(xpaths)));
		element.selectByVisibleText(visibleName);

	} 

	public void clearInputFromTextBox(WebDriver driver, String xpaths) {

		waitUntillElementLoaded(driver, xpaths);
		driver.findElement(By.xpath(xpaths)).clear();

	}

	public String extractTextFromWeb(WebDriver driver, String xpaths) {
		waitUntillElementLoaded(driver, xpaths);
		WebElement element = driver.findElement(By.xpath(xpaths));
		String text = element.getText();
		return text;
	}

	public void navigateToWebsite(WebDriver driver,String url) {
		driver.get(url);
	}
}

package com.common.browser;

import org.openqa.selenium.WebDriver;

public interface ScrewfixBrowser {

	public void waitFor(int seconds);
	
	public void waitUntillElementLoaded(WebDriver driver, String xpaths);
	
	public void clickOnWebElement(WebDriver driver, String xpaths);
	
	public void insertInput(WebDriver driver,String xpaths,String text);
	
	public void selectFromDropDown(WebDriver driver,String xpaths, String visibleName);
	
	public void clearInputFromTextBox(WebDriver driver, String xpaths);
	
	public String extractTextFromWeb(WebDriver driver, String xpaths);
	
	public void navigateToWebsite(WebDriver driver, String url);
	
}

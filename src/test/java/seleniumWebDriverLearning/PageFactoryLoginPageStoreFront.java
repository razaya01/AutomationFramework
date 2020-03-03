package seleniumWebDriverLearning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import ReusableFunctions.XpathsConstants;
 

public class PageFactoryLoginPageStoreFront {
	final WebDriver driver;
    public static String CONTINUER = "";
	@FindBy(how = How.ID, using = "user")
	 static WebElement userID;
	
	@FindBy(how = How.XPATH,using=".//input[@id='pwd']")
	 static WebElement pswd;
	@FindBy(how = How.XPATH,using=".//input[@name='/kf/csc/navigation/formhandler/AgentLoginFormHandler.login']")
	 static WebElement signIn;
	
	@FindBy(how = How.XPATH,using=".//input[@id='location']")
	 static WebElement store;
	
	@FindBy(how = How.XPATH,using=".//input[@id='confirmLocation']")
	 static WebElement valider;
	@FindBy(how = How.XPATH,using=".//input[@value='Continuer']|//input[@value='Continue']")
	 static WebElement continuer;
	public PageFactoryLoginPageStoreFront(WebDriver driver) {
		this.driver=driver;
	}
	public void loginStorefront(String username,String password,String storeId) {
		
		userID.sendKeys(username);
		pswd.sendKeys(password);
		signIn.click();
		store.clear();
		store.sendKeys(storeId);
		valider.click();
		continuer.click();
		
	}
	
	
}

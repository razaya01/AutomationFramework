package com.java.concepts;

import org.testng.annotations.Test;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.common.browser.actionclasses.CommonOperations;

public class JavaAnnotations extends CommonOperations {

	@Override
	public void triggerScript(WebDriver driver) {
		System.out.println("override annotations");
	}
@Test(priority = 1)
@SuppressWarnings("unchecked")  
public void supressWarningS() {
	
	ArrayList list=new ArrayList();  
	//ArrayList<String> list=new ArrayList<String>();  
	list.add("sonoo");  
	list.add("vimal");  
	list.add("ratan");  
	for(Object obj:list)  
		System.out.println(obj); 
	
}
@Test(priority = 2)
public void testDeprecated() {
	deprecated();
}
@Deprecated
public void deprecated() {
	System.out.println("deprecated");
}
@Test(priority = 3)

public void customAnnotations() {
	
	
}

}

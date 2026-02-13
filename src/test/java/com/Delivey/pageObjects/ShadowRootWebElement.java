package com.Delivey.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRootWebElement {
	
  public void shadowDom() {
	
	  
	// html dom --> iframe --> shadow dom element

	 
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	    driver.get("https://selectorshub.com/xpath-practice-page/"); // html body DOM

	    driver.switchTo().frame("pact"); // iframe

	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    WebElement element = (WebElement) jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");

	    String js = "arguments[0].setAttribute('value', 'Green Masala Tea')";
	    jse.executeScript(js, element);
	  
	  
	  
	  
}
	
	
	

}

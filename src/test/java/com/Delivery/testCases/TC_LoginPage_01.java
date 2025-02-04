package com.Delivery.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Delivey.pageObjects.LoginPage;
 
//@Listeners(com.Delivery.utilities.MyListeners.class)
public class TC_LoginPage_01 extends BaseClass
{
	
	@Test()
	public void LoginTest() throws Exception
	{
		
	//	logger.info("url entered in logs ");
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.signin();
		Thread.sleep(5000);
		WebElement  Text = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		System.out.println("one------->>"+Text.getText());
		
		if(Text.getText().equals("Selenium"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			takeScreenshot("LoginTest");
			Assert.assertTrue(false);
		}
		
		
	}
	
	@Test()
	public void Test2()
	{
		System.out.println("Test 2 method passed");
		Assert.assertFalse(false);
	
	}
	
	@Test()
	public void Test3()
	{
		System.out.println("Test 3 method passed ");
		Assert.assertEquals(true, true);
		
		
	}
	
	
		
}

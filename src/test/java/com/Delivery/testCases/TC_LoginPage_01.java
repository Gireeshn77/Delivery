package com.Delivery.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Delivey.pageObjects.LoginPage;
import com.Delivey.pageObjects.RetryAnalyzer;

public class TC_LoginPage_01 extends BaseClass {

	@Test()
	public void LoginTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		lp.setusername(username);
		lp.setpassword(password);
		lp.signin();
		Thread.sleep(5000);
		
		WebElement Text = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		System.out.println("one------->>" + Text.getText());

		if (Text.getText().equals("Selenium")) {
			Assert.assertTrue(true);
		} else {
			takeScreenshot("LoginTest");
			Assert.assertTrue(false);
		}
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Test2() {
		System.out.println("Test 2 method passed");
		Assert.assertFalse(false);
	}

	@Test()
	public void Test3() {
		System.out.println("Test 3 method passed ");
		Assert.assertEquals(true, true);
	}

	@Test()
	public void Test4() {
		System.out.println("Test 4 method passed ");
		Assert.assertEquals(true, false);
	}
	
	
}

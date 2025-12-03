package com.Delivey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement username;
	@FindBy(name = "passwd")
	WebElement password;
	@FindBy(name = "SubmitLogin")
	WebElement signinbtn;

	public void setusername(String uname) {
		username.sendKeys(uname);
	}

	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void signin() {
		signinbtn.click();
	}

}

package com.vicks.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vicks.qa.base.TestBase;

public class LoginPage_Demo extends TestBase {

	// Initialization Page Object
	public LoginPage_Demo() {
		PageFactory.initElements(driver, this);
	}

	// Page Factory
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	@FindBy(xpath = "//button[contains(text(), 'sign up')]")
	WebElement signUpBtn;

	// Actions
	
	//Login Page action --> After login should return to homepge
	
	public HomePage login(String um, String pd){
	username.sendKeys(um);
	password.sendKeys(pd);
	loginBtn.click();
	
	return new HomePage();
	}
	

}

package com.vicks.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vicks.qa.base.TestBase;
import com.vicks.qa.pages.HomePage;
import com.vicks.qa.pages.LoginPage_Demo;

public class LoginPageTest extends TestBase{
	LoginPage_Demo lg;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		 lg=new LoginPage_Demo();
	}
	
	HomePage hp= new HomePage();
	
	// Test after login should return to homepage
	  @Test(enabled=false)
	   public void LoginTest(){
	   hp= lg.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

package com.vicks.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.vicks.qa.base.TestBase;
import com.vicks.qa.pages.ContactUsPage;
import com.vicks.qa.pages.HomePage;


public class ContactUsPageTest extends TestBase{
	 /* What is log?: capturing info/activities at the time of program execution.
	  * types of logs:
	  * 1. info;
	  * 2. warn;
	  * 3. error;
	  * 4. fatal
	  * 
	  * How to generate the logs? : use Apache log4j API;
	  * How it works?  it reads log4j configuration from log4j.properties file
	  * where to create: create inside resources folder 
	  * New--> sources folder --> "src/main/resources"
	  * In this new folder --> New--> File -->"log4j.properties"
	  */
	
	
	
	HomePage hp;
	ContactUsPage ctp;
	
	
	Logger log=Logger.getLogger(ContactUsPage.class);
	
	public ContactUsPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		
		initialization();
		hp= new HomePage();
		 ctp= hp.clickOnContactUsLink();
		 
		// log.info("start");
	}
	
	@Test(enabled=false)
	public void ContactUsTitleTest() {
		String title = ctp.verifyContactUsPageTitle();
		Assert.assertEquals(title, prop.getProperty("contactUsPageTitle"));
	}
	
	@Test(priority=2)
	public void validateSearchFunction() {
		boolean result=ctp.searchText(prop.getProperty("searchValue"));
		Assert.assertTrue(result);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

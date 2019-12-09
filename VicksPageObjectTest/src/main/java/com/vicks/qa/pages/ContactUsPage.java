package com.vicks.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.vicks.qa.base.TestBase;

public class ContactUsPage extends TestBase {
	
	//Initialization Contact Page Object
			public ContactUsPage() {
				PageFactory.initElements(driver, this);
			}

			
			public String verifyContactUsPageTitle() {
				return driver.getTitle();
			}
}

package com.vicks.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vicks.qa.base.TestBase;

public class ContactUsPage extends TestBase {
	
	//Initialization Contact Page Object
			public ContactUsPage() {
				PageFactory.initElements(driver, this);
			}

			@FindBy(xpath="//input[@placeholder=' Search our answers...']")
			WebElement searchInputBox;
			@FindBy(xpath="//button[@id='searchButton']")
			WebElement searchBtn;
			@FindBy(xpath="//div[text()='Search results]")
			WebElement searchResult;
			
			public boolean searchText(String searchingText ) {
				searchInputBox.sendKeys(searchingText);
				searchInputBox.sendKeys(Keys.ENTER );
				searchBtn.click();
				return searchResult.isDisplayed();

			}
			public String verifyContactUsPageTitle() {
				return driver.getTitle();
			}
}

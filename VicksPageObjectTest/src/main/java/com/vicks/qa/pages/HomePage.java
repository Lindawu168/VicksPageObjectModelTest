package com.vicks.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vicks.qa.base.TestBase;

public class HomePage extends TestBase {

	// Initialization Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Page Factory -OR:
	@FindBy(xpath = "//img[contains(@class, 'logo')]")
	WebElement vicksLogo;
	@FindBy(name = "term")
	WebElement searchBox;
	@FindBy(xpath = "//a[contains(text(), 'Contact Us')]")
	WebElement contactUsLink;
	@FindBy(xpath = "//a[contains(text(),'Shop Products')]")
	WebElement shopProductsLink;
	@FindBy(xpath = "//a[contains(text(),'Symptoms')]")
	WebElement symptomsLink;
	@FindBy(xpath = "//a[contains(text(),'Treatments')]")
	WebElement treamentsLink;
	@FindBy(xpath = "//a[contains(text(),'Safety & faqs')]")
	WebElement safetyFaqsLink;
	@FindBy(xpath = "//a[contains(text(),'Vicks History')]")
	WebElement historyLink;

	@FindBy(xpath = "//div[@class='SlickSliderstyles__BannerImage-sc-36clm4-1 zXdsr']//a[@data-action-detail='slide : FluTherapy : LEARN MORE']")
	WebElement carousellearnMoreBtn1;

	// @FindBy(id="continentsmultiple")
	// WebElement languageSelector;
	@FindBy(xpath = "//button[@aria-label='language select']")
	WebElement languageBtn;

	@FindBy(xpath = "//a[text()='Canada - English']")
	WebElement languageS;

	// Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateVicksLogoImage() {
		return vicksLogo.isDisplayed();
	}

	public String validateLogoImageTitle() {
		return vicksLogo.getText();
	}

	public String selectLanguage() {
		// Select sl= new Select (languageSelector);
		// sl.selectByVisibleText(lg);
		languageBtn.click();
		languageS.click();
		return languageBtn.getText();
	}

	public void setSearchingValue(String sItem) {
		searchBox.sendKeys(sItem);
	}
//Page navigations
	public ContactUsPage clickOnContactUsLink() {
		contactUsLink.click();
		return new ContactUsPage();
	}
	public ShopProductsPage clickOnshopProductsLink() {
		shopProductsLink.click();
		return new ShopProductsPage();
	}
	public SymptomsPage clickOnsymptomsLink() {
		symptomsLink.click();
		return new SymptomsPage();
	}
	public TreatMentsPage clickOntreamentsLink() {
		treamentsLink.click();
		return new TreatMentsPage();
	}
	public Safety_FAQsPage safetyFaqsLink() {
		safetyFaqsLink.click();
		return new Safety_FAQsPage();
	}
	public VicksHistoryPage historyLink() {
		historyLink.click();
		return new VicksHistoryPage();
	}
}

package com.vicks.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vicks.qa.base.TestBase;
import com.vicks.qa.pages.HomePage;


public class HomePageTest extends TestBase{
	HomePage hp;
	//LoginPage_Demo lg;
	//TestUtil tsul; -- When an utility needs (such as switchToFramework, generate a TestUtil object)
	
	public HomePageTest() {
		super();
	}
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		/* If need user to login, then generate Login object first
		 * lg= new LoginPage_Demo();
		 * hp = lg.login(prop.getProperty("username"), prop.getProperty("password"));
		 * 
		 * TestUtil
		 * tsul = new TestUtil();
		 */
		 hp=new HomePage();
	}
	
	/*@Test(priority =1)
	public void HomePageTitleTest() {
		String title = hp.validateHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("homepage.title"));
	}
	
	@Test(priority =2)
	public void HomePageLogoTest() {
		boolean flag= hp.validateVicksLogoImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void HomePageLogoTitle() {
		System.out.println(hp.validateLogoImageTitle());
	}*/
	
	@Test(enabled=false )
	public void verifyLanguageSelection() {
		String selectedL= hp.selectLanguage();
		System.out.println(selectedL);
		
		Assert.assertEquals(selectedL, prop.getProperty("language"));
	
	}
	
	@Test
	public void verifyNavigationtoContactUsPage() {
		hp.clickOnContactUsLink();
	String actualTitle = driver.getTitle();
		//tsul.switchToFrame();
		Assert.assertEquals(actualTitle, prop.getProperty("contactUsPageTitle"), prop.getProperty("titleError"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

package com.vicks.qa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vicks.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public TestBase() {
		try{
			
			String filePath= new File("").getAbsolutePath();
			FileReader ir= new FileReader(filePath+"/src/main/java/com/vicks/qa/config/config.properties");
			prop = new Properties();
			prop.load(ir);
			
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows\\eclipse\\libs\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Windows\\eclipse\\libs\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void clickOn(WebDriver dr, WebElement elm, int waitingTime) {
		WebDriverWait w=new WebDriverWait(dr, waitingTime);
		w.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
	}
	
	
}

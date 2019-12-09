package com.vicks.qa.util;

import com.vicks.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPICIT_WAIT =10;
	
	public void switchToFrame() {
		driver.switchTo().frame(prop.getProperty("frameName"));
	}
}

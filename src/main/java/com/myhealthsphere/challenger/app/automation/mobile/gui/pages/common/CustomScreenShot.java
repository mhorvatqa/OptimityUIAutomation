package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;



public class CustomScreenShot{
	
	WebDriver mDriver;
	
    public CustomScreenShot(WebDriver driver) {
        mDriver = driver;
    }
    
	 static boolean isScreenshotAllowed = R.CONFIG.getBoolean("get_custom_screenshots");
	
	 public void captureScreenShot(String description) {
		 if(isScreenshotAllowed) {
			 Screenshot.captureByRule(mDriver, description);
		 } else {
			 System.out.println("CONFIG.profile [get_custom_screenshots] is set to false -  no captures are allowed: " + description);
		 }
	 }
}

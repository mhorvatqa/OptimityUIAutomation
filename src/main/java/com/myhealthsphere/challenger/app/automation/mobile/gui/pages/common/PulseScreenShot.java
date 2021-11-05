package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.screenshot.IScreenshotRule;

public class PulseScreenShot implements IScreenshotRule {
	
    @Override
    public boolean isTakeScreenshot() {
        // enable screenshot generation for every call if auto_screenshots=true
        return R.CONFIG.getBoolean("get_custom_screenshots");
    }
}

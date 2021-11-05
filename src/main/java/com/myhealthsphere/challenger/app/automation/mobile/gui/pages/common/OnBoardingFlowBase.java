package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class OnBoardingFlowBase extends AbstractPage {

	public OnBoardingFlowBase(WebDriver driver) {
		super(driver);
	}


	public abstract ExtendedWebElement getHeaderImageView();
	public abstract ExtendedWebElement getSloganTextView();
	public abstract ExtendedWebElement getOnboardingImageView();
	public abstract ExtendedWebElement getPrimaryButtonSignUp();
	public abstract ExtendedWebElement getSecondaryButtonLogIn();
	public abstract ExtendedWebElement getTitleText(int pageIndexTitle);
	public abstract ExtendedWebElement getSubTitleText(int pageIndexSubTitle);
	public abstract ExtendedWebElement setDot(int dotPage);
	public abstract void getTourPager();
}

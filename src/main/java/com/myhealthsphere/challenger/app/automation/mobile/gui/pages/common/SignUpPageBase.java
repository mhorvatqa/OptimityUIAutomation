package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class SignUpPageBase extends AbstractPage {

	public SignUpPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract ExtendedWebElement getHeaderImageView();
	public abstract ExtendedWebElement getSloganTextView();
	public abstract ExtendedWebElement getHeaderTitle();
	public abstract ExtendedWebElement getAuthLoginEmailEdittext();
	public abstract ExtendedWebElement getAuthLoginPasswordEdittext();
	public abstract ExtendedWebElement getChecked_textInputEndIcon();
	public abstract ExtendedWebElement getunChecked_textInputEndIcon();
	public abstract ExtendedWebElement getMinCharacterCheckTextview();
	public abstract ExtendedWebElement getCaseCharacterCheckTextview();
	public abstract ExtendedWebElement getNumberCheckTextview();
	public abstract ExtendedWebElement getFragmentSignupFormTermsText();
	public abstract ExtendedWebElement getPrimaryButton();










}

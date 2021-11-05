package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.ios;

import org.openqa.selenium.WebDriver;

import com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common.SignUpPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {


	@FindBy(id = "header_image_view")
	private ExtendedWebElement headerImageView;

	@FindBy(xpath = "//android.widget.TextView[@text='Maximize your physical, mental\n" +
			"and financial wellness']")
	private ExtendedWebElement sloganTextView;


	@FindBy(id = "header_title")
	private ExtendedWebElement headerTitle;

	@FindBy(id = "auth_login_email_edittext")
	private ExtendedWebElement authLoginEmailEdittext;

	@FindBy(id = "auth_login_password_edittext")
	private ExtendedWebElement authLoginPasswordEdittext;
	@FindBy(xpath = "//*[@resource-id='com.myhealthsphere.challenger:id/text_input_end_icon' and @checked='false']")
	private ExtendedWebElement unChecked_textInputEndIcon;
	@FindBy(xpath = "//*[@resource-id='com.myhealthsphere.challenger:id/text_input_end_icon' and @checked='true']")
	private ExtendedWebElement Checked_textInputEndIcon;


	@FindBy(id = "min_character_check_textview")
	private ExtendedWebElement minCharacterCheckTextview;

	@FindBy(id = "case_character_check_textview")
	private ExtendedWebElement caseCharacterCheckTextview;

	@FindBy(id = "number_check_textview")
	private ExtendedWebElement numberCheckTextview;


	@FindBy(id = "fragment_signup_form_terms_text")
	private ExtendedWebElement fragmentSignupFormTermsText;

	@FindBy(id = "primary_button")
	private ExtendedWebElement primaryButton;

	public SignUpPage(WebDriver driver) {
		super(driver);
	}



	@Override
	public ExtendedWebElement getHeaderImageView() {
		return headerImageView;
	}

	@Override
	public ExtendedWebElement getSloganTextView() {
		return sloganTextView;
	}



	@Override
	public ExtendedWebElement getHeaderTitle() {
		return headerTitle;
	}

	@Override
	public ExtendedWebElement getAuthLoginEmailEdittext() {
		return authLoginEmailEdittext;
	}

	@Override
	public ExtendedWebElement getAuthLoginPasswordEdittext() {
		return authLoginPasswordEdittext;
	}

	@Override
	public ExtendedWebElement getunChecked_textInputEndIcon() {
		return unChecked_textInputEndIcon;
	}@Override
	public ExtendedWebElement getChecked_textInputEndIcon() {
		return Checked_textInputEndIcon;
	}







	@Override
	public ExtendedWebElement getMinCharacterCheckTextview() {
		return minCharacterCheckTextview;
	}

	@Override
	public ExtendedWebElement getCaseCharacterCheckTextview() {
		return caseCharacterCheckTextview;
	}

	@Override
	public ExtendedWebElement getNumberCheckTextview() {
		return numberCheckTextview;
	}



	@Override
	public ExtendedWebElement getFragmentSignupFormTermsText() {
		return fragmentSignupFormTermsText;
	}

	@Override
	public ExtendedWebElement getPrimaryButton() {
		return primaryButton;
	}



}

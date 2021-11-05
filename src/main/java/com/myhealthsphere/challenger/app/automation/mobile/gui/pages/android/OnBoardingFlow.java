package com.myhealthsphere.challenger.app.automation.mobile.gui.pages.android;

import com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common.CustomScreenShot;
import com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common.OnBoardingFlowBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = OnBoardingFlowBase.class)
public class OnBoardingFlow extends OnBoardingFlowBase {

	CustomScreenShot getScreen = new CustomScreenShot(getDriver());

	@FindBy(id = "header_image_view")
	private ExtendedWebElement headerImageView;


	@FindBy(xpath = "//android.widget.TextView[@text='Maximize your physical, mental\n" +
			"and financial wellness']")
	private ExtendedWebElement sloganTextView;

	@FindBy(id = "onboarding_image_view")
	private ExtendedWebElement onboardingImageView;

	@FindBy(xpath = "//*[@resoure-id='com.myhealthsphere.challenger:id/onboarding_titleview']")
	private ExtendedWebElement onboardingTitleView;

	@FindBy(xpath = "//*[@resoure-id='com.myhealthsphere.challenger:id/onboarding_subtitle']")
	private ExtendedWebElement onboardingSubTitleView;

	@FindBy(xpath =  "//*[@text='%s']")
	protected ExtendedWebElement elementId;

	@FindBy(xpath = "%s")
	private ExtendedWebElement dotsPageIndicator;


	@FindBy(xpath = "//*[@resource-id='com.myhealthsphere.challenger:id/primary_button' and @text='Sign Up']")
	private ExtendedWebElement primaryButtonSignUp;

	@FindBy(xpath = "//*[@resource-id='com.myhealthsphere.challenger:id/secondary_button' and @text='Log In']")
	private ExtendedWebElement secondaryButtonLogIn;



	
	
	public OnBoardingFlow(WebDriver driver) {
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
	public ExtendedWebElement getOnboardingImageView() {
		return onboardingImageView;
	}

	@Override
	public ExtendedWebElement getPrimaryButtonSignUp() {
		return primaryButtonSignUp;
	}


	@Override
	public ExtendedWebElement getSecondaryButtonLogIn() {
		return secondaryButtonLogIn;
	}


	@Override
	public ExtendedWebElement getTitleText(int pageIndexTitle) {
		String[] textArray = {
				"Earn rewards",
				"Learn while you earn",
				"Challenge friends"
		};
		return (elementId.format(textArray[pageIndexTitle]));
	}

	@Override
	public ExtendedWebElement getSubTitleText(int pageIndexSubTitle) {
		String[] textArray = {
				"Get gift cards and prizes for hitting daily step goals and taking quick quizzes",
				"Get tips for healthy habits, nutrition and financial wellness along the way",
				"Compete with friends to get motivated, have fun, and earn even more prizes"
		};
		return (elementId.format(textArray[pageIndexSubTitle]));
	}

	@Override
	public ExtendedWebElement setDot(int dotPage) {
		String[] textArray = {
				"//*[@resource-id='com.myhealthsphere.challenger:id/dots_indicator']/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]",
				"//*[@resource-id='com.myhealthsphere.challenger:id/dots_indicator']/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]",
				"//*[@resource-id='com.myhealthsphere.challenger:id/dots_indicator']/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]"
		};
		return (dotsPageIndicator.format(textArray[dotPage]));
	}

	@Override
	public void getTourPager() {
		final int DOT_PAGE_COUNT = 3;
		for (int i = 0; i < DOT_PAGE_COUNT; i++) {
			setDot(i).click();
			setDot(i).assertElementPresent();
			setDot(i).click();
			getTitleText(i).assertElementPresent();
			setDot(i).click();
			getSubTitleText(i).assertElementPresent();
			setDot(i).click();
			getOnboardingImageView().assertElementPresent();
			setDot(i).click();
			getScreen.captureScreenShot("Carousel - Get Android page no: " + (i+1));

		}

	}


}

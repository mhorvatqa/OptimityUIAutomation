package com.myhealthsphere.challenger.app.automation.mobile.gui.pages;

import com.myhealthsphere.challenger.app.automation.mobile.gui.pages.common.*;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.common.CommonUtils;
import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.screenshot.IScreenshotRule;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MobileMyHealthSphereTest extends AbstractTest {

	// Constants
	public static final int ONBOARDING_PAGE_COUNT = 3;
	public static final int LMS_NAME_TIMEOUT_MSECONDS = 20;
	public static final int SCREEN_DELAY_SECONDS = 5;
	public static final int DECTECT_MODAL_DIALOG_SECONDS = 3;
	public static final String BASE_URL = "/Users/marianahorvat/MyWorkspace/UIAutomation/MobileBlinkDiff/src/images" +
			"/Snapshots/" + getPlatformName();
	static boolean isActualSnapShotAllowed = R.CONFIG.getBoolean("snapshots_visual_diff_ACTUAL");
	int targetSize = 200;

	CustomScreenShot getScreen = new CustomScreenShot(getDriver());
	WebDriver mDriver;

	OnBoardingFlowBase onboardingFlow;
	SignUpPageBase signUpPage;



	public static String getPlatformName() {
		return R.CONFIG.get("capabilities.platformName");
	}

	@BeforeSuite
	public void startDriver() {

		onboardingFlow = initPage(getDriver(), OnBoardingFlowBase.class);
		signUpPage = initPage(getDriver(), SignUpPageBase.class);


		// ScreenShoter method to allow us to grab custom screen shots
		IScreenshotRule takesCustomScreenShots = (IScreenshotRule) new PulseScreenShot();
		Screenshot.clearRules();
		Screenshot.addScreenshotRule(takesCustomScreenShots);
	}

	@AfterSuite
	public void tearDown(){
		try {
			mDriver = getDriver();
			mDriver.quit();
		} catch (Exception ignore) {}
	}



	@Test(description = "TestPlan-Login Flow", enabled = true)
	public void test1OnBoardingFlow() throws InterruptedException, IOException {

		System.out.println("Testing OnBoarding Screen" + " > " + getPlatformName());

		/**
		 TC: As a User, I can see logo_layout displayed on the page
		*/
		onboardingFlow.getHeaderImageView().assertElementPresent();
		onboardingFlow.getSloganTextView().assertElementPresent();

		/**
		 TC: As a User, I can see tour_viewpager
		 */
		onboardingFlow.getTourPager();

		/**
		 TC: As a User, I can see footer_linear_layout
		 */
		onboardingFlow.getPrimaryButtonSignUp().assertElementPresent();
		onboardingFlow.getSecondaryButtonLogIn().assertElementPresent();


		getScreen.captureScreenShot("Main Screenshot ONBOARDING: " + " > " + getPlatformName());
		createVisualDiff(3);

		// Click on Sign Up button
		onboardingFlow.getPrimaryButtonSignUp().click();



	}

	@Test(description = "TestPlan-Course Screen", enabled = true)
	public void test2SignUp() throws IOException, InterruptedException {

		System.out.println("Testing now BPG Home Screen for" + " > " + getPlatformName());

		/**
		 TC: As a User, I can see logo_layout displayed on the page
		 */
		signUpPage.getHeaderImageView().assertElementPresent();
		signUpPage.getSloganTextView().assertElementPresent();


		// Get Title screen
		signUpPage.getHeaderTitle().assertElementPresent();

		// State Transition matrix
		signUpPage.getAuthLoginEmailEdittext().assertElementPresent();
		signUpPage.getAuthLoginPasswordEdittext().assertElementPresent();
		signUpPage.getunChecked_textInputEndIcon().assertElementPresent();

		test2verifyUserPassCorrect();

		signUpPage.getFragmentSignupFormTermsText().assertElementPresent();
		signUpPage.getPrimaryButton().assertElementPresent();
		createVisualDiff(3);

		signUpPage.getPrimaryButton().click();




	}


	private void test2verifyUserPassCorrect() throws IOException, InterruptedException {
		System.out.println("Verify Correct Username and Password");

		signUpPage.getAuthLoginEmailEdittext().click();
		signUpPage.getAuthLoginEmailEdittext().type("bravo@gmail.com");
		signUpPage.getAuthLoginPasswordEdittext().click();
		signUpPage.getAuthLoginPasswordEdittext().type("BravoDelta1");

		getDriver().navigate().back();

		signUpPage.getunChecked_textInputEndIcon().click();
		signUpPage.getChecked_textInputEndIcon().assertElementPresent();


		signUpPage.getMinCharacterCheckTextview().isVisible();
		signUpPage.getCaseCharacterCheckTextview().isVisible();
		signUpPage.getNumberCheckTextview().isVisible();


		getScreen.captureScreenShot("Screenshot - Student BPG detail: " + " > " + getPlatformName());
	}




	public void createVisualDiff(int methodNameLevel) throws IOException {
		getBlinkDiffSnapshot();
		createThumbnails(methodNameLevel);
	}


	public void getBlinkDiffSnapshot() throws IOException {
		if (isActualSnapShotAllowed){
			getScreenshot(getDriver(),
					BASE_URL  + "/" + Thread.currentThread().getStackTrace()[3].getMethodName() + "/" + "actual" +
							".png");
		} else {
			getScreenshot(getDriver(),
					BASE_URL  + "/" + Thread.currentThread().getStackTrace()[3].getMethodName() + "/" + "base" +
							".png");
		}
	}

	public String getSnapshot(int methodNameLevel)  {
		return Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName();
	}

	public static void getScreenshot(WebDriver driver, String outputlocation ) throws IOException {
		System.out.println("BlinkDiff - Capturing the snapshot on platform " + getPlatformName());
		File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFiler, new File(outputlocation));
	}

	public void createThumbnails(int methodNameLevel) {
		File theDir = new File(BASE_URL + "/" + Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName() +"/" +
				"thumbnails");
		if (!theDir.exists()){
			theDir.mkdirs();
			resizeImage(BASE_URL + "/" + Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName(),
					BASE_URL + "/" + Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName() +"/" + "thumbnails" ,
					targetSize);
		} else {
			resizeImage(BASE_URL + "/" + Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName(),
					BASE_URL + "/" + Thread.currentThread().getStackTrace()[methodNameLevel].getMethodName() +"/" + "thumbnails" ,
					targetSize);
		}
	}


	public static void resizeImage(String sourceDirectory, String destinationDirectory, int targetSize) {
		try {
			File directory = new File(sourceDirectory);
			if(!directory.exists())
				return;

			FileFilter fileFilter = file -> file.isFile() && file.getName().endsWith(".png");
			File[] listOfFiles = directory.listFiles(fileFilter);
			for(File sourceFile : listOfFiles) {
				BufferedImage originalImage = ImageIO.read(sourceFile);

				BufferedImage resizedImage = Scalr.resize(originalImage, targetSize);

				File resizedFile = Paths.get(destinationDirectory, sourceFile.getName()).toFile();
				ImageIO.write(resizedImage, "png", resizedFile);
				originalImage.flush();
				resizedImage.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carouselSnapShot (int methodNameLevel, int page) throws IOException {
	if (isActualSnapShotAllowed){
		getScreenshot(getDriver(),
				BASE_URL  + "/" + getSnapshot(methodNameLevel) + "/" + "Slide" + page + "/" +
						"actual" + ".png");
		getScreenshot(getDriver(),
				BASE_URL  + "/" + getSnapshot(methodNameLevel) + "/" + "Slide" + page + "/" + "thumbnails" + "/" +
						"actual" + ".png");
	} else {
		getScreenshot(getDriver(),
				BASE_URL  + "/" + getSnapshot(methodNameLevel) + "/" + "Slide" + page + "/" + "base" +
						".png");
		getScreenshot(getDriver(),
				BASE_URL  + "/" + getSnapshot(methodNameLevel) + "/" + "Slide" + page + "/" + "thumbnails" + "/" +
						"base" + ".png");
	}

	resizeImage(BASE_URL + "/" + getSnapshot(methodNameLevel)+ "/" + "Slide" + page,
	BASE_URL  + "/" + getSnapshot(methodNameLevel) + "/" + "Slide" + page + "/" + "thumbnails" ,
	targetSize);

	}





	public void scrollDown() {
//		while (true) {
//			boolean isVisible = signUpPage.detailLatestPosts().isVisible(1);
//			if (!isVisible) {
//				JavascriptExecutor js = (JavascriptExecutor) getDriver();
//				HashMap scrollObject = new HashMap();
//				scrollObject.put("direction", "down");
//				js.executeScript("mobile: scroll", scrollObject);
//				break;
//			}
//		}
//		Assert.assertTrue(signUpPage.detailLatestPosts().isVisible(), "Latest Posts are NOT the screen");
	}






}
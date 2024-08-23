package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.AboutELDScreen;
import com.at.screens.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class AboutELD extends Certification {

	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

	@Test(priority = 17)
	public void AboutELDScreen() throws IOException {
		ExtentTest test = extent.createTest("About ELD_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

		AboutELDScreen ab = new AboutELDScreen(driver);
		BaseClass base = new BaseClass();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			// Wait and tap on the hamburger icon
			WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
			hamburgerIcon.click();
			logger.info("Tapped on the hamburger icon");
			test.info("Tapped on the hamburger icon");

			// Wait and navigate to About ELD
			wait.until(ExpectedConditions.elementToBeClickable(ab.getAboutELD()));
			ab.navigateToAboutELD();
			logger.info("Navigated to About ELD");
			test.pass("Navigated to ELD");
			Thread.sleep(delay);

			// Navigate back using the back button
			driver.navigate().back();
			logger.info("Navigated back using the back button");
			test.info("Navigated back using the back button");

			// Wait and tap on the hamburger icon again
			hamburgerIcon.click();
			logger.info("Tapped on the hamburger icon again");
			test.info("Tapped on the hamburger icon again");

		} catch (Exception e) {
			test.fail("Unable to navigate to about ELD: " + e.getMessage());
			logger.error("Unable to navigate to about ELD: " + e.getMessage());
			String screenshotPath = getScreenshot(driver, "AboutELDFailedScreenshot");
			test.fail("Unable to navigate to about ELD: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}

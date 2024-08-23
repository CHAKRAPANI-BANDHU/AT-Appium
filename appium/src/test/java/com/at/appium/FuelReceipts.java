package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.BaseClass;
import com.at.screens.FuelReceiptsScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class FuelReceipts extends Documents { //Need to write code for auto scroll to execute other modules
	
	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

	@Test(priority = 13)
	public void FuelReceiptsScreen() throws IOException {
		ExtentTest test = extent.createTest("Fuel Receipts_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

		FuelReceiptsScreen fr = new FuelReceiptsScreen(driver);
		BaseClass base = new BaseClass();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
			hamburgerIcon.click();
			logger.info("Tapped on the hamburger icon");
			test.info("Tapped on the hamburger icon");

			// Wait and navigate to Fuel Receipts
			wait.until(ExpectedConditions.elementToBeClickable(fr.getFuelReceipts()));
			fr.navigateToFuelReceipts();
			logger.info("Navigated to Fuel Receipts");
			test.pass("Navigated to Fuel Receipts");
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
			test.fail("Unable to navigate to fuel receipts: " + e.getMessage());
			logger.error("Unable to navigate to fuel receipts: " + e.getMessage());
			String screenshotPath = getScreenshot(driver, "FuelReceiptsFailedScreenshot");
			test.fail("Unable to navigate to fuel receipts: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
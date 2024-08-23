package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.BaseClass;
import com.at.screens.DiagnosticScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Diagnostic extends ScanDevices {
	
	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

	@Test(priority = 15)
	public void Diagnosticscreen() throws IOException {
		ExtentTest test = extent.createTest("Diagnostic_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

		DiagnosticScreen dg = new DiagnosticScreen(driver);
		BaseClass base = new BaseClass();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
			hamburgerIcon.click();
			logger.info("Tapped on the hamburger icon");
			test.info("Tapped on the hamburger icon");

			// Wait and navigate to Diagnostic
			wait.until(ExpectedConditions.elementToBeClickable(dg.getDiagnosticScreen()));
			dg.navigateToDiagnostic();
			logger.info("Navigated to Diagnostic");
			test.pass("Navigated to Diagnostic");
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
			test.fail("Unable to navigate to diagnostic: " + e.getMessage());
			logger.error("Unable to navigate to diagnostic: " + e.getMessage());
			String screenshotPath = getScreenshot(driver, "DiagnosticFailedScreenshot");
			test.fail("Unable to navigate to diagnostic: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
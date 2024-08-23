package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.BaseClass;
import com.at.screens.ScanDevicesScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ScanDevices extends FuelReceipts {
	
	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

	@Test(priority = 14)
	public void ScanDevicesScreen() throws IOException {
		ExtentTest test = extent.createTest("Scan Devices_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

		ScanDevicesScreen sd = new ScanDevicesScreen(driver);
		BaseClass base = new BaseClass();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
			hamburgerIcon.click();
			logger.info("Tapped on the hamburger icon");
			test.info("Tapped on the hamburger icon");

			// Wait and navigate to Scan Devices
			wait.until(ExpectedConditions.elementToBeClickable(sd.getScanDevices()));
			sd.navigateToScanDevices();
			logger.info("Navigated to Scan Devices");
			test.pass("Navigated to Scan Devices");
			Thread.sleep(delay);
//			
//			if (ls.isECMDeviceNotAvailable()) {
//				// ECM Device is not available
//				logger.info("ECM Device is still not available after scanning.");
//				test.info("ECM Device is still not available after scanning.");
//				Thread.sleep(delay);
//
//				// Click Continue Button
//				WebElement continueButton = wait
//						.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
//				continueButton.click();
//				logger.info("Tapped on the continue button");
//				test.info("Tapped on the continue button");
//				Thread.sleep(delay);
//
//				ls.tapOKButton();
//				logger.info("Tapped on the ok button");
//				test.info("Tapped on the ok button");
//				Thread.sleep(delay);
//
//				// Fetch and log Dashboard Information
//				logger.info("Speed Information: " + ls.getSpeed());
//				test.info("Speed Information: " + ls.getSpeed());
//
//				logger.info("RPM Information: " + ls.getRPM());
//				test.info("RPM Information: " + ls.getRPM());
//
//				logger.info("Engine State Information: " + ls.getEngineState());
//				test.info("Engine State Information: " + ls.getEngineState());
//
//				logger.info("Engine Information: " + ls.getEngine());
//				test.info("Engine Information: " + ls.getEngine());
//
//				logger.info("Odometer Information: " + ls.getOdometer());
//				test.info("Odometer Information: " + ls.getOdometer());
//
//				// Run ELDDiagnostic
//				ls.ELDDiagnostic();
//				Thread.sleep(delay);
//
//				// Click Continue Button
//				WebElement continueButton2 = wait
//						.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
//				continueButton2.click();
//				Thread.sleep(delay);
//
//				ls.tapOKButton();
//				Thread.sleep(delay);
//
//			} else if (ls.isECMDeviceAvailable()) {
//				// ECM Device is available
//				WebElement ecmDevice = wait.until(ExpectedConditions.visibilityOf(ls.ECMDeviceIsAvailable));
//				ecmDevice.click();
//				logger.info("ECM Device is available");
//				test.info("ECM Device is available");
//				Thread.sleep(000);
//
//				// Fetch and log Dashboard Information
//				logger.info("Speed Information: " + ls.getSpeed());
//				test.info("Speed Information: " + ls.getSpeed());
//
//				logger.info("RPM Information: " + ls.getRPM());
//				test.info("RPM Information: " + ls.getRPM());
//
//				logger.info("Engine State Information: " + ls.getEngineState());
//				test.info("Engine State Information: " + ls.getEngineState());
//
//				logger.info("Engine Information: " + ls.getEngine());
//				test.info("Engine Information: " + ls.getEngine());
//
//				logger.info("Odometer Information: " + ls.getOdometer());
//				test.info("Odometer Information: " + ls.getOdometer());
//
//				// Run ELDDiagnostic
//				ls.ELDDiagnostic();
//				logger.info("Tapped on the run diagnostic button");
//				test.info("Tapped on the run diagnostic button");
//				Thread.sleep(delay);
//
//				// Click Continue Button
//				WebElement continueButton = wait
//						.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
//				continueButton.click();
//				logger.info("Tapped on the continue button");
//				test.info("Tapped on the continue button");
//				Thread.sleep(delay);
//
//				ls.tapOKButton();
//				logger.info("Tapped on the ok button");
//				test.info("Tapped on the ok button");
//				Thread.sleep(delay);
//
//			} else {
//				// Log unknown ECM device status
//				System.out.println(ls.isECMDeviceNotAvailable());
//				logger.warn("ECM device status is unknown.");
//				test.warning("ECM device status is unknown.");
//			}
//
//			// Navigated to hours of service screen
//			if (ls.HoursOfService.isDisplayed()) {
//				logger.info("Navigated to Hours of Service");
//				test.pass("Navigated to Hours of Service");
//			} else {
//				logger.info("Navigated to Hours of Service");
//				test.fail("Unable to navigate to Hours of Service screen");
//			}
//
//		} finally {
//			logger.info("Login test has finished execution.");
//			test.pass("Login t");
//		}
//	
//
//			// Navigate back using the back button
//			driver.navigate().back();
//			logger.info("Navigated back using the back button");
//			test.info("Navigated back using the back button");
//
//			// Wait and tap on the hamburger icon again
//			hamburgerIcon.click();
//			logger.info("Tapped on the hamburger icon again");
//			test.info("Tapped on the hamburger icon again");

		} catch (Exception e) {
			test.fail("Unable to navigate to scan devices: " + e.getMessage());
			logger.error("Unable to navigate to scan devices: " + e.getMessage());
			String screenshotPath = getScreenshot(driver, "ScanDevicesFailedScreenshot");
			test.fail("Unable to navigate to scan devices: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
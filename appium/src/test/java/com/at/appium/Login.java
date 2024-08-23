package com.at.appium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.at.screens.BaseClass;
import com.at.screens.LoginScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.io.IOException;
import java.time.Duration;

public class Login extends BaseClass {

	int delay = 500;

	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
	}

	@Test(priority = 1)
	public void LoginScreen() throws IOException {
		ExtentTest test = extent.createTest("Login_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");
		test.info("ELD App is launched");
		logger.info("ELD App is launched");

		LoginScreen ls = new LoginScreen(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			ls.tapAgreeButton();
			logger.info("Tapped on the agree button");
			test.info("Tapped on the agree button");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getWhileUsingAppLocationPermission()));
			ls.tapWhileUsingAppLocationPermission();
			logger.info("Tapped on the while using the app location permission");
			test.info("Tapped on the while using the app location permission");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getAllowMediaPermission()));
			ls.tapAllowMediaPermission();
			logger.info("Tapped on the allow media permission");
			test.info("Tapped on the allow media permission");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getAllowAllTimeLocationPermission()));
			ls.tapAllowAllTimeLocationPermission();
			logger.info("Tapped on the allow all time location permission");
			test.info("Tapped on the allow all time location permission");

			ls.tapBackArrowIcon();
			logger.info("Tapped on the back arrow icon");
			test.info("Tapped on the back arrow icon");

			// Enable overlay permission
//	        wait.until(ExpectedConditions.elementToBeClickable(ls.handleOverlayPermissionsInSettings()));
//	        ls.handleOverlayPermissionsInSettings();

			// Wait for user ID field to be visible
			wait.until(ExpectedConditions.visibilityOf(ls.getUserIdInput()));
			ls.setUserId("Kitretsu");
			logger.info("Entered the Username");
			test.info("Entered User ID");

			wait.until(ExpectedConditions.visibilityOf(ls.getPasswordInput()));
			ls.setPassword("12345");
			logger.info("Entered Password");
			test.info("Entered the Password");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getLoginButton()));
			ls.tapLoginButton();
			logger.info("Tapped on the Login button");
			test.pass("Tapped on the Login button");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getConfigureButton()));
			ls.tapConfigureButton();
			logger.info("Tapped on the configure button");
			test.pass("Tapped on the configure button");

			wait.until(ExpectedConditions.elementToBeClickable(ls.getOKButton()));
			ls.tapOKButton();
			logger.info("Tapped on the ok button");
			test.pass("Tapped on the ok button");
			Thread.sleep(delay);

			wait.until(ExpectedConditions.visibilityOf(ls.getEnvironmentInfo()));
			String environmentDetails = ls.getEnvironment();
			logger.info("Environment Details: " + environmentDetails);
			test.pass("Environment Details: " + environmentDetails);

			wait.until(ExpectedConditions.visibilityOf(ls.getAppVersionInfo()));
			String appDetails = ls.getAppVersion();
			logger.info("App Version: " + appDetails);
			test.pass("App Version: " + appDetails);

			// Check if login button is displayed after tapping OK button
			WebElement loginButton = ls.getLoginButton();
			wait.until(ExpectedConditions.visibilityOf(loginButton));
			if (loginButton.isDisplayed()) {
				// Click on login button if displayed
				loginButton.click();
				logger.info("Successfully logged in.");
				test.pass("Successfully logged in.");
				Thread.sleep(3000);

				// Check for Tractor Information
				try {
					if (ls.isTractorInformationDisplayed()) {
						ls.SelectTractor();
						logger.info("Tap on Tractor to select");
						test.info("Tap on Tractor to select");
						Thread.sleep(delay);

						ls.SelectAll();
						logger.info("Tap on All");
						test.info("Tap on All");
						Thread.sleep(delay);

						ls.Tractor();
						logger.info("Tap on Tractor to select in tractor screen");
						test.info("Tap on Tractor to select in tractor screen");
						Thread.sleep(delay);

						ls.SaveTractorTrailer();
						Thread.sleep(delay);
						logger.info("Tap on save button in tractor");
						test.info("Tap on save button in tractor");
					} else {
						String screenshotPath = getScreenshot(driver, "ExceptionForTractorSelectionScreenshot");
						test.fail("Exception when handling Trailer Information: ",
								MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					}
				} catch (NoSuchElementException e) {
					String screenshotPath = getScreenshot(driver, "TractorInfoFailedScreenshot");
					test.fail("Exception when handling Tractor Information: " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}

				try {
					if (ls.isTrailerInformationDisplayed()) {
						logger.info("Trailer Information is displayed.");
						test.info("Trailer Information is displayed.");

						ls.SelectTrailer();
						logger.info("Tap on Trailer to select");
						test.info("Tap on Trailer to select");
						Thread.sleep(delay);

						ls.Trailer();
						logger.info("Select a trailer in the trailer screen");
						test.info("Select a trailer in the trailer screen");

						ls.SaveTractorTrailer();
						Thread.sleep(delay);
						logger.info("Tap on save button in trailer");
						test.info("Tap on save button in trailer");

						ls.enterUniqueOdometer();
						logger.info("Entered unique value for Odometer and Confirm Odometer");
						test.pass("Entered unique value for Odometer and Confirm Odometer");
						Thread.sleep(delay);

						// Hide Keyboard
						driver.hideKeyboard();

					} else {
						String screenshotPath = getScreenshot(driver, "ExceptionForTrailerSelectionScreenshot");
						test.fail("Exception when handling Trailer Information: ",
								MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					}
				} catch (NoSuchElementException e) {
					String screenshotPath = getScreenshot(driver, "TrailerInfoFailedScreenshot");
					test.fail("Exception when handling Trailer Information: " + e.getMessage(),
							MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}

				// Save the tractor and trailer information
				ls.saveButton();
				Thread.sleep(delay);

				try {
					// Click the Scan Devices button
					WebElement scanDevicesButton = wait.until(ExpectedConditions.elementToBeClickable(ls.scanDevices));
					scanDevicesButton.click();
					logger.info("Tapped on the scan devices");
					test.info("Tapped on the scan devices");
					Thread.sleep(delay); // Adjust timing if needed

					if (ls.isECMDeviceNotAvailable()) {
						// ECM Device is not available
						logger.info("ECM Device is still not available after scanning.");
						test.info("ECM Device is still not available after scanning.");
						Thread.sleep(delay);

						// Click Continue Button
						WebElement continueButton = wait
								.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
						continueButton.click();
						logger.info("Tapped on the continue button");
						test.info("Tapped on the continue button");
						Thread.sleep(delay);

						ls.tapOKButton();
						logger.info("Tapped on the ok button");
						test.info("Tapped on the ok button");
						Thread.sleep(delay);

						// Fetch and log Dashboard Information
						logger.info("Speed Information: " + ls.getSpeed());
						test.info("Speed Information: " + ls.getSpeed());

						logger.info("RPM Information: " + ls.getRPM());
						test.info("RPM Information: " + ls.getRPM());

						logger.info("Engine State Information: " + ls.getEngineState());
						test.info("Engine State Information: " + ls.getEngineState());

						logger.info("Engine Information: " + ls.getEngine());
						test.info("Engine Information: " + ls.getEngine());

						logger.info("Odometer Information: " + ls.getOdometer());
						test.info("Odometer Information: " + ls.getOdometer());

						// Run ELDDiagnostic
						ls.ELDDiagnostic();
						Thread.sleep(delay);

						// Click Continue Button
						WebElement continueButton2 = wait
								.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
						continueButton2.click();
						Thread.sleep(delay);

						ls.tapOKButton();
						Thread.sleep(delay);

					} else if (ls.isECMDeviceAvailable()) {
						// ECM Device is available
						WebElement ecmDevice = wait.until(ExpectedConditions.visibilityOf(ls.ECMDeviceIsAvailable));
						ecmDevice.click();
						logger.info("ECM Device is available");
						test.info("ECM Device is available");
						Thread.sleep(000);

						// Fetch and log Dashboard Information
						logger.info("Speed Information: " + ls.getSpeed());
						test.info("Speed Information: " + ls.getSpeed());

						logger.info("RPM Information: " + ls.getRPM());
						test.info("RPM Information: " + ls.getRPM());

						logger.info("Engine State Information: " + ls.getEngineState());
						test.info("Engine State Information: " + ls.getEngineState());

						logger.info("Engine Information: " + ls.getEngine());
						test.info("Engine Information: " + ls.getEngine());

						logger.info("Odometer Information: " + ls.getOdometer());
						test.info("Odometer Information: " + ls.getOdometer());

						// Run ELDDiagnostic
						ls.ELDDiagnostic();
						logger.info("Tapped on the run diagnostic button");
						test.info("Tapped on the run diagnostic button");
						Thread.sleep(delay);

						// Click Continue Button
						WebElement continueButton = wait
								.until(ExpectedConditions.elementToBeClickable(ls.continueButton));
						continueButton.click();
						logger.info("Tapped on the continue button");
						test.info("Tapped on the continue button");
						Thread.sleep(delay);

						ls.tapOKButton();
						logger.info("Tapped on the ok button");
						test.info("Tapped on the ok button");
						Thread.sleep(delay);

					} else {
						// Log unknown ECM device status
						System.out.println(ls.isECMDeviceNotAvailable());
						logger.warn("ECM device status is unknown.");
						test.warning("ECM device status is unknown.");
					}

					// Navigated to hours of service screen
					if (ls.HoursOfService.isDisplayed()) {
						logger.info("Navigated to Hours of Service");
						test.pass("Navigated to Hours of Service");
					} else {
						logger.info("Navigated to Hours of Service");
						test.fail("Unable to navigate to Hours of Service screen");
					}

				} finally {
					logger.info("Login test has finished execution.");
					test.pass("Login test has finished execution.");
				}
			}
		} catch (Exception e) {
			logger.error("An error occurred during the login process: " + e.getMessage());
			String screenshotPath = getScreenshot(driver, "LoginProcessFailedScreenshot");
			test.fail("An error occurred during the login process: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
}
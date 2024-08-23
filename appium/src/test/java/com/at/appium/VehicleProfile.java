//package com.at.appium;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import com.at.screens.BaseClass;
//import com.at.screens.VehicleProfileScreen;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//
//public class VehicleProfile extends Logbook {
//
//	@BeforeClass
//	public void setupClass() throws Exception {
//		ensureDriverInitialized(); // Ensure driver is initialized
//		super.setupClass(); // Call setupClass from Login to ensure proper initialization
//	}
//
//	@Test(priority = 4)
//	public void VehicleProfileScreen() throws IOException {
//		ExtentTest test = extent.createTest("Vehicle Profile_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");
//
//		VehicleProfileScreen vp = new VehicleProfileScreen(driver);
//		BaseClass base = new BaseClass();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		try {
//			// Wait and tap on the hamburger icon
//			WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
//			hamburgerIcon.click();
//			logger.info("Tapped on the hamburger icon");
//			test.info("Tapped on the hamburger icon");
//
//			// Wait and navigate to Vehicle Profile
//			wait.until(ExpectedConditions.elementToBeClickable(vp.getVehicleProfileScreen()));
//			vp.navigateToVehicleProfile();
//			logger.info("Navigated to Vehicle Profile");
//			test.pass("Navigated to Vehicle Profile");
//          Thread.sleep(delay);
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
//
//		} catch (Exception e) {
//			test.fail("Unable to navigate to vehicle profile: " + e.getMessage());
//			logger.error("Unable to navigate to vehicle profile: " + e.getMessage());
//			String screenshotPath = getScreenshot(driver, "VehicleProfileFailedScreenshot");
//			test.fail("Unable to navigate to vehicle profile: " + e.getMessage(),
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		}
//	}
//}

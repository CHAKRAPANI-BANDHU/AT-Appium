package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.BaseClass;
import com.at.screens.HomeScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Home extends Logbook {
	
	@BeforeClass
	public void setupClass() throws Exception {
		ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

	@Test(priority = 3)
	public void HomeScreen() throws IOException {
		ExtentTest test = extent.createTest("Home_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

	    HomeScreen hs = new HomeScreen(driver);
	    BaseClass base = new BaseClass();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    try {
	        // Wait for the hamburger icon to be clickable, but don't call tapHamburgerIcon() here
	        WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));

	        // Now tap on the hamburger icon
	        hamburgerIcon.click();
	        logger.info("Tapped on the hamburger icon");
	        test.info("Tapped on the hamburger icon");

	        // Wait and navigate to Home
	        wait.until(ExpectedConditions.elementToBeClickable(hs.getHome()));
	        hs.navigateToHome();
	        logger.info("Navigated to Home");
	        test.pass("Navigated to Home");
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
	        test.fail("Unable to navigate to home: " + e.getMessage());
	        logger.error("Unable to navigate to home: " + e.getMessage());
	        String screenshotPath = getScreenshot(driver, "HomeFailedScreenshot");
	        test.fail("Unable to navigate to home: " + e.getMessage(),
	                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    }
	}
}
package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;  // Corrected import statement
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test; 


import com.at.screens.BaseClass;
import com.at.screens.LogoutScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Logout extends FuelReceipts { 
	
	int delay = 100;
	
	@BeforeClass
	public void setupClass() throws Exception {
        ensureDriverInitialized(); // Ensure driver is initialized
		super.setupClass(); // Call setupClass from Login to ensure proper initialization
	}

    @Test(priority = 19)
    public void LogoutScreen() throws IOException {
        ExtentTest test = extent.createTest("Logout_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

        LogoutScreen lg = new LogoutScreen(driver);
        BaseClass base = new BaseClass();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Wait and tap on the hamburger icon again
            wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));  // Assuming getHamburgerIcon() is defined in LogoutScreen
            base.tapHamburgerIcon();
            logger.info("Tapped on the hamburger icon again");
            test.info("Tapped on the hamburger icon again");
         
            // Wait and navigate to Logout
            lg.tapLogoutButton();
            logger.info("Tapped on logout on the left navigation bar");
            test.info("Tapped on logout on the left navigation bar");
            Thread.sleep(delay);
            
         // Tap on the logout button
            wait.until(ExpectedConditions.elementToBeClickable(lg.getLogout()));
            lg.getLogout().click();
            logger.info("Tapped on logout in the popup");
            test.info("Tapped on logout in the popup");
            
        } catch (Exception e) {
            logger.error("Unable to perform logout: " + e.getMessage());
            String screenshotPath = getScreenshot(driver, "LogoutFailedScreenshot");
            test.fail("Unable to perform logout: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
		driver.quit();
    }
}
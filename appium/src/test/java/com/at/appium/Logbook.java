package com.at.appium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.BaseClass;
import com.at.screens.LogbookScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Logbook extends Login {

    @BeforeClass
    public void setupClass() throws Exception {
        ensureDriverInitialized(); // Ensure driver is initialized
        super.setupClass(); // Call setupClass from Login to ensure proper initialization
    }

    @Test(priority = 2)
    public void LogbookScreen() throws IOException {
    	ExtentTest test = extent.createTest("Logbook_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

        LogbookScreen lb = new LogbookScreen(driver);
        BaseClass base = new BaseClass();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        try {
            // Wait for the hamburger icon to be clickable and store the reference
            WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));

            // Now tap on the hamburger icon
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon");
            test.info("Tapped on the hamburger icon");

            // Wait and navigate to Logbook
            wait.until(ExpectedConditions.elementToBeClickable(lb.getLogbookElement()));
            lb.navigateToLogbook();
            logger.info("Navigated to Logbook");
            test.pass("Navigated to Logbook");
            Thread.sleep(delay);

            // Navigate back using the back button
            driver.navigate().back(); 
            logger.info("Navigated back using the back button");
            test.info("Navigated back using the back button");

            // Wait for the hamburger icon to be clickable again and store the reference
            hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));

            // Tap on the hamburger icon again
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon again");
            test.info("Tapped on the hamburger icon again");

        } catch (Exception e) {
            test.fail("Unable to navigate to logbook: " + e.getMessage());
            logger.error("Unable to navigate to logbook: " + e.getMessage());
            String screenshotPath = getScreenshot(driver, "LogbookFailedScreenshot");
            test.fail("Unable to navigate to logbook: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}
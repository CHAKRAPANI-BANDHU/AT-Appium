package com.at.appium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.at.screens.BaseClass;
import com.at.screens.ViolationsScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Violations extends DriverProfile {

    @BeforeClass
    public void setupClass() throws Exception {
        ensureDriverInitialized(); // Ensure driver is initialized
        super.setupClass(); // Call setupClass from Login to ensure proper initialization
    }

    @Test(priority = 6)
    public void ViolationsScreen() throws IOException {
        ExtentTest test = extent.createTest("Violations_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

        ViolationsScreen vs = new ViolationsScreen(driver);
        BaseClass base = new BaseClass();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait and tap on the hamburger icon
            WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon");
            test.info("Tapped on the hamburger icon");

            // Wait and navigate to Violations
            wait.until(ExpectedConditions.elementToBeClickable(vs.getViolations()));
            vs.navigateToViolations();
            logger.info("Navigated to Violations");
            test.pass("Navigated to Violations");
            Thread.sleep(delay);

            // Check if there are any violations
            if (vs.getEmptyViolationsMessage().isDisplayed()) {
                String emptyMessage = vs.getViolationsEmptyMessage();
                logger.info("Violations: " + emptyMessage);
                test.pass("Violations: " + emptyMessage);
            } else {
                // Get lists of ruleset names, times, and statuses
                List<WebElement> names = vs.getViolationsRulesetNames();
                List<WebElement> times = vs.getViolationsRulesetTimes();
                List<WebElement> statuses = vs.getViolationsRulesetStatuses();

                // Ensure the lists are of the same size
                if (names.size() == times.size() && names.size() == statuses.size()) {
                    for (int i = 0; i < names.size(); i++) {
                        String name = names.get(i).getText();
                        String time = times.get(i).getText();
                        String status = statuses.get(i).getText();

                        // Log and report the violations details for each index
                        logger.info("Violations " + (i + 1) + ": Name: " + name + ", Time: " + time + ", Status: " + status);
                        test.pass("Violations " + (i + 1) + ": Name: " + name + ", Time: " + time + ", Status: " + status);
                    }
                } else {
                    logger.error("Mismatch in the number of ruleset names, times, or statuses.");
                    test.fail("Mismatch in the number of ruleset names, times, or statuses.");
                }
            }

            // Navigate back using the back button
            driver.navigate().back();
            logger.info("Navigated back using the back button");
            test.info("Navigated back using the back button");

            // Wait and tap on the hamburger icon again
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon again");
            test.info("Tapped on the hamburger icon again");

        } catch (Exception e) {
            test.fail("Unable to navigate to violations: " + e.getMessage());
            logger.error("Unable to navigate to violations: " + e.getMessage());
            String screenshotPath = getScreenshot(driver, "ViolationsFailedScreenshot");
            test.fail("Unable to navigate to violations: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}
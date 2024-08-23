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
import com.at.screens.NotificationsScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Notifications extends Shipments {
    
    @BeforeClass
    public void setupClass() throws Exception {
        ensureDriverInitialized(); // Ensure driver is initialized
        super.setupClass(); // Call setupClass from Login to ensure proper initialization
    }

    @Test(priority = 10)
    public void NotificationsScreen() throws IOException {
        ExtentTest test = extent.createTest("Notifications_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

        NotificationsScreen nf = new NotificationsScreen(driver);
        BaseClass base = new BaseClass();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon");
            test.info("Tapped on the hamburger icon");

            // Wait and navigate to Notifications
            wait.until(ExpectedConditions.elementToBeClickable(nf.getNotificationsScreen()));
            nf.navigateToNotifications();
            logger.info("Navigated to Notifications");
            test.pass("Navigated to Notifications");
            Thread.sleep(delay);
            
            // Check if there are any notifications
            if (nf.getEmptyNotificationsMessage().isDisplayed()) {
                String emptyMessage = nf.getNotificationsEmptyMessage();
                logger.info("Notifications: " + emptyMessage);
                test.pass("Notifications: " + emptyMessage);
            } else {
                // Get lists of subjects and bodies
                List<WebElement> subjectElements = nf.getSubjectElements();
                List<WebElement> bodyElements = nf.getBodyElements();

                // Ensure both subject and body lists are of the same size
                if (subjectElements.size() == bodyElements.size()) {
                    for (int i = 0; i < subjectElements.size(); i++) {
                        // Get the subject text
                        String subjectText = subjectElements.get(i).getText();

                        // Get the body text
                        String bodyText = bodyElements.get(i).getText();

                        // Log the subject and body text for each index
                        logger.info("Index " + (i + 1));
                        logger.info("  Subject: " + subjectText);
                        logger.info("  Body: " + bodyText);

                        test.pass("Notification " + (i + 1) + ": Subject: " + subjectText + ", Body: " + bodyText);
                    }
                } else {
                    logger.error("The number of subjects and bodies do not match.");
                    test.fail("The number of subjects and bodies do not match.");
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
            test.fail("Unable to navigate to notifications: " + e.getMessage());
            logger.error("Unable to navigate to notifications: " + e.getMessage());
            String screenshotPath = getScreenshot(driver, "NotificationsFailedScreenshot");
            test.fail("Unable to navigate to notifications: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}

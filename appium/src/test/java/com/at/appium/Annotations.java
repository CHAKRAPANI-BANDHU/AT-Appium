package com.at.appium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.at.screens.AnnotationsScreen;
import com.at.screens.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Annotations extends Violations {

    @BeforeClass
    public void setupClass() throws Exception {
        ensureDriverInitialized(); // Ensure driver is initialized
        super.setupClass(); // Call setupClass from Login to ensure proper initialization
    }

    @Test(priority = 7)
    public void AnnotationScreen() throws IOException {
        ExtentTest test = extent.createTest("Annotations_Testcases").assignAuthor("QA_Wenable").assignDevice("Android");

        AnnotationsScreen as = new AnnotationsScreen(driver);
        BaseClass base = new BaseClass();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement hamburgerIcon = wait.until(ExpectedConditions.elementToBeClickable(base.tapHamburgerIcon()));
            hamburgerIcon.click();
            logger.info("Tapped on the hamburger icon");
            test.info("Tapped on the hamburger icon");

            // Wait and navigate to Annotations
            WebElement annotations = wait.until(ExpectedConditions.elementToBeClickable(as.getAnnotations()));
            annotations.click();
            logger.info("Navigated to Annotations");
            test.pass("Navigated to Annotations");

            // Wait for annotations to load
            WebElement emptyAnnotationsMessage = null;
            try {
                emptyAnnotationsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(as.getAnnotationsEmptyMessageLocator()));
            } catch (Exception e) {
                // Element not found, proceed to check for annotations
                emptyAnnotationsMessage = null;
            }

            if (emptyAnnotationsMessage != null && emptyAnnotationsMessage.isDisplayed()) {
                String emptyMessage = emptyAnnotationsMessage.getText();
                logger.info("Annotations: " + emptyMessage);
                test.pass("Annotations: " + emptyMessage);
            } else {
                // Get lists of subjects and bodies
                List<WebElement> subjectElements = as.getSubjectElements();
                List<WebElement> bodyElements = as.getBodyElements();

                // Ensure both subject and body lists are of the same size
                if (subjectElements.size() == bodyElements.size()) {
                    for (int i = 0; i < subjectElements.size(); i++) {
                        // Get the subject and body text
                        String subjectText = subjectElements.get(i).getText();
                        String bodyText = bodyElements.get(i).getText();

                        // Log the subject and body text for each annotation
                        String annotationText = "Annotations " + (i + 1) + " ===> " + subjectText + " | " + bodyText;
                        logger.info(annotationText);
                        test.pass(annotationText);
                    }
                } else {
                    logger.error("The number of subjects and bodies do not match.");
                    test.fail("The number of subjects and bodies do not match.");
                }
            }
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
            test.fail("Unable to navigate to annotations: " + e.getMessage());
            logger.error("Unable to navigate to annotations: " + e.getMessage());
            String screenshotPath = getScreenshot(driver, "AnnotationsFailedScreenshot");
            test.fail("Unable to navigate to annotations: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}
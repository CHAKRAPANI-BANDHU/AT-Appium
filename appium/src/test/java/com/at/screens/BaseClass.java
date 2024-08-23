package com.at.screens;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
    public SoftAssert softAssert = new SoftAssert();
    private String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(new Date());
    private String reportName = "./ExtentReports/QA_Test_Report-" + timestamp + ".html";
    protected ExtentReports extent;
    protected ExtentSparkReporter spark;
    protected static Logger logger;
    protected static AndroidDriver driver; // Ensure driver is static to persist across classes
    private String screenRecordPath;

    @BeforeSuite
    public void setup() throws Exception { 
        logger = LogManager.getLogger(BaseClass.class);

        // Initialize ExtentReports
        extent = new ExtentReports();
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Reporter", "Chakrapani Bandhu");
        extent.setSystemInfo("Designation", "Quality Assurance Engineer");

        spark = new ExtentSparkReporter(reportName);
        spark.config().setDocumentTitle("Assured Techmatics Appium Automation Test Report");
        spark.config().setReportName("QA Test Report");
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);

        ensureDriverInitialized(); // Ensure driver is initialized before any test
    }

    public void initializeDriver() throws Exception {
        if (driver == null) { // Initialize driver only if it's null
          	DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("deviceName", "BS6533S4JM0322003286");
            dc.setCapability("platformName", "android");
            dc.setCapability("platformVersion", "11");
            dc.setCapability("appPackage", "td.HoursOfService");
            dc.setCapability("appActivity", "apollo.hos.LoginActivity");

            URI uri = new URI("http://127.0.0.1:4723/wd/hub");
            URL url=uri.toURL();

            driver = new AndroidDriver(url, dc);

            if (driver != null) {
                startScreenRecording();
            } else {
                logger.error("Driver initialization failed.");
                throw new RuntimeException("Driver is null after initialization.");
            }
        }
    }

    public void ensureDriverInitialized() {
        if (driver == null) {
            try {
                initializeDriver();
            } catch (Exception e) {
                logger.error("Failed to initialize driver: " + e.getMessage(), e);
                throw new RuntimeException("Failed to initialize driver: " + e.getMessage(), e);
            }
        }
    }

    public String getScreenshot(AndroidDriver driver, String screenshotName) throws IOException {
        if (driver == null) {
            logger.error("Cannot take screenshot as driver is null.");
            throw new RuntimeException("Driver is null. Screenshot capture failed.");
        }
        String dateName = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Failed_Screenshots/" + screenshotName + dateName + ".png";

        File screenshotDir = new File(System.getProperty("user.dir") + "/Failed_Screenshots/");
        if (!screenshotDir.exists()) {
            if (!screenshotDir.mkdirs()) {
                logger.error("Failed to create directory for screenshots.");
            }
        }

        FileUtils.copyFile(source, new File(destination));
        return destination;
    }

    public void startScreenRecording() {
        if (driver == null) {
            logger.error("Cannot start screen recording as driver is null.");
            return;
        }

        screenRecordPath = System.getProperty("user.dir") + "/ScreenRecordings/";
        File screenRecordDir = new File(screenRecordPath);
        if (!screenRecordDir.exists()) {
            if (!screenRecordDir.mkdirs()) {
                logger.error("Failed to create directory for screen recordings.");
            }
        }

        driver.startRecordingScreen();
    }

    public void stopScreenRecording(String testName) throws IOException {
        if (driver == null) {
            logger.error("Cannot stop screen recording as driver is null.");
            return;
        }

        String media = driver.stopRecordingScreen();
        byte[] decodedMedia = Base64.getDecoder().decode(media);

        String dateName = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(new Date());
        String filePath = screenRecordPath + testName + "_" + dateName + ".mp4";
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(decodedMedia);
        } catch (IOException e) {
            logger.error("Error writing screen recording to file: " + e.getMessage(), e);
            throw e;
        }

        System.out.println("Screen recording saved at: " + filePath);
    }

    @AfterSuite
    public void tearDown() { // Changed from @AfterClass to @AfterSuite
        try {
            if (driver != null) {
                stopScreenRecording("Appium_Report");
            }
        } catch (Exception e) {
            logger.error("Exception while stopping screen recording: " + e.getMessage(), e);
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null; // Set driver to null to clean up the static instance
            }
        }
        extent.flush(); // Make sure to flush the ExtentReports at the end of the suite
    }

    public WebElement tapHamburgerIcon() {
        ensureDriverInitialized(); // Ensure driver is initialized before use

        if (driver == null) {
            logger.error("Cannot tap hamburger icon as driver is null.");
            throw new RuntimeException("Driver is null. Cannot interact with elements.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait for the element to be visible and clickable
            WebElement hamburgerIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Hours Of Service\"]")));
            wait.until(ExpectedConditions.elementToBeClickable(hamburgerIcon));
            
            // Log if the element is found and clickable
            if (hamburgerIcon.isDisplayed()) {
                logger.info("Hamburger icon is visible and clickable.");
            } else {
                logger.warn("Hamburger icon is not visible.");
            }

            // Tap on the hamburger icon
            hamburgerIcon.click();
            return hamburgerIcon;
        } catch (Exception e) {
            logger.error("Error while trying to tap the hamburger icon: " + e.getMessage(), e);
            throw e; // Re-throw the exception to handle it in the calling method
        }
    }
}

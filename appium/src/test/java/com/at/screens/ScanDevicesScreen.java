package com.at.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScanDevicesScreen {
    private AndroidDriver driver;

    public ScanDevicesScreen(WebDriver ddriver) {
        this.driver = (AndroidDriver) ddriver;  // Cast the WebDriver to AndroidDriver
        PageFactory.initElements(ddriver, this);
    }

    // Tap on the Scan Devices on the left navigation bar
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='td.HoursOfService:id/design_menu_item_text' and @text='Scan Devices']")
    WebElement scanDevicesElement;

    public WebElement getScanDevices() {
        return scanDevicesElement;
    }

    public void navigateToScanDevices() {
        scrollAndClick("Scan Devices");
    }
    
    public void scrollAndClick(String visibleText) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
            + "new UiSelector().textContains(\"" + visibleText + "\"))"
        )).click();
    }
}
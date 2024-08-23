package com.at.screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogoutScreen {
    AndroidDriver rdriver;
    WebDriver lgdriver;
    WebDriver driver;

    public LogoutScreen(WebDriver ddriver) {
        // Cast WebDriver to AndroidDriver
        lgdriver = rdriver;
        PageFactory.initElements(new AppiumFieldDecorator(lgdriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Logout\"]")
    WebElement LogoutButton;

    @AndroidFindBy(id = "android:id/button1")
    WebElement Logout;

    public void tapLogoutButton() {
        // Check if Logout button is visible
        if (LogoutButton.isDisplayed()) {
            LogoutButton.click();
        } else {
            // Use JavascriptExecutor to scroll until Logout button is visible
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", LogoutButton);
            LogoutButton.click();
        }
        }

    public WebElement getLogoutButton() {
        return LogoutButton;
    }

    public WebElement getLogout() {
        return Logout;
    }

    public void Logout() {
        Logout.click();
    }
}
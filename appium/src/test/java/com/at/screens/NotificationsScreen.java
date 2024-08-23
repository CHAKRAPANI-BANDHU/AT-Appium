package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotificationsScreen {
    WebDriver nfdriver;

    public NotificationsScreen(WebDriver ddriver) {
        nfdriver = ddriver;
        PageFactory.initElements(ddriver, this);
    }

    // Tap on the Notifications on the left navigation bar
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Notifications\"]")
    WebElement NotificationsScreen;
    
    // Get notifications information if it is empty
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tv_empty_view']")
    WebElement EmptyNotifications;
    
    // Get list of notification subjects
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvSubject']")
    List<WebElement> NotificationSubjectElements;

    // Get list of notification bodies
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvBody']")
    List<WebElement> NotificationsBodyElements;

    public WebElement getNotificationsScreen() {
        return NotificationsScreen;
    }

    public void navigateToNotifications() {
        getNotificationsScreen().click();
    }

    public WebElement getEmptyNotificationsMessage() {
        return EmptyNotifications;
    }

    public String getNotificationsEmptyMessage() {
        return EmptyNotifications.getText();
    }

    public List<WebElement> getSubjectElements() {
        return NotificationSubjectElements;
    }

    public List<WebElement> getBodyElements() {
        return NotificationsBodyElements;
    }
}

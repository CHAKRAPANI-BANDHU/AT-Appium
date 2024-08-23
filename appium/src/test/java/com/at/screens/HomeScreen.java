package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomeScreen {
    AndroidDriver rdriver;
    WebDriver hsdriver;
    WebDriver driver;

	public HomeScreen(WebDriver ddriver) {
		hsdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Home on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Home\"]")
	WebElement HomeScreen;

	// Inside your Home class
	public WebElement getHome() {
		return HomeScreen; 
	}

	public void navigateToHome() {
		getHome().click();
	}
}

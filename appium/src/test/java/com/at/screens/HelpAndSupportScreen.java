package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpAndSupportScreen {
	WebDriver hsdriver;

	public HelpAndSupportScreen(WebDriver ddriver) {
		hsdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Help and Support on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Help and Support\"]")
	WebElement HelpAndSupportScreen;

	// Inside your Help and Support class
	public WebElement getHelpAndSupportScreen() {
		return HelpAndSupportScreen;
	}

	public void navigateToHelpAndSupport() {
		getHelpAndSupportScreen().click();
	}
}
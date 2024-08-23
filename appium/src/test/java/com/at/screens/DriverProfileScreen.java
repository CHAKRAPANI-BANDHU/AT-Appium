package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverProfileScreen {
	WebDriver dpdriver;

	public DriverProfileScreen(WebDriver ddriver) {
		dpdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Driver Profile on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Driver Profile\"]")
	WebElement DriverProfileScreen;

	// Inside your Driver Profile class
	public WebElement getDriverProfileScreen() {
		return DriverProfileScreen;
	}

	public void navigateToDriverProfile() {
		getDriverProfileScreen().click();
	}
}

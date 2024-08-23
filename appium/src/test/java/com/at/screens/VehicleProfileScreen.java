package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleProfileScreen {
	WebDriver vpdriver;

	public VehicleProfileScreen(WebDriver ddriver) {
		vpdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Vehicle Profile on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Vehicle Profile\"]")
	WebElement VehicleProfileScreen;

	// Inside your Vehicle Profile class
	public WebElement getVehicleProfileScreen() {
		return VehicleProfileScreen;
	}

	public void navigateToVehicleProfile() {
		getVehicleProfileScreen().click();
	}
}

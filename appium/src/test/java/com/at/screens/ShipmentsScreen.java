package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentsScreen {
	WebDriver spdriver;

	public ShipmentsScreen(WebDriver ddriver) {
		spdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Shipments on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Shipments\"]")
	WebElement ShipmentsScreen;

	// Inside your Shipments class
	public WebElement getShipments() {
		return ShipmentsScreen;
	}

	public void navigateToShipments() {
		getShipments().click();
	}
}

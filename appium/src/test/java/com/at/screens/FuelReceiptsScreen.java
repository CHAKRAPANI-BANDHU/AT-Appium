package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuelReceiptsScreen {
	WebDriver frdriver;

	public FuelReceiptsScreen(WebDriver ddriver) {
		frdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Fuel Receipts on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Fuel Receipts\"]")
	WebElement FuelReceiptsScreen;

	// Inside your Fuel Receipts class
	public WebElement getFuelReceipts() {
		return FuelReceiptsScreen;
	}

	public void navigateToFuelReceipts() {
		getFuelReceipts().click();
	}
}
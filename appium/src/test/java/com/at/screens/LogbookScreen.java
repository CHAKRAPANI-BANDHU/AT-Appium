package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogbookScreen {
	WebDriver lbdriver;

	public LogbookScreen(WebDriver ddriver) {
		lbdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}
	
	// Tap on the Logbook on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Logbook\"]")
	WebElement Logbook;

	// Inside your Logbook class
	public WebElement getLogbookElement() {
		return Logbook; // Replace with the actual locator
	}

	public void navigateToLogbook() {
		getLogbookElement().click();
	}
}

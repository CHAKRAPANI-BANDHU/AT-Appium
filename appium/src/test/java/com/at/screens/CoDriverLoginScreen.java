package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoDriverLoginScreen {
	WebDriver cdldriver;

	public CoDriverLoginScreen(WebDriver ddriver) {
		cdldriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the CoDriver Login on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"CoDriver Login\"]")
	WebElement CoDriverLoginScreen;

	// Inside your CoDriver Login class
	public WebElement getCoDriverLoginScreen() {
		return CoDriverLoginScreen;
	}

	public void navigateToCoDriverLogin() {
		getCoDriverLoginScreen().click();
	}
}
package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutELDScreen {
	WebDriver abdriver;

	public AboutELDScreen(WebDriver ddriver) {
		abdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the About ELD on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"About ELD\"]")
	WebElement AboutELDScreen;

	// Inside your About ELD class
	public WebElement getAboutELD() {
		return AboutELDScreen;
	}

	public void navigateToAboutELD() {
		getAboutELD().click();
	}
}

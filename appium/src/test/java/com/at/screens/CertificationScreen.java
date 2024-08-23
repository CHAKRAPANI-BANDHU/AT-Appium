package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificationScreen {
	WebDriver ctdriver;

	public CertificationScreen(WebDriver ddriver) {
		ctdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Certification on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Certification\"]")
	WebElement CertificationScreen;

	// Inside your Fuel Receipts class
	public WebElement getCertificationScreen() {
		return CertificationScreen;
	}

	public void navigateToCertification() {
		getCertificationScreen().click();
	}
}
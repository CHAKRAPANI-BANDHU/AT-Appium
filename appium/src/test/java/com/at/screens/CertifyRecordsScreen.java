package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertifyRecordsScreen {
	WebDriver crdriver;

	public CertifyRecordsScreen(WebDriver ddriver) {
		crdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the certify records on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Certify Records\"]")
	WebElement CertifyRecordsScreen;

	// Inside your Home class
	public WebElement getCertifyRecords() {
		return CertifyRecordsScreen;
	}

	public void navigateToCertifyRecords() {
		getCertifyRecords().click();
	}
}
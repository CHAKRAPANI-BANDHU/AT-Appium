package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsScreen {
	WebDriver dcdriver;

	public DocumentsScreen(WebDriver ddriver) {
		dcdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Documents on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Documents\"]")
	WebElement DocumentsScreen;

	// Inside your Documents class
	public WebElement getDocuments() {
		return DocumentsScreen;
	}

	public void navigateToDocuments() {
		getDocuments().click();
	}
}
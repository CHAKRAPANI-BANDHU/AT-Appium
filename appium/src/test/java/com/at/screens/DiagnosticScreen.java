package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiagnosticScreen {
	WebDriver dgdriver;

	public DiagnosticScreen(WebDriver ddriver) {
		dgdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Diagnostic on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Diagnostic\"]")
	WebElement DiagnosticScreen;

	// Inside your Fuel Receipts class
	public WebElement getDiagnosticScreen() {
		return DiagnosticScreen;
	}

	public void navigateToDiagnostic() {
		getDiagnosticScreen().click();
	}
}
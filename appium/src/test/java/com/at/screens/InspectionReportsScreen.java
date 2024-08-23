package com.at.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InspectionReportsScreen {
	WebDriver irdriver;

	public InspectionReportsScreen(WebDriver ddriver) {
		irdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Inspection Reports on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Inspection reports\"]")
	WebElement InspectionReportsScreen;

	// Inside your Inspection Reports class
	public WebElement getInspectionReports() {
		return InspectionReportsScreen;
	}

	public void navigateToInspectionReports() {
		getInspectionReports().click();
	}
}
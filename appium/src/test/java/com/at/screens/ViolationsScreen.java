package com.at.screens;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViolationsScreen {
	WebDriver vsdriver;

	public ViolationsScreen(WebDriver ddriver) {
		vsdriver = ddriver;
		PageFactory.initElements(ddriver, this);
	}

	// Tap on the Violations on the left navigation bar
	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Violations\"]")
	WebElement ViolationsScreen;

	// Get violations information if it is empty
	@FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tv_empty_view']")
	WebElement EmptyViolations;

	// Get violations ruleset information
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"td.HoursOfService:id/tvNameRuleSet\"])[1]")
	List<WebElement> ViolationsRulesetName;

	// Get violations ruleset time
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"td.HoursOfService:id/tvStartTime\"])[1]")
	List<WebElement> ViolationsRulesetTime;

	// Get violations ruleset status
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"td.HoursOfService:id/tvLastStatus\"])[1]")
	List<WebElement> ViolationsRulesetStatus;

	// Get violations ruleset time information
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"td.HoursOfService:id/textView2\" and @text=\"2024-08-25 05:38:54 AM (EDT)\"]")
	WebElement ViolationsRulesetTimeInfo;

	// Inside your Violations class
	public WebElement getViolations() {
		return ViolationsScreen;
	}

	public void navigateToViolations() {
		getViolations().click();
	}
	
	public WebElement getEmptyViolationsMessage() {
		return EmptyViolations;
	}

	public String getViolationsEmptyMessage() {
		return EmptyViolations.getText();
	}

	public List<WebElement> getViolationsRulesetNames() {
		return ViolationsRulesetName;
	}

	public List<WebElement> getViolationsRulesetTimes() {
		return ViolationsRulesetTime;
	}

	public List<WebElement> getViolationsRulesetStatuses() {
		return ViolationsRulesetStatus;
	}
}

package com.at.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnotationsScreen {
    WebDriver asdriver;

    public AnnotationsScreen(WebDriver ddriver) {
        asdriver = ddriver;
        PageFactory.initElements(ddriver, this);
    }

    // Tap on the Annotations on the left navigation bar
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"td.HoursOfService:id/design_menu_item_text\" and @text=\"Annotations\"]")
    WebElement AnnotationsScreen;

    // Get annotations information if it is empty
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tv_empty_view']")
    WebElement EmptyAnnotations;
    
    // Get list of annotations subjects
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/textView3']")
    List<WebElement> AnnotationsSubjectElements;

    // Get list of annotations bodies
    @FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvText']")
    List<WebElement> AnnotationsBodyElements;

    public WebElement getAnnotations() {
        return AnnotationsScreen;
    }

    public void navigateToAnnotations() {
        getAnnotations().click();
    }

    public By getAnnotationsEmptyMessageLocator() {
        return By.xpath("//android.widget.TextView[@resource-id='td.HoursOfService:id/tv_empty_view']");
    }

    public List<WebElement> getSubjectElements() {
        return AnnotationsSubjectElements;
    }

    public List<WebElement> getBodyElements() {
        return AnnotationsBodyElements;
    }
}
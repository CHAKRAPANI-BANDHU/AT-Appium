package com.at.screens;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class LoginScreen {
	WebDriver lsdriver;
    WebDriver driver;
	private Set<Integer> usedNumbers = new HashSet<>();
	private static final int MAX_ODOMETER_VALUE = 999999; // Adjust as per realistic limits

	public LoginScreen(WebDriver rdriver) {
		lsdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Get Environment details
	@FindBy(id = "td.HoursOfService:id/tv_env")
	WebElement Environment;

	// Get app version
	@FindBy(id = "td.HoursOfService:id/tv_app_version")
	WebElement AppVersion;

	// Enter the username
	@FindBy(id = "etUser")
	WebElement userIdInput;

	// Enter the password
	@FindBy(id = "etPass")
	WebElement passwordInput;

	// Tap on the login button
	@FindBy(id = "btnLogin")
	WebElement loginButton;

	// Tap on the agree button
	// @FindBy(id ="td.HoursOfService:id/btnAgree")
	@FindBy(id = "btnAgree")
	WebElement agreeButton;

	// Tap on the while using the app location permission
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	WebElement whileUsingAppLocationPermission;

	// Tap on the allow for media permission
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement allowMediaPermission;

	// Tap on the alway allow location permission
	@FindBy(id = "com.android.permissioncontroller:id/allow_always_radio_button")
	WebElement allowAllTimeLocationPermission;

	// Tap on the app in settings for display over other app permissions
	@FindBy(id = "//android.widget.LinearLayout[@content-desc=\"ELD Test\"]/android.widget.LinearLayout[2]")
	WebElement displayOverOtherApp;

	// Tap on the toggle in settings to enable display over other app permissions
	@FindBy(id = "android:id/switch_widget")
	WebElement enableOverOtherAppPermission;

	// Tap on the configure button
	@FindBy(id = "android:id/button1")
	WebElement configureButton;

	// Tap on the ok button
	@FindBy(id = "android:id/button1")
	WebElement okButton;

////	// Tap on the back arrow icon in settings while enabling the permission
//	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Back' or @content-desc='Navigate up']")
//	List<WebElement> backArrowIcons;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")
	WebElement backArrowIcon;
	
	// Tap on the back arrow icon in settings while enabling the permission
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement backArrowIcon2;

	// Select a tractor when tractor is not selected
	@FindBy(xpath = "//android.widget.TextView[@text=\"Tractor Information:\"]")
	public WebElement tractorInformationIsNull;

	// Select a tractor
	@FindBy(id = "td.HoursOfService:id/ivTractor")
	WebElement selectTractor;

	// Tap on All tab in select tractor
	@FindBy(id = "td.HoursOfService:id/btnAll")
	WebElement selectAll;

	// Select a tractor from list
	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"td.HoursOfService:id/llContainerRadioButton\"])[1]")
	WebElement Tractor;

	// Enter the odometer value
	@FindBy(id = "td.HoursOfService:id/etVisualOdometer")
	public WebElement Odometer;

	// Select a trailer
	@FindBy(id = "td.HoursOfService:id/ivTrailer")
	WebElement selectTrailer;

	// Select a trailer from list
	@FindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"td.HoursOfService:id/item_draft_instance_layout\"])[1]")
	WebElement Trailer;

	// Select a trailer when trailer is not selected
	@FindBy(xpath = "//android.widget.TextView[@text=\"Trailer Information:\"]")
	public WebElement trailerInformationIsNull;

	// Enter the confirmation odometer value
	@FindBy(id = "td.HoursOfService:id/etVisualOdometerConfirmation")
	public WebElement confirmationOdometer;

	// Tap on save button after selecting a tractor and trailer
	@FindBy(id = "td.HoursOfService:id/btnSave")
	public WebElement saveTractorTrailer;

	// Tap on back button at the bottom
	@FindBy(id = "td.HoursOfService:id/btnBack")
	public WebElement backButton;

	// Tap on save button at the bottom
	@FindBy(id = "td.HoursOfService:id/btnSave")
	public WebElement SaveButton;

	// Tap on scan devices in ECM Linked Devices screen
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"td.HoursOfService:id/btnScan\"]")
	public WebElement scanDevices;

	// ECM Device is not available
	@FindBy(id = "td.HoursOfService:id/rvDevices")
	public WebElement ECMDeviceNotAvailable;

	// ECM Device is available
	@FindBy(id = "td.HoursOfService:id/clContainer")
	public WebElement ECMDeviceIsAvailable;

	// Tap on the continue button in ECM Linked Devices screen
	@FindBy(id = "td.HoursOfService:id/btnContinue")
	public WebElement continueButton;

	// Tap on Run ELD Diagnostic in Diagnostic
	@FindBy(id = "td.HoursOfService:id/btnTest")
	public WebElement runELDDiagnostic;

	// Dashboard in Diagnostic
	@FindBy(id = "td.HoursOfService:id/viewDashboard")
	public WebElement Dashboard;

	// Speed in dashboard
	@FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvSpeed']")
	public WebElement speedInDashboard;

	// RPM in dashboard
	@FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvRpm']")
	public WebElement rpmInDashboard;

	// Engine state in dashboard
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='td.HoursOfService:id/ivEngineState']")
	public WebElement engineStateInDashboard;

	// Engine in dashboard
	@FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvEngine']")
	public WebElement engineInDashboard;

	// Odometer in dashboard
	@FindBy(xpath = "//android.widget.TextView[@resource-id='td.HoursOfService:id/tvOdometer']")
	public WebElement odometerInDashboard;

	// Hours Of Service screen (Home)
	@FindBy(xpath = "//android.widget.TextView[@text=\"Hours Of Service\"]")
	public WebElement HoursOfService;

	public void tapAgreeButton() {
		agreeButton.click();
	}

	public void setUserId(String uid) {
		userIdInput.sendKeys(uid);
	}

	public void setPassword(String pwd) {
		passwordInput.sendKeys(pwd);
	}

	public void tapLoginButton() {
		loginButton.click();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUserIdInput() {
		return userIdInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getWhileUsingAppLocationPermission() {
		return whileUsingAppLocationPermission;
	}

	public void tapWhileUsingAppLocationPermission() {
		whileUsingAppLocationPermission.click();
	}

	public WebElement getAllowMediaPermission() {
		return allowMediaPermission;
	}

	public void tapAllowMediaPermission() {
		allowMediaPermission.click();
	}

	public WebElement getAllowAllTimeLocationPermission() {
		return allowAllTimeLocationPermission;
	}

	public void tapAllowAllTimeLocationPermission() {
		allowAllTimeLocationPermission.click();
	}

	public void navigateToSettingsForELDTestApp() {
		displayOverOtherApp.click();
	}

	public WebElement enableOverOtherAppsPermissions() {
		return displayOverOtherApp;
	}

	public void enableOverOtherAppsPermission() {
		enableOverOtherAppPermission.click();
	}

	private boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void handleOverlayPermissionsInSettings() {
		// Handle Agree button
		if (isElementDisplayed(agreeButton)) {
			tapAgreeButton();
		}

		// Handle permissions
		tapAllowAllTimeLocationPermission();

		// Navigate to settings and enable the toggle
		navigateToSettingsForELDTestApp();
		enableOverOtherAppsPermission();

		// Tap back button twice
		tapBackArrowIcon();
		tapBackArrowIcon();
	}

	public WebElement getConfigureButton() {
		return configureButton;
	}

	public void tapConfigureButton() {
		configureButton.click();
	}

	public WebElement getOKButton() {
		return okButton;
	}

	public void tapOKButton() {
		okButton.click();
	}

	public WebElement getEnvironmentInfo() {
		return Environment;
	}

	public WebElement getAppVersionInfo() {
		return AppVersion;
	}

	public String getEnvironment() {
		return Environment.getText();
	}

	public String getAppVersion() {
		return AppVersion.getText();
	}

	public void tapBackArrowIcon() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        // First check if the backArrowIcon is displayed and clickable
	        if (isElementDisplayed(backArrowIcon)) {
	            WebElement clickableBackArrowIcon = wait.until(ExpectedConditions.elementToBeClickable(backArrowIcon));
	            clickableBackArrowIcon.click();
	        }
	        // Then check if the backArrowIcon2 is displayed and clickable
	        else if (isElementDisplayed(backArrowIcon2)) {
	            WebElement clickableBackArrowIcon2 = wait.until(ExpectedConditions.elementToBeClickable(backArrowIcon2));
	            clickableBackArrowIcon2.click();
	        } else {
	            System.out.println("Unable to find back arrow icon, both locators failed");
	        }
	    } catch (Exception e) {
	        System.out.println("Unable to find back arrow icon: " + e.getMessage());
	    }
	}

	
	public boolean isTractorInformationDisplayed() {
		return tractorInformationIsNull.isDisplayed();
	}

	public void SelectTractor() {
		selectTractor.click();
	}

	public void SelectAll() {

		selectAll.click();
	}

	public void Tractor() {
		Tractor.click();
	}

	public void SaveTractorTrailer() {
		saveTractorTrailer.click();
	}

	public String enterUniqueOdometer() {
		Odometer.click();
		String uniqueValue = generateUniqueOdometerValue();
		Odometer.sendKeys(uniqueValue);
		confirmationOdometer.sendKeys(uniqueValue);
		return uniqueValue; // Return the generated odometer value
	}

	public boolean isTrailerInformationDisplayed() {
		return trailerInformationIsNull.isDisplayed();
	}

	public void SelectTrailer() {
		selectTrailer.click();
	}

	public void Trailer() {
		Trailer.click();
	}

	private String generateUniqueOdometerValue() {
		Random random = new Random();
		int value;
		do {
			value = random.nextInt(MAX_ODOMETER_VALUE + 1); // Ensures the value is within range
		} while (usedNumbers.contains(value));
		usedNumbers.add(value);
		return String.valueOf(value);
	}

	public void backButton() {
		backButton.click();
	}

	public void saveButton() {
		SaveButton.click();
	}

	public boolean isECMDeviceNotAvailable() {
		try {
			return ECMDeviceNotAvailable.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isECMDeviceAvailable() {
		try {
			return ECMDeviceIsAvailable.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void tapECMDeviceAvailable() {
		ECMDeviceIsAvailable.click();
	}

	public void ScanDevices() {
		scanDevices.click();
	}

	public void ContinueButton() {
		continueButton.click();
	}

	public void ELDDiagnostic() {
		runELDDiagnostic.click();
	}

	public void dashboard() {
		Dashboard.click();
	}

	// Method to get Speed
	public String getSpeed() {
		String Speed = speedInDashboard.getText();
		return Speed;
	}

	// Method to get RPM
	public String getRPM() {
		String RPM = speedInDashboard.getText();
		return RPM;
	}

	// Method to get Engine State
	public String getEngineState() {
		String Speed = engineStateInDashboard.getText();
		return Speed;
	}

	// Method to get Engine
	public String getEngine() {
		String Engine = engineInDashboard.getText();
		return Engine;
	}

	// Method to get Odometer
	public String getOdometer() {
		String Odometer = odometerInDashboard.getText();
		return Odometer;
	}

	public DashboardInformation getDashboardInformation() {
		return new DashboardInformation(getSpeed(), getRPM(), getEngineState(), getEngine(), getOdometer());
	}

	public static class DashboardInformation {
		private String speed;
		private String rpm;
		private String engineState;
		private String engine;
		private String odometer;

		public DashboardInformation(String speed, String rpm, String engineState, String engine, String odometer) {
			this.speed = speed;
			this.rpm = rpm;
			this.engineState = engineState;
			this.engine = engine;
			this.odometer = odometer;
		}

		public String getSpeed() {
			return speed;
		}

		public String getRPM() {
			return rpm;
		}

		public String getEngineState() {
			return engineState;
		}

		public String getEngine() {
			return engine;
		}

		public String getOdometer() {
			return odometer;
		}
	}
}

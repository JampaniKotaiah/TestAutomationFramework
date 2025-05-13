package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v130.audits.model.BlockedByResponseIssueDetails;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility{
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.name("processAddress");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public ShippmentPage goToShippementPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ShippmentPage(getDriver());
	}

}

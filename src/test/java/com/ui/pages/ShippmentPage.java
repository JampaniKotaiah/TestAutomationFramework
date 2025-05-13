package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage extends BrowserUtility{
	
	private static final By TERMS_OF_SERICES_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT = By.name("processCarrier");

	public ShippmentPage(WebDriver driver) {
		super(driver);
	}
	
	public PaymentPage chosePaymentMethod() {
		scrollDownScreen();
		clickOn(TERMS_OF_SERICES_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT);
		return new PaymentPage(getDriver());
	}
	
	

}

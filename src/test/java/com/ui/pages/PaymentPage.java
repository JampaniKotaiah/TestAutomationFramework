package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	
	private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.xpath("//p[contains(@class,'cart_navigation')]/button");
	private static final By SUCESS_MESSAGE = By.xpath("//p[contains(@class,'alert-success')]");
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public String orderConfirmation() {
		
		clickOn(PAY_BY_BANK_WIRE_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return getVisibleText(SUCESS_MESSAGE);
		
	}

}

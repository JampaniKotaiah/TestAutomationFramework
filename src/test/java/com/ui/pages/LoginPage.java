package com.ui.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT = By.id("email");
	private static final By PASSWORD_TEXT = By.id("passwd");
	private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
	private static final By ERROR_MSG_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String email, String password) {

		enterText(EMAIL_TEXT, email);
		enterText(PASSWORD_TEXT, password);
		clickOn(SIGN_IN_BUTTON);
		
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	public LoginPage doLoginWithInvalidCredentials(String email,String password) {
		
		enterText(EMAIL_TEXT,email);
		enterText(PASSWORD_TEXT,password);
		clickOn(SIGN_IN_BUTTON);
		
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}
	
	public String getErrorMessage() {
		
		return getVisibleText(ERROR_MSG_LOCATOR);
	}

}

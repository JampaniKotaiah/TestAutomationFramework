package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtility.*;

public final class HomePage extends BrowserUtility{
	
	private static final By SIGN_IN_LINK =  By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(readProperty(QA,"URL"));
//		goToWebsite(JSONUtility.readJSON(QA)); Json file 
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(readProperty(QA,"URL"));
	}

	public LoginPage goToLoginPage() {
		
		clickOn(SIGN_IN_LINK);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}



}

package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pojo.Users;
import com.utility.LoggerUtlity;


@Listeners({com.ui.listeners.TestListener.class})
public class InvalidCredLoginTest extends TestBase {
	
	private static final String INVALID_EMAIL_ADDRESS = "jampani.kotaiah@gmail.com";
	private static final String INVALID_PASSWORD = "password1234";

	@Test(description = "Verify if the proper error message i shown for the user when they enter invalid credentials",groups = {"e2e","sanity"})
	public void loginExcelTest() {

	assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD ).getErrorMessage(),"Authentication failed.");
 
	}

}

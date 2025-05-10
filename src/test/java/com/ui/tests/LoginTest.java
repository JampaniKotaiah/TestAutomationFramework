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
public class LoginTest extends TestBase {

//	@Test(description = "Verify with valid user is able to login into the application",groups = {"e2e","sanity"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
//	public void loginTest(Users user) {
//
//	assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Some Name");
//
//	}
	
	
	@Test(description = "Verify with valid user is able to login into the application",groups = {"e2e","sanity"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(Users user) {

	assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Some Name");
 
	}

}

package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.*;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Users;
import com.utility.LoggerUtlity;


@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";
	
	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		
		myAccountPage = homePage.goToLoginPage().doLoginWith("dadege5046@owlny.com", "password");
	}
	
	
	@Test(description ="Verify if the logged in user is able to search for a product and correct products search result are displayed",
			groups = {"e2e","sanity"})
	public void verifyProductSearchTest() {
		
		boolean actualResult = myAccountPage.searchforProduct(SEARCH_TERM).isSearchTermProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}

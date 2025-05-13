package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	private static final String PAYMENT_SUCESS_MESSAGE = "Your order on My Shop is complete.";

	private SearchResultPage searchResultpage;
	
	@BeforeMethod(description = "User logs into the application and searches for a product")
	public void setup() {
		
		searchResultpage = homePage.goToLoginPage().doLoginWith("dadege5046@owlny.com","Password").searchforProduct(SEARCH_TERM); 
	}
	
	
	@Test(description="verify if the logged in User is able to buy  a address", groups={"e2e", "sanity"})
	public void checkOutTest() {
		
		String result = searchResultpage.clickOnTheProductIndex(0).changeSize(L).addProductToCard().proceedToCheckOut().goToConfirmAddressPage()
		.goToShippementPage().chosePaymentMethod().orderConfirmation();
		
		Assert.assertTrue(result.contains("complete"));
	}

}

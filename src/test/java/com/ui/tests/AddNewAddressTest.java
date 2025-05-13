package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	@BeforeMethod(description="Valid First Time user logs into the application")
	public void setup() {
		
	myAccountPage = homePage.goToLoginPage().doLoginWith("dadege5046@owlny.com", "Password");
	address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test()
	public void addNewAddress() {
		
	String  newAddress = myAccountPage.goToAddressPage().saveAddress(address);
	Assert.assertEquals(newAddress, address.getAddressTitle().toUpperCase());
	}
}

package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{
	
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By POSTALCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILEPHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONALINFORMATION_TEXTBOX_LOCATOR = By.id("other");
	private static final By ADDRESS_TITLE_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");
	
	

	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String saveAddress(AddressPOJO addressPOJO) {
		
		enterText(COMPANY_TEXTBOX_LOCATOR,addressPOJO.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR,addressPOJO.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR,addressPOJO.getCity());
		enterText(POSTALCODE_TEXTBOX_LOCATOR,addressPOJO.getPostCode());
		enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPOJO.getHomePhoneNumber());
		enterText(MOBILEPHONE_TEXTBOX_LOCATOR,addressPOJO.getMobileNumber());
		enterText(ADDITIONALINFORMATION_TEXTBOX_LOCATOR,addressPOJO.getAditionalInformation());
		clearText(ADDRESS_TITLE_TEXTBOX_LOCATOR); 
		enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR,addressPOJO.getAddressTitle());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
		clickOn(SAVE_BUTTON_LOCATOR);
		
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;
	}
	

}

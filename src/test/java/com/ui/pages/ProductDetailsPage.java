package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {
	
	private static final By PRODUCT_SIZE_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR  = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage changeSize(Size size) {
		scrollDownScreen();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectFromDropDown(PRODUCT_SIZE_LOCATOR, size.toString());
		return new ProductDetailsPage(getDriver());
		
	}
	
	public ProductDetailsPage addProductToCard() {
		
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartSummaryPage proceedToCheckOut() {

		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartSummaryPage(getDriver());
	}
	

}

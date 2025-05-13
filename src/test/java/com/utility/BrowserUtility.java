package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtlity.getLogger(this.getClass());
	private WebDriverWait wait;
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else if(browserName.equalsIgnoreCase("firefox")){
			
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else if(browserName.equalsIgnoreCase("edge")){
			
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else{
			
			System.err.println("Invalid browser Name...Please select valid broswer like chrome, edge and firefox");
		}
	}
	
	
	public BrowserUtility(Browser browserName) {
		
		if(browserName == Browser.CHROME) {
			
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else if(browserName == Browser.FIREFOX){
			
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else if(browserName == Browser.EDGE){
			
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
		}else{
			
			System.err.println("Invalid browser Name...Please select valid broswer like chrome, edge and firefox");
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		
		logger.info("Launching Browser for "+browserName);;
		if(browserName == Browser.CHROME ) {
			if(isHeadless) {
			ChromeOptions  options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			}else
			{
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			}
			
		}else if(browserName == Browser.FIREFOX){
			
			if(isHeadless) {
			FirefoxOptions  options = new FirefoxOptions();
			options.addArguments("--headless");
			driver.set(new FirefoxDriver(options));
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			}else {
			
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			} 
		}else if(browserName == Browser.EDGE){
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("headless");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			}else {
				
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L)); 
			}
			
			
		}else{
			
			System.err.println("Invalid browser Name...Please select valid broswer like chrome, edge and firefox");
		}
	}
	
	public void goToWebsite(String url) {
		
		driver.get().get(url);
		
	}
	
	public void maximizeWindow() {
		
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOn(WebElement element ) {

		element.click();
	}
	
	public void scrollDownScreen() {
		
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,300)");
	}
	
	public void selectFromDropDown(By dropDownlocator, String optionToSelect) {
		
		WebElement element = driver.get().findElement(dropDownlocator);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropDownlocator));
		Select options = new Select(element);
		options.selectByVisibleText(optionToSelect);
		
	}
	
	public void enterText(By locator, String text) {
		
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
	}
	
	public List<String> getAllVisibleText(By locator) {
		
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<>();
		for(WebElement element:elementList) {
		
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	
	public List<WebElement> getAllElements(By locator) {
		
		List<WebElement> elementList = driver.get().findElements(locator);
		return elementList;
	}
	
	public String getVisibleText(WebElement element) {

		return element.getText();
	} 
	
	public String getVisibleText(By locator) {
		
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public void clearText(By locator) {
		
		WebElement element = driver.get().findElement(locator);
		element.clear();
	}
	
	public String takeScreenShot(String name) {
		
		TakesScreenshot screenshot= (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		
		String path = "./screenshots /"+name+" - "+timestamp+".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return path;
	}
	
	public void quit() {
		
		if(getDriver() != null) {
			getDriver().quit();
		}
	}


}

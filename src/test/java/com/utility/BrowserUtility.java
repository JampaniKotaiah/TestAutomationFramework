package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtlity.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")){
			
			driver.set(new FirefoxDriver());
		}else if(browserName.equalsIgnoreCase("edge")){
			
			driver.set(new EdgeDriver());
		}else{
			
			System.err.println("Invalid browser Name...Please select valid broswer like chrome, edge and firefox");
		}
	}
	
	
	public BrowserUtility(Browser browserName) {
		
		if(browserName == Browser.CHROME) {
			
			driver.set(new ChromeDriver());
		}else if(browserName == Browser.FIREFOX){
			
			driver.set(new FirefoxDriver());
		}else if(browserName == Browser.EDGE){
			
			driver.set(new EdgeDriver());
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
			}else
			{
				driver.set(new ChromeDriver());
			}
			
		}else if(browserName == Browser.FIREFOX){
			
			if(isHeadless) {
			FirefoxOptions  options = new FirefoxOptions();
			options.addArguments("--headless");
			driver.set(new FirefoxDriver(options));
			}else {
			
			driver.set(new FirefoxDriver());
			} 
		}else if(browserName == Browser.EDGE){
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("headless");
				driver.set(new EdgeDriver(options));
			}else {
				
				driver.set(new EdgeDriver());
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
		
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text) {
		
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisidleText(By locator) {
		
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	public String takeScreenShot(String name) {
		
		TakesScreenshot screenshot= (TakesScreenshot)driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//screenshots //"+name+" - "+timestamp+".png";
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

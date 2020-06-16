package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToGetTitle {
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.facebook.com/'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
	//how to get title
	String actualTitle=jse.executeScript("return document.title").toString();
	System.out.println(actualTitle);
	
	String explTitle="Facebook - Log In or Sign Up";
	
	if (actualTitle.matches(explTitle)) {
		System.out.println("Title matches = pass");
	}else {
		System.out.println("Title does not match = Fail");
	}
	
	driver.quit();
	
	/* happy coding 
	 * change code based on your need.
	 * 
	 * */
	
	}

}

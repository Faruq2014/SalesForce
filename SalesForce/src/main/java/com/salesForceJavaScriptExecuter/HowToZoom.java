package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToZoom {
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	JavascriptExecutor jse= (JavascriptExecutor)driver;
	
	// zomming twice
		//jse.executeScript("document.body.style.zoom='2'");
		// zomming twice less
		//jse.executeScript("document.body.style.zoom='0.5'");
		jse.executeScript("document.body.style.zoom='1.5'");
		/* happy zooming 
		 * change the math zoom=' ' , based on your need.
		 * 
		 * */
	
	}

}

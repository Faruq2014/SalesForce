package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToHighlightElementWithColor {
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

	//jse.executeScript("document.body.style.zoom='1.5'");
	jse.executeScript("document.getElementById('email').style.backgroundColor='red'");
	jse.executeScript("document.getElementById('pass').style.backgroundColor='green'");
	
	/* happy coloring 
	 * change the color Color=' ' , based on your need.
	 * 
	 * */
	
	}

}

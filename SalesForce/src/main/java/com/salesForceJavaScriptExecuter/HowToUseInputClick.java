package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToUseInputClick {
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
	//how to work with send key FIRST method
	Object user=jse.executeScript("return document.getElementById('email')");
	((WebElement)user).sendKeys("Test");
	
	//how to work with send key second Method
	jse.executeScript("document.getElementById('pass').value='12345'");
	
	//how to work with click button FIRST Method
	//jse.executeScript("document.getElementById('u_0_b').click()");
	

	//how to work with click button if you have more elements with same attribute
	jse.executeScript("document.getElementsByName('websubmit')[0].click()");
	
	
	/* happy coding 
	 * change code based on your need.
	 * 
	 * */
	
	}

}

package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToHighlightElementWithColorBackground {
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
	
	jse.executeScript("document.body.style.zoom='1.2'");
	WebElement user=driver.findElement(By.name("email"));
	WebElement pword=driver.findElement(By.name("pass"));
	
  jse.executeScript("arguments[0].setAttribute('style', 'background: orange; border: 3px solid red;');",user);
  jse.executeScript("arguments[0].setAttribute('style', 'background: red; border: 3px solid black;');",pword);	
	
	/* happy coloring  background and bordering  
	 * change the  background: orange ;   based on your need.
	 * change the  border: 3px solid black;    based on your need.
	 * */
	
	}

}

/**
 * 
 */
package com.salesForceJavaScriptExecuter_forCalander;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Faruq
 *
 */
public class DynamicJS {
   
	WebDriver driver;
	
	@BeforeTest
	public void init() {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		//driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void pickAdate() {
		String day_month_year="07/07/2020";
	    WebElement element=driver.findElement(By.xpath("//div[@id='sandbox-container1']//input"));
	    selectDateByJS(driver, day_month_year,  element );
	}
	
	public static void selectDateByJS(WebDriver driver,String dateVal, WebElement element ) {
		JavascriptExecutor jse= (JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].setAttribute('value','"+dateVal+"')",element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

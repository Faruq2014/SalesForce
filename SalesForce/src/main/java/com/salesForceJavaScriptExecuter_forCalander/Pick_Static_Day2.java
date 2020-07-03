		package com.salesForceJavaScriptExecuter_forCalander;
		
		import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
		
		public class Pick_Static_Day2 {
		public static WebDriver driver;
			public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		//JavascriptExecutor jse= (JavascriptExecutor)driver;
		//jse.executeScript("window.location='https://www.spicejet.com/'");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// WebElement dateElement= driver.findElement(By.id("(//button[@class='ui-datepicker-trigger'])[1]")); 
		 WebElement dateElement= driver.findElement(By.id("ctl00_mainContent_view_date2")); 
		 String dateVal="07/07/2020";
		selectDateByJS(driver, dateVal, dateElement);
		System.out.println("date clicked");
         // driver.quit();
			}
			
			public static void selectDateByJS(WebDriver driver,String dateVal, WebElement element ) {
				JavascriptExecutor jse= (JavascriptExecutor)driver; 
				jse.executeScript("arguments[0].setAttribute('value','"+dateVal+"')",element);
			}
		}

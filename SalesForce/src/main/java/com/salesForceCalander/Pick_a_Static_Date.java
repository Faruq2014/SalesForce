package com.salesForceCalander;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_Static_Date {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.makemytrip.com/'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// bellow line is just to login pop up disappear
		driver.findElement(By.xpath("//div[contains(@class,'loginModal displayBlock modalLogin dynHeight personal')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Jul 10 2020')]")).click();
		
		String dayString="'Jul 20 2020'";
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Jul 20 2020')]")).click();
		String day="'Aug 25 2020'"; //we can make date dynamic this way.
		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, "+day+")]")).click();
              System.out.println("picked a fixed date");
       // driver.quit();
	}
	
	

}

package com.salesForceCalander_False;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_AnyDate_WhileLoop {
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
		
		
		String flag="False";
		
		//lets select departure date
		
		// the whole months of date xpath is the same, only changes are months and dates, so change accordingly. 
		// this code will work for any days/dates of the year. 
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		while (flag=="False") {
if(driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Aug 10 2020')]")).size()>0)			
	{driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Aug 10 2020')]")).click();	
	flag="True";
		}
		else {
driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();			
		}
		
		}
		 System.out.println("picked a DEPARTURE date");
		
		 
		 
		//lets select Return date
		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
		while (flag=="False") {
			if(driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Aug 20 2020')]")).size()>0)			
				{driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Aug 20 2020')]")).click();	
				flag="True";
					}
					else {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();			
					}
					
					}
		 System.out.println("picked a fixed RETURN date");
        driver.quit();
	}
	
	

}

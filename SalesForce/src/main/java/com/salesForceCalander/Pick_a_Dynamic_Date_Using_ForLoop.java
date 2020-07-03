package com.salesForceCalander;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_Dynamic_Date_Using_ForLoop {
	public static WebDriver driver;

	public static void main(String[] args) {
		pickFixedcDate();
		pickDynamicDate("20");
		
		
	}
	

	public static void pickFixedcDate() {

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
	List<WebElement> element=	driver.findElements(By.xpath("(//div[@class='DayPicker-Month']/div[3])[1]"));
	int total=element.size();
	for (int i = 0; i < total; i++) {
		String date=element.get(i).getText().trim();
		//System.out.print(date);
		if (date.equalsIgnoreCase("10")) {
		element.get(i).click();
	
		break;
		}
	}
              System.out.println("picked a fixed date");
        //driver.quit();
		
	}
	
	public static void pickDynamicDate(String pickdate) {
		

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
	
		//driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
		
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Jul 10 2020')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
	List<WebElement> element=	driver.findElements(By.xpath("(//div[@class='DayPicker-Month']/div[3])[1]"));
	int total=element.size();
	for (int i = 0; i < total; i++) {
		String date=element.get(i).getText().trim();
		System.out.println(date);
	
		if (date.equalsIgnoreCase(pickdate)) {
		element.get(i).click();
		//element.get(i).click();
		break;
		}
	}
              System.out.println("picked a dynamic date");
      // driver.quit();
		
	}
	
	//div[@class='DayPicker-Month'][contains(@class, 'DayPicker-Day')]
	
//	(//div[@class='DayPicker-Month']/div[3])[1]

}

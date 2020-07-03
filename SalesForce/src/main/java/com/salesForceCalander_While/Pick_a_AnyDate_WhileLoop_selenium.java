package com.salesForceCalander_While;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_AnyDate_WhileLoop_selenium {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		//driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String month="June 2020";
	    String day="16";
		driver.findElement(By.xpath("//div[@id='sandbox-container1']//input")).click();

		while (true) {
			
			String text=driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();
			System.out.println(text);
			if (text.equals(month)) {
				break;
			}else {
				driver.findElement(By.xpath("(//th[@class='prev'])[1]")).click();
			}
		}
		
		driver.findElement(By.xpath("//table[1]/tbody/tr/td[contains(text(),"+day+")]")).click();
		
	
	}
	}
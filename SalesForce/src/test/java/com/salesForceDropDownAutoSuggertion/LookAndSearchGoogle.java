package com.salesForceDropDownAutoSuggertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LookAndSearchGoogle {
	
	
	WebDriver driver;

	@BeforeTest
	public void openTest() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.google.com/'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
	
	@Test
	public void getSpecificText() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@title='Search']")).submit();
		Thread.sleep(3000);
		
		List<WebElement>listOfElements = driver.findElements(By.xpath("//*[@id='xjs']/div/table/tbody/tr/td"));
     System.out.println("<<<<<<<<<<<<<<<.......>>>>>>>>>>>>>>>>>>>>>>>>");
    
     System.out.println("size of the elements"+listOfElements.size());
     listOfElements.get(5).click();
     
     }
	

}

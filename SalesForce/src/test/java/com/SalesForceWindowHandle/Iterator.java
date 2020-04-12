package com.SalesForceWindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iterator {
	public static WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void iterator() throws InterruptedException {
	
	driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
	Set<String> handler = driver.getWindowHandles();
	java.util.Iterator<String> it=handler.iterator();
    String parentWindowID = it.next();
    System.out.println("parent window id is "+parentWindowID);
    String childWindowID = it.next();
    System.out.println("child window id is "+childWindowID);
    driver.switchTo().window(childWindowID);
    Thread.sleep(2000);
    String childTitle= driver.getTitle();
    System.out.println("child title is"+childTitle);
    driver.close();
    driver.switchTo().window(parentWindowID);
    String parentTitle =driver.getTitle();
    System.out.println("parent title is "+parentTitle);
    driver.quit();
    

	}
}

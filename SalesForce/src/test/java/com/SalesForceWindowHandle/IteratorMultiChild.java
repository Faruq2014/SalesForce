package com.SalesForceWindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IteratorMultiChild {
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
	
		driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
		driver.findElement(By.xpath("//a[@id='terms-link']")).click();
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
		
	Set<String> handler = driver.getWindowHandles();
	java.util.Iterator<String> it=handler.iterator();
    String parentWindowID = it.next();
    System.out.println("parent window id is "+parentWindowID);
    
    // window one
    String childWindowID1 = it.next();
    System.out.println("child window one id is "+childWindowID1);
    driver.switchTo().window(childWindowID1);
    Thread.sleep(2000);
    String childTitle1= driver.getTitle();
    System.out.println("child one title is"+childTitle1+"..........................");
   // driver.close();
    
    //driver.switchTo().window(parentWindowID);
    //String parentTitle =driver.getTitle();
   // System.out.println("parent title is "+parentTitle);
    
    //window2
    String childWindowID2 = it.next();
    System.out.println("child window id is "+childWindowID1);
    driver.switchTo().window(childWindowID2);
    Thread.sleep(2000);
    String childTitle2= driver.getTitle();
    System.out.println("child two title is"+childTitle2+"..........................");
    //driver.close();
    // switch to parent
    // window3
    String childWindowID3 = it.next();
    System.out.println("child window id is "+childWindowID1);
    driver.switchTo().window(childWindowID3);
    Thread.sleep(2000);
    String childTitle3= driver.getTitle();
    System.out.println("child three title is"+childTitle3+"..........................");
   // driver.close();
    Thread.sleep(2000);
   // driver.switchTo().window(childWindowID1);
    
    driver.switchTo().window(childWindowID2);
    driver.findElement(By.cssSelector("#email")).sendKeys("abbbb");
    Thread.sleep(2000);
    driver.switchTo().window(childWindowID1);
    driver.findElement(By.cssSelector("#email")).sendKeys("abbbb");
    Thread.sleep(2000);
    driver.switchTo().window(childWindowID2);
    driver.findElement(By.cssSelector("#pass")).sendKeys("######");
    driver.switchTo().window(parentWindowID);
   // driver.quit();
    }
	
	
}

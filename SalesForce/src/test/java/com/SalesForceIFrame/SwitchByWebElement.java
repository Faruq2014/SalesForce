package com.SalesForceIFrame;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchByWebElement {

public static WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void switchByElement() throws InterruptedException {
	driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println(size);
	//Commented the code for finding the index of the element
    driver.switchTo().frame(0); //Switching to the frame
	System.out.println("********We are switched to the iframe*******");
	driver.findElement(By.xpath("( //*[@class='btn-container ']/a)[1]")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("fae");
	System.out.println("title is "+ driver.getTitle());
	
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
    boolean ele1=driver.findElement(By.cssSelector("input[id^='UserFirstName']")).isDisplayed();
   
    if(ele1==true) {
    	driver.findElement(By.cssSelector("input[id^='UserFirstName']")).sendKeys("faruq");	
    }else {driver.findElement(By.xpath("(//div[@class='option-ui '])[1]")).click();
    }
    
    //driver.findElement(By.cssSelector("input[id^='UserFirstName']")).sendKeys("fae");
	}
}

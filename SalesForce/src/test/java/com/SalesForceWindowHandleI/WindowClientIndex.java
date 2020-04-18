package com.SalesForceWindowHandleI;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.salesForceWindowHandleLibrary.SwitchWindowByListSet;
import com.salesForceWindowHandleLibrary.WindowHandleLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowClientIndex {
public static WebDriver driver;
	
	@BeforeClass
	public void openApp() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("https://www.salesforce.com/");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		driver.findElement(By.cssSelector("[aria-label*='Login']>a")).click();
		Thread.sleep(2000);
		 //tag name is always i frame.
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("how many i frame in this page "+size);
		//Commented the code for finding the index of the element
	    driver.switchTo().frame(0); //Switching to the frame
	    
		System.out.println("********We are switched to the iframe*******");
		driver.findElement(By.xpath("( //*[@class='btn-container ']/a)[1]")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("fae");
		System.out.println("title is "+ driver.getTitle());
	
	  
	  }
	
	@Test(priority=1)
	public void switchToChildWindow() throws InterruptedException {
		
		WindowHandleLibrary switchW = new WindowHandleLibrary(driver);
                // window 1
	switchW.switchToWindowByIndex(1);
	Thread.sleep(3000);
	String childTitle1 = driver.getTitle();
	System.out.println("Child1 title is " + childTitle1);
	//Assert.assertEquals(childTitle1, "Free Trial - Salesforce.com");
	switchW.switchToWindowByIndex(1);
boolean d=driver.findElement(By.cssSelector("[aria-labelledby='CompanyEmployees-descby']>div:nth-child(2)")).isEnabled();
boolean d1=driver.findElement(By.cssSelector("[name='UserFirstName']")).isEnabled();

	if(d= true) {
		
	driver.findElement(By.cssSelector("[aria-labelledby='CompanyEmployees-descby']>div:nth-child(2)")).click();
	}
	else if(d1=true) {driver.findElement(By.cssSelector("[name='UserFirstName']")).sendKeys("first name");}
	else {
	
		System.out.println("wrong page");
		
		}
	Thread.sleep(1000);
	}
	
	@Test(priority=2)
	public void switchToParentWindow() throws InterruptedException {
		
                // window 0
		WindowHandleLibrary switchW = new WindowHandleLibrary(driver);
		switchW.switchToWindowByIndex(0);
	Thread.sleep(3000);
	String parentTitle = driver.getTitle();
	System.out.println(" Parent title is " + parentTitle);
	Assert.assertEquals(parentTitle, "Login | Salesforce");
	WebElement ele = driver.findElement(By.cssSelector("input[id^='username']"));
	ele.clear(); ele.sendKeys("Faruq");
	
	}
	
	@Test(priority=3)
	public void allTest() {
		WindowHandleLibrary switchW = new WindowHandleLibrary(driver);
		switchW.findAllWindowID();
		switchW.findPapentWindow();
		switchW.findAllWindowsCount();
		switchW.findWindowsIndexWithTitle();
	}

	
	

}

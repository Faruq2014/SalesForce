package com.SalesForceWindowHandleIterator;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.salesForceWindowHandleLibrary.SwitchWindowByListSet;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IteratorMain {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
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
			Thread.sleep(2000);
			
			SwitchWindowByListSet switchW = new SwitchWindowByListSet(driver);
            // window 1
switchW.toIterator(1);
Thread.sleep(3000);
String childTitle1 = driver.getTitle();
System.out.println("Child1 title is " + childTitle1);
//Assert.assertEquals(childTitle1, "Free Trial - Salesforce.com");

Thread.sleep(1000);
//boolean d=driver.findElement(By.cssSelector("[aria-labelledby='CompanyEmployees-descby']>div:nth-child(2)")).isEnabled();
boolean d1=driver.findElement(By.cssSelector("[name='UserFirstName']")).isEnabled();

if(d1= true) {
	
driver.findElement(By.cssSelector("[name='UserFirstName']")).sendKeys("faruq");
}

else {
	/*
	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[2]//div[1]//div[1]//div[2]")));
	element1.click();
	*/
	WebElement ele = driver.findElement(By.xpath("//form//div[2]//div[1]//div[1]//div[2]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);
	
	//driver.findElement(By.cssSelector("[aria-labelledby='CompanyEmployees-descby']>div:nth-child(2)")).click();
	//driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[1]")).click();

		  

	}
//SwitchWindow switchW = new SwitchWindow(driver);
switchW.toIterator(0);
Thread.sleep(3000);
String parentTitle = driver.getTitle();
System.out.println(" Parent title is " + parentTitle);
Assert.assertEquals(parentTitle, "Login | Salesforce");
WebElement ele = driver.findElement(By.cssSelector("input[id^='username']"));
ele.clear(); ele.sendKeys("Faruq");


	}
}

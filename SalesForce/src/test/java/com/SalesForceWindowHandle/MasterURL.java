package com.SalesForceWindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MasterURL {
static WebDriver driver;
@Test
public void urlTesting() throws InterruptedException {
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String Parenttitle = driver.getTitle();
	System.out.println("parent title is " + Parenttitle);
	
	//open all the child window
	driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
	driver.findElement(By.xpath("//a[@id='terms-link']")).click();
	driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
	
	// just to see how many window is open
	Set<String> AllWindow = driver.getWindowHandles();
	int count = AllWindow.size();
	System.out.println("how many window we have " + count);
	
	// call the switchWindow library
	SwitchWindow switchW = new SwitchWindow(driver);
	
	// window 1
	switchW.toURL("https://www.facebook.com/about/privacy/update");
	Thread.sleep(3000);
	String childTitle1 = driver.getTitle();
	System.out.println("Child1 title is " + childTitle1);
	
	// window 2
	switchW.toURL("https://www.facebook.com/legal/terms/update");
	Thread.sleep(3000);
	String childTitle2 = driver.getTitle();
	System.out.println("Child2 title is " + childTitle2);
	
	// window3
	switchW.toURL("https://www.facebook.com/policies/cookies/");
	Thread.sleep(3000);
	String childTitle3 = driver.getTitle();
	System.out.println("Child3 title is " + childTitle3);
	
	// back to parent window
	Thread.sleep(2000);
	switchW.toURL("https://www.facebook.com/");
	String ParenURL = driver.getCurrentUrl();
	System.out.println("parent url is " + ParenURL);
	
	// working on a particular window
	System.out.println(" working on a particular window>>>>>>>>>>>>>>>>>>>");
		switchW.toURL("https://www.facebook.com/policies/cookies/");
		Thread.sleep(3000);
		 driver.findElement(By.cssSelector("#email")).sendKeys("abbbb");
		 driver.findElement(By.cssSelector("#pass")).sendKeys("######");
	     driver.quit();

}
}

package com.SalesForceIFrame;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ByIndex {
	/*
	 * Working with index number is very risk, because developer could change the
	 * index number.
	 * 
	 */
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
	public void findByIndexTest() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		// tag name is always i frame.
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("how many i frame in this page " + size);

		driver.switchTo().frame(0); // Switching to the frame

		String iFrameTitle = driver.getTitle();
		System.out.println("i frame title is " + iFrameTitle);
		Assert.assertEquals(iFrameTitle, "Login | Salesforce"); // assertion
		System.out.println("********We are switched to the iframe*******");
		// working inside the frame
		driver.findElement(By.xpath("( //*[@class='btn-container ']/a)[1]")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("faruq");
		System.out.println("title is " + driver.getTitle());
		driver.quit();
	}

}

package com.SalesForceIFrame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ByWebElement {
	/*
	 * Switching by web element is the most reliable used one. because: you probable
	 * do not know how many i frame are there. what is the index number of it. even
	 * though you know iframe number could change any time.
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
	public void findByWebElementTest() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='marketing']")));

		// WebElement Iframe= driver.findElement(By.xpath("//iframe[@id='marketing']"));
		// driver.switchTo().frame(Iframe);
		System.out.println("********We are switched to the iframe*******");

		driver.findElement(By.xpath("( //*[@class='btn-container ']/a)[1]")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("faruq");
		System.out.println("title is " + driver.getTitle());

		driver.quit();

	}

}

package com.SalesForceIFrame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByID {
	/*
	 * An I frame (Inline frame) is an HTML document embedded inside another HTML
	 * document on a Web Page. the I frame HTML element is often used to insert
	 * content from another source, such as an advertisement on a web side. i frame
	 * should have an id. you must switch to default window to go to any other
	 * window that means if there is more than one i frame and you need to work on
	 * next i frame than you need to switch to default window first and then switch
	 * to next i frame.
	 */
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
	 // WebDriverManager.chromedriver().setup();
		/*switch ifame method fail if we use WebDriverManager.
		 * why why why?
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void findByIDTest() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		// tag name is always i frame.
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("how many i frame in this page " + size);

		driver.switchTo().frame("marketing");

		// System.out.println("********We are switched to the iframe*******");
		boolean ele = driver.findElement(By.xpath("(//*[@class='btn-container ']/a)[1]")).isDisplayed();
		System.out.println(ele);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("faruq");
		System.out.println("title is " + driver.getTitle());

		// driver.quit();
	}

}

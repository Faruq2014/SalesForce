package com.salesForceWaitCommands;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Fluent1 {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		System.out.println("All done");
		driver.quit();
	}

	@Test
	public void fluentTest() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.MILLISECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@id='forgot_password_link']")));

		String text = driver.findElement(By.xpath("//a[@id='forgot_password_link']")).getText();
		System.out.println(text);
		System.out.println(text.contains("Forgot"));
		Thread.sleep(3000);

	}

}

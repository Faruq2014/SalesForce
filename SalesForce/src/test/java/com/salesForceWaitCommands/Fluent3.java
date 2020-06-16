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

public class Fluent3 {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/Students/Contact");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		System.out.println("All done");
		// driver.quit();
	}

	@Test
	public void fluentTest() throws InterruptedException {
		driver.findElement(By.linkText("This is a Ajax link")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ContactUs")));
		String text = driver.findElement(By.className("ContactUs")).getText();
		System.out.println(text);
		System.out.println(text.contains("python" + "if it is false then postive testing pass. "));
		Thread.sleep(3000);
	}

}

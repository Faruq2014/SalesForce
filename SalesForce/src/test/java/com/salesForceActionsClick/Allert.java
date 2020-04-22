package com.salesForceActionsClick;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Allert {
	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.salesforce.com/");

	}

	@Test(priority = 1)
	public void directClickTest() throws Throwable {
		Thread.sleep(5000);
		// this class is pop up or alert box in sales force. need to work on it.
		/*
		 * String text = driver.switchTo().alert().getText(); System.out.println(text);
		 * driver.switchTo().alert().accept();
		 */
		driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[2]/div/div[4]/div/div[2]/div/a")).click();
	}
}

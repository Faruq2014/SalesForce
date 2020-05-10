package com.salesForceActionsKeyboardEvent;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysUpAndDown {
	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.uitestpractice.com/Students/Actions");

	}

	@Test(priority = 1)
	public void keysUpAndDown() throws Throwable {
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL)
		.click(driver.findElement(By.name("one"))).pause(Duration.ofSeconds(1))
		.click(driver.findElement(By.name("five"))).pause(Duration.ofSeconds(1))
		.click(driver.findElement(By.name("nine"))).pause(Duration.ofSeconds(1))
		.click(driver.findElement(By.name("ten"))).pause(Duration.ofSeconds(1))
		.click(driver.findElement(By.name("two"))).pause(Duration.ofSeconds(1))
		.keyUp(Keys.CONTROL).build().perform();
	}
	
	@Test(priority = 2)
	public void keysUpAndDownTest() throws Throwable {
		Actions act = new Actions(driver);
		act.keyDown(driver.findElement(By.name("six")),Keys.CONTROL)
		.keyUp(driver.findElement(By.name("one")),Keys.CONTROL)
		.keyDown(driver.findElement(By.name("nine")),Keys.CONTROL)
		.build().perform();
		
	}
}

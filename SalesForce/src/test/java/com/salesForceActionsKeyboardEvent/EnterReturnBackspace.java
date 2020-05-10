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

public class EnterReturnBackspace {

	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void returnTest() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		driver.findElement(By.id("username")).sendKeys("faruq");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys("molla").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.RETURN).build().perform();

	}

//	@Test(priority = 2)
	public void enterTest() throws InterruptedException {

		// driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		Actions act = new Actions(driver);
		// driver.findElement(By.id("username")).sendKeys("faruq");
		act.sendKeys("faruq").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys("molla").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ENTER).build().perform();
		// driver.quit();
	}

	//@Test(priority = 3)
	public void backSpaceTest() throws InterruptedException {

		// driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		Actions act = new Actions(driver);
		// driver.findElement(By.id("username")).sendKeys("faruq");
		act.sendKeys("faruq").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys("molla").pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ENTER)
				.build().perform();
		// driver.quit();
	}

}

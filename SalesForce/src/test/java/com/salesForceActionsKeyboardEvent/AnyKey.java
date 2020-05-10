package com.salesForceActionsKeyboardEvent;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnyKey {
	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://the-internet.herokuapp.com/key_presses");

	}

	@Test(priority = 1)
	public void tabEvent() throws Throwable {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.CANCEL).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.SHIFT).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.PAGE_UP).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.BACK_SPACE).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.DELETE).pause(Duration.ofSeconds(1)).build().perform();
		act.sendKeys(Keys.SUBTRACT).pause(Duration.ofSeconds(1)).build().perform();
	}
}

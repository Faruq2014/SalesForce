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

public class Tab {
	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.navigate().to("https://www.salesforce.com/");
		driver.get("https://www.facebook.com/");

	}

	@Test(priority = 1)
	public void tabEvent() throws Throwable {
		Actions act = new Actions(driver);
		driver.findElement(By.name("email")).sendKeys("faruq");

		act.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("Molla").pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).click().build().perform();
				
				
				
				//sendKeys("703").pause(Duration.ofSeconds(1))
				//.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("dhhhh").build().perform();
	}
}

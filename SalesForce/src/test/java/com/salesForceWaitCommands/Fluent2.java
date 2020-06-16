package com.salesForceWaitCommands;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Fluent2 {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
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
	public void name() {
		// Click on timer so clock will start

		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
//Create object of FluentWait class and pass webdriver as input

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				// It should poll webelement after every single second
				.withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		// Max time for wait- If conditions are not met within this time frame then it
		// will fail the script // we are creating Function here which accept webdriver
		// and output as WebElement-

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement ele = driver.findElement(By.xpath("//p[@id='demo']"));

//Will capture the inner Text and will compare will WebDriver

//If condition is true then it will return the element and wait will be over
				String value = ele.getAttribute("innerHTML");
				if (value.equalsIgnoreCase("WebDriver")) {
					return ele;
				}

//If condition is not true then it will return null and it will keep checking until condition is not true

				else {
					System.out.println("Value is >>> " + value);
					return null;
				}
			}
		});

//If element is found then it will display the status

		System.out.println("Final visible status is >>>>> " + element.isDisplayed());

	}

}

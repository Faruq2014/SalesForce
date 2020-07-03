package com.salesForceDropDownAutoSuggertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BootStrapDropDown {

	WebDriver driver;

	@BeforeTest
	public void openTest() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.google.com/'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void clikOnElement() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
		for (WebElement webElement : listOfElements) {
			if (webElement.getText().trim().equals("selenium ide")) {
				webElement.click();
				break;
			}
		}

	}

	@Test
	public void getAllText() throws InterruptedException {

		driver.findElement(By.xpath(".//*[@title='Search']")).clear();
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
		for (WebElement webElement : listOfElements) {
			System.out.println(webElement.getText());
		}

	}

	@Test
	public void getTextUntilBreak() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@title='Search']")).clear();
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
     System.out.println("<<<<<<<<<<<<<<<.......>>>>>>>>>>>>>>>>>>>>>>>>");
		for (WebElement webElement : listOfElements) {
			System.out.println(webElement.getText());
			if (webElement.getText().trim().equals("selenium ide")) {
				break;
			}
		
		}
	}
	
	@Test
	public void getSpecificText() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@title='Search']")).clear();
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> listOfElements = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
     System.out.println("<<<<<<<<<<<<<<<.......>>>>>>>>>>>>>>>>>>>>>>>>");
		for (WebElement webElement : listOfElements) {
			
			if (webElement.getText().trim().equals("selenium ide")) {
				System.out.println("specific: "+webElement.getText());
				break;
			}
		
		}
	}
	
}

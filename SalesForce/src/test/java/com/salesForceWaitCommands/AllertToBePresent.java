package com.salesForceWaitCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllertToBePresent {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup(); //why its fail?
		driver = new ChromeDriver();
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void AcceptTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='content']/button")).click();
		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		String alrt = driver.switchTo().alert().getText();
		System.out.println(alrt + " this is priority one");
		driver.switchTo().alert().accept();

	}

	@Test(priority = 1)
	public void DismisTest() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/button"))).click();

		wait.until(ExpectedConditions.alertIsPresent());
		String alrt = driver.switchTo().alert().getText();
		System.out.println("Text from priority two allert is " + alrt);
		driver.switchTo().alert().dismiss();
	}

	@Test(priority = 2)
	public void RegularTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='content']/button")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String print = alert.getText();
		System.out.println(print + " text from regular method");
		alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='content']/button")).click();
		Thread.sleep(3000);
		alert.dismiss();
		driver.close();
	}

}

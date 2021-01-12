package com.salesForceActionsMouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver2 {
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
	
	@Test(priority=0)
	public void muTest() throws InterruptedException {
	//WebElement parentElement=driver.findElement(By.xpath("//*[@id='products_menu_item']"));
	Thread.sleep(1000);
	WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
	WebElement customer360=driver.findElement(By.cssSelector("div[class='sub-nav'] ul>li:first-child"));
	
	Actions act = new Actions(driver);
	
	//act.moveToElement(Products).build().perform();
	Thread.sleep(1000);
	//act.moveToElement(customer360).click().build().perform();
	
	act.moveToElement(Products).moveToElement(customer360).click().build().perform();
	

	}
	

	@Test(priority = 1)
	public void directClickTest() throws Throwable {
		Thread.sleep(1000);
		WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
		WebElement ProductsOView = driver.findElement(By.cssSelector("div[class='sub-nav'] ul>li:first-child"));
		Products.click();
		ProductsOView.click();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void mouseOverTest() throws Throwable {
		Thread.sleep(1000);
		WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
		WebElement ProductsOView = driver.findElement(By.cssSelector("div[class='sub-nav'] ul>li:first-child"));
		Actions action = new Actions(driver);
		action.moveToElement(Products).build().perform();
		Thread.sleep(1000);
		action.moveToElement(ProductsOView).click().build().perform();
	    
	}

	@Test(priority = 3)
	public void mouseOverOneClickTest() throws Throwable {
		Thread.sleep(1000);
		WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
		WebElement ProductsOView = driver.findElement(By.cssSelector("div[class='sub-nav'] ul>li:first-child"));
		Actions action = new Actions(driver);
		action.moveToElement(Products).moveToElement(ProductsOView).click().build().perform();

	}

}

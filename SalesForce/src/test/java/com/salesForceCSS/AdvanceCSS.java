package com.salesForceCSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvanceCSS {
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
@Test(priority=1)
public void direcChild() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver,30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("[aria-label*='Login']>a")));
	driver.findElement(By.cssSelector("[aria-label*='Login']>a")).click();
	//Thread.sleep(1000);
	driver.navigate().back();
	//driver.navigate().back();
}

@Test(priority=2)
public void directntnChildNumbering() throws Throwable {	
	Thread.sleep(1000);
	WebElement ele=driver.findElement(By.cssSelector("[class='wwww-main-nav searchEnabled']>li:nth-child(3)"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).build().perform();
	
	}


@Test(priority=3)
public void directNtnFirstChild() throws Throwable {	
	Thread.sleep(1000);
	WebElement ele=driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).build().perform();
	
	}

@Test(priority=4)
public void directNtnLastChild() throws Throwable {	
	Thread.sleep(1000);
	WebElement ele=driver.findElement(By.cssSelector("ul[class^='wwww-main-nav ']>li:first-child"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).build().perform();
	
	}
}

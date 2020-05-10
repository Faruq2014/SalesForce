package com.salesForceWaitCommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisibilityOfAllElementsLocatedBy {
	public static WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUP() {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void teardown() {
	System.out.println("All done");
	driver.quit();
	}
	
	@Test(priority = 1)
	public void mouse() throws Throwable {
		Thread.sleep(1000);
		WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
		Actions action = new Actions(driver);
		action.moveToElement(Products).build().perform();
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='drawer_products']//div[@class='sub-nav']/ul/li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='drawer_products']//div[@class='sub-nav']/ul/li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("What is Salesforce? "))
			{
				list.get(i).click();
				break;
			}
		}
		
	}

	
}

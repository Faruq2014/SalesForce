package com.salesForceWaitCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameToBeAvailableAndSwitchToIt {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup(); //why its fail?
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void findByIDTest() throws InterruptedException {

		driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("how many i frame in this page " + size);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//switch by index
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//switch by ID
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("marketing")));
		//switch by WebElement
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='marketing']")));
      
		/*since i have explicitly wait, i do not need this two line. 
		driver.switchTo().frame("marketing");
		Thread.sleep(2000);
		*/
     
		 System.out.println("********We are switched to the iframe*******");
		boolean ele = driver.findElement(By.xpath("(//*[@class='btn-container ']/a)[1]")).isDisplayed();
		System.out.println("Switch to iframe = "+ele);
		//driver.findElement(By.xpath("(//*[@class='btn-container ']/a)[1]")).click();

		driver.switchTo().defaultContent();
		//Thread.sleep(2000); // not need static wait any more. we have dynamic wait. 
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id^='username']")));
		driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("faruq");
		  wait.until(ExpectedConditions.titleContains("Salesforce"));
		System.out.println("title from parent window " + driver.getTitle());

		 driver.quit();
	}

	

}

package com.salesForceWaitCommands;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckElementsStatus {
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
	
//	@Test(priority = 1)
	public void ElementsToBeClickable() {
		wait=new WebDriverWait(driver, 15);
		By dropdown = By.xpath("(//div[@class='dropdown']/a)[2]");
		wait.until(ExpectedConditions.
	            elementSelectionStateToBe(dropdown, true));
	
		
	}
	
	//@Test(priority = 2)
	public void visibilityOfElementLocated() {
		/*Below is the syntax to check if the element is present on the DOM of a page and visible.
		 *  Visibility means that the element is not just displayed but also should also 
		 *  has a height and width that is greater than 0.
		 * 
		 */
		 wait=new WebDriverWait(driver, 15);
		By pass= By.xpath("//input[@id='password']");
	WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
	ele.clear();
	ele.sendKeys("1233");
	
	
	
	}
}

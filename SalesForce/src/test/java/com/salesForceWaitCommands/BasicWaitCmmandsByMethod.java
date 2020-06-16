package com.salesForceWaitCommands;

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

public class BasicWaitCmmandsByMethod {
	public static WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		System.out.println("All done");
		driver.quit();
	}

	@Test(priority = 1)
	public void ElementsToBeClickable() {
		wait = new WebDriverWait(driver, 15);
		By dropdown = By.xpath("(//div[@class='dropdown']/a)[2]");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		System.out.println("is dropdown clickable? " + element);
		element.click();
		// WebDriverWait wait=new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='dropdown']/a)[2]"))).click();

	}

	@Test(priority = 2)
	public void invisibilityOfElementLocated() {
		/*
		 * Below is the syntax which is used for checking that an element is either
		 * invisible or not present on the DOM.
		 */

		wait = new WebDriverWait(driver, 15);
		By dropdown = By.xpath("(//div[@class='dropdown']/a)[2]");

		Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated((dropdown)));
		System.out.println("is that elements gone from the page " + element);
		if (element == true) {// also can write element==true, because by default it is true.
			driver.findElement(By.cssSelector("input[id^='username']")).sendKeys("faruq");
		}

	}

	@Test(priority = 3)
	public void visibilityOfElementLocated() {
		/*
		 * Below is the syntax to check if the element is present on the DOM of a page
		 * and visible. Visibility means that the element is not just displayed but also
		 * should also has a height and width that is greater than 0.
		 * 
		 */
		wait = new WebDriverWait(driver, 15);
		By pass = By.xpath("//input[@id='password']");
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
		ele.clear();
		ele.sendKeys("1233");
	}

	@Test(priority = 4)
	public void presenceOfElementLocated() {
		/*
		 * Here it is checking that an element is present on the DOM of a page or not.
		 * That does not necessarily mean that the element is visible.
		 * ExpectedConditions will return true once the element is found in the DOM.
		 */
		wait = new WebDriverWait(driver, 15);
		By loginButton = By.xpath("//input[@id='Login']");
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
		element.click();
		/*
		 * We should use presenceOfElementLocated when we don't care about the element
		 * visible or not, we just need to know if it's on the page.
		 */
	}

}

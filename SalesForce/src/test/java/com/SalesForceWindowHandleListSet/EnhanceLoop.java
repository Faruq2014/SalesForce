package com.SalesForceWindowHandleListSet;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnhanceLoop {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void enhanceLoopTest() throws InterruptedException {

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		System.out.println("parent window id is " + parent);
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
		
		Set<String> AllWindow = driver.getWindowHandles();
		int count = AllWindow.size();
		System.out.println("how many window we have " + count);
		// for (int i=0; i>count;i++) { } since it is Set iterator we must use enhance
		// loop.
		Thread.sleep(2000);
		for (String child : AllWindow) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				String childTitle = driver.switchTo().window(child).getTitle();
				System.out.println("the child window title is " + childTitle);
				driver.findElement(By.id("email")).sendKeys("abccd");
				Thread.sleep(2000);
				driver.close();
			}
			// driver.close();
			driver.switchTo().window(parent);
			driver.findElement(By.id("pass")).sendKeys("dfggg");
			String parenttitle = driver.switchTo().window(parent).getTitle();

			System.out.println("parent title is " + parenttitle);
			Thread.sleep(2000);

		}
		driver.quit();
	}

}

package com.salesForceActionsMouseHover;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverListHTML {
	/*
	 * mouse hover also called mouse over or called hover over. just build and
	 * perform is the action.
	 */
	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.navigate().to("https://www.salesforce.com/");
		driver.get("https://www.salesforce.com/");

	}

	@Test(priority = 1)
	public void mouseHover() throws Throwable {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.cssSelector("[class='wwww-main-nav searchEnabled']>li:nth-child(5)"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(1000);

		List<WebElement> links = driver
				.findElements(By.xpath("//div[@id='drawer_resources']//div[@class='sub-nav']/ul/li/a"));
		int total_count = links.size();
		System.out.println(total_count);
		for (int i = 0; i < total_count; i++) {
			WebElement elements = links.get(i);
			String HTML = elements.getAttribute("innerHTML");
			// System.out.println(text);
			boolean status = elements.isEnabled();
			// System.out.println(status);
			System.out.println(HTML + " is enable " + status);

			if (HTML.equalsIgnoreCase("<span>Podcasts</span>")) {
				elements.click();
				break;
			}

		}

	}

}

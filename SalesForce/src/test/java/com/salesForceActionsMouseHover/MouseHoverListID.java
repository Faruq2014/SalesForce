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

public class MouseHoverListID {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.navigate().to("https://www.salesforce.com/");
		driver.get("https://www.spicejet.com/RedHotOffers.aspx");

	}

	@Test(priority = 1)
	public void mouseHover() throws Throwable {
		Thread.sleep(1000);
		WebElement add = driver.findElement(By.xpath("//a[@id='highlight-addons']"));
		Actions action = new Actions(driver);
		action.moveToElement(add).build().perform();
		Thread.sleep(1000);

		Thread.sleep(1000);
		List<WebElement> links = driver.findElements(By.xpath("//ul[@class='add-ons-tab']/li"));
		int count = links.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			WebElement elements = links.get(i);

			String text = elements.getAttribute("innerHTML");
			// System.out.println(text);
			boolean status = elements.isEnabled();
			// System.out.println(status);
			System.out.println(text + " is enable " + status);

			if (text.equalsIgnoreCase("You 1st")) {
				elements.click();
				break;
			}

		}

	}

}

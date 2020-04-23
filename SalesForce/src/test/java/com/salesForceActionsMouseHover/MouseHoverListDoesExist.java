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

public class MouseHoverListDoesExist {

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
		WebElement Products = driver.findElement(By.cssSelector("ul[class$='-main-nav searchEnabled']>li:first-child"));
		Actions action = new Actions(driver);
		action.moveToElement(Products).build().perform();
		Thread.sleep(1000);

		Thread.sleep(1000);
		List<WebElement> links = driver
				.findElements(By.xpath("//div[@id='drawer_products']//div[@class='sub-nav']/ul/li"));

		String unOrganizedData = "What is Salesforce?,Products Overview,Pricing,Small Business,Artificial Intelligence,Faruq";
		// csv=comma seperated file.
		// you could have ; separated file.
		// or any type of separated elements, just say spilt (;) or (.) or (,) and so on
		String arrayEmployee[] = unOrganizedData.split(",");

		for (String EachStr : arrayEmployee) {

			boolean Found = false;

			for (WebElement eachOne : links) {

				if (EachStr.equals(eachOne.getText())) {
					Found = true;
					System.out.println(EachStr + " yes! String does exist");
					break;
				}
			}
			if (!Found) {
				System.err.println(EachStr + " sorry! does not Exist");
			}
			// break;
		}

	}
}

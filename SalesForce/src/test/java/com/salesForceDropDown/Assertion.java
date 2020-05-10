package com.salesForceDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assertion {

	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void totalElementTest() {
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);

		List<WebElement> allCountry = select.getOptions();
		int total = allCountry.size();
		Assert.assertEquals(total, 229);
		System.out.println(total + " pass the total number of drop down test.");

	}

	@Test(priority = 1)
	public void assertionTest() {

		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);

		List<WebElement> allCountry = select.getOptions();

		for (WebElement webElement : allCountry) {
			// asserting by text
			String text = allCountry.get(1).getText();
			System.out.println("value is " + text);
			Assert.assertEquals(text, "United States");
			// asserting by value
			String us1 = allCountry.get(1).getAttribute("value");
			Assert.assertEquals(us1, "US");
			System.out.println("Positive testing is satisfied");
			break;
		}
		select.selectByIndex(23);
	}

	@Test(priority = 2)
	public void wrongAsseertion() {

		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);

		List<WebElement> allCountry = select.getOptions();

		for (WebElement webElement : allCountry) {
			try {
				// to make sure text string is working.
				String text = allCountry.get(1).getText(); // it is United States
				Assert.assertNotEquals(text, "united");
				System.out.println("pass the negative test for text string.");
			} catch (Exception e) {
				System.out.println("fail the negative test");
			}

			try {
				// to make sure value string is working.
				String us = allCountry.get(1).getAttribute("value"); // it is US
				Assert.assertNotEquals(us, "RandomText");
				System.out.println("pass the negative test for value string.");
			} catch (Exception e) {
				System.out.println("fail the negative test for value string");
			}

			break;
		}
		select.selectByIndex(13);
	}

	@Test(priority = 3)
	public void assertionTest3() {

		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);

		List<WebElement> allCountry = select.getOptions();

		for (WebElement webElement : allCountry) {
			// comparing two different element
			String text1 = allCountry.get(1).getText();

			String text2 = allCountry.get(3).getText();

			Assert.assertNotEquals(text2, text1);
			System.out.println("Selected text strings are not conflicting each other");
			break;
		}
		select.selectByIndex(3);
		System.out.println("Final assertion is, dropdown functionality is working properly");
	}

}

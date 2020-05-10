package com.salesForceDropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basics {
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
	public void generalTest() {

		Select select = new Select(driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]")));

		// WebElement
		// country=driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		// Select select1 = new Select(country);
		select.selectByIndex(1);
		select.selectByValue("BD");
		select.selectByVisibleText("American Samoa");

	}

	@Test(priority = 1)
	public void indexTest() {
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByIndex(12);
	}

	@Test(priority = 2)
	public void VisibleTextTest() {
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByVisibleText("Antarctica");

	}

	// @Test(priority = 3)
	public void ValueTest() throws InterruptedException {
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByValue("BD");

	}

}

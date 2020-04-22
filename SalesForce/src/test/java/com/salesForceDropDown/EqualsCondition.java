package com.salesForceDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EqualsCondition {

	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void indexTest() {
		// is two elements equals? Basically we can compare index to index.
		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();
		for (WebElement webElement : allEmployee) {
			WebElement us = allEmployee.get(1);
			boolean b = allEmployee.get(11).equals(us);
			if (b == true) {
				System.out.println("index=index");
			} else {
				System.out.println("it is not equals");
			}
			break;
		}
		// select.selectByIndex(3);
	}

	@Test(priority = 2)
	public void textTest() {
		// is two elements equals? Basically we can compare text to text.
		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();
		for (WebElement webElement : allEmployee) {
			String us1 = allEmployee.get(1).getText();
			boolean b = allEmployee.get(11).getText().equals(us1);
			if (b == true) {
				System.out.println("index=index");
			} else {
				System.out.println("it is not equals");
			}
			break;
		}
		// select.selectByIndex(3);
	}

	@Test(priority = 3)
	public void valueTest() {
		// is two elements equals? Basically we can compare Attribute to Attribute(in
		// this case it is value.)
		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();
		for (WebElement webElement : allEmployee) {
			String value = allEmployee.get(1).getAttribute("value");
			System.out.println("value is " + value);
			String us1 = allEmployee.get(1).getAttribute("value");
			boolean b = allEmployee.get(11).getAttribute("value").equals(us1);
			if (b == true) {
				System.out.println("index=index");
			} else {
				System.out.println("it is not equals");
			}
			break;
		}
		select.selectByIndex(3);
	}

}

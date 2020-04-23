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

public class AssertionList {

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
	public void assertionTest() {

		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyEmployees')]"));

		String arr[] = { "Employees", "1 - 20 employees", "21 - 200 employees", "201 - 10,000 employees",
				"10,001+ employees" };
		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();
		int total = allEmployee.size();
		Assert.assertEquals(total, 5);
		System.out.println(total + " is total elements in this dropdown");

		for (int i = 0; i < total; i++) {
			Assert.assertEquals(arr[i], allEmployee.get(i).getText());
			// Assert.assertEquals(allEmployee.get(i).getText(), arr[i]);
// matching expected elements with actual element following given index/
		}
		System.out.println("list verification is successful.");

	}

}

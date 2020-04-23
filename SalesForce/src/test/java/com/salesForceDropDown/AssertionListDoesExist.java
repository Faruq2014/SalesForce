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

public class AssertionListDoesExist {

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
	public void organizeDataTest() {

		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyEmployees')]"));

		String arrEmp[] = { "Employees", "1 - 20 employees", "21 - 200 employees", "201 - 10,000 employees",
				"10,001+ employees", "random element" };
		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();

		for (String EachStr : arrEmp) {

			boolean Found = false;

			for (WebElement eachOne : allEmployee) {

				if (EachStr.equals(eachOne.getText())) {
					Found = true;
					System.out.println(EachStr + " yes! String does exist");
					break;
				}
			}
			if (!Found) {
				System.err.println(EachStr + " sorry! does not Exist");
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();// for empty space
	}

	@Test(priority = 2)
	public void unOrganizeDataTest() {

		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyEmployees')]"));

		String unOrganizedData = "Employees,Faruq,1 - 20 employees,21 - 200 employees, 201 - 10,000 employees,10,001+ employees,random element";
		// csv=comma separated value file.
		// you could have ; separated file.
		// or any type of separated elements, just say spilt (;) or (.) or (,) and so on
		String arrayEmployee[] = unOrganizedData.split(",");

		Select select = new Select(employee);
		List<WebElement> allEmployee = select.getOptions();

		for (String EachStr : arrayEmployee) {

			boolean Found = false;

			for (WebElement eachOne : allEmployee) {

				if (EachStr.equals(eachOne.getText())) {
					Found = true;
					System.out.println(EachStr + " yes! String does exist");
					break;
				}
			}
			if (!Found) {
				System.err.println(EachStr + " sorry! does not Exist");
			}
		}

	}

}

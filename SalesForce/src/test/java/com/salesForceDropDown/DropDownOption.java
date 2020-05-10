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

public class DropDownOption {

	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void printAllTest() { // Enhance for loop implementation
		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyEmployees-')]"));
		Select select = new Select(employee);
		select.selectByIndex(3);
		List<WebElement> allEmployee = select.getOptions();
		int total = allEmployee.size();
		System.out.println("Total number of employee type is " + total);

		for (WebElement empoyee : allEmployee) {
			String value = empoyee.getAttribute("value");
			String tag = employee.getTagName();
			String text = employee.getText();

			System.out.println(" tag is " + tag + " value is " + value + " text is " + text);

			break;
		}

	}

	@Test(priority = 2)
	public void allElementTest() throws InterruptedException { // for loop implementation
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Thread.sleep(3000);
		WebElement countries = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(countries);
		select.selectByValue("BD");

		List<WebElement> totalCountries = select.getOptions();
		System.out.println("total country is " + totalCountries.size());
		int number = totalCountries.size();

		for (int i = 0; i <= number; i++) {

			String countryName = select.getOptions().get(i).getText();
			String countryValue = select.getOptions().get(i).getAttribute("value");
			System.out.println("The name of the country is  " + countryName + " the value is " + countryValue);

			if (countryValue.equals("BD")) {
				// that means you want to stop the loop in this particular value.
				break; // nested for loop method.
			}
		}

	}

}

package com.salesForceDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

public class IsSelectedCondition {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// @Test(priority = 0)
	public void firstSelectedTest() throws InterruptedException {
		// if by default any element is selected.

		WebElement employee = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(employee);

		List<WebElement> allEmployee = select.getOptions();
		for (WebElement webElement : allEmployee) {
			String name = allEmployee.get(1).getText();
			System.out.println("the conuntry name is  " + name);

			boolean b = allEmployee.get(1).isSelected();// =true

			if (b == false) {
				System.out.println("by default it is  selected.");
				select.selectByIndex(11);
			} else {
				System.out.println("by default it is not selected.");
			}
			break;
		}

		Thread.sleep(1000);
	}

}

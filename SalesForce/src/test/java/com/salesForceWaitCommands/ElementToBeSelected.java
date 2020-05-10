package com.salesForceWaitCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementToBeSelected {
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
	public void elementToBeSelectedTest() {

		Select select = new Select(driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]")));
    	WebElement	selected=select.getFirstSelectedOption();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		boolean elementToBeSelected = wait.until(ExpectedConditions.elementToBeSelected(selected));
		System.out.println("elementToBeSelected results" + elementToBeSelected);
	}

	
}

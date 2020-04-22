package com.salesForceActionsClick;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=70130000000EqoP");

	}

	@Test(priority = 1)
	public void doubleClickTest1() throws Throwable {

		WebElement ce = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyEmployees')]"));
		Actions action = new Actions(driver);
		action.doubleClick(ce).build().perform();

	}

	@Test(priority = 1)
	public void doubleClickTest() throws Throwable {

		WebElement cc = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry')]"));
		Action action = new Actions(driver).doubleClick(cc).build();
		// Action action = new Actions
		// First action begin without s. just different way to do it;
		action.perform();
		Select select = new Select(cc);
		select.selectByIndex(11);
	}

}

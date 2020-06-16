package com.salesForceWaitCommands;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpectedConditionsTitleAndURL {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		System.out.println("All done");
		// driver.quit();
	}

	@Test(priority = 1)
	public void titleTest() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Boolean isTitleContain = wait.until(ExpectedConditions.titleContains("Salesforce:"));
		System.out.println("title Contains Salesforce " + isTitleContain);
		// assertEquals(driver.getTitle(), "title Contains Salesforce ");

		Boolean titleIs = wait
				.until(ExpectedConditions.titleIs("Salesforce: We Bring Companies and Customers Together"));
		System.out.println(" is this title from source " + titleIs);

		// check if the home title is correct String
		// This way we are checking: Title is coming from data base. data validity.
		String expectedHomeTitle = "Salesforce: We Bring Companies and Customers Together";
		boolean isTitleFromSource = wait.until(ExpectedConditions.titleIs(expectedHomeTitle));
		assertTrue(isTitleFromSource == true);
		System.out.println("source title test pass");

		assertEquals(driver.getTitle(), expectedHomeTitle);
		System.out.println("actual title and expected title test pass");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Test(priority = 2)
	public void URLtest() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Boolean urlContains = wait.until(ExpectedConditions.urlContains("www.salesforce.com"));
		System.out.println("urlContains salesforce " + urlContains);

		Boolean urlToBe = wait.until(ExpectedConditions.urlToBe("https://www.salesforce.com/"));
		System.out.println("urlToBe results is " + urlToBe);

		// check if the home url is correct .
		// This way we are checking: url is coming from data base. data validity.
		String expectedHomeURL = "https://www.salesforce.com/";
		boolean isURLeFromSource = wait.until(ExpectedConditions.urlToBe(expectedHomeURL));
		assertTrue(isURLeFromSource == true);
		System.out.println("source URL test pass");

		assertEquals(driver.getCurrentUrl(), expectedHomeURL);
		System.out.println("actual url and expected url test pass");

	}
}

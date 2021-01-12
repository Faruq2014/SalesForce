package com.salesForceActionsMouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverMultiLinkAtATime {
	public static WebDriver driver;


	@Test(priority = 1)
	public void actionClick() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.spicejet.com/");
		//driver.navigate().to("https://www.spicejet.com/RedHotOffers.aspx");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id*='HyperLinkLogin']")));
		WebElement login = driver.findElement(By.cssSelector("[id*='HyperLinkLogin']"));
		WebElement spcm = driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"));
		WebElement member = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
		Actions action = new Actions(driver);
		//action.moveToElement(login).build().perform();
		//action.moveToElement(spcm).build().perform();
		//action.moveToElement(member).click().build().perform();
		action.moveToElement(login).moveToElement(spcm).moveToElement(member).click().build().perform();
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(priority = 2)
	public void OneActionClick() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.spicejet.com/");

		WebElement login = driver.findElement(By.cssSelector("[id*='HyperLinkLogin']"));
		WebElement spcm = driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"));
		WebElement member = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
		Actions action = new Actions(driver);
		action.moveToElement(login).moveToElement(spcm).build().perform();
		action.moveToElement(member).click().build().perform();
		Thread.sleep(3000);
		driver.quit();
	}

}

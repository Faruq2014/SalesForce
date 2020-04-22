package com.salesForceActionsClick;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");

	}

	@Test(priority = 1)
	public void rightClickTest() throws InterruptedException {
		WebElement right = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement right1 = driver.findElement(By.xpath("/html/body/ul/li[2]/span"));
		Actions action = new Actions(driver);
		action.contextClick(right).build().perform();
		Thread.sleep(3000);
		action.contextClick(right1).build().perform();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();

	}

	@Test(priority = 2)
	public void rightClickTogetherTest() {
		WebElement right = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement right1 = driver.findElement(By.xpath("/html/body/ul/li[3]/span"));
		Actions action = new Actions(driver);
		action.contextClick(right).contextClick(right1).build().perform();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();

	}

}

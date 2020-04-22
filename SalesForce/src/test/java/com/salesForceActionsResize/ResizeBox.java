package com.salesForceActionsResize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeBox {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://jqueryui.com/resizable/");

	}

	@Test(priority = 1)
	public void resizeBoxTest() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement resize = driver.findElement(By.xpath("//body//div[3]"));
		Actions action = new Actions(driver);
		// action.dragAndDropBy(resize, 50, 50).build().perform();
		// Thread.sleep(3000);
		action.moveToElement(resize).dragAndDropBy(resize, 70, 70).build().perform();
		Thread.sleep(3000);
		// driver.close();

	}

}

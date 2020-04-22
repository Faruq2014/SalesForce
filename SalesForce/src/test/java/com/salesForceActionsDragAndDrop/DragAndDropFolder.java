package com.salesForceActionsDragAndDrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropFolder {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-folder-tree/drag-drop-folder-tree.html");

	}

	@Test(priority = 1)
	public void DragAndDMiltiClickTest() throws InterruptedException {
		WebElement source = driver.findElement(By.id("nodeATag2"));
		WebElement target = driver.findElement(By.id("nodeATag15"));
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release().build().perform();

	}

}

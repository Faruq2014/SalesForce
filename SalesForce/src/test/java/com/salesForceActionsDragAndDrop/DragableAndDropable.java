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

public class DragableAndDropable {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-2.html");

	}

	@Test(priority = 1)
	public void DragAndDMiltiClickTest() throws InterruptedException {

		WebElement source = driver.findElement(By.id("box1"));
		WebElement target = driver.findElement(By.id("dropBox"));
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release().build().perform();
		// action.dragAndDrop(source, target).build().perform();
	}

	@Test(priority = 2)
	public void DragAndDOneClickTest() throws InterruptedException {

		WebElement source = driver.findElement(By.id("box2"));
		WebElement target = driver.findElement(By.id("dropBox"));
		Actions action = new Actions(driver);
		// action.clickAndHold(source).moveToElement(target).release().build().perform();
		action.dragAndDrop(source, target).build().perform();
	}

	@Test(priority = 2)
	public void DragAndDmanyBoxAtATimeTest() throws InterruptedException {

		WebElement source1 = driver.findElement(By.id("box3"));
		WebElement source2 = driver.findElement(By.id("box4"));
		WebElement target = driver.findElement(By.id("dropBox"));
		Actions action = new Actions(driver);
		// action.clickAndHold(source).moveToElement(target).release().build().perform();
		action.dragAndDrop(source1, target).build().perform();
		action.dragAndDrop(source2, target).build().perform();
	}

}

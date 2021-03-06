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

public class DragAndDrop {

	public static WebDriver driver;

	@BeforeClass
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

	}

	@Test(priority = 1)
	public void DragAndDMiltiClickTest() throws InterruptedException {
		WebElement source = driver.findElement(By.id("box1"));
		WebElement target = driver.findElement(By.id("box101"));
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release().build().perform();

	}

	@Test(priority = 2)
	public void DragAndDropOneClickTest() throws InterruptedException {
		WebElement source = driver.findElement(By.id("box2"));
		WebElement target = driver.findElement(By.id("box102"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();

	}

	@Test(priority = 2)
	public void manyBoxClickTest() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement source3 = driver.findElement(By.id("box3"));
		WebElement target3 = driver.findElement(By.id("box103"));
		action.dragAndDrop(source3, target3).build().perform();

		WebElement source4 = driver.findElement(By.id("box4"));
		WebElement target4 = driver.findElement(By.id("box104"));
		action.dragAndDrop(source4, target4).build().perform();

		WebElement source5 = driver.findElement(By.id("box5"));
		WebElement target5 = driver.findElement(By.id("box105"));
		action.dragAndDrop(source5, target5).build().perform();
	}

}

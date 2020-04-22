package com.salesForceDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiSelect {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframe);
	}

	@BeforeMethod
	public void openingTesst() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<starting the test>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Test(priority = 1)
	public void selectAllTest() {

		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select1.selectByIndex(0);
		select1.selectByValue("saab");
		select1.selectByVisibleText("Audi");
	}

	@Test(priority = 2)
	public void deSelectTest() throws InterruptedException {
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select1.deselectByIndex(0);

	}

	@Test(priority = 3)
	public void deSelectAllTest() throws InterruptedException {
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select1.deselectAll();
	}

	@Test(priority = 4)
	public void SelectedOptionTest() throws InterruptedException {
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select1.selectByIndex(0);
		select1.selectByValue("saab");
		select1.selectByVisibleText("Audi");

		List<WebElement> selectedOptions = select1.getAllSelectedOptions();
		for (WebElement selectedCar : selectedOptions) {
			String id = selectedCar.getAttribute("value");
			String text = selectedCar.getText();
			System.out.println(id + " is value and text is " + text);

		}
		int totla = selectedOptions.size();
		System.out.println("Total number of selected cars is " + totla);
	}

	@Test(priority = 5)
	public void allOptionTest() {
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		List<WebElement> allCars = select1.getOptions();
		for (WebElement car : allCars) {
			String value = car.getAttribute("value");
			String tag = car.getTagName();
			String text = car.getText();
			System.out.println(tag + " is tag " + text + " is text " + value + " is value");
		}

		System.out.println("Total number of cars is " + allCars.size());

	}
}

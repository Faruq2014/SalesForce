package com.SalesForceIFrame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.salesForceWindowHandleLibrary.WindowHandleLibrary;

public class SwitchByWebElement {

public static WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void switchByElement() throws InterruptedException {

		//Click on login button
		System.out.println("Click on login");
		driver.findElement(By.xpath("//a[@href = 'https://login.salesforce.com/']")).click();

		Thread.sleep(2000);

		//go to iframe
		System.out.println("Switching to Iframe");
		driver.switchTo().frame(0);

		//click on "Start my Free Trial"
		System.out.println("Click on Start My Free Trial");
		driver.findElement(By.xpath("//a[@class = 'btn btn-lg btn-neutral-snow salesforce-sans-regular    ']")).click();


		// get window handles
		System.out.println("Swithing to new window");
		WindowHandleLibrary window = new WindowHandleLibrary(driver);
		window.switchToWindowByIndex(1);

		String title= driver.getTitle();

		if (title.equalsIgnoreCase("Free Trial - Salesforce.com")){

		System.out.println("Insert into the Form");
		driver.findElement(By.xpath("//*[@class = 'option-ui '][1]")).click();

		driver.findElement(By.xpath("//input[starts-with(@id, 'CompanyName')]")).sendKeys("Mollah INC");
		driver.findElement(By.xpath("//input[starts-with(@id, 'UserTitle')]")).sendKeys("CEO");
		driver.findElement(By.xpath("//*[@class = 'btn-container'][2]")).click();

		driver.findElement(By.xpath("//input[@name= 'UserFirstName']")).sendKeys("UserFirstName");
		driver.findElement(By.xpath("//input[starts-with(@id,'UserLastName')]")).sendKeys("UserLastName");
		driver.findElement(By.xpath("(//*[@class = 'checkbox-ui'])[2]")).click();
		}
		else if(title.equalsIgnoreCase("Sales Cloud Free Trial - Salesforce.com")){

		   //Fill the text fields
		System.out.println("Insert into the Form");
		driver.findElement(By.xpath("//input[@name= 'UserFirstName']")).sendKeys("UserFirstName");
		driver.findElement(By.xpath("//input[starts-with(@id,'UserLastName')]")).sendKeys("UserLastName");
		Select select = new Select(driver.findElement(By.xpath("//*[starts-with(@id,'CompanyEmployees')][1]")));
		select.selectByVisibleText("1 - 20 employees");

		driver.findElement(By.xpath("//*[@class = 'checkbox-ui']")).click();

		}

		//Close all the windows
		System.out.println("Close all the windows");
		//driver.quit();
}
}

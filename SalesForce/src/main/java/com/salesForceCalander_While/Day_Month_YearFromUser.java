package com.salesForceCalander_While;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day_Month_YearFromUser {
	public static WebDriver driver;
	@BeforeTest
	public void init() {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test(priority = 1)
public static void departDate() {
		

		//String expectedDate=EnterDepartDate;
		String expectedDate="10-October-2020";
		String edaye=expectedDate.split("-")[0];
		String emonth=expectedDate.split("-")[1];
		String eyear=expectedDate.split("-")[2];
		System.out.println(edaye+"/"+emonth+"/"+eyear);
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, 3000);
		WebElement dButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")));
		dButton.click();
		String cMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		String cyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		WebElement next;
		while((!cMonth.equalsIgnoreCase(emonth)) || (!cyear.equalsIgnoreCase(eyear))) {
			next=driver.findElement(By.xpath("//span[text()='Next']"));
			next.click();
			 cMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		    cyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		
		}
		
	List<WebElement>dates=	driver.findElements(By.xpath("//a[@class='ui-state-default']"));
	for (WebElement ele : dates) {
	if (ele.getText().trim().equalsIgnoreCase(edaye)) {
		ele.click();
		break;
	}	
	}
	
	}

	@Test(priority = 2)
public static void returnDay() {
	//String expectedDate=EnterReturnDate;
		String expectedDate="15-November-2020";
		String edaye=expectedDate.split("-")[0];
		String emonth=expectedDate.split("-")[1];
		String eyear=expectedDate.split("-")[2];
		System.out.println(edaye+"/"+emonth+"/"+eyear);
		WebDriverWait wait= new WebDriverWait(driver, 3000);
		WebElement dButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_mainContent_view_date2']")));
		//WebElement dButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")));
		
		dButton.click();
		String cMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		String cyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		WebElement next;
		while((!cMonth.equalsIgnoreCase(emonth)) || (!cyear.equalsIgnoreCase(eyear))) {
			next=driver.findElement(By.xpath("//span[text()='Next']"));
			next.click();
			 cMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText().trim();
		    cyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText().trim();
		
		}
		
	List<WebElement>dates=	driver.findElements(By.xpath("//a[@class='ui-state-default']"));
	for (WebElement ele : dates) {
	if (ele.getText().trim().equalsIgnoreCase(edaye)) {
		ele.click();
		break;
	}	
	}
	
	
	}

}

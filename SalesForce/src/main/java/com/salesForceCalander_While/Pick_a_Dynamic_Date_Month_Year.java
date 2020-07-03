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

public class Pick_a_Dynamic_Date_Month_Year {
	

	
	public static WebDriver driver;
	public static void main(String[] args) {
		departDate("10-july-2020");
		returnDay("20-july-2020");
		
	}
	public static void departDate(String EnterDepartDate) {
		

		String expectedDate=EnterDepartDate;
		
		String edaye=expectedDate.split("-")[0];
		String emonth=expectedDate.split("-")[1];
		String eyear=expectedDate.split("-")[2];
		System.out.println(edaye+"/"+emonth+"/"+eyear);
		
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	public static void returnDay(String EnterReturnDate) {

		

		String expectedDate=EnterReturnDate;
		
		String edaye=expectedDate.split("-")[0];
		String emonth=expectedDate.split("-")[1];
		String eyear=expectedDate.split("-")[2];
		System.out.println(edaye+"/"+emonth+"/"+eyear);
		
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 3000);
		WebElement dButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")));
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

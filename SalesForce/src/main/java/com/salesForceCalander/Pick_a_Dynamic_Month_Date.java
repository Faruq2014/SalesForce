package com.salesForceCalander;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_Dynamic_Month_Date {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		//JavascriptExecutor jse= (JavascriptExecutor)driver;
		//jse.executeScript("window.location='https://www.expedia.ca/'");
		driver.get("https://www.expedia.ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String month="July 2020";
		
		String month1="August,2020";
		String month2 ="September,";
		String month3 ="December,";
		String exp_day="20";
		
		driver.findElement(By.xpath("//button[contains(text(),'Jul 2')]")).click();
		System.out.println("the months are:");
		
		while (true) {
				
String text=driver.findElement(By.xpath("//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-new-date-picker-desktop-pagination-container']")).getText().trim();
			System.out.println(text);
		//String[] data=text.split("\n");
		
		if (text.equalsIgnoreCase(month)) {
			break;
		}else {
			driver.findElement(By.xpath("//div[@class='uitk-calendar']//button[2]")).click();
		
		// it will click until found the month we are looking for. 
		}	
		
		Thread.sleep(3000);
	List <WebElement> elements=driver.findElements(By.xpath("//div[@class='uitk-calendar']//div[1]//table[1]//tbody[1]//tr//td//button[1]"));
		for (WebElement ele : elements) {
			String date_text=ele.getText();
			String date[]=date_text.split("\n");
			if (date[0].equals(exp_day)) {
				ele.click();
				break;
			}
		}
		
	
		
		}
			//driver.quit();
	}
	
	 
	
}

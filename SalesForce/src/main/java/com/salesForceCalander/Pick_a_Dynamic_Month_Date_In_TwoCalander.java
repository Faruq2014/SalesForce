package com.salesForceCalander;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pick_a_Dynamic_Month_Date_In_TwoCalander {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.phptravels.net/'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String month="July,";
		
		String month1="August,";
		String month2 ="September,";
		String month3 ="December,";
		String day="20";
		// bellow line is just to login pop up disappear
		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		System.out.println("the months are:");
		while (true) {
		String text=driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/nav/div[2]")).getText();
		// this line is always click in current month. since we use while loop, it will print all the month unitl 
		// it found the true condition.
		
		System.out.println(text);
		String[] data=text.split("\n");
		// there are two elements it is printing , (july, 2020;) but we only want to match the month.
		// so we use split method and create a array. and use the 0th elements of the array. 
		if (data[0].equalsIgnoreCase(month1)) {
			break;
		}else {
			driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/nav/div[3]")).click();
		// it will click until found the month we are looking for. 
		}	
		
		
//String ele=driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).getText().trim();
		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));		
		for (WebElement ele : dates) {
			String[] data1=ele.getText().trim().split("/n");
			//System.out.println(ele);
			if (data1[0].equalsIgnoreCase(day)) {
				ele.click();
				//driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).click();
			break;
			}
		}
		// there are three elements it is printing , (20,july, 2020;) but we only want to match the day.
			// so we use split method and create a array. and use the 0th elements of the array.
			System.out.println("the dates are ");
			
		
	
		
		}
			//driver.quit();
	}
	
	 
	
}

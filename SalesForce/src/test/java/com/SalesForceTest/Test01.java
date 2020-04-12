package com.SalesForceTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test01 {
	public static WebDriver driver;

	@Test
	public void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		findPapentWindow();
		
		driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
		driver.findElement(By.xpath("//a[@id='terms-link']")).click();
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
	
		findAllWindowsCount();
		findAllWindowID();

		switchToWindowByTitle("Cookies Policy");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("jjjj");
		
		
		switchToWindowByTitle("Data Policy");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("jjjj");
		//driver.quit();
		
		//Cookies Policy
		//Facebook - Log In or Sign Up
		//Facebook Policies | Facebook
		//Data Policy
		//Terms of Service
		
	}

	
	
	
	
	
	
	
	
	
	
	public void findPapentWindow(){
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		System.out.println("parent window id is " + parent);
	}
	
	public void findAllWindowsCount(){
		Set<String> AllWindow = driver.getWindowHandles();
		int count = AllWindow.size();
		System.out.println("how many window we have " + count);
	}
	
	public void findAllWindowID(){
		Set<String> AllWindow = driver.getWindowHandles();
		for (String child : AllWindow) {
		System.out.println("Window---" + child);
		}
	} 
	
	public void switchToWindowByTitle(String title){
		
		Set<String> AllWindow = driver.getWindowHandles();

		for (String child : AllWindow) {

			String childTitle = driver.getTitle();

			if (childTitle.equalsIgnoreCase(title)) {
					break;
			}
			else{
				driver.switchTo().window(child);
				
			}
		}
	}
	
	
}

package com.SalesForceWindowHandleListSet;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.salesForceWindowHandleLibrary.SwitchWindowByListSet;

public class MasterTitle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Parenttitle = driver.getTitle();
		
		//open java base pop up or window.
		System.out.println("parent title is " + Parenttitle);
		driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
		driver.findElement(By.xpath("//a[@id='terms-link']")).click();
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
		Set<String> AllWindow = driver.getWindowHandles();
        int count = AllWindow.size();
		System.out.println("how many window we have " + count);
		
		// switch to child one
		SwitchWindowByListSet switchW = new SwitchWindowByListSet(driver);
		switchW.toTitle("Data Policy");
		Thread.sleep(3000);
		String childTitle1 = driver.getTitle();
		System.out.println("Child title is " + childTitle1);
        Thread.sleep(2000);
        
        // switch to child2
        switchW.toTitle("Terms of Service");
		Thread.sleep(3000);
		String childTitle2 = driver.getTitle();
		System.out.println("Child title is " + childTitle2);
        Thread.sleep(2000);
        
     // switch to child3
        switchW.toTitle("Cookies Policy");
		Thread.sleep(3000);
		String childTitle3 = driver.getTitle();
		System.out.println("Child title is " + childTitle3);
        Thread.sleep(2000);
       
        // switch to parent.
		switchW.toTitle("Facebook - Log In or Sign Up");
		String ParenURL = driver.getCurrentUrl();
		System.out.println("parent url is " + ParenURL);
		//driver.quit();

	}

}

package com.salesForceJavaScriptExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HowToScrollIntoView {
	public static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement help=driver.findElement(By.xpath("//*[@id='pageFooterChildren']/ul/li[30]/a"));
	JavascriptExecutor jse= (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true);",help);
	System.out.println(help.getText());
	help.click();
	driver.close();
	
	/* happy scrollIntoView 
	 *
	 * 
	 * */
	
	}

}

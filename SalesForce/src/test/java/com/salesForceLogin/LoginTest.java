package com.salesForceLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public static WebDriver driver;
	@BeforeClass
	public void setUP() {
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void loginWithValidCredentialTest() {
		Login login = new Login(driver);
		login.loginPage("dddd", "1234");
		
	}
	
	
	  @AfterClass public void destroy_setUp() { driver.quit(); }
	 
}

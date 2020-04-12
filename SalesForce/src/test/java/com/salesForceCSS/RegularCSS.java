package com.salesForceCSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegularCSS {
public static WebDriver driver;
@BeforeClass
public void openAPP() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("https://www.salesforce.com/");
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[@class='global-nav-login-flydown global-login']/div/div/a")).click();
}

@Test(priority=0)
public void oneAttributeTest() {
	
	//CSS formula = [attribute=’value’]
	
	//driver.findElement(By.cssSelector("[id='username']")).sendKeys("aaaa");
	//driver.findElement(By.cssSelector("#username")).sendKeys("aaaa");
	
	//driver.findElement(By.cssSelector("[name='username']")).sendKeys("aaaa");
	//driver.findElement(By.cssSelector(".username")).sendKeys("aaaa");
	
	driver.findElement(By.cssSelector("[type='email']")).sendKeys("aaaa");
}
@Test(priority=1)
public void twoAttributeTest() {
	//CSS formula = [attribute=’value’][attribute=’value’]
	driver.findElement(By.cssSelector("[name='pw'][type='password']")).sendKeys("bbbbbb");
}

@Test(priority=2)
public void startWithAttributeTest() {
	//CSS formula = [attribute^=’value’]  ^ means start with
	driver.findElement(By.cssSelector("[id^='forgot_password']")).click();
}


@Test(priority=3)
public void endsWithAttributeTest() {
	//CSS formula = [attribute$=’value’] $ mean ends with (do not use it, really does not work.)
	driver.findElement(By.cssSelector("[class$='input wide mb12 mt8 username']")).sendKeys("cccc");
}

@Test(priority=4)
public void SubstringTest() throws InterruptedException {Thread.sleep(3000);
//CSS formula = [attribute*=’value’]  * means substring, if you have a attribute change dynamically at the begaining 
// and at the end but at the middle it does unchange,or some part of it remain unchange then * is a good choice.
	driver.findElement(By.cssSelector("[class*=' button fiftyfifty ']")).click();
}

}

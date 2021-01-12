package com.salesForceDropDown;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basics2ForBatch {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.salesforce.com/form/signup/freetrial-elf-v2/?d=cta-li-promo-147");
		driver.get("https://www.salesforce.com/form/demo/salesforce-products/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	//@Test 
	public void selectExplain() {
		WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(country);
		select.selectByIndex(12);
		
	}
	
	//@Test 
	public void selectExplain2() {
		WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(country);
		//select.selectByIndex(12);
		select.selectByValue("BD");
		
	}
	
	
	//@Test 
	public void selectExplain3() {
		WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(country);
		//select.selectByIndex(12);
		//select.selectByValue("BD");
		select.selectByVisibleText("Morocco");
		
		}
	
	//@Test
	public void exp() {
		selectExplain4();
	}
	
	
	
		
	WebElement selectExplain4() {
		//WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(driver.findElement(By.name("CompanyCountry")));
		//select.selectByIndex(12);
		//select.selectByValue("BD");
		select.selectByVisibleText("Morocco");
		return null;
		
	}
	
	
	//@Test 
		public void selectSize() {
			WebElement country=driver.findElement(By.name("CompanyCountry"));
			
			Select select= new Select(country);
			List<WebElement>allConunt=select.getOptions();
			
			int total=allConunt.size();
			System.out.println(total);
			
			//System.out.println(allConunt.size());
			}
	
	//@Test 
	public void selectprintAllTheValues() {
		WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(country);
		List<WebElement>allConunt=select.getOptions();
		
		int total=allConunt.size();
		System.out.println(total);
		
		for (WebElement i : allConunt) {
			System.out.println(i.getText());
		}
		
		}
	
	@Test 
	public void selectprintAllTheValuesWithRegularLoop() {
		WebElement country=driver.findElement(By.name("CompanyCountry"));
		
		Select select= new Select(country);
		List<WebElement>allConunt=select.getOptions();
		
		int total=allConunt.size();
		System.out.println(total);
		
		for (int i = 0; i < total; i++) { 
			try {
				//System.out.println(allConunt.get(i).getText());
				String c49=allConunt.get(49).getText();
			
				Assert.assertEquals("Test fail",c49, "Colombia");
				break;
			} catch (Exception e) {
				System.out.println(e);
				System.err.println("test did not pass, might a bug");
			}
		}
		
		
		
		}
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//@Test(priority = 0)
	public void generalTest() {

		Select select = new Select(driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]")));

		// WebElement
		// country=driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		// Select select1 = new Select(country);
		select.selectByIndex(1);
		select.selectByValue("BD");
		select.selectByVisibleText("American Samoa");

	}

	//@Test(priority = 1)
	public void indexTest() {
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByIndex(12);
	}

	//@Test(priority = 2)
	public void VisibleTextTest() {
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByVisibleText("Antarctica");

	}

	// @Test(priority = 3)
	public void ValueTest() throws InterruptedException {
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[starts-with(@id,'CompanyCountry-')]"));
		Select select = new Select(country);
		select.selectByValue("BD");

	}

}

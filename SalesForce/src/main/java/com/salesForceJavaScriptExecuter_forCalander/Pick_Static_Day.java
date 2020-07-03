		package com.salesForceJavaScriptExecuter_forCalander;
		
		import java.util.concurrent.TimeUnit;
		
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;
		
		public class Pick_Static_Day {
		public static WebDriver driver;
			public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver(options);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.location='http://demo.automationtesting.in/Datepicker.html'");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//jse.executeScript("document.getElementById('datepicker1').value='09/12/2020',");
		
		jse.executeScript("document.querySelector('#datepicker1').value='09/12/2017',");

			}
			
		}

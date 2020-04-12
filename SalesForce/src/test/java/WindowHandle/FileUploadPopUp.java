package WindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadPopUp {
	static WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://html.com/input-type-file/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void fileUpload() {
		
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Faruq\\Desktop");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		//driver.quit();
	
	}
	//@Test(priority=2)
	public void allert() throws InterruptedException {
		Thread.sleep(3000);
		Alert al= driver.switchTo().alert();
		System.out.println("allert message"+al.getText());
		al.dismiss();
	}

}

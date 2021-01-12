	package com.salesforce.login;
	
	import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
	
	public class Login {
	
		
	public  WebDriver driver;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	public WebElement login_Link;
	
	/*
	 * public Login(WebDriver driver) { this.driver= driver; }
	 */

	public void clickOnLoginLink() {
		login_Link.click();
		
	}
	
	//driver.findElement(By.xpath("(//div[@class='dropdown']/a)[2]")).click();
	
	@FindBy(how = How.ID, using = "username")private WebElement userid;
	
	public void enterYourUserName() {
		userid.sendKeys("Faruq");
		
	}
	
	@FindBy(how = How.CSS, using = "#password")private WebElement password;
	
	public void enterYourPassword() {
		password.sendKeys("qqqqq");
		
	}
	
	
	@FindBy(how = How.CSS, using = "#Login")private WebElement submit;
	
	public void clickOnSubmitButton() {
		submit.sendKeys(Keys.ENTER);
		
	}
	}

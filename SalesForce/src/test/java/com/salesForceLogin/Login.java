	package com.salesForceLogin;
	
	import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
	
	public class Login {
	
		
	public  WebDriver driver;
	
	public Login(WebDriver driver) {
		//super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class='img-responsive']")
	public WebElement login_Link;
	
	

	public void clickOnLoginLink() {
		login_Link.click();
		
	}
	

	
	@FindBy(how = How.ID, using = "username")private WebElement userid;
	
	public void enterYourUserName(String whatIsYourUserName) {
		userid.sendKeys(whatIsYourUserName);
		
	}
	
	@FindBy(how = How.CSS, using = "#password")private WebElement password;
	
	public void enterYourPassword(String whatIsYourPassword) {
		password.sendKeys(whatIsYourPassword);
		
	}
	
	
	@FindBy(how = How.CSS, using = "#Login")private WebElement submit;
	
	public void clickOnSubmitButton() {
		submit.sendKeys(Keys.ENTER);
		
	}
	
	public void loginPage(String whatIsYourUserName, String whatIsYourPassword) {
		this.clickOnLoginLink();
		this.enterYourUserName(whatIsYourUserName);
		this.enterYourPassword( whatIsYourPassword);
		this.clickOnSubmitButton();
	}
	

	}

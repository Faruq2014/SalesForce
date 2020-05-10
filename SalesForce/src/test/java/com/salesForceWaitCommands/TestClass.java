package com.salesForceWaitCommands;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestClass {
	 WebDriver driver; 
	  WebDriverWait wait; 

	  //this is where chromedriver.exe should be 
	 // String driverPath = "c:/browserdrivers/chromedriver.exe"; 

	  @Before 
	  public void setUp() { 
		  WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
	    wait = new WebDriverWait(driver, 10); 
	  } 

	  @After 
	  public void tearDown() { 
	    driver.quit(); 
	  } 

	  @Test 
	  public void clickElementWithExplicitWait() 
	    throws InterruptedException { 

	    //open site 
	    driver.get("http://www.vpl.ca"); 

	    //finds the search box 
	    By searchBoxId = By.id("edit-search"); 
	    WebElement searchBox = wait.until
	                              (ExpectedConditions
	                                  .elementToBeClickable
	                                     (searchBoxId)); 

	    //types in the search box 
	    searchBox.click(); 
	    searchBox.clear(); 
	    searchBox.sendKeys("java"); 

	    //finds the search button 
	    By searchButtonId = By.id("edit-submit"); 
	    WebElement searchButton = wait.until
	                               (ExpectedConditions
	                                 .visibilityOfElementLocated
	                                   (searchButtonId)); 

	    //clicks the search button 
	    searchButton.click(); 

	    //delay so you can see whats happening in the browser 
	    Thread.sleep(10000); 

	    //find all titles using visibilityOfAllElementsLocatedBy 
	    By titleLocator = By.xpath("//a[@testid = 'bib_link']"); 
	    List<WebElement> titles = wait.until
	                               (ExpectedConditions.
	                                  visibilityOfAllElementsLocatedBy
	                                    (titleLocator)); 

	    //get the number of titles found 
	    int titleCount = titles.size();

	    //check that the title count is equal to 25 
	    assertEquals(titleCount, 25); 
	    System.out.println("title count = " + titleCount);

	    //find all authors using presenceOfAllElementsLocatedBy 
	    By authorLocator = By.xpath("//a[@testid = 'author_search']"); 
	    List<WebElement> authors = wait.until(
	                                 ExpectedConditions
	                                   .presenceOfAllElementsLocatedBy
	                                     (authorLocator)); 

	    //get the number of authors found 
	    int authorCount = authors.size();
	  
	    //check that the author count is > 0 
	    assertTrue(authorCount > 0); 
	    System.out.println("author count = " + authorCount);
	 }
}

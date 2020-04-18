package com.salesForceWindowHandleLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandleLibrary {
public  WebDriver driver;
public WindowHandleLibrary(WebDriver driver) {
	this.driver=driver;
}
	public void findPapentWindow(){
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		System.out.println("parent window id is " + parent);
	}
	
	public void findAllWindowsCount(){
		Set<String> AllWindow = driver.getWindowHandles();
		int count = AllWindow.size();
		System.out.println("how many window we have " + count);
	}
	
	public void findAllWindowID(){
		Set<String> AllWindow = driver.getWindowHandles();
		for (String child : AllWindow) {
		System.out.println("Window---" + child);
		}
	} 
	
	public void switchToWindowByTitle(String title){
		
		Set<String> AllWindow = driver.getWindowHandles();
		int count = AllWindow.size();
		for (String child : AllWindow) {
			int i=0;
			String childTitle = driver.getTitle();

			if (childTitle.equalsIgnoreCase(title)) {
				break;
			}
			else{	
				if(i  > count){
					driver.switchTo().window(child);
					i++;
				}
				else{
					break;
				}
			}
		}
	}
	
	public void switchToWindowByIndex(int index){
		
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowStrings = new ArrayList<>(windowHandles);
	    driver.switchTo().window(windowStrings.get(index));
	}
	
	public void findWindowsIndexWithTitle(){
		
		Set<String> AllWindow = driver.getWindowHandles();
		List<String> windowStrings = new ArrayList<>(AllWindow);
		int count = AllWindow.size();
		
		for (int i=0; i<count; i++){
			
			System.out.print("Index-------  " + i);
		    driver.switchTo().window(windowStrings.get(i));
			System.out.println("  ---Title-------  " + driver.getTitle());
			
		}
		
	}
}

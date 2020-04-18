package com.salesForceWindowHandleLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindowByIterator {

	WebDriver driver;

	public SwitchWindowByIterator(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean toIndex (int index) {  
		String Parent = driver.getWindowHandle();
		Set<String> AllWindow = driver.getWindowHandles();
		 List<String> windowStrings = new ArrayList<>(AllWindow);
		 java.util.Iterator<String> it=windowStrings.iterator();
		 while(it.hasNext()) {
			 for (String child : windowStrings)
			 if(!Parent.equalsIgnoreCase(child)) {
				 driver.switchTo().window(windowStrings.get(index));

				 return true; 
			 }
			 driver.switchTo().window(Parent);
		 }
		return false;
}
	
	
	
	

	public boolean toTitle(String title) {  
		String Parent = driver.getWindowHandle();
		Set<String> AllWindow = driver.getWindowHandles();
		// List<String> windowStrings = new ArrayList<>(AllWindow);
		 java.util.Iterator<String> it=AllWindow.iterator();
		 while(it.hasNext()) {
			 for (String child : AllWindow)
			 if(!Parent.equalsIgnoreCase(child)) {
				 driver.switchTo().window(child);
				 if (driver.getTitle().equalsIgnoreCase(title)) {
						return true;

					}
				 driver.switchTo().window(Parent);
			 }
			
		 }
		return false;
}

	
	public boolean toURL(String URL) {  
		String Parent = driver.getWindowHandle();
		Set<String> windowStrings =  driver.getWindowHandles();
		 java.util.Iterator<String> it=windowStrings.iterator();
		 while(it.hasNext()) {
			 for (String child : windowStrings)
			 if(!Parent.equalsIgnoreCase(child)) {
				 driver.switchTo().window(child);
				 if (driver.getCurrentUrl().equalsIgnoreCase(URL)) {
						return true;

					}
				 driver.switchTo().window(Parent);
			 }
			
		 }
		return false;
}
}

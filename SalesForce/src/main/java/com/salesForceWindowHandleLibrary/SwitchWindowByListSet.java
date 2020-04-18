package com.salesForceWindowHandleLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindowByListSet {
	

	WebDriver driver;

	public SwitchWindowByListSet(WebDriver driver) {
		this.driver = driver;
	}

	public boolean toTitle(String title) {
		String Parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String winID : windows) {
			if (!winID.equals(Parent_window)) {
				driver.switchTo().window(winID);
				if (driver.getTitle().equalsIgnoreCase(title)) {
					return true;

				}

				driver.switchTo().window(Parent_window);
			}
		}
		return false;
	}

	public boolean toURL(String URL) {
		String Parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String winID : windows) {
			if (!winID.equals(Parent_window)) {
				driver.switchTo().window(winID);
				if (driver.getCurrentUrl().equalsIgnoreCase(URL)) {
					return true;

				}

				driver.switchTo().window(Parent_window);
			}
		}
		return false;
	}

	public boolean toIndex(int index) {  // Experimenting method, work in progress. 
		String Parent = driver.getWindowHandle();
		Set<String> AllWindow = driver.getWindowHandles();
		 List<String> windowStrings = new ArrayList<>(AllWindow);
		for (String child : AllWindow) {
			 {
			if (!Parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(windowStrings.get(index));

				 return true;
			}
			 driver.switchTo().window(Parent);
		}
		
	}
		return false;

	}
	
	//begain
	
	public boolean toIterator (int index) {  // Experimenting method, work in progress. 
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
	
	
//last	
}
	

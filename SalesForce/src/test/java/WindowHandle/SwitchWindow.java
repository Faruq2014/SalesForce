package WindowHandle;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	

	WebDriver driver;

	public SwitchWindow(WebDriver driver) {
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

	public boolean toIndex(int index) {  //need improvement, child loop is not working.
		String Parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		 for (String winID : windows) {
			if (!winID.equals(Parent_window)) {
				driver.switchTo().window(winID);
				if (driver.equals(winID)) {
					return true;

				}

				driver.switchTo().window(Parent_window);
			}
		}
		return false;
	}

	public boolean toIndex2(int index) {  // Experimenting method, work in progress. 
		String Parent = driver.getWindowHandle();
		Set<String> AllWindow = driver.getWindowHandles();
		for (String child : AllWindow) {
			// if (!winID.equals(Parent_window)) {

			if (!Parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				// return true;
			}
			// driver.switchTo().window(Parent);
		}
		// return false;
		return false;
	}

}

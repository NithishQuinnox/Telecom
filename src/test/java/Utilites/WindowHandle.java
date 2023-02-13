package Utilites;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandle {
	WebDriver driver;

	public WindowHandle(WebDriver driver) {
		this.driver=driver;
	}

	public  void windowHandler() {

		String mainWindow=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		for (String child : childWindows) {
			if(!mainWindow.equals(child)) {
				driver.switchTo().window(child);
				//driver.close();
			}
			driver.switchTo().window(mainWindow);
		}
	}
}

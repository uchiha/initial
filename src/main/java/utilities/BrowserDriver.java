package utilities;

import org.openqa.selenium.WebDriver;

// static class to handle
// browser driver (any browsers)
public class BrowserDriver {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		return BrowserDriver.driver;
	}
	
	public static void setDriver(WebDriver driver) {
		BrowserDriver.driver = driver;
	}

}

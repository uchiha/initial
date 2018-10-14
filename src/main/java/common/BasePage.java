package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	protected long timeOut = 10;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		// new WebDriverWait(driver,
		// timeOut).until(((JavascriptExecutor)driver).executeScript("return
		// document.readyState").equals("complete")); <- needs work

	}
	
	protected WebElement findTheElementUntilVisible(LocatorWrapper samp) {
		return GetElements.findTheElementUntilVisible(driver, timeOut, samp);
	}

}

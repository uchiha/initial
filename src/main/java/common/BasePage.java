package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	protected WebDriver driver;
	protected long timeOut = 10;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		// new WebDriverWait(driver,
		// timeOut).until(((JavascriptExecutor)driver).executeScript("return
		// document.readyState").equals("complete")); <- needs work

	}
	
	public static By getByObjectFromLocator(LocatorWrapper locWrap) {
		By byObject = null;
		switch(locWrap.elementType) {
			case XPATH:
				byObject = By.xpath(locWrap.elementValue);
				break;
			case NAME:
				byObject = By.name(locWrap.elementValue);
				break;
			case ID:
				byObject = By.id(locWrap.elementValue);
				break;
			case CSS_SELECTOR:
				byObject = By.cssSelector(locWrap.elementValue);
				break;
				
		}
		return byObject;
	}

	protected WebElement findById(String loc) {
		return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
	}

	protected WebElement findByXPath(String loc) {
		return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
	}

	protected WebElement findByName(String loc) {
		return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.name(loc)));
	}
	
	protected WebElement findTheElementUntilVisible(LocatorWrapper samp) {
		WebElement elem = null;
		try {
			elem =  new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(getByObjectFromLocator(samp)));
		} catch(Exception e) {
			Assert.fail("The element named: \"" + samp.elementName + "\" was not found!");
		}
		
		return elem;
		
	}

}

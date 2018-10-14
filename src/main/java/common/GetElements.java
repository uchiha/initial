package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GetElements {
	
	private static By getByObjectFromLocator(LocatorWrapper locWrap) {
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
	
	protected static WebElement findTheElementUntilVisible(WebDriver driver, long timeOut, LocatorWrapper samp) {
		WebElement elem = null;
		try {
			elem =  new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(getByObjectFromLocator(samp)));
		} catch(Exception e) {
			Assert.fail("The element named: \"" + samp.elementName + "\" was not found!");
		}
		
		return elem;
		
	}

}

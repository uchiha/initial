package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected long timeOut = 60000;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement findById(String loc) {
		return new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));
	}

}

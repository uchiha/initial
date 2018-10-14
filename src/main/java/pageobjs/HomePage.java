package pageobjs;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.LocatorWrapper;

public class HomePage extends BasePage {
		
	private static final LocatorWrapper LOGIN_BUTTON = 
			new LocatorWrapper("Login Button", "(//a[contains(.,'Log in')])[2]", LocatorWrapper.LocatorType.XPATH);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void goToLoginPage() {
		findTheElementUntilVisible(LOGIN_BUTTON).click();
	}
	
}

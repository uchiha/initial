package pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.LocatorWrapper;

public class LoginPage extends BasePage {
	
	private static final LocatorWrapper USER_NAME = 
			new LocatorWrapper("User Name Input", "(//input[@name='session[username_or_email]'])[2]", LocatorWrapper.LocatorType.XPATH);
	private static final LocatorWrapper PASSWORD = 
			new LocatorWrapper("Password Input", "(//input[@name='session[password]'])[2]", LocatorWrapper.LocatorType.XPATH);
	private static final LocatorWrapper REMEMBER_ME = 
			new LocatorWrapper("Remember me tickbox", "(//input[@name='remember_me'])[2]", LocatorWrapper.LocatorType.XPATH);
	private static final LocatorWrapper ACTUAL_LOGIN =
			new LocatorWrapper("THE Login Button", "button[class = 'submit EdgeButton EdgeButton--primary EdgeButtom--medium']", LocatorWrapper.LocatorType.CSS_SELECTOR);


	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginWithCredentials(String username, String password) {
		WebElement tickBox = findTheElementUntilVisible(REMEMBER_ME);
		findTheElementUntilVisible(USER_NAME).sendKeys(username);
		findTheElementUntilVisible(PASSWORD).sendKeys(password);
		tickBox.click(); // don't remember me
		findTheElementUntilVisible(ACTUAL_LOGIN).click();
	}

}

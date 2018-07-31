package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class TwitterSmokeStepDefinition {
public WebDriver driver;
	
	@Before
	public void setupBrowser() {
		final String webAppUrl = System.getProperty("URL");
		System.setProperty("webdriver.chrome.driver", "src/main/java/utilities/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(webAppUrl);
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("I am in the twitter login or signup page")
	public void i_am_in_the_twitter_login_or_signup_page() {
	    System.out.println(">>>>>> yep, caught");
	}
}

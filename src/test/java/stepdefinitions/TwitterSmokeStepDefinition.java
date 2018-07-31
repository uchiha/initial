package stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjs.HomePage;
import pageobjs.LoginPage;
import pageobjs.TwitterUserHomePage;
import utilities.BrowserDriver;

public class TwitterSmokeStepDefinition {
	HomePage hPage;
	LoginPage loginP;
	TwitterUserHomePage twitterHome;

	@Before
	public void setupBrowser() {
		final String webAppUrl = System.getProperty("URL");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		// set the driver based on property above
		BrowserDriver.setDriver(new ChromeDriver());
		BrowserDriver.getDriver().get(webAppUrl);
	}

	@After
	public void tearDown() {
		BrowserDriver.getDriver().quit();
	}

	@Given("I am in the twitter home page")
	public void i_am_in_the_twitter_login_or_signup_page() {
		hPage = new HomePage(BrowserDriver.getDriver());
		hPage.goToLoginPage();
	}

	@Given("^login as \"([^\"]*)\" with password \"([^\"]*)\"$")
	public void loginAsGiven(String uName, String pWord) {
		loginP = new LoginPage(BrowserDriver.getDriver());
		loginP.loginWithCredentials(uName, pWord);
	}

	@Then("^I should land on my personal landing page \"([^\"]*)\"$")
	public void verifyUserLandingPage(String fullName) {
		twitterHome = new TwitterUserHomePage(BrowserDriver.getDriver());
		Assert.assertEquals(twitterHome.verifyDashboardProfileName(fullName), true,
				"The fullname: \"" + fullName + "\" was not found in the dashboard profile.");
	}

}

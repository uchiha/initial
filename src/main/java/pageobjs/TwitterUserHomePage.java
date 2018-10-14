package pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.LocatorWrapper;

public class TwitterUserHomePage extends BasePage {
		
	private static final LocatorWrapper DASHBOARD_PROFILE = 
			new LocatorWrapper("Dashboard Name", "//div[contains(@class,'DashboardProfileCard-content')]/..//a[contains(@class,'u-textInheritColor')]", LocatorWrapper.LocatorType.XPATH);

	public TwitterUserHomePage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyDashboardProfileName(String fullName) {

		boolean correctNameFound = false;
		WebElement profileName = findTheElementUntilVisible(DASHBOARD_PROFILE);

		// check that the text of profileName
		// in fact contains the set full name
		if (profileName.getText().contains(fullName)) {
			correctNameFound = true;
		}

		return correctNameFound;
	}

}

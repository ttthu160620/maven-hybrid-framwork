package pageObject.noopCommerce.admin;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;
public class AdminHomePageObject extends BasePage{
	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderIsDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminHomePageUI.DASHBOARD_HEADER);
	}
	
	
}

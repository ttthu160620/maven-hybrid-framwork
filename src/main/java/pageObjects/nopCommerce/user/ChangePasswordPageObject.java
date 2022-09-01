package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage{
	private WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getChangePasswordSuccessMessage(){
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
	
	public void clickToCloseIcon() {
		waitForClickable(driver, ChangePasswordPageUI.CLOSE_MESSAGE_ICON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_MESSAGE_ICON);
	}
}

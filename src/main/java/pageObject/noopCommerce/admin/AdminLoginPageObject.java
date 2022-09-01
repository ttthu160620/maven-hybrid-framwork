package pageObject.noopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;
import pageUIs.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void inputAdminEmailTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, email);
	}
	
	public void inputAdminPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
	}
	
	public AdminHomePageObject clickToAdminLoginButton() {
		waitForClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminHomePage(driver);
	}
	
	public AdminHomePageObject loginAsAdmin(String email, String password) {
		inputAdminEmailTextbox(email);
		inputAdminPasswordTextbox(password);
		return clickToAdminLoginButton();
	}
}

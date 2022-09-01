package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public RegisterPageObjects  clickToRegisterLink() {
		waitForClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public LoginPageObjects clickToLoginLink() {
		waitForClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getHometLoginPage(driver);
	}
	
	public CustomerInforPageObject clickMyAccountLink() {
		waitForClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}
	
	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	
	public HomePageObject openHomePage() {
		clickToElement(driver, HomePageUI.HOME_PAGE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public void clickToProductLinkInFeatureByText(String productText) {
		waitForClickable(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_IN_FEATURE_BY_TEXT, productText);
		clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_LINK_IN_FEATURE_BY_TEXT, productText);
	}
}

package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.AddressPageUI;
import pageUIs.user.CustomerInforPageUI;

public class AddressPageObject extends BasePage{
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void selectDropdownByID(String dropdownID, String textItem) {
		waitForClickable(driver, AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(driver, AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, textItem, dropdownID);
	}
	
	public String getFirstItemIsSelectedInBirthdayDropdownByID(String dropdownID) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getFirstItemIsSelectedDropdown(driver, AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}
	
	public String getAddressInfoByClass(String className) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_INFO_BY_CLASS, className);
		return getElementText(driver, AddressPageUI.DYNAMIC_INFO_BY_CLASS, className);
	}
}

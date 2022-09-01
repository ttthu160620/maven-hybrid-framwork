package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage{
	private WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean isCustomerInfoDisplayed() {
		waitForElementVisible (driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
	}
	
	public void checkGenderRadioByLabelName(String genderLabelName) {
		waitForClickable(driver, CustomerInforPageUI.DYNAMIC_GENGER_RADIO_BY_LABEL_NAME, genderLabelName);
		checkToDefaultCheckboxRadio(driver, CustomerInforPageUI.DYNAMIC_GENGER_RADIO_BY_LABEL_NAME, genderLabelName);
	}

	public void selectDropdownByName(String dropdownName, String textItem) {
		waitForClickable(driver, CustomerInforPageUI.DAY_OF_BIRTH_DROPDOWN_DYNAMIC, dropdownName);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.DAY_OF_BIRTH_DROPDOWN_DYNAMIC, textItem, dropdownName);
	}
	
	public boolean isGenderRadioByLabelNameSelected(String labelName) {
		waitForElementVisible(driver, CustomerInforPageUI.DYNAMIC_GENGER_RADIO_BY_LABEL_NAME, labelName);
		return isElementSelected(driver, CustomerInforPageUI.DYNAMIC_GENGER_RADIO_BY_LABEL_NAME, labelName);
	}
	
	public String getFirstItemIsSelectedInBirthdayDropdownByName(String dropdownName) {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_OF_BIRTH_DROPDOWN_DYNAMIC, dropdownName);
		return getFirstItemIsSelectedDropdown(driver, CustomerInforPageUI.DAY_OF_BIRTH_DROPDOWN_DYNAMIC, dropdownName);
	}
}

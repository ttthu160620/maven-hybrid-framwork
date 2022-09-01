package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.user.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getNoProductMessage() {
		waitForElementVisible(driver, SearchPageUI.NO_PRODUCT_MESSAGE);
		return getElementText(driver, SearchPageUI.NO_PRODUCT_MESSAGE);
	}
	
	public boolean isProductDisplayedByText(String productName) {
		waitForElementVisible(driver, SearchPageUI.DYNAMIC_PRODUCT_LINK_IN_HOMEPAGE_BY_TEXT, productName);
		return isElementDisplayed(driver, SearchPageUI.DYNAMIC_PRODUCT_LINK_IN_HOMEPAGE_BY_TEXT, productName);
	}
	
	public List<WebElement> getListResultProduct() {
		waitForAllElementsVisible(driver, SearchPageUI.LIST_PRODUCT_TEXT);
		List<WebElement> listProduct = getListWebElements(driver, SearchPageUI.LIST_PRODUCT_TEXT);
		return listProduct;
	}
	
	public void checkToCheckboxByLabelName(String labelName) {
		waitForClickable(driver, SearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
	}
	
	public void uncheckToCheckboxByLabelName(String labelName) {
		waitForClickable(driver, SearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
		uncheckToDefaultCheckbox(driver, SearchPageUI.DYNAMIC_CHECKBOX_BY_LABEL, labelName);
	}
	
	public void selectInDropdownByLabelName(String labelName, String textItem) {
		waitForClickable(driver, SearchPageUI.DYNAMIC_DROPDOWN_BY_LABEL, labelName);
		selectItemInDefaultDropdown(driver, SearchPageUI.DYNAMIC_DROPDOWN_BY_LABEL, textItem, labelName);
	}
	
	public SearchPageObject clickSearchInAdvancedButton() {
		waitForClickable(driver, SearchPageUI.SEARCH_IN_ADVANCED_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_IN_ADVANCED_BUTTON);
		return PageGeneratorManager.getSearchPage(driver);
	}
	
}

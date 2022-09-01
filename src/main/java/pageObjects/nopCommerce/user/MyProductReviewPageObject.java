package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyProductReviewPageUI;

public class MyProductReviewPageObject extends BasePage{
private WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickToAddReviewLink() {
		waitForClickable(driver, MyProductReviewPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, MyProductReviewPageUI.ADD_REVIEW_LINK);
	}
	
	public void inputReviewTextArea(String reviewText) {
		waitForAllElementsVisible(driver, MyProductReviewPageUI.REVIEW_TEXT_AREA);
		senkeyToElement(driver, MyProductReviewPageUI.REVIEW_TEXT_AREA, reviewText);
	}
	
	public void checkRatingRadioByLabel(String labelName) {
		waitForClickable(driver, MyProductReviewPageUI.DYNAMIC_ADD_PRODUCT_RATING_RADIO, labelName);
		checkToDefaultCheckboxRadio(driver, MyProductReviewPageUI.DYNAMIC_ADD_PRODUCT_RATING_RADIO, labelName);
	}
	
	public boolean isSuccessResultMessageDisplayed() {
		waitForElementVisible(driver, MyProductReviewPageUI.SUCCESSFUL_RESULT_MESSAGE);
		return isElementDisplayed(driver, MyProductReviewPageUI.SUCCESSFUL_RESULT_MESSAGE);
	}
	
	public String getReviewByClassName(String reviewClass) {
		waitForElementVisible(driver, MyProductReviewPageUI.DYNAMIC_REVIEW_BY_CLASS_NAME, reviewClass);
		return getElementText(driver, MyProductReviewPageUI.DYNAMIC_REVIEW_BY_CLASS_NAME, reviewClass);
	}
	
	public boolean isProductReviewInfoDisplayed(String productText) {
		waitForElementVisible(driver, MyProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_BY_TEXT_IN_MYACCOUNT, productText);
		return isElementDisplayed(driver, MyProductReviewPageUI.DYNAMIC_PRODUCT_REVIEW_BY_TEXT_IN_MYACCOUNT, productText);
	}
}

package pageUIs.user;

public class MyProductReviewPageUI {
	public static final String DYNAMIC_PRODUCT_LINK_IN_HOMEPAGE_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String ADD_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String REVIEW_TEXT_AREA = "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String DYNAMIC_ADD_PRODUCT_RATING_RADIO = "xpath=//input[@aria-label='%s']";
	public static final String SUCCESSFUL_RESULT_MESSAGE = "xpath=//div[contains(text(),'Product review is successfully added.')]";
	public static final String DYNAMIC_REVIEW_BY_CLASS_NAME = "xpath=//div[@class='%s']";
	public static final String DYNAMIC_PRODUCT_REVIEW_BY_TEXT_IN_MYACCOUNT = "xpath=//div[@class='review-info']//label[text()='Product review for:']/following-sibling::a[text()='%s']";
}

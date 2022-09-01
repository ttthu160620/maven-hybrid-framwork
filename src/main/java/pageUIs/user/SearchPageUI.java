package pageUIs.user;

public class SearchPageUI {
	public static final String NO_PRODUCT_MESSAGE = "css=.no-result";
	public static final String DYNAMIC_PRODUCT_LINK_IN_HOMEPAGE_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String LIST_PRODUCT_TEXT = "xpath=//h2[@class='product-title']/a";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input[@type='checkbox']";
	public static final String DYNAMIC_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::select";
	public static final String SEARCH_IN_ADVANCED_BUTTON = "xpath=//div[@class='buttons']/button[text()='Search']";
	
}

package pageUIs.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_LINK = "xpath=//li[@class='customer-info active']/a";
	public static final String ADDRESSES_LINK ="xpath=//li[@class='customer-addresses inactive']/a";
	public static final String ORDERS_LINK = "xpath=//li[@class='customer-orders inactive']/a";
	public static final String REWARD_POINT_LINK = "xpath=//li[@class='reward-points inactive']/a";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//li[@class='change-password inactive']/a";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//li[@class='customer-reviews inactive']/a";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String USER_LOGOUT_LINK ="xpath=//a[@class='ico-logout']";
	
	public static final String DYNAMIC_LINK_MY_ACCOUNT_AREA = "xpath=//div[@class='block block-account-navigation']//a[text()='%s']";
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_PRODUCT_LINK_IN_HOMEPAGE_BY_TEXT = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
}

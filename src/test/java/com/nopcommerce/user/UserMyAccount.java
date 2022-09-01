package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.AddressPageObject;
import pageObjects.nopCommerce.user.ChangePasswordPageObject;
import pageObjects.nopCommerce.user.CustomerInforPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.MyProductReviewPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import utilities.DataHelperFaker;

public class UserMyAccount extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	LoginPageObjects loginPage;
	CustomerInforPageObject customerInfoPage;
	AddressPageObject addressPage;
	ChangePasswordPageObject changePasswordPage;
	MyProductReviewPageObject productReviewPage;
	DataHelperFaker dataFaker;
	String email, firstName, lastName, password, newPassword;
	String firstNameID, lastNameID, emailID, passwordID, confirmPasswordID, companyID;
	String editFirstName, editLastName, editEmail, editCompany, dayOfBirth, monthOfBirth, yearOfBirth, attributeName;
	String country, state, city, address1, phoneNumber, zipCode;
	String productReview, reviewTitle, reviewText;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-Condition 01: Open browser: " + browserName + "and navigate to home page");
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition 02: Register successfuly");
		firstNameID = "FirstName";
		lastNameID = "LastName";
		emailID = "Email";
		passwordID = "Password";
		confirmPasswordID = "ConfirmPassword";
		companyID = "Company";
		attributeName = "value";
		
		dataFaker = DataHelperFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		newPassword = dataFaker.getPassword();
		country = "Viet Nam";
		state = "Other";
		city = "Da Nang";
		address1 = dataFaker.getAddress();
		zipCode = "550000";
		phoneNumber = dataFaker.getPhone();
		
		editFirstName = dataFaker.getFirstName();
		editLastName = dataFaker.getLastName();
		editEmail = dataFaker.getEmail();
		editCompany = dataFaker.getCompanyName();
		dayOfBirth = "28";
		monthOfBirth = "August";
		yearOfBirth = "2000";
		
		productReview = "Apple MacBook Pro 13-inch";
		reviewTitle = productReview + getRandomNumber();
		reviewText = "This is good item.";
		
		log.info("Precondition 02 - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Precondition 02 - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, "FirstName", firstName);
		
		log.info("Precondition 02 - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, "LastName", lastName);
		
		log.info("Precondition 02 - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, "Email", email);
		
		log.info("Precondition 02 - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "Password", password);
		
		log.info("Precondition 02 - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Precondition 02 - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Precondition 02 - Step 08: Verify successful register message is displayed");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		log.info("Precondition 02 - Step 09: Navigate to My Account page");
		customerInfoPage = homePage.clickMyAccountLink();
	}
	
	@Test
	public void My_Account_01_Update_Customer_Info() {
		log.info("My_Account_01_Update_Customer_Info - Step 01: Navigate to 'Customer Info' page");
		customerInfoPage.openDynamicMorePage(driver, "Customer info");
		
		log.info("My_Account_01_Update_Customer_Info - Step 02: Select Gender radio button");
		customerInfoPage.checkGenderRadioByLabelName("Female");
		
		log.info("My_Account_01_Update_Customer_Info - Step 03: Enter to First name textbox with value is: " + editFirstName);
		customerInfoPage.inputTextboxByID(driver, firstNameID, editFirstName);
		
		log.info("My_Account_01_Update_Customer_Info - Step 04: Enter to Last name textbox with value is: " + editLastName);
		customerInfoPage.inputTextboxByID(driver, lastNameID, editLastName);
		
		log.info("My_Account_01_Update_Customer_Info - Step 05: Select to Date of birth dropdown with value is:" + dayOfBirth);
		customerInfoPage.selectDropdownByName("DateOfBirthDay", dayOfBirth);
		
		log.info("My_Account_01_Update_Customer_Info - Step 06: Select to Month of birth dropdown with value is:" + monthOfBirth);
		customerInfoPage.selectDropdownByName("DateOfBirthMonth", monthOfBirth);
		
		log.info("My_Account_01_Update_Customer_Info - Step 07: Select to Year of birth dropdown with value is:" + yearOfBirth);
		customerInfoPage.selectDropdownByName("DateOfBirthYear", yearOfBirth);
		
		log.info("My_Account_01_Update_Customer_Info - Step 08: Enter to Email textbox with value is: " + editEmail);
		customerInfoPage.inputTextboxByID(driver, emailID, editEmail);
		
		log.info("My_Account_01_Update_Customer_Info - Step 09: Enter to Company textbox with value is: " + editCompany);
		customerInfoPage.inputTextboxByID(driver, companyID, editCompany);
		
		log.info("My_Account_01_Update_Customer_Info - Step 10: Click to 'Save' button.");
		customerInfoPage.clickToButtonByText(driver, "Save");
		
		log.info("My_Account_01_Update_Customer_Info - Step 11: Verify Gender radio button is selected");
		customerInfoPage.isGenderRadioByLabelNameSelected("Female");
		
		log.info("My_Account_01_Update_Customer_Info - Step 13: Verify First name value after updated");
		Assert.assertEquals(customerInfoPage.getAttributeTextboxByID(driver, firstNameID, attributeName), editFirstName);
		
		log.info("My_Account_01_Update_Customer_Info - Step 14: Verify Last name value after updated");
		Assert.assertEquals(customerInfoPage.getAttributeTextboxByID(driver, lastNameID, attributeName), editLastName);
		
		log.info("My_Account_01_Update_Customer_Info - Step 15: Verify Email value after updated");
		Assert.assertEquals(customerInfoPage.getAttributeTextboxByID(driver, emailID, attributeName), editEmail);
		
		log.info("My_Account_01_Update_Customer_Info - Step 16: Verify Company value after updated");
		Assert.assertEquals(customerInfoPage.getAttributeTextboxByID(driver, companyID, attributeName), editCompany);
		
		log.info("My_Account_01_Update_Customer_Info - Step 17: Verify Day Of Birth value is selected");
		Assert.assertEquals(customerInfoPage.getFirstItemIsSelectedInBirthdayDropdownByName("DateOfBirthDay"), dayOfBirth);
		
		log.info("My_Account_01_Update_Customer_Info - Step 18: Verify Month Of Birth value is selected");
		Assert.assertEquals(customerInfoPage.getFirstItemIsSelectedInBirthdayDropdownByName("DateOfBirthMonth"), monthOfBirth);
		
		log.info("My_Account_01_Update_Customer_Info - Step 19: Verify Year Of Birth value is selected");
		Assert.assertEquals(customerInfoPage.getFirstItemIsSelectedInBirthdayDropdownByName("DateOfBirthYear"), yearOfBirth);
	}
	
	@Test
	public void My_Account_02_Add_Address() {
		log.info("My_Account_02_Add_Address - Step 01: Navigate Address page");
		addressPage = (AddressPageObject) customerInfoPage.openPageAtMyAccountArea(driver, "Addresses");
		
		log.info("My_Account_02_Add_Address - Step 02: Click to 'Add New' button");
		addressPage.clickToButtonByText(driver, "Add new");
		
		log.info("My_Account_02_Add_Address - Step 03: Enter to First name textbox with value is: " + firstName);
		addressPage.inputTextboxByID(driver, "Address_FirstName", firstName);
		
		log.info("My_Account_02_Add_Address - Step 04: Enter to Last name textbox with value is: " + lastName);
		addressPage.inputTextboxByID(driver, "Address_LastName", lastName);
		
		log.info("My_Account_02_Add_Address - Step 05: Enter to Email textbox with value is: " + email);
		addressPage.inputTextboxByID(driver, "Address_Email", email);
		
		log.info("My_Account_02_Add_Address - Step 06: Enter to Company textbox with value is: " + editCompany);
		addressPage.inputTextboxByID(driver, "Address_Company", editCompany);
		
		log.info("My_Account_02_Add_Address - Step 07: Select to Country dropdown with value is: " + country);
		addressPage.selectDropdownByID("Address_CountryId", country);
		
		log.info("My_Account_02_Add_Address - Step 08: Select to State/Province dropdown with value is: " + state);
		addressPage.selectDropdownByID("Address_StateProvinceId", state);
		
		log.info("My_Account_02_Add_Address - Step 09: Enter to City textbox with value is: " + city);
		addressPage.inputTextboxByID(driver, "Address_City", city);
		
		log.info("My_Account_02_Add_Address - Step 10: Enter to Address1 textbox with value is: " + address1);
		addressPage.inputTextboxByID(driver, "Address_Address1", address1);
		
		log.info("My_Account_02_Add_Address - Step 11: Enter to Zip/ Postal code textbox with value is: " + zipCode);
		addressPage.inputTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("My_Account_02_Add_Address - Step 12: Enter to Phone number textbox with value is: " + phoneNumber);
		addressPage.inputTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("My_Account_02_Add_Address - Step 13: Click to 'Save' button");
		addressPage.clickToButtonByText(driver, "Save");
		
		log.info("My_Account_02_Add_Address - Step 14: Verify add address is successful");
		Assert.assertEquals(addressPage.getAddressInfoByClass("name"), firstName + " " + lastName);
		Assert.assertEquals(addressPage.getAddressInfoByClass("email"), "Email: " + email);
		Assert.assertEquals(addressPage.getAddressInfoByClass("phone"), "Phone number: " + phoneNumber);
		Assert.assertEquals(addressPage.getAddressInfoByClass("company"), editCompany);
		Assert.assertEquals(addressPage.getAddressInfoByClass("address1"), address1);
		Assert.assertEquals(addressPage.getAddressInfoByClass("city-state-zip"), city + ", " + zipCode);
		Assert.assertEquals(addressPage.getAddressInfoByClass("country"), country);
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		log.info("My_Account_03_Change_Password - Step 01: Navigate to Change Password page");
		changePasswordPage = (ChangePasswordPageObject) addressPage.openPageAtMyAccountArea(driver, "Change password");
		
		log.info("My_Account_03_Change_Password - Step 02: Enter to Old Password textbox with value is :" + password);
		changePasswordPage.inputTextboxByID(driver, "OldPassword", password);
		
		log.info("My_Account_03_Change_Password - Step 03: Enter to New Password textbox with value is :" + newPassword);
		changePasswordPage.inputTextboxByID(driver, "NewPassword", newPassword);
		
		log.info("My_Account_03_Change_Password - Step 04: Enter to Confirm Password textbox with value is :" + newPassword);
		changePasswordPage.inputTextboxByID(driver, "ConfirmNewPassword", newPassword);
		
		log.info("My_Account_03_Change_Password - Step 05: Click to 'Change Password' button");
		changePasswordPage.clickToButtonByText(driver, "Change password");
		
		log.info("My_Account_03_Change_Password - Step 06: Verify successful message is displayed");
		Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), "Password was changed");
		
		log.info("My_Account_03_Change_Password - Step 07: Click to close message icon");
		changePasswordPage.clickToCloseIcon();
		changePasswordPage.sleepInSecond(2);
		
		log.info("My_Account_03_Change_Password - Step 08: Click to 'Log out' link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("My_Account_03_Change_Password - Step 09: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("My_Account_03_Change_Password - Step 10: Enter to Email textbox with value is: " + editEmail);
		loginPage.inputTextboxByID(driver, emailID, editEmail);
		
		log.info("My_Account_03_Change_Password - Step 11: Enter to Password textbox with old password: " + password);
		loginPage.inputTextboxByID(driver, passwordID, password);
		
		log.info("My_Account_03_Change_Password - Step 12: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("My_Account_03_Change_Password - Step 13: Verify error message is displayed." );
		Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
		
		log.info("My_Account_03_Change_Password - Step 14: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("My_Account_03_Change_Password - Step 15: Enter to Email textbox with value is: " + editEmail);
		loginPage.inputTextboxByID(driver, emailID, editEmail);
		
		log.info("My_Account_03_Change_Password - Step 16: Enter to Password textbox with new password: " + newPassword);
		loginPage.inputTextboxByID(driver, passwordID, newPassword);
		
		log.info("My_Account_03_Change_Password - Step 17: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		
		log.info("My_Account_03_Change_Password - Step 18: Verify My Account link is displayed.");
		homePage.isMyAccountDisplayed();
	}
	
	@Test
	public void My_Account_04_My_Product_Review() {
		log.info("My_Account_04_My_Product_Review - Step 01: Navigate to home page");
		homePage.openHomePage();
		
		log.info("My_Account_04_My_Product_Review - Step 02: Click to product link is: " + productReview);
		homePage.clickToProductLinkInFeatureByText(productReview);
		
		log.info("My_Account_04_My_Product_Review - Step 03: Click to 'Add your review' link");
		productReviewPage = PageGeneratorManager.getMyProductPreviewPage(driver);
		productReviewPage.clickToAddReviewLink();
		
		log.info("My_Account_04_My_Product_Review - Step 04: Enter to Review title textbox with value is: " + reviewTitle);
		productReviewPage.inputTextboxByID(driver, "AddProductReview_Title", reviewTitle);
		
		log.info("My_Account_04_My_Product_Review - Step 05: Enter to Review text text area with value is: " + reviewText);
		productReviewPage.inputReviewTextArea(reviewText);
		
		log.info("My_Account_04_My_Product_Review - Step 06: Select rating radio button with value is: ");
		productReviewPage.checkRatingRadioByLabel("Good");
		
		log.info("My_Account_04_My_Product_Review - Step 07: Click to 'Submit Review' button");
		productReviewPage.clickToButtonByText(driver, "Submit review");
		
		log.info("My_Account_04_My_Product_Review - Step 08: Verify successful message is displayed");
		Assert.assertTrue(productReviewPage.isSuccessResultMessageDisplayed());
		
		log.info("My_Account_04_My_Product_Review - Step 09: Click to 'My Account' link");
		homePage.clickMyAccountLink();
		
		log.info("My_Account_04_My_Product_Review - Step 10: Navigate to 'My Product Review' page");
		productReviewPage = (MyProductReviewPageObject) customerInfoPage.openPageAtMyAccountArea(driver, "My product reviews");
		
		log.info("My_Account_04_My_Product_Review - Step 11: Verify review title");
		Assert.assertEquals(productReviewPage.getReviewByClassName("review-title"), reviewTitle);
		
		log.info("My_Account_04_My_Product_Review - Step 12: Verify review text");
		Assert.assertEquals(productReviewPage.getReviewByClassName("review-text"), reviewText);
		
		log.info("My_Account_04_My_Product_Review - Step 13: Verify product review is displayed");
		Assert.assertTrue(productReviewPage.isProductReviewInfoDisplayed(productReview));
	}
}

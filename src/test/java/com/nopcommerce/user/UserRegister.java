package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import utilities.DataHelperFaker;

public class UserRegister extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	DataHelperFaker dataFaker;
	String firstNameID, lastNameID, emailID, passwordID, confirmPasswordID;
	String firstNameMsgID, lastNameMsgID, emailMsgID, passwordMsgID, confirmPasswordMsgID;
	String invalidEmail, email, notFoundEmail, firstName, lastName, invalidPassword, password, invalidConfirmPassword;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstNameID = "FirstName";
		lastNameID = "LastName";
		emailID = "Email";
		passwordID = "Password";
		confirmPasswordID = "ConfirmPassword";
		
		firstNameMsgID = "FirstName-error";
		lastNameMsgID = "LastName-error";
		emailMsgID = "Email-error";
		passwordMsgID = "Password-error";
		confirmPasswordMsgID = "ConfirmPassword-error";
	
		dataFaker = DataHelperFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		notFoundEmail = dataFaker.getEmail();
		invalidEmail = "abc@abc";
		invalidPassword = "1234";
		invalidConfirmPassword = dataFaker.getPassword();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
	}
	
	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01_Empty_Data - Step 02: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_01_Empty_Data - Step 03: Verify error message in First name textbox");
		Assert.assertEquals(registerPage.getErrorMessageByID(firstNameMsgID), "First name is required.");
		
		log.info("Register_01_Empty_Data - Step 04: Verify error message in Last name textbox");
		Assert.assertEquals(registerPage.getErrorMessageByID(lastNameMsgID), "Last name is required.");
		
		log.info("Register_01_Empty_Data - Step 05: Verify error message in Email textbox");
		Assert.assertEquals(registerPage.getErrorMessageByID(emailMsgID), "Email is required.");
		
		log.info("Register_01_Empty_Data - Step 06: Verify error message in Password textbox");
		Assert.assertEquals(registerPage.getErrorMessageByID(passwordMsgID), "Password is required.");
		
		log.info("Register_01_Empty_Data - Step 07: Verify error message in Confirm Password textbox");
		Assert.assertEquals(registerPage.getErrorMessageByID(confirmPasswordMsgID), "Password is required.");
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02_Invalid_Email - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, firstNameID, firstName);
		
		log.info("Register_02_Invalid_Email - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, lastNameID, lastName);
		
		log.info("Register_02_Invalid_Email - Step 04: Enter to Email textbox with value: " + invalidEmail);
		registerPage.inputTextboxByID(driver, emailID, invalidEmail);
		
		log.info("Register_02_Invalid_Email - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, passwordID, password);
		
		log.info("Register_02_Invalid_Email - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, confirmPasswordID, password);
		
		log.info("Register_02_Invalid_Email - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_02_Invalid_Email - Step 08: Verify wrong email is displayed");
		Assert.assertEquals(registerPage.getExistingErrorMessage(), "Wrong email");
	}
	
	@Test
	public void Register_03_Successful() {
		log.info("Register_03_Successful - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, firstNameID, firstName);
		
		log.info("Register_03_Successful - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, lastNameID, lastName);
		
		log.info("Register_03_Successful - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, emailID, email);
		
		log.info("Register_03_Successful - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, passwordID, password);
		
		log.info("Register_03_Successful - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, confirmPasswordID, password);
		
		log.info("Register_03_Successful - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_03_Successful - Step 08: Verify successful register message is displayed");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		log.info("Register_03_Successful - Step 09: Click to 'Logout' link");
		registerPage.clickToLogoutLink();
	}
	
	@Test
	public void Register_04_Existing_Email() {
		log.info("Register_04_Existing_Email - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, firstNameID, firstName);
		
		log.info("Register_04_Existing_Email - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, lastNameID, lastName);
		
		log.info("Register_04_Existing_Email - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, emailID, email);
		
		log.info("Register_04_Existing_Email - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, passwordID, password);
		
		log.info("Register_04_Existing_Email - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, confirmPasswordID, password);
		
		log.info("Register_04_Existing_Email - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_04_Existing_Email - Step 08: Verify existed email message is displayed.");
		Assert.assertEquals(registerPage.getExistingErrorMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_Password_Less_6_Characters() {
		log.info("Register_05_Password_Less_6_Characters - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, firstNameID, firstName);
		
		log.info("Register_05_Password_Less_6_Characters - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, lastNameID, lastName);
		
		log.info("Register_05_Password_Less_6_Characters - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, emailID, email);
		
		log.info("Register_05_Password_Less_6_Characters - Step 05: Enter to Password textbox with value: " + invalidPassword);
		registerPage.inputTextboxByID(driver, passwordID, invalidPassword);
		
		log.info("Register_05_Password_Less_6_Characters - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, confirmPasswordID, password);
		
		log.info("Register_05_Password_Less_6_Characters - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_05_Password_Less_6_Characters - Step 08: Verify error message is displayed.");
		Assert.assertEquals(registerPage.getErrorMessagePasswordTextbox(), 
				  "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Confirm_Password_Different_Password() {
		log.info("Register_06_Confirm_Password_Different_Password - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, firstNameID, firstName);
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, lastNameID, lastName);
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, emailID, email);
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, passwordID, password);
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 06: Enter to Confirm Password textbox with value: " + invalidConfirmPassword);
		registerPage.inputTextboxByID(driver, confirmPasswordID, invalidConfirmPassword);
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Register_06_Confirm_Password_Different_Password - Step 08: Verify error message is displayed.");
		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}
}

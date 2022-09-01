package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import utilities.DataHelperFaker;

public class UserLogin extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObjects registerPage;
	LoginPageObjects loginPage;
	DataHelperFaker dataFaker;
	String firstName, lastName, email, password, invalidEmail, unregisterEmail, invalidPassword;
	String emailTextboxID, passwordTextboxID, loginButonText;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		emailTextboxID = "Email";
		passwordTextboxID = "Password";
		loginButonText = "Log in";
		
		dataFaker = DataHelperFaker.getData();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();
		unregisterEmail = dataFaker.getEmail();
		invalidEmail = "123@123";
		invalidPassword = dataFaker.getPassword();
		
		log.info("Precondition: Register successfully");
		log.info("Precondition - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Precondition - Step 02: Enter to FirstName textbox with value: " + firstName);
		registerPage.inputTextboxByID(driver, "FirstName", firstName);
		
		log.info("Precondition - Step 03: Enter to LastName textbox with value: " + lastName);
		registerPage.inputTextboxByID(driver, "LastName", lastName);
		
		log.info("Precondition - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputTextboxByID(driver, "Email", email);
		
		log.info("Precondition - Step 05: Enter to Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "Password", password);
		
		log.info("Precondition - Step 06: Enter to Confirm Password textbox with value: " + password);
		registerPage.inputTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Precondition - Step 07: Click to 'Register' button");
		registerPage.clickRegisterButton();
		
		log.info("Precondition - Step 08: Verify successful register message is displayed");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		log.info("Precondition - Step 09: Click to 'Logout' link");
		registerPage.clickToLogoutLink();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Before method: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
	}
	
	@Test
	  public void Login_01_Empty_Data() {
		  log.info("Login_01_Empty_Data - Step 01: Click to 'Login' button");
		  loginPage.clickToLoginButton();
		  
		  log.info("Login_01_Empty_Data - Step 02: Verify error message is displayed");
		  Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	  }
	  
	  @Test
	  public void Login_02_Invalid_Email() {
		  log.info("Login_02_Invalid_Email - Step 01: Enter to Email textbox with value is: " + invalidEmail);
		  loginPage.inputTextboxByID(driver, emailTextboxID, invalidEmail);
		  
		  log.info("Login_02_Invalid_Email - Step 02: Click to 'Login' button");
		  loginPage.clickToButtonByText(driver, loginButonText);
		  
		  log.info("Login_02_Invalid_Email - Step 03: Verify error message is displayed");
		  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
			  		+ "No customer account found");
	  }
	  
	  @Test
	  public void Login_03_Email_Not_Found() {
		  log.info("Login_03_Email_Not_Found - Step 01: Enter to Email textbox with value is: " + unregisterEmail);
		  loginPage.inputTextboxByID(driver, emailTextboxID, unregisterEmail);
		  
		  log.info("Login_03_Email_Not_Found - Step 02: Click to 'Login' button");
		  loginPage.clickToButtonByText(driver, loginButonText);
		  
		  log.info("Login_03_Email_Not_Found - Step 03: Verify error message is displayed");
		  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
			  		+ "No customer account found");
	  }
	  
	  @Test
	  public void Login_04_Existing_Email_Empty_Password() {
		  log.info("Login_03_Email_Not_Found - Step 01: Enter to Email textbox with value is: " + email);
		  loginPage.inputTextboxByID(driver, emailTextboxID, email);
		  
		  log.info("Login_02_Invalid_Email - Step 02: Click to 'Login' button");
		  loginPage.clickToButtonByText(driver, loginButonText);
		  
		  log.info("Login_02_Invalid_Email - Step 03: Verify error message is displayed");
		  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
			  		+ "The credentials provided are incorrect");
	  }
	  
	  @Test
	  public void Login_05_Existing_Email_Wrong_Password() {
		  log.info("Login_05_Existing_Email_Wrong_Password - Step 01: Enter to Email textbox with value is: " + email);
		  loginPage.inputTextboxByID(driver, emailTextboxID, email);
		  
		  log.info("Login_05_Existing_Email_Wrong_Password - Step 02: Enter to Password with value is: " + invalidPassword);
		  loginPage.inputTextboxByID(driver, passwordTextboxID, invalidPassword);
		  
		  log.info("Login_05_Existing_Email_Wrong_Password - Step 03: Click to 'Login' button");
		  loginPage.clickToButtonByText(driver, loginButonText);
		  
		  log.info("Login_05_Existing_Email_Wrong_Password - Step 04: Verify error message is displayed");
		  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
	  }
	  
	  @Test
	  public void Login_06_Login_Success() {
		  log.info("Login_06_Login_Success - Step 01: Enter to Email textbox with value is: " + email);
		  loginPage.inputTextboxByID(driver, emailTextboxID, email);
		  
		  log.info("Login_06_Login_Success - Step 02: Enter to Password with value is: " + password);
		  loginPage.inputTextboxByID(driver, passwordTextboxID, password);
		  
		  log.info("Login_06_Login_Success - Step 03: Click to 'Login' button");
		  homePage = loginPage.clickToLoginButton();
	  }
}

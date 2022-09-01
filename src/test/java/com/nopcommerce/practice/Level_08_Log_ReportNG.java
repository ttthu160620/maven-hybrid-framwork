package com.nopcommerce.practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_08_Log_ReportNG extends BaseTest{
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  private HomePageObject homePage;
  private LoginPageObjects loginPage;
  private RegisterPageObjects registerPage;
  String firstName, lastName, password, existingEmail;
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  firstName = "automation";
	  lastName = "fc";
	  existingEmail = "abc" + getRandomNumber() + "@gmail.com";
	  password = "123456";
  }
  
  @Test
  public void User_01_Register() {
	  log.info("Register - Step 01: Navigate to Register Page");
	  registerPage = homePage.clickToRegisterLink();
	  
	  log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
	  registerPage.inputToEmailTextbox(existingEmail);
	  
	  log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
	  registerPage.inputToPasswordTextbox(password);
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  log.info("Register - Step 07:  Click to 'Register' button");
	  registerPage.clickRegisterButton();
	  
	  log.info("Register - Step 08: Verify successful reegister message is dispaled");
	  verifyEquals(registerPage.getSuccessRegisterMessage(), "Your registration complete");
	  
	  log.info("Register - Step 09: Click to 'Logout' link");
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Test
  public void User_02_Login_Success() {
	  log.info("Login - Step 01: Navigate to Login page");
	  loginPage = homePage.clickToLoginLink();
	  
	  log.info("Login - Step 02: Enter to Email textbox with value is '" + existingEmail + "'");
	  loginPage.inputToEmailTextbox(existingEmail);
	  
	  log.info("Login - Step 03: Enter to Password textbox with value is '" + password + "'");
	  loginPage.inputToPasswordTextbox(password);
	  
	  log.info("Login - Step 04: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Login - Step 05: Verify 'Customer Infor' page is displayed");
	  verifyTrue(homePage.isMyAccountDisplayed());
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int getRandomNumber() {
	  Random random = new Random();
	  return  random.nextInt(999);
  }

}

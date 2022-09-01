package com.nopcommerce.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;
import reportConfig.ExtentTestManager;

public class Level_09_Log_Extentv5 extends BaseTest{
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
  public void User_01_Register(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_01_Register");
	  ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register Page");
	  registerPage = homePage.clickToRegisterLink();
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
	  registerPage.inputToEmailTextbox(existingEmail);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: Enter to Password textbox with value is '" + password + "'");
	  registerPage.inputToPasswordTextbox(password);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 07:  Click to 'Register' button");
	  registerPage.clickRegisterButton();
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 08: Verify successful reegister message is dispaled");
	  Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration complete");
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 09: Click to 'Logout' link");
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Test
  public void User_02_Login_Success(Method method) {
	  ExtentTestManager.startTest(method.getName(), "User_02_Login_Success");
	  homePage = registerPage.clickToLogoutLink(); 
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Navigate to Login page");
	  loginPage = homePage.clickToLoginLink();
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 02: Enter to Email textbox with value is '" + existingEmail + "'");
	  loginPage.inputToEmailTextbox(existingEmail);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 03: Enter to Password textbox with value is '" + password + "'");
	  loginPage.inputToPasswordTextbox(password);
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 04: Click to 'Login' button");
	  homePage = loginPage.clickToLoginButton();
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 05: Verify 'Customer Infor' page is displayed");
	  verifyTrue(homePage.isMyAccountDisplayed());
  }

  @AfterTest
  public void afterClass() {
	  driver.quit();
  }
  
  public int getRandomNumber() {
	  Random random = new Random();
	  return  random.nextInt(999);
  }

}

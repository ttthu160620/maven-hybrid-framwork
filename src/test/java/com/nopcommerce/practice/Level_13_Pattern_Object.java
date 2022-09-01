package com.nopcommerce.practice;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_13_Pattern_Object extends BaseTest{
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
	  registerPage = homePage.clickToRegisterLink();
	  
	  //page object pattern
	  //registerPage.inputToFirstNameTextbox(firstName);
	  //pattern object
	  registerPage.inputTextboxByID(driver, "FirstName", firstName);
	  
	  //registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputTextboxByID(driver, "LastName", lastName);
	  
	  //registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputTextboxByID(driver, "Email", existingEmail);
	  
	  //registerPage.inputToPasswordTextbox(password);
	  registerPage.inputTextboxByID(driver, "Password", password);
	  
	  //registerPage.inputToConfirmPasswordTextbox(password);
	  registerPage.inputTextboxByID(driver, "ConfirmPassword", password);
	  
	  //registerPage.clickRegisterButton();
	  registerPage.clickToButtonByText(driver, "Register");
	  
	  Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Test
  public void User_02_Login_Success() {
	  loginPage = homePage.clickToLoginLink();
	  //loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputTextboxByID(driver, "Email", existingEmail);
	  
	  //loginPage.inputToPasswordTextbox(password);
	  loginPage.inputTextboxByID(driver, "Password", password);
	  
	  //homePage = loginPage.clickToLoginButton();
	  loginPage.clickToButtonByText(driver, "Log in");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  Assert.assertTrue(homePage.isMyAccountDisplayed());
  }
  
  @Test
  public void Search_01_Search_With_Empty_Data() {
	  
  }
  
  @Test
  public void Search_02_Search_With_Not_Existing_Data() {
	  
  }
  
  @Test
  public void Search_03_Search_With_Relate_Data() {
	  
  }
  
  @Test
  public void Search_04_Search_With_Absolute_Data() {
	  
  }

  @AfterClass
  public void afterClass() {
	  
  }
  
}

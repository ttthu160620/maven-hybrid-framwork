package com.nopcommerce.practice;

import java.util.Random;

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

public class Level_05_Login_PageGeneratorManager extends BaseTest{
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  private HomePageObject homePage;
  private LoginPageObjects loginPage;
  private RegisterPageObjects registerPage;
  String firstName, lastName, password, invalidEmail, notFoundEmail, existingEmail;
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  firstName = "automation";
	  lastName = "fc";
	  existingEmail = "abc" + getRandomNumber() + "@gmail.com";
	  notFoundEmail = "abc" + getRandomNumber() + "@gmail.com";
	  invalidEmail = "123";
	  password = "123456";
	  System.out.println("Pre-condition_Register");
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Test
  public void Login_01_Empty_Data() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
  }
  
  @Test
  public void Login_03_Email_Not_Found() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "No customer account found");
  }
  
  @Test
  public void Login_04_Existing_Email_Empty_Password() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
		  		+ "The credentials provided are incorrect");
  }
  
  @Test
  public void Login_05_Existing_Email_Wrong_Password() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox("123");
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getUnsuccessErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n"
	  		+ "The credentials provided are incorrect");
  }
  
  @Test
  public void Login_06_Login_Success() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(password);
	  homePage = loginPage.clickToLoginButton();
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

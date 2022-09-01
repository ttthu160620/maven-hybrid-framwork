package com.nopcommerce.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import pageObjects.nopCommerce.user.AddressPageObject;
import pageObjects.nopCommerce.user.ChangePasswordPageObject;
import pageObjects.nopCommerce.user.CustomerInforPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.OrdersPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_10_Allure_Report extends BaseTest{
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
  
  @Description("Register to the system")
  @Test
  public void User_01_Register() {
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  verifyEquals(registerPage.getSuccessRegisterMessage(), "Your registration complete");
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Description("Login to the system")
  @Test
  public void User_02_Login_Success() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(password);
	  homePage = loginPage.clickToLoginButton();
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

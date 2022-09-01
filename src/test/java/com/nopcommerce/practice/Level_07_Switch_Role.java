package com.nopcommerce.practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.noopCommerce.admin.AdminHomePageObject;
import pageObject.noopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.CustomerInforPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_07_Switch_Role extends BaseTest{
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  private HomePageObject homePage;
  private LoginPageObjects loginPage;
  private RegisterPageObjects registerPage;
  private CustomerInforPageObject customerPage;
  private AdminHomePageObject adminHomePage;
  private AdminLoginPageObject adminLoginPage;
  String firstName, lastName, password, existingEmail;
  String adminEmail, adminPassword;
  
  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  firstName = "automation";
	  lastName = "fc";
	  existingEmail = "abc" + getRandomNumber() + "@gmail.com";
	  password = "123456";
	  adminEmail = "admin@yourstore.com";
	  adminPassword = "admin";
	  
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(existingEmail);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
	  homePage = registerPage.clickToLogoutLink(); 
  }
  
  @Test
  public void Role_01_User() {
	  //login as user
	  loginPage = homePage.clickToLoginLink();
	  homePage = loginPage.loginAsUser(existingEmail, password);
	  
	  
	  //home page -> customer infor
	  customerPage = homePage.clickMyAccountLink();
	  Assert.assertTrue(customerPage.isCustomerInfoDisplayed());
	  //về lại home page
	  homePage = customerPage.clickToUserLogoutLink(driver);
	  
	  homePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  adminHomePage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
	  Assert.assertTrue(adminHomePage.isDashboardHeaderIsDisplayed()); 
	  
	  adminLoginPage = adminHomePage.clickToAdminLogoutLink(driver);
	  
  }
  
  @Test
  public void Role_02_Admin() {
	  //admin -> user
	  adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
	  homePage = PageGeneratorManager.getHomePage(driver);
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

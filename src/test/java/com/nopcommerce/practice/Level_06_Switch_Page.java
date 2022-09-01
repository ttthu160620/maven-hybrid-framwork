package com.nopcommerce.practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.AddressPageObject;
import pageObjects.nopCommerce.user.ChangePasswordPageObject;
import pageObjects.nopCommerce.user.CustomerInforPageObject;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.OrdersPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_06_Switch_Page extends BaseTest{
  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  private HomePageObject homePage;
  private LoginPageObjects loginPage;
  private RegisterPageObjects registerPage;
  private CustomerInforPageObject customerPage;
  private AddressPageObject addressPage;
  private OrdersPageObject ordersPage;
  private ChangePasswordPageObject changePasswordPage;
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
  public void User_02_Login_Success() {
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(password);
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountDisplayed());
  }
  
  @Test
  public void User_03_Customer_Infor() {
	  customerPage = homePage.clickMyAccountLink();
	  //Assert.assertTrue(customerPage.isCustomerInfoDisplayed());
  }
  
  @Test
  public void User_04_Switch_Page() {
	  addressPage = customerPage.clickToAddressLink(driver);
	  ordersPage = addressPage.clickToOdersLink(driver);
	  changePasswordPage = ordersPage.clickToChangePasswordLink(driver);
	  addressPage = changePasswordPage.clickToAddressLink(driver);
  }
  
  @Test
  public void User_05_Dynamic_Page() {
	 ordersPage = (OrdersPageObject) addressPage.openPageAtMyAccountArea(driver, "Orders");
	 
	 customerPage = PageGeneratorManager.getCustomerInforPage(driver);
	 customerPage.openDynamicMorePage(driver, "Customer info");
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

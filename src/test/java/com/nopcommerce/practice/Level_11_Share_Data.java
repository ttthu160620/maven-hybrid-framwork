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

import com.nopcommerce.commons.Common_01_Register;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Level_11_Share_Data extends BaseTest{
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
	  existingEmail = Common_01_Register.existingEmail;
	  password = Common_01_Register.password;
	  
	  loginPage = homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(existingEmail);
	  loginPage.inputToPasswordTextbox(password);
	  homePage = loginPage.clickToLoginButton();
	  verifyTrue(homePage.isMyAccountDisplayed());
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
	  closeBrowserAndDriver();
  }
  
  public int getRandomNumber() {
	  Random random = new Random();
	  return  random.nextInt(999);
  }

}

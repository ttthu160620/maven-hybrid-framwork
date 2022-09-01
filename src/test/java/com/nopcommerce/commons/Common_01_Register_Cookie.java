package com.nopcommerce.commons;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.LoginPageObjects;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.RegisterPageObjects;

public class Common_01_Register_Cookie extends BaseTest{
	  WebDriver driver;
	  String projectPath = System.getProperty("user.dir");
	  private HomePageObject homePage;
	  private RegisterPageObjects registerPage;
	  private LoginPageObjects loginPage;
	  private String firstName, lastName;
	  public static String password, existingEmail;
	  public static Set<Cookie> loggedCookies;	
	  
	  
	  @Parameters("browser")
	  @BeforeTest(description = "Create new commen User for all Classes Test")
	  public void User_01_Register(String browserName) {
		  driver = getBrowserDriver(browserName);
		  homePage = PageGeneratorManager.getHomePage(driver);
		  firstName = "automation";
		  lastName = "fc";
		  existingEmail = "abc" + getRandomNumber() + "@gmail.com";
		  password = "123456";
		  
		  registerPage = homePage.clickToRegisterLink();
		  registerPage.inputToFirstNameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(existingEmail);
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  registerPage.clickRegisterButton();
		  verifyEquals(registerPage.getSuccessRegisterMessage(), "Your registration complete");
		  homePage = registerPage.clickToLogoutLink(); 
		  
		  loginPage = homePage.clickToLoginLink();
		  loginPage.inputToEmailTextbox(existingEmail);
		  loginPage.inputToPasswordTextbox(password);
		  homePage = loginPage.clickToLoginButton();
		  verifyTrue(homePage.isMyAccountDisplayed());
		  
		  loggedCookies = driver.manage().getCookies();
		  driver.quit();
	  }
	  
	  public int getRandomNumber() {
		  Random random = new Random();
		  return  random.nextInt(999);
	  }
}

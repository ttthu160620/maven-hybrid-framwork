package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.SearchPageObject;

public class UserSearch extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	SearchPageObject searchPage;
	String notExistData, relateProduct, absoluteProduct, advancedProduct, searchTextboxID, searchButtonText;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-Condition 01: Open browser: " + browserName + "and navigate to home page");
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		searchTextboxID = "small-searchterms";
		searchButtonText = "Search";
		
		notExistData = "Macbook Pro 2050";
		relateProduct = "lenovo";
		absoluteProduct = "Thinkpad X1 Carbon Laptop";
		advancedProduct = "Apple Macbook Pro";
	}
	
	@Test
	public void Search_01_Search_With_Empty_Data() {
		log.info("Search_01_Search_With_Empty_Data - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_01_Search_With_Empty_Data - Step 02: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_01_Search_With_Empty_Data - Step 03: Verify error message displayed in alert");
		Assert.assertEquals(homePage.getAlertText(driver), "Please enter some search keyword");
		
		log.info("Search_01_Search_With_Empty_Data - Step 04: Accept alert");
		homePage.acceptAlert(driver);
	}
	  
	@Test
	public void Search_02_Search_With_Not_Existing_Data() {
		log.info("Search_02_Search_With_Not_Existing_Data - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_02_Search_With_Not_Existing_Data - Step 02: Enter to Search textbox with value is: " + notExistData);
		homePage.inputTextboxByID(driver, searchTextboxID, notExistData);
		
		log.info("Search_02_Search_With_Not_Existing_Data - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_02_Search_With_Not_Existing_Data - Step 04: Verify result message is displayed");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");
	}
	  
	@Test
	public void Search_03_Search_With_Relate_Data() {
		log.info("Search_03_Search_With_Relate_Data - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_03_Search_With_Relate_Data - Step 02: Enter to Search textbox with value is: " + relateProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, relateProduct);
		
		log.info("Search_03_Search_With_Relate_Data - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_03_Search_With_Relate_Data - Step 04: Verify 2 products are displayed");
		Assert.assertEquals(searchPage.getListResultProduct().size(), 2);
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	  
	@Test
	public void Search_04_Search_With_Absolute_Data() {
		log.info("Search_04_Search_With_Absolute_Data - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_04_Search_With_Absolute_Data - Step 02: Enter to Search textbox with value is: " + absoluteProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, absoluteProduct);

		log.info("Search_04_Search_With_Absolute_Data - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_04_Search_With_Absolute_Data - Step 04: Verify only 1 product is displayed");
		Assert.assertEquals(searchPage.getListResultProduct().size(), 1);
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	
	@Test
	public void Search_05_Advanced_Search_With_Parent_Categories() {
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 02: Enter to Search textbox with value is:" + advancedProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, advancedProduct);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 04: Check 'Advanced Search' checkbox");
		searchPage.checkToCheckboxByLabelName("Advanced search");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 05: Select 'Computers' value in Categories dropdown");
		searchPage.selectInDropdownByLabelName("Category:", "Computers");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 06: Uncheck 'Automatically search sub categories' checkbox");
		searchPage.uncheckToCheckboxByLabelName("Automatically search sub categories");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 07: Click to 'Search' button");
		searchPage = searchPage.clickSearchInAdvancedButton();
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 08: Verfify result message is displayed");
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_06_Advanced_Search_With_Sub_Categories() {
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 02: Enter to Search textbox with value is:" + advancedProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, advancedProduct);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 04: Check 'Advanced Search' checkbox");
		searchPage.checkToCheckboxByLabelName("Advanced search");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 05: Select 'Computers' value in Categories dropdown");
		searchPage.selectInDropdownByLabelName("Category:", "Computers");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 06: Uncheck 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabelName("Automatically search sub categories");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 07: Click to 'Search' button");
		searchPage = searchPage.clickSearchInAdvancedButton();
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 08: Verfify only 1 product is displayed");
		Assert.assertEquals(searchPage.getListResultProduct().size(), 1);
		Assert.assertTrue(searchPage.isProductDisplayedByText("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Search_07_Advanced_Search_With_Incorrect_Manufacturer() {
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 02: Enter to Search textbox with value is:" + advancedProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, advancedProduct);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 04: Check 'Advanced Search' checkbox");
		searchPage.checkToCheckboxByLabelName("Advanced search");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 05: Select 'Computers' value in Categories dropdown");
		searchPage.selectInDropdownByLabelName("Category:", "Computers");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 06: Uncheck 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabelName("Automatically search sub categories");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 07: Select 'HP' value in Manufaturer dropdown");
		searchPage.selectInDropdownByLabelName("Manufacturer:", "HP");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 08: Click to 'Search' button");
		searchPage = searchPage.clickSearchInAdvancedButton();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 07: Verfify result message is displayed");
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_08_Advanced_Search_Correct_Manufacturer() {
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 01: Navigate Home page");
		homePage = homePage.openHomePage();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 02: Enter to Search textbox with value is:" + advancedProduct);
		homePage.inputTextboxByID(driver, searchTextboxID, advancedProduct);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 03: Click to 'Search' button");
		homePage.clickToButtonByText(driver, searchButtonText);
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 04: Check 'Advanced Search' checkbox");
		searchPage.checkToCheckboxByLabelName("Advanced search");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 05: Select 'Computers' value in Categories dropdown");
		searchPage.selectInDropdownByLabelName("Category:", "Computers");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 06: Uncheck 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabelName("Automatically search sub categories");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 07: Select 'Apple' value in Manufaturer dropdown");
		searchPage.selectInDropdownByLabelName("Manufacturer:", "Apple");
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 08: Click to 'Search' button");
		searchPage = searchPage.clickSearchInAdvancedButton();
		
		log.info("Search_05_Advanced_Search_With_Parent_Categories - Step 09: Verfify only 1 product is displayed");
		Assert.assertEquals(searchPage.getListResultProduct().size(), 1);
		Assert.assertTrue(searchPage.isProductDisplayedByText("Apple MacBook Pro 13-inch"));
	}
}

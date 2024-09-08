//package com.dazn.automation.tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.dazn.automation.pages.HomePage;
//import com.dazn.automation.pages.LoginPage;
//
//public class HomePageTest {
//	private WebDriver driver;
//    private LoginPage loginPage;
//    private HomePage homePage;
//    
//    @BeforeClass
//    public void setUp() {
//        // Initialize WebDriver (example for Chrome)
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
//        loginPage.login("saipavan.uppalapati@dazn.com", "DAZN20233");
//    }
//    
//    @Test(priority=1)
//    public void testPopUpAvailability() {
//        homePage.isOfferPopUpDisplayed();
//        homePage.clickOnStartWatching();
//        
//        
//    }
//    
//    @Test(priority=2)
//    public void testEventAvailability() {
//        driver.navigate().back();
//        homePage.goToEvent();
//        
//        
//    }
//    
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    
//
//}
//}
//

//package com.dazn.automation.tests;
//
//import static org.testng.Assert.assertEquals;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import com.dazn.automation.pages.LoginPage;
//
//public class LoginTest {
//
//    private WebDriver driver;
//    private LoginPage loginPage;
//
//    @BeforeMethod
//  
//    public void setUp() {
//        // Initialize WebDriver (example for Chrome)
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
//    }
//
//    @Test
//    public void testValidLogin() {
//        loginPage.login("saipavan.uppalapati@dazn.com", "DAZN20233");
//        // Add assertions to verify successful login
//        
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

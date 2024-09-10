package com.dazn.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dazn.automation.factory.DriverFactory;
import com.dazn.automation.pages.EventPage;
import com.dazn.automation.pages.HomePage;
import com.dazn.automation.pages.LoginPage;

@Listeners(com.dazn.automation.listeners.ExtentReportListener.class)

public class EventPageTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private EventPage eventPage;


    @BeforeClass
    public void setUp() {
    	driver = DriverFactory.initDriver("chrome");  // Ensure this method initializes the WebDriver
        DriverFactory.setDriver(driver); 

        driver.manage().window().maximize();

        // Initialize page objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        eventPage = new EventPage(driver);

        // Perform login
        loginToApplication("saipavan.uppalapati@dazn.com", "dAZN20233");
    }

    private void loginToApplication(String username, String password) {
        System.out.println("Logging in to the application with username: " + username);
        loginPage.login(username, password);
      // Assert.assertTrue(homePage.isLoaded(), "Home page did not load after login");
    }

    @Test(priority = 1)
    public void testPopUpAvailability() {
        System.out.println("Checking if offer pop-up is displayed...");
        if (homePage.isOfferPopUpDisplayed()) {
            homePage.clickOnStartWatching();
       } else {
            System.out.println("Offer pop-up not displayed. Skipping this step.");
        }
    }

    @Test(priority = 2)
    public void testOpenEvent() {
        System.out.println("Navigating to an event...");
        driver.navigate().back();
        homePage.goToEvent();
        eventPage.joinEvent();
        Assert.assertTrue(eventPage.isEventLoaded(), "Event page did not load correctly");
    }

    @Test(priority = 3)
    public void startTexting() {
        System.out.println("Starting texting functionality on the event page...");
       // eventPage.clickOnAgeRestrictionBtn();
       // eventPage.clickFZ();
        eventPage.enterText("Hello all");
        eventPage.sendText();

        Assert.assertTrue(eventPage.isTextSent(), "Text message was not sent successfully");
    }

    @AfterClass
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.quitDriver();
        }
    
    }
}

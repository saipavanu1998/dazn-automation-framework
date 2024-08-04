package com.dazn.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dazn.automation.pages.EventPage;
import com.dazn.automation.pages.HomePage;
import com.dazn.automation.pages.LoginPage;

public class EventPageTest {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private EventPage eventPage;
	
	 @BeforeClass
	    public void setUp() {
	        // Initialize WebDriver (example for Chrome)
	        driver = new EdgeDriver();
	        loginPage = new LoginPage(driver);
	        homePage = new HomePage(driver);
	        eventPage = new EventPage(driver);
	        loginPage.login("saipavan.uppalapati@dazn.com", "DAZN20233");
	    }
	 
	 @Test(priority=1)
	    public void testPopUpAvailability() {
	        homePage.waitforPopUp();
	        homePage.clickonStartWatching();
	        
	        
	    }
	    
	    @Test(priority=2)
	    public void testOpenEvent() 
	    {
	        driver.navigate().back();
	        homePage.goToEvent();
	        eventPage.joinEvent();
	        
	        
	    }

}

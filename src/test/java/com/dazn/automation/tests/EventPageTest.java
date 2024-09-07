package com.dazn.automation.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
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
	        driver = new ChromeDriver();
	        loginPage = new LoginPage(driver);
	        homePage = new HomePage(driver);
	        eventPage = new EventPage(driver);
	        loginPage.login("saipavan.uppalapati@dazn.com", "dAZN20233");
	        
	    }
	 
	 @Test(priority=1)
	 public void testPopUpAvailability() {
		    if (homePage.isOfferPopUpDisplayed()) {
		        homePage.clickOnStartWatching();
		    } else {
		        System.out.println("Offer pop-up not displayed. Skipping this step.");
		    }
		}
	    
	    @Test(priority=2)
	    public void testOpenEvent() 
	    {
	        driver.navigate().back();
	        homePage.goToEvent();
	       eventPage.joinEvent();
	        
	        
	    }
	    @Test(priority=3)
	    public void startTexting()
	    {  
	    	eventPage.clickOnAgeRestrictionBtn();
	    	eventPage.clickFZ();;
	    	eventPage.enterText();
	    	eventPage.loadFZ();
	    	eventPage.sendText();
	    	
	    	
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    
	    
	    }
   
	    
}


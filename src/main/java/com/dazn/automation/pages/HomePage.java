package com.dazn.automation.pages;

import com.dazn.automation.utils.JavaScriptUtils;
import com.dazn.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptUtils jsUtils;

    // Locators for elements on the HomePage
   
    private By offerPopUp = By.xpath("(//div[@class='OfferPopup__content___3FXDU OfferPopup__content-new-layout___1glrq'])[1]");
    private By startWatching = By.xpath("(//button[@class='sc-pyfCe sc-kDvujY gTYMya ihnwix OfferPopup__cta___39Cvo OfferPopup__cta-new-layout___1LvRF'])[1]");
    private By eventName = By.xpath("(//h4[normalize-space()='Honor of Kings - Day 3'])");
    
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver, 30);
        jsUtils = new JavaScriptUtils(driver);
    }

    public void waitforPopUp() {
        WebElement acceptButton = waits.waitForVisibilityOfElement(offerPopUp);
        acceptButton.click();
    }
    
    public void goToEvent()
    {
    	WebElement event = waits.waitForPresenceOfElementToBeClickable(eventName);
    	WebElement event1=jsUtils.scrollToElement(event);
    	jsUtils.clickElement(event1);
    	
    }
 

    public void clickonStartWatching() {
        WebElement element = waits.waitForElementToBeClickable(startWatching);
       
        element.click();
    }
}

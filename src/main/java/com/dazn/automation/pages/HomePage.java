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
    private By startWatching = By.xpath("(//button[@class='sc-pyfCe sc-kDvujY gTYMya ihnwix OfferPopup__cta___39Cvo OfferPopup__cta-new-layout___1LvRF OfferPopup__nfl-monthly-flex-cta-instalments___365IP'])");
    private By eventName = By.xpath("//h4[normalize-space()='EKO Acropolis Rally Greece: Stage 15	']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 30);
        this.jsUtils = new JavaScriptUtils(driver);
    }

    // Method to check if offer pop-up is displayed
    public boolean isOfferPopUpDisplayed() {
        try {
            WebElement popup = waits.waitForVisibilityOfElement(offerPopUp);
            return popup != null;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click 'Start Watching' if the offer pop-up is displayed
    public void clickOnStartWatching() {
        WebElement element = waits.waitForElementToBeClickable(startWatching);
        element.click();
    }

    // Method to navigate to an event
    public void goToEvent() {
        WebElement event = waits.waitForPresenceOfElementToBeClickable(eventName);
        jsUtils.scrollToElement(event);
        jsUtils.clickElement(event);
    }

    // Verifying the home page loaded properly after login
    public boolean isLoaded() {
        return waits.waitForVisibilityOfElement(eventName) != null;
    }
}

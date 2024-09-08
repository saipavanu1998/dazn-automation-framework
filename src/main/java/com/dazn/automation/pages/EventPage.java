package com.dazn.automation.pages;

import com.dazn.automation.utils.JavaScriptUtils;
import com.dazn.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventPage {
    private WebDriver driver;
    private Waits waits;
    private JavaScriptUtils jsUtils;

    // Locators for elements on the EventPage
    private By joinLiveBtn = By.xpath("(//button[@class='watch-from-start__join-live-button___1LqiX'])[1]");
    private By textArea = By.cssSelector("textarea[placeholder='Start typing...']");
    private By sendMessage = By.xpath("//div[@class='sc-hmLeec TCspB']");
    private By messageList = By.xpath("//div[@data-testid='messages-list-container']");
    private By fzLoader = By.cssSelector(".sc-evZas.jFUGBX.loader-container");
    private By showFZ = By.xpath("(//div[@class='sc-breuTD cznXtV'])[1]");
    private By ageRestrictionBtn = By.cssSelector("button[class='sc-crXcEl couCKK']");
    private By chatMessages = By.xpath("(//div[@class='sc-tQuYZ bRrJnM'])");

    public EventPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 50);
        this.jsUtils = new JavaScriptUtils(driver);
    }

    // Method to join the event
    public void joinEvent() {
        WebElement joinButton = waits.waitForVisibilityOfElement(joinLiveBtn);
        joinButton.click();
    }

    // Method to enter a text message
    public void enterText(String message) {
        WebElement textAreaElement = waits.waitForVisibilityOfElement(textArea);
        textAreaElement.sendKeys(message);
    }

    // Method to send the text message
    public void sendText() {
        WebElement sendMessageElement = waits.waitForVisibilityOfElement(sendMessage);
        sendMessageElement.click();
    }

    // Method to wait until FZ Loader disappears
    public void loadFZ() {
        waits.waitForInvisibilityOfElement(fzLoader);
    }

    // Method to click FZ button
    public void clickFZ() {
        WebElement showFZButton = waits.waitForVisibilityOfElement(showFZ);
        showFZButton.click();
    }

    // Method to click on Age Restriction button
    public void clickOnAgeRestrictionBtn() {
        WebElement ageRestrictionButton = waits.waitForVisibilityOfElement(ageRestrictionBtn);
        ageRestrictionButton.click();
    }

    // Method to get a list of chat messages
    public List<WebElement> getMessageList() {
        WebElement messageContainer = waits.waitForVisibilityOfElement(messageList);
        return messageContainer.findElements(chatMessages);
    }

    // Verifying if the event page loaded correctly
    public boolean isEventLoaded() {
        return waits.waitForVisibilityOfElement(joinLiveBtn) != null;
    }

    // Verifying if the text message was sent
    public boolean isTextSent() {
        List<WebElement> messages = getMessageList();
        return !messages.isEmpty();
    }
}

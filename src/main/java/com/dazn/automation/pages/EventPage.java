package com.dazn.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dazn.automation.utils.JavaScriptUtils;
import com.dazn.automation.utils.Waits;

public class EventPage {
	private WebDriver driver;
    private Waits waits;
    private JavaScriptUtils jsUtils;
	
	private By joinLiveBtn = By.xpath("(//button[@class='watch-from-start__join-live-button___1LqiX'])[1]");
	private By textArea = By.cssSelector("textarea[placeholder=' Start typing...']");
	private By sendMessage = By.xpath("//div[@class='sc-hmLeec TCspB']");
	private By messageList = By.xpath("//div[@data-testid=\"messages-list-container\"]");
	private By fzLoader = By.cssSelector(".sc-evZas.jFUGBX.loader-container");
	private By ShowFZ = By.xpath("(//div[@class='sc-breuTD cznXtV'])[1]");
	private By ageRestrictionBtn = By.cssSelector(".sc-breuTD.cznXtV");
	
	
	private By chatMessages = By.xpath("(//div[@class='sc-tQuYZ bRrJnM'])");
	public EventPage(WebDriver driver)
	{
		this.driver = driver;
		this.waits = new Waits(driver, 50);
		this.jsUtils = new JavaScriptUtils(driver);
	}
	
	
	public void joinEvent()
	{
		WebElement joinButton = waits.waitForVisibilityOfElement(joinLiveBtn);
		joinButton.click();
        
	}
	public void enterText()
	{
		WebElement textArea1 = waits.waitForVisibilityOfElement(textArea);
		textArea1.sendKeys("hello all");;
        
	}
	public void sendText()
	{
		WebElement sendMessage1 = waits.waitForVisibilityOfElement(sendMessage);
		sendMessage1.click();
		
        
	}
	
	public void loadFZ()
	{
		waits.waitForInvisibilityOfElement(fzLoader);
	}
	public void clickFZ()
	{
		WebElement joinButton = waits.waitForVisibilityOfElement(ShowFZ);
		joinButton.click();
        
	}
	
	
	public void clickOnAgeRestrictionBtn() 
	{
		WebElement joinButton = waits.waitForVisibilityOfElement(ageRestrictionBtn);
		joinButton.click();
        
		
	}
	
	
	
	
	
	public List<WebElement> getMessagelist()
	{
		WebElement messagesList1 = waits.waitForVisibilityOfElement(messageList);
		 List<WebElement> messages = 	messagesList1.findElements(chatMessages);
		 return messages;
        
	}
}

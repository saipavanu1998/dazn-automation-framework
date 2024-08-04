package com.dazn.automation.pages;

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

	public EventPage(WebDriver driver)
	{
		this.driver = driver;
		this.waits = new Waits(driver, 30);
		this.jsUtils = new JavaScriptUtils(driver);
	}
	
	
	public void joinEvent()
	{
		WebElement joinButton = waits.waitForVisibilityOfElement(joinLiveBtn);
		joinButton.click();
        
	}
	
	
}

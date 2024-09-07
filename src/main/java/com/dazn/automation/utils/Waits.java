package com.dazn.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForPresenceOfElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForInvisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    // Add more wait methods as needed
}

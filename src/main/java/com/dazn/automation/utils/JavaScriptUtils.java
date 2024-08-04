package com.dazn.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
    
    private WebDriver driver;
    private Waits waitsUtil;

    public JavaScriptUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Scroll to a specific element
    public WebElement scrollToElement(WebElement element) {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    // Scroll to the bottom of the page
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to the top of the page
    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }
    
    public void clickElement(WebElement element)
    {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}

package com.dazn.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.dazn.automation.utils.Waits;

public class LoginPage {

    private WebDriver driver;
    private Waits waits;

    // Locators for elements on the login page
    private By acceptCookiesButton = By.id("onetrust-accept-btn-handler");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[@data-test-id='signIn__BUTTON']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 30); // Timeout can be adjusted as needed
    }

    // Method to open the login page
    public void openLoginPage() {
        driver.get("https://www.dazn.com/en-FR/signin");
        driver.manage().window().maximize();
    }

    // Method to accept cookies
    public void acceptCookies() {
        WebElement acceptButton = waits.waitForVisibilityOfElement(acceptCookiesButton);
        acceptButton.click();
    }

    // Method to enter email
    public void enterEmail(String email) {
        WebElement emailInput = waits.waitForVisibilityOfElement(emailField);
        emailInput.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebElement passwordInput = waits.waitForVisibilityOfElement(passwordField);
        passwordInput.sendKeys(password);
    }

    // Method to click sign in button
    public void clickSignIn() {
        WebElement signInBtn = waits.waitForElementToBeClickable(signInButton);
        signInBtn.click();
    }

    // Method to perform a complete login action
    public void login(String email, String password) {
        openLoginPage();
        acceptCookies();
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }
}

package com.dazn.automation.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest 
{
protected WebDriver driver;
protected WebDriverWait wait;

//Setup method to initialize WebDriver and WebDriverWait before each test
@BeforeMethod
@Parameters("browser")
public void setUp(String browser)
{
	//Initialize WebDriver
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		
	}else {
		throw new IllegalArgumentException("Unsupported browser: " + browser);
	}
	
	driver.manage().window().maximize();
    // Initialize WebDriverWait
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}

//Teardown method to quit the WebDriver after each test
@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }





}
}



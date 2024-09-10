package com.dazn.automation.factory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        // Add other browser initializations if needed (e.g., Firefox, Edge)
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset the driver to null after quitting
        }
    }

    public static String getScreenshot(String methodName) throws IOException {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized, cannot take screenshot");
        }
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshot_" + timestamp + ".png";
        
        // Capture screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        
        // Define the destination file with unique name
        File destPath = new File("./screenshots" + File.separator + fileName);
        
        // Save the screenshot to the specified folder
        FileHandler.copy(src, destPath);  // You can switch this with FileHandler.copy() if necessary
        return destPath.toString();
    }
    public static void captureScreenshot(WebDriver driver, String folderPath) {
        try {
            // Generate a unique filename using timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshot_" + timestamp + ".png";
            
            // Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            
            // Define the destination file with unique name
            File dest = new File(folderPath + File.separator + fileName);
            
            // Save the screenshot to the specified folder
            FileHandler.copy(src, dest);  // You can switch this with FileHandler.copy() if necessary

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}

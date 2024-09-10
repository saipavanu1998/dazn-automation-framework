package com.dazn.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;  // Add this if you use FileUtils instead of FileHandler
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

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
            FileUtils.copyFile(src, dest);  // You can switch this with FileHandler.copy() if necessary

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}


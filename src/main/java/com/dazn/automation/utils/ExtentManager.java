package com.dazn.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    // Method to create the ExtentReports instance
    public static ExtentReports createInstance(String fileName) {
        // Initialize ExtentSparkReporter instead of ExtentHtmlReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("DAZN Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setEncoding("utf-8");

        // Attach the reporter to ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // You can also set system info here
        extent.setSystemInfo("Automation Tester", "Your Name");
        extent.setSystemInfo("Organization", "DAZN");
        extent.setSystemInfo("Build no", "v1.0.0");

        return extent;
    }

    public static ExtentReports getExtent() {
        return extent;
    }
}

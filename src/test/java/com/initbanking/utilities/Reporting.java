package com.initbanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest log;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp for report
        String repName = "Test-Report-" + timeStamp + ".html";
        
        // Initialize ExtentSparkReporter
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

        // Optional: Configure SparkReporter directly in the code
        sparkReporter.config().setDocumentTitle("InitBanking Test Project");
        sparkReporter.config().setReportName("Functional Test Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set additional system information
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "pavan");
    }

    public void onTestSuccess(ITestResult tr) {
        log = extent.createTest(tr.getName()); // Create a new test entry in the report
        log.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Mark test as passed with green color
    }

    public void onTestFailure(ITestResult tr) {
        log = extent.createTest(tr.getName()); // Create a new test entry in the report
        log.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // Mark test as failed with red color

        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
        File f = new File(screenshotPath);

        	if (f.exists()) {
        	    log.fail("Screenshot is below:" + log.addScreenCaptureFromPath(screenshotPath)); // Add screenshot to the report
        	}
    }

    public void onTestSkipped(ITestResult tr) {
        log = extent.createTest(tr.getName()); // Create a new test entry in the report
        log.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); // Mark test as skipped with orange color
    }

    public void onFinish(ITestContext testContext) {
        extent.flush(); // Flush the report
    }
}

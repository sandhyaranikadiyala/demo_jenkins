package com.training.automation.base;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.training.automation.browser.Browser;
import com.training.automation.browserinterface.IBrowser;
import com.training.automation.constants.FilePathConstants;

/**
 * This is base class initializing web drivers and extent report
 *
 * @author arun.pareek
 */
public class TestBase {
	public static IBrowser browser = null;
    public WebDriver driver ;
    JavascriptExecutor executor;

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstants.EXTENT_REPORT_PATH);
    }

    @BeforeClass
    public void beforeClass() {
        browser = new Browser();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        test = extent.startTest((this.getClass().getSimpleName() + "::" +method.getName()), method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @AfterClass
    public void afterClass() {
        browser.closeBrowser();
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        extent.close();
    }


}


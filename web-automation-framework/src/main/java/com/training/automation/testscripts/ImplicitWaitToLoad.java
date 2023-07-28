package com.training.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is ImplicitWaitToLoad to wait until the document.readyState is
 * ""complete"" using the Implicit Wait concept.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ImplicitWaitToLoad extends TestBase {
	@Test
	public void waitForPageToLoadTest() {
		browser.openURL("https://demoqa.com/dynamic-properties");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		waitForPageLoad(browser.getDriver());
	}

	private void waitForPageLoad(WebDriver driver) {
		
		 JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	        String readyState = "";
	        while (!readyState.equals("complete")) {
	            readyState = javaScriptExecutor.executeScript("return document.readyState").toString();
	        }

}}

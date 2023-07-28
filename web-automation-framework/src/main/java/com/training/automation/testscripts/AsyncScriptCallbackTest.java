package com.training.automation.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;
/**
 * This class is to open the herokuapp site with in the time using executeAsyncScript method.
 * @author Sandhya.Kadiyala
 *
 */
public class AsyncScriptCallbackTest extends TestBase {
	/**
	 * This method is used to open the herokuapp site with in the time using executeAsyncScript method. 
	 */
	@Test
	public void testCallbackFun() {
		browser.openURL("http://the-internet.herokuapp.com/javascript_alerts");
		browser.maximizeWindow();

		long start_time = System.currentTimeMillis();
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) browser.getDriver());
		javascriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));

	}
}

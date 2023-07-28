package com.training.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is JavaScriptExecutorsTest class to execute the script using
 * JavaScriptExecutors.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class JavaScriptExecutorsTest extends TestBase {
	/**
	 * This is a test method to scroll the page using executescript method.
	 */
//	@Test(priority = 1)
//	public void scrollWebpageBottom() {
//		browser.openURL("https://demoqa.com/");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) browser.getDriver());
//		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//
//	}

	/**
	 * This is a test method to retrieve the value of hidden input field.
	 */
	@Test(priority = 2)
	public void testHiddenField() {
		browser.openURL("https://www.letskodeit.com/practice");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement hideTextbox = browser.getDriver().findElement(By.id("displayed-text"));
		hideTextbox.sendKeys("Selenium");
		WebElement hideButton = browser.getDriver().findElement(By.id("hide-textbox"));

		hideButton.click();
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) browser.getDriver());

		javascriptExecutor.executeScript("document.getElementById('displayed-text').value");
		String hiddenText = (String) javascriptExecutor
				.executeScript("return document.getElementById('displayed-text').value");
		System.out.print("Value entered in hidden field: " + hiddenText + "\n");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This is injectScriptToWebpage method to inject a custom JavaScript code
	 * snippet into a webpage.
	 */
//	@Test(priority = 3)
//	public void injectScriptToWebpage() {
//
//		browser.openURL("https://www.letskodeit.com/practice");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) browser.getDriver());
//		String script = "var element = document.getElementById('openwindow');"
//				+ "element.style.backgroundColor = 'red';" + "element.style.color = 'white';"
//				+ "element.style.fontSize = '20px';";
//		javascriptExecutor.executeScript(script);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	@Test (priority = 4)
//	public void iFrameElement() {
//		browser.openURL("http://the-internet.herokuapp.com/frames");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////		WebElement iframeButton=browser.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a"));
////		iframeButton.click();
////		 // browser.getDriver().switchTo().frame("//*[@id=\"content\"]/div/ul/li[2]/a");
//		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) browser.getDriver());
////		WebElement frameText=browser.getDriver().findElement(By.xpath("//body[@id='tinymce']/p)"));
////		frameText.sendKeys("Hello, World!");
////		javascriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
//		
////		javascriptExecutor.executeScript(
////	            "var editor = document.getElementById('tinymce');" +
////	            "if (editor) {" +
////	            "  editor.innerHTML = 'Hello, World!';" +
////	            "}"
////	        );
//		javascriptExecutor.executeAsyncScript( "var callback = arguments[arguments.length - 1];" +
//				 "var iframe = document.getElementById('mce_0_ifr');" +
//				 "iframe.onload = function() {" +
//		            "  var editor = iframe.contentDocument.getElementById('tinymce');" +
//		            "  editor.innerHTML = 'Hello, World!';" 
//		           // "  callback();" +"}
//		            
//				);
//		 String headingText = driver.findElement(By.cssSelector("h3")).getText();
//	        System.out.println("Heading text: " + headingText);

	// }

}

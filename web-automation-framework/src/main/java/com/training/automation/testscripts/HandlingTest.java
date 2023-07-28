package com.training.automation.testscripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This class is to Handling Alerts,Windows,Frames and Tooltip.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class HandlingTest extends TestBase {
	/**
	 * This method is to open the url and triggers the Alert popup and accept it see
	 * the result.
	 */
//	@Test
//	public void handlingAlert() {
//		browser.openURL("http://the-internet.herokuapp.com/javascript_alerts");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//		WebElement alertButton = browser.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
//		alertButton.click();
//		
//		Alert alert = browser.getDriver().switchTo().alert();
//		String alertMessage = alert.getText();
//		alert.accept();
//		
//		String expectedMessage = "I am a JS Alert";
//		if (expectedMessage.equals(alertMessage)) {
//			System.out.println("Alert Message is correct : " + alertMessage);
//
//		} else {
//			System.out.println("Alert Message is Incorrect.Expected : " + alertMessage);
//
//		}
//		System.out.println("You successfully clicked an alert");
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * This method is to perform windows handling and do some action and switch back
	 * to parent window.
	 */
//	@Test
//	public void handlingWindows() {
//		browser.openURL("https://www.globalsqa.com/demo-site/frames-and-windows/");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		String originalWindowHandle = browser.getDriver().getWindowHandle();
//
//		System.out.println("Parent Window : " + originalWindowHandle);
//		browser.getDriver().findElement(By.xpath("//*[@id='Open New Window']")).click();
//		WebElement clickHereButton = browser.getDriver()
//				.findElement(By.xpath("//*[@id='post-2632']/div[2]/div/div/div[2]/a"));
//		clickHereButton.click();
//
//		Set<String> windowHandles = browser.getDriver().getWindowHandles();
//		for (String handle : windowHandles) {
//			System.out.println("Child Window : " + handle);
//			if (!handle.equals(originalWindowHandle)) {
//				System.out.println("Handle::::" + handle);
//				browser.getDriver().switchTo().window(handle);
//
//			}
//		}
//
//		WebElement contactUsButton = browser.getDriver().findElement(By.xpath("//*[@id='menu-item-1561']/a"));
//		contactUsButton.click();
//
//		browser.getDriver().findElement(By.id("comment_name")).sendKeys("About Windows");
//		browser.getDriver().findElement(By.id("email")).sendKeys("abc@gmail.com");
//		browser.getDriver().findElement(By.id("subject")).sendKeys("windows");
//		browser.getDriver().findElement(By.id("comment")).sendKeys("helloo");
//		browser.getDriver().findElement(By.xpath("//*[@id='submit']")).click();
//		System.out.println("originalWindowHandle::::" + originalWindowHandle);
//		browser.getDriver().switchTo().window(originalWindowHandle);
//
//		String expectedTitleOriginal = "Frames and Window Dummy Testing Site - GlobalSQA";
//		String actualTitleOriginal = browser.getDriver().getTitle();
//		if (expectedTitleOriginal.equals(actualTitleOriginal)) {
//			System.out.println("Expected title in the original window");
//		}
//
//	}
	/**
	 * This method is to perform Frames handling do some action and switch back to
	 * Frame.
	 */
//	@Test
//	public void handlingFrames() {
//		browser.openURL("https://www.globalsqa.com/demo-site/frames-and-windows/");
//		browser.maximizeWindow();
//		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement iFrameTab = browser.getDriver().findElement(By.xpath("//*[@id='iFrame']"));
//		iFrameTab.click();
//		browser.getDriver().switchTo().frame(0);
//		WebElement clickSelenium = browser.getDriver()
//				.findElement(By.xpath("//*[@id=\"portfolio_items\"]/div[1]/a/div/div/div[1]/img"));
//		clickSelenium.click();
//		
//	
//		WebElement searchTextField = browser.getDriver().findElement(By.xpath("//*[@id='s']"));
//		searchTextField.sendKeys("Teaching Philosophy");
//		
//		WebElement searchButton = browser.getDriver().findElement(By.xpath("//button[@class='button_search'][1]"));
//		searchButton.click();
//		browser.getDriver().navigate().back();
//		browser.getDriver().navigate().back();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//			}

	/**
	 * This method is used to hover over an element that displays a tooltip and capture the
	 * tooltip text and verify its content.
	 * 
	 */
	@Test
	public void handlingTooltip() {
		browser.openURL("https://www.globalsqa.com/demo-site/tooltip/");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		browser.getDriver().findElement(By.xpath("//*[@id='Forms Based']")).click();

		WebElement iFrame = browser.getDriver().findElement(
				By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']/child::p/iframe"));
		browser.getDriver().switchTo().frame(iFrame);

		WebElement firstNameTextField = browser.getDriver().findElement(By.xpath("//input[@id='firstname']"));
		String tooltipText = firstNameTextField.getAttribute("title");
		System.out.println("Retrieved tooltip text as :" + tooltipText);
		
		if (tooltipText.equalsIgnoreCase("Please provide your firstname.")) {
			System.out.println("Pass : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}
	}
}

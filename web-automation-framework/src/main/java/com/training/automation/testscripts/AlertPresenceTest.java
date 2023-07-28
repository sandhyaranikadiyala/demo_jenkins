package com.training.automation.testscripts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

import io.netty.handler.timeout.TimeoutException;

/**
 * This is AlertLoad class to alert to be present on the page within a specified
 * timeout.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class AlertPresenceTest extends TestBase {
	@BeforeClass
	public void setup() {
		browser.openURL("https://demoqa.com/alerts");
		browser.maximizeWindow();

	}

	@Test
	public void waitForAlertPresentTest() {
		try {

			WebElement clickAlert = browser.getDriver().findElement(By.id("alertButton"));
			clickAlert.click();
			WebDriverWait wait = new WebDriverWait(browser.getDriver(),Duration.ofSeconds(20));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = browser.getDriver().switchTo().alert();
			System.out.println("Alert text: " + alert.getText());
			alert.accept();

		} catch (TimeoutException e) {
			System.out.println("Timed out while waiting for the alert to be present.");
		}
	}

}

package com.training.automation.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is ExplicitWaitElementClickable to wait for an element to be clickable
 * using the Explicit Wait concept in selenium.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ExplicitWaitElementClickable extends TestBase {
	@Test
	public void explicitWait() {
		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();
		WebElement clickRemoveButton = browser.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
		clickRemoveButton.click();
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loading")));

	}

}

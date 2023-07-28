package com.training.automation.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is ElementVisibilityWait to specific element to be visible on the page
 * within a specified timeout period.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class ElementVisibilityWait extends TestBase {
	@Test
	public void visibilityWait() {
		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();
		WebElement clickEnableButton = browser.getDriver().findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		clickEnableButton.click();
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
	}
}

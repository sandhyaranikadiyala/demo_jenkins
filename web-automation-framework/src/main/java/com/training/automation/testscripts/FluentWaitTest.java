package com.training.automation.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

public class FluentWaitTest extends TestBase {
	@Test
	public void waitForElementToDisappearTest() throws InterruptedException {

		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();
		
		WebElement checkbox = browser.getDriver().findElement(By.xpath("//div[@id='checkbox']"));
		checkbox.click();
		
		WebElement removeButton = browser.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeButton.click();

		Wait<WebDriver> wait = new FluentWait<>(browser.getDriver()).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add']")));
		WebElement addButton = browser.getDriver().findElement(By.xpath("//button[normalize-space()='Add']"));
		
		addButton.click();
		System.out.println("Successfuuly Clicked");
		

	}

}

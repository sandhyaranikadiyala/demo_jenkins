package com.training.automation.testscripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

import io.netty.handler.timeout.TimeoutException;

/**
 * This is WaitTest to perform ExplicitWait,ImplicitWait and FluentWait.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class WaitExerciseTest extends TestBase {
	/**
	 * This is explicitWait method to wait for an element to be clickable using the
	 * Explicit Wait concept in selenium.
	 */
	@Test(priority = 1)
	public void waitforElementClickable() {
		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();
		WebElement removeButton = browser.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeButton.click();
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loading")));

	}

	/**
	 * This is visibilityWait method to specific element to be visible on the page
	 * within a specified timeout period.
	 */
	@Test(priority = 2)
	public void waitforElementVisibility() {
		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();
		WebElement enableButton = browser.getDriver().findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		enableButton.click();
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
	}

	/**
	 * This is waitForPageToLoadTest to wait until the document.readyState is
	 * "complete"" using the Implicit Wait concept.
	 * 
	 */
	@Test(priority = 3)
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
	}

	/**
	 * This is waitForElementToDisappearTest method to perform FluentWait.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
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
		System.out.println("Successfully Clicked");

	}

	/**
	 * This is waitForAlertPresentTest method to alert to be present on the page
	 * within a specified timeout.
	 */
	@Test(priority = 5)
	public void waitForAlertPresentTest() {
		browser.openURL("https://demoqa.com/alerts");
		browser.maximizeWindow();
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

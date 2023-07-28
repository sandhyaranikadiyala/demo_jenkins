package com.training.automation.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is DynamicElementTest class to write the selenium script to perform
 * Clicking buttons and checking checkboxes.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class DynamicElementTest extends TestBase {
	
	@Test
	public void clickButtons() {
		browser.openURL("https://the-internet.herokuapp.com/dynamic_controls");
		browser.maximizeWindow();

		WebElement removeButton = browser.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeButton.click();

		WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		WebElement checkboxMeassage = browser.getDriver().findElement(By.xpath("//*[@id=\"message\"]"));
		System.out.println(checkboxMeassage.getText());

		WebElement addButton = browser.getDriver().findElement(By.xpath("//button[contains(text(),'Add')]"));

		addButton.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		WebElement checkboxElement = browser.getDriver().findElement(By.id("checkbox"));
		boolean isCheckboxPresent = checkboxElement.isDisplayed();
		if (isCheckboxPresent) {
			System.out
					.println("The checkbox element is no longer present on the page after clicking the Remove button.");

		} else {
			System.out.println("The checkbox element is still present on the page.");
		}

		boolean isCheckedBoxPresent1 = browser.getDriver().findElement(By.id("checkbox")).isDisplayed();
		System.out.println("\n" + "After Clicking Add button Is checkbox present? " + isCheckedBoxPresent1 + "\n");

	}

}

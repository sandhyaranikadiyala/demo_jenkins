package com.training.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsClickButtons {
	public void clickButtons() {
		WebDriver driver = new ChromeDriver();
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		removeButton.click();

		// WebDriverWait wait= new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

	}

}

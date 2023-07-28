package com.training.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This is WorldPopulationScript class to print the Population Growth Today to
 * console using dynamic elements.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class WorldPopulationScript extends TestBase {
	@Test
	public void getPopulationToday() {
		browser.openURL("https://www.worldometers.info/world-population/");
		browser.maximizeWindow();
		WebElement populationGrowthToday = browser.getDriver().findElement(By.xpath(
				"//*[@class='sec-box-last']/child::*[@class='sec-text'][text()='Population Growth today ']/following::span[1]"));

		System.out.println("Population Growth Today : " + populationGrowthToday.getText() + "\n");

		WebElement birthsToday = browser.getDriver().findElement(By.xpath(
				"//div[@class='sec-box']/child::*[@class='sec-text'][text()='Births today ']/following::span[1]"));

		System.out.println("Births Today  : " + birthsToday.getText() + "\n");

	}

}

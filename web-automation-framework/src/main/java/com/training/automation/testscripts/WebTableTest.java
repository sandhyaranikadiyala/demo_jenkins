package com.training.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This class is to Locate and retrieve the data from a specific cell in the
 * table.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class WebTableTest extends TestBase {
	/**
	 * This method is to Locate and retrieve the data from a specific cell in the
	 * table. Verify the expected content of the cell.
	 */
	@Test
	public void handlingWebTable() {
		browser.openURL("https://the-internet.herokuapp.com/tables");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement table = browser.getDriver().findElement(By.id("table1"));
		int rowsCount = table.findElements(By.xpath("//*[@id='table1']/tbody/tr")).size();
		System.out.println("Number of rows in the table: " + rowsCount);
		
		WebElement cellData = table.findElement(By.xpath("//*[@id='table1']/tbody/tr[3]/td[4]"));
		String actualContent = cellData.getText();
		System.out.println("Cell Data : " + actualContent);
		
		String expectedContent = "$100.00";
		
		if (expectedContent.equals(actualContent)) {
			System.out.println("Pass : Cell content matched with the Expected content");
		}

	}

}

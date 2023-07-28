package com.training.automation.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.training.automation.base.TestBase;

/**
 * This class is used to upload the file and verify the success message.
 * 
 * @author Sandhya.Kadiyala
 *
 */
public class FileUploadTest extends TestBase {
	/**
	 * This is a test method which tests the file upload and verify the success message.
	 */
	@Test
	public void testFileUpload() {
		browser.openURL("https://the-internet.herokuapp.com/upload");
		browser.maximizeWindow();
		browser.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement chooseFileButton = browser.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
		chooseFileButton.sendKeys("C:\\Users\\sandhya.kadiyala\\eclipse-workspace\\javaselenium_task\\output.txt");
		WebElement uploadButton = browser.getDriver().findElement(By.id("file-submit"));
		uploadButton.click();

		WebElement successMessage = browser.getDriver().findElement(By.tagName("h3"));
		if (successMessage.getText().equals("File Uploaded!")) {
			System.out.println("File uploaded successfully!");
		} else {
			System.out.println("File upload failed!");
		}

	}

}

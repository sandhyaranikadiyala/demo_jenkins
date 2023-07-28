package com.training.automation.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.automation.constants.FilePathConstants;
import com.training.automation.messages.ErrorMessages;
import com.training.automation.messages.InfoMessages;
import com.training.automation.page.keys.GoogleSearchPageKeys;
import com.training.automation.utils.PropertyParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class contains supported methods for executing test methods
 * of {@link com.training.automation.testscripts.GoogleSearchTest} class.
 *
 * @author arun.pareek
 */
public class GoogleSearchPage {
    PropertyParser propertyParser;

    public GoogleSearchPage() {
        propertyParser = new PropertyParser(FilePathConstants.GOOGLE_SEARCH_LOCATOR_FILE_PATH);
    }

    /**
     * This method is used to search text on Google Search page
     *
     * @param text   Text to be search on Google
     * @param driver Current {@link WebDriver} instance
     * @param test   Current {@link ExtentTest} instance
     */
    public void searchText(String text, WebDriver driver, ExtentTest test) {
        try {
            test.log(LogStatus.INFO, InfoMessages.ENTER_TEXT_MESSAGE + text);

            String searchTextFieldXPath = propertyParser.getPropertyValue(GoogleSearchPageKeys.SEARCH_TEXT_FIELD_KEY);
            if (searchTextFieldXPath.length() == 0) {
                test.log(LogStatus.ERROR, ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + GoogleSearchPageKeys.SEARCH_TEXT_FIELD_KEY + ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
                return;
            }

            WebElement searchTextField = driver.findElement(By.xpath(searchTextFieldXPath));
            searchTextField.sendKeys(text);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            String searchButtonXPath = propertyParser.getPropertyValue(GoogleSearchPageKeys.SEARCH_BUTTON_KEY);
            if (searchButtonXPath.length() == 0) {
                test.log(LogStatus.ERROR, ErrorMessages.XPATH_READING_FAILED_MESSAGE_PREFIX + GoogleSearchPageKeys.SEARCH_BUTTON_KEY + ErrorMessages.XPATH_READING_FAILED_MESSAGE_SUFFIX);
                return;
            }

            test.log(LogStatus.INFO, InfoMessages.PRESS_ENTER_KEY_MESSAGE);
            WebElement searchButton = driver.findElement(By.xpath(searchButtonXPath));
            searchButton.click();
        } catch (NoSuchElementException noSuchElementException) {
            test.log(LogStatus.ERROR, noSuchElementException.getLocalizedMessage());
        }
    }
}

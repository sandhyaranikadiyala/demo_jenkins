package com.training.automation.testscripts;

import com.relevantcodes.extentreports.LogStatus;
import com.training.automation.base.TestBase;
import com.training.automation.messages.InfoMessages;
import com.training.automation.messages.VerifyMessages;
import com.training.automation.pages.GoogleSearchPage;
import com.training.automation.verification.Verify;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBase {

	@Test
	public void googleSearch() {
		test.log(LogStatus.INFO, InfoMessages.OPENING_BROWSER_MESSAGE);
		browser.openURL("http://www.google.com");

		test.log(LogStatus.INFO, InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
		browser.maximizeWindow();

		GoogleSearchPage googleSearchPage = new GoogleSearchPage();
		googleSearchPage.searchText("Selenium", browser.getDriver(), test);

		String actualPageTitle = browser.getCurrentPageTitle();
		String expectedPageTitle = "Selenium - Google Search";

		Verify.verifyString(actualPageTitle, expectedPageTitle, VerifyMessages.VERIFY_PAGE_TITLE_MESSAGE, test);

	}	
    @Test
    public void googleSearch2() {
        test.log(LogStatus.INFO, InfoMessages.OPENING_BROWSER_MESSAGE);
        browser.openURL("http://www.google.com");

        test.log(LogStatus.INFO, InfoMessages.MAXIMIZE_BROWSER_MESSAGE);
        browser.maximizeWindow();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchText("Selenium", browser.getDriver(), test);

        String actualPageTitle = browser.getCurrentPageTitle();
        String expectedPageTitle = "Selenium - Google Search1";

        Verify.verifyStringAndStopTest(actualPageTitle, expectedPageTitle, VerifyMessages.VERIFY_PAGE_TITLE_MESSAGE, test);


    }

}

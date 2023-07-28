package com.training.automation.browser;

import com.training.automation.browserinterface.IBrowser;
import com.training.automation.driver.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * This class implements the IBrowser interface methods
 *
 * @author arun.pareek
 */
public class Browser implements IBrowser {
    WebDriver driver = null;

    @Override
    public void openURL(String URL) {
        if (driver==null) {
            DriverManager driverManager = new DriverManager();
            driver = driverManager.getWebDriver();
        }
        driver.get(URL);
    }

    @Override
    public void closeBrowser() {
        if (driver!=null) {
            driver.close();
        }
    }

    @Override
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Override
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    @Override
    public String getCurrentURL() {
        String currentURL = null;

        try {
            currentURL = driver.getCurrentUrl();
        } catch (NullPointerException nullPointerException) {
            System.out.println("Browser is not available to get the current url " + nullPointerException.getMessage());
        }

        return currentURL;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public String getCurrentPageTitle() {
        String currentPageTitle = null;

        try {
            currentPageTitle = driver.getTitle();
        } catch (NullPointerException nullPointerException) {
            System.out.println("Browser is not available to close the browser " + nullPointerException.getMessage());
        }

        return currentPageTitle;
    }

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
}

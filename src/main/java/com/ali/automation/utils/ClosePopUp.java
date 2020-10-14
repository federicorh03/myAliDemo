package com.ali.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ali.automation.webdriver.ElementsUtil.waitForElementToBeClickable;
import static com.ali.automation.webdriver.ElementsUtil.waitForPageLoaded;

public class ClosePopUp {
    private final static Logger log = LoggerFactory.getLogger(com.ali.automation.utils.ClosePopUp.class);

    public static void closeFirstPopUp(WebDriver driver, WebElement closeButton) {
        try {
            log.info("Waiting for popup to appear");
            waitForPageLoaded(driver);
            waitForElementToBeClickable(driver, closeButton);
            closeButton.click();
            log.info("Popup closed");
        } catch (Exception e) {
            log.error("Error while closing popup");
        }

    }
}

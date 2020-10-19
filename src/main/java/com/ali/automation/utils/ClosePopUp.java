package com.ali.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClosePopUp {
    private final static Logger log = LoggerFactory.getLogger(com.ali.automation.utils.ClosePopUp.class);

    public static void closePopUp(WebDriver driver, WebElement closeButton) {
        try {
            closeButton.click();
            log.info("Popup closed");
        } catch (Exception e) {
            log.error("Error while closing popup");
        }

    }
}

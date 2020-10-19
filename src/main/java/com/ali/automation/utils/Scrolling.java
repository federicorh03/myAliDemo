package com.ali.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scrolling {
    private final static Logger log = LoggerFactory.getLogger(com.ali.automation.utils.Pagination.class);



    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollByPixel(WebDriver driver, String pixels) {
        String javaScript = "window.scrollBy(0," + pixels + ")";
        log.info("Scrolling {} pixels", pixels);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(javaScript);
    }
}

package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ali.automation.utils.ClosePopUp.closeFirstPopUp;
import static com.ali.automation.webdriver.ElementsUtil.waitForPageLoaded;

public class AliResultsPage extends Page{
    public AliResultsPage(WebDriver driver) {
        super(driver);
    }

    private final static String dialogCloseClass = "next-dialog-close";

    private WebElement dialogCloseButton = driver.findElement(By.className(dialogCloseClass));

    public void preparePage() {
        waitForPageLoaded(driver);
        closeFirstPopUp(driver, dialogCloseButton);
    }


}

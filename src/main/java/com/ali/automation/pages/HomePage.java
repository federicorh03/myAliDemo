package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ali.automation.utils.ClosePopUp.closePopUp;
import static com.ali.automation.webdriver.ElementsUtil.*;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final static String popUpCloseXpath = "(//img[@class='rax-image '])[2]";
    private final static String searchBarInputId = "search-key";
    private final static String searchBarButtonClass = "search-button";
    private final static String popUpFrameCSS = "iframe[src*=\"campaign\"]";

    public void preparePage() {
        waitForPageLoaded(driver);
        waitForFrameToBeAvailableAndSwitchToIt(driver, By.cssSelector(popUpFrameCSS));
        log.info("Waiting for popup to appear");
        fluentWait(driver, By.xpath(popUpCloseXpath), 10);
        WebElement popUpClose = driver.findElement(By.xpath(popUpCloseXpath));
        closePopUp(driver, popUpClose);
    }

    public ResultsPage searchText(String text) {
        WebElement searchBarInput = driver.findElement(By.id(searchBarInputId));
        WebElement searchBarButton = driver.findElement(By.className(searchBarButtonClass));

        log.info("Searching for text \"{}\"", text);
        searchBarInput.sendKeys(text);
        searchBarButton.click();
        return new ResultsPage(driver);
    }

}

package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ali.automation.utils.ClosePopUp.closeFirstPopUp;
import static com.ali.automation.webdriver.ElementsUtil.waitForPageLoaded;

public class AliHomePage extends Page {
    public AliHomePage(WebDriver driver) {
        super(driver);
    }

    private final static String popUpCloseXpath = "(//img[@class='rax-image '])[2]";
    private final static String searchBarInputId = "search-key";
    private final static String searchBarButtonClass = "search-button";

    private WebElement popUpClose = driver.findElement(By.xpath(popUpCloseXpath));
    private WebElement searchBarInput = driver.findElement(By.id(searchBarInputId));
    private WebElement searchBarButton = driver.findElement(By.className(searchBarButtonClass));

    public void preparePage() {
        waitForPageLoaded(driver);
        closeFirstPopUp(driver, popUpClose);
    }

    public AliResultsPage searchText(String text) {
        log.info("Searching for text \"" + text + "\"");
        searchBarInput.sendKeys(text);
        searchBarButton.click();
        return new AliResultsPage(driver);
    }

}

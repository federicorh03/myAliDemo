package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.ali.automation.utils.ClosePopUp.closePopUp;
import static com.ali.automation.utils.Pagination.goToNextPage;
import static com.ali.automation.webdriver.ElementsUtil.*;
import static com.ali.automation.utils.Scrolling.scrollToElement;

public class ResultsPage extends Page{
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private final static String dialogCloseClass = "next-dialog-close";
    private final static String productAdTitleCSSByIndex = ".list-item [product-index=\"number\"] a.item-title";
    private final static String lastProductCSS = ".list-item:last-child";

    public void preparePage() {
        waitForPageLoaded(driver);
        WebElement dialogCloseButton = driver.findElement(By.className(dialogCloseClass));
        closePopUp(driver, dialogCloseButton);
    }

    public ResultsPage nextPage(WebDriver driver) throws InterruptedException {
        log.info("Going to next page");
        log.info(String.valueOf(driver.findElements(By.cssSelector(".list-item")).size()));
        while (driver.findElements(By.cssSelector(".list-item")).size()<60) {
            Thread.sleep(5);
        }
        scrollToElement(driver, driver.findElement(By.cssSelector(lastProductCSS)));
        goToNextPage(driver);
        return new ResultsPage(driver);
    }

    public ProductPage selectProductByIndex(int productIndex) {
        String index = Integer.toString(productIndex-1);
        By by = By.cssSelector(productAdTitleCSSByIndex.replace("number", index));
        WebElement productAdTitle = driver.findElement(by);

        waitForElementToBeClickable(driver, productAdTitle);
        log.info("Selecting product #{}", productIndex);
        clickWithStaleRefHandle(driver, by);
        //productAdTitle.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new ProductPage(driver);
    }

}

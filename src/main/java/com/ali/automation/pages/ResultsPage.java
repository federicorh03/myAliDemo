package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.ali.automation.utils.ClosePopUp.closePopUp;
import static com.ali.automation.utils.Pagination.goToNextPage;
import static com.ali.automation.utils.Scrolling.*;
import static com.ali.automation.webdriver.ElementsUtil.*;

public class ResultsPage extends Page{
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private final static String dialogCloseClass = "next-dialog-close";
    private final static String productAdTitleCSSByIndex = ".list-item [product-index=\"number\"] a.item-title";
    private final static String lastProductCSS = ".list-item:last-child";

    public void preparePage() {
        WebElement dialogCloseButton = driver.findElement(By.className(dialogCloseClass));
        closePopUp(driver, dialogCloseButton);
    }

    public ResultsPage nextPage(WebDriver driver) throws InterruptedException {
        int pixels = 13500;
        log.info("Going to next page");
        Thread.sleep(2000); //sleeping thread due to lack of better handling, must be replaced
        WebElement productElement = driver.findElement(By.cssSelector("li > div"));
        log.info("Handling results view as there are two possibilities. Gallery and list views");
        if (productElement.getAttribute("class").contains("gallery")) {
            pixels = 4000;
        }
        log.info("Gallery view: " + productElement.getAttribute("class").contains("gallery"));
        scrollByPixel(driver, String.valueOf(pixels));
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
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new ProductPage(driver);
    }

}

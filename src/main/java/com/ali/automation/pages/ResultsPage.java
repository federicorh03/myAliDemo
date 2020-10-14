package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ali.automation.utils.ClosePopUp.closeFirstPopUp;
import static com.ali.automation.webdriver.ElementsUtil.waitForElementToBeClickable;
import static com.ali.automation.webdriver.ElementsUtil.waitForPageLoaded;

public class ResultsPage extends Page{
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    private final static String dialogCloseClass = "next-dialog-close";
    private final static String productAdCSSByIndex = ".list-item [product-index=number]";

    private WebElement dialogCloseButton = driver.findElement(By.className(dialogCloseClass));

    public void preparePage() {
        waitForPageLoaded(driver);
        closeFirstPopUp(driver, dialogCloseButton);
    }

    public ProductPage selectProductByIndex(String index) {
        WebElement productAd = driver.findElement(By.cssSelector(productAdCSSByIndex.replace("number", index)));

        waitForElementToBeClickable(driver, productAd);
        productAd.click();
        return new ProductPage(driver);
    }

}

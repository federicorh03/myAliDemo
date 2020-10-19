package com.ali.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.ali.automation.webdriver.ElementsUtil.waitForElementGetsVisible;

public class ProductPage extends Page{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final static String productAvailQtyCSS = ".product-quantity-tip span";

    private final WebElement productAvailQtyLabel = driver.findElement(By.cssSelector(productAvailQtyCSS));

    public int getProductAvailableQuantity() {

        log.info("Getting available items quantity");
        waitForElementGetsVisible(driver, productAvailQtyLabel);
        String[] productAvailQtyLabelArray = productAvailQtyLabel.getText().split(" ");
        return Integer.parseInt(productAvailQtyLabelArray[0]);
    }
}

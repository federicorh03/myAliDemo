package com.ali.automation.functional;

import com.ali.automation.pages.HomePage;
import com.ali.automation.pages.ProductPage;
import com.ali.automation.pages.ResultsPage;
import com.ali.automation.parallelexecution.TLDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductAvailabilityTest extends TestSuitesBase {

    @Test
    public void verifyProductAvailability() throws Exception {
        WebDriver driver;
        driver = TLDriverFactory.getDriver();
        log.info("Starting test");
        driver.get(baseUrl);

        log.info("Search product");
        HomePage homePage = new HomePage(driver);
        homePage.preparePage();
        String product = "Iphone";
        ResultsPage resultsPage = homePage.searchText(product);

        resultsPage.preparePage();
        ProductPage productPage = resultsPage.selectProductByIndex(2);

        int availableToBuy = productPage.getProductAvailableQuantity();

        Assert.assertTrue(availableToBuy > 0, "No more items available to buy, please select another product");
    }
}

package com.ali.automation.functional;

import com.ali.automation.pages.HomePage;
import com.ali.automation.pages.ProductPage;
import com.ali.automation.pages.ResultsPage;
import com.ali.automation.utils.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductAvailabilityTest extends TestSuitesBase {

    @Test
    public void verifyProductAvailability() throws Exception {
        WebDriver driver = DriverInit.setDriver();
        log.info("Starting test");
        driver.get(baseUrl);
        log.info("Search product");
        HomePage homePage = new HomePage(driver);
        homePage.preparePage();
        String product = "Iphone";
        ResultsPage resultsPage = homePage.searchText(product);

        resultsPage.preparePage();
        ResultsPage secondResultsPage = resultsPage.nextPage(driver);
        ProductPage productPage = secondResultsPage.selectProductByIndex(2);

        int availableToBuy = productPage.getProductAvailableQuantity();

        try {
            Assert.assertTrue(availableToBuy > 0, "No more items available to buy, please select another product");
            log.info("Test passed");
            driver.quit();
        }catch (Exception e){
            log.info("Test failed");
            driver.quit();
        }
    }
}

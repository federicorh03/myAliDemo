package com.ali.automation.utils;

import com.ali.automation.pages.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pagination {
    private final static Logger log = LoggerFactory.getLogger(com.ali.automation.utils.Pagination.class);

    private final static String previousButtonCSS = "[aria-label~=Previous]";
    private final static String nextButtonCSS = "[aria-label~=Next]";
    private final static String pagesListClass = "next-pagination-list";
    private final static String goToPageInputClass = "next-large";
    private final static String gotToPageButtonClass = "jump-btn";

    public ResultsPage goToPreviousPage(WebDriver driver) {
        WebElement previousButton = driver.findElement(By.cssSelector(previousButtonCSS));

        if (previousButton.getAttribute("disabled") == null) {
            previousButton.click();
        }else {
            log.info("You can't go further the first page");
        }
        return new ResultsPage(driver);
    }

    public ResultsPage goToNextPage(WebDriver driver) {
        WebElement nextButton = driver.findElement(By.cssSelector(nextButtonCSS));

        if (nextButton.getAttribute("disabled") == null) {
            nextButton.click();
        }else {
            log.info("You can't go further the last page");
        }
        return new ResultsPage(driver);
    }

    public ResultsPage goToPageNumber(WebDriver driver, Integer destPageNumber) {
        int pagesQty = driver.findElements(By.className(pagesListClass)).size();
        WebElement pageInput = driver.findElement(By.className(goToPageInputClass));
        WebElement goButton = driver.findElement(By.className(gotToPageButtonClass));

        if (pagesQty == 1) {
            log.info("There's only one results page");
        }else if (pagesQty < destPageNumber){
            log.info("There's no page " + destPageNumber + ". Last page is " + pagesQty);
        }else {
            pageInput.sendKeys(destPageNumber.toString());
            goButton.click();
            log.info("Going to page " + destPageNumber);
        }
        return new ResultsPage(driver);
    }

}

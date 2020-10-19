package com.ali.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ali.automation.webdriver.ElementsUtil.getLongTimeIntervalSec;
import static com.ali.automation.webdriver.ElementsUtil.getShortTimeIntervalSec;
import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final static Logger log = LoggerFactory.getLogger(Page.class);


    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, getLongTimeIntervalSec() * 4);
        driver.manage().timeouts().implicitlyWait(getShortTimeIntervalSec(), SECONDS);
        PageFactory.initElements(driver, this);
    }
}

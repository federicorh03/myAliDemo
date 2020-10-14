package com.ali.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

import static com.ali.automation.utils.GetScreenshot.captureScreenshot;
import static com.ali.automation.webdriver.ElementsUtil.*;
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

package com.ali.automation.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetScreenshot {
    private final static Logger log = LoggerFactory.getLogger(com.ali.automation.utils.GetScreenshot.class);

    public static String captureScreenshotForExtentHtmlReporter(WebDriver driver, String screenshotNamePattern) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String fileNameDestination = "target" + File.separator + "surefire-reports" + File.separator + "screenshots" +
                    File.separator + screenshotNamePattern + "_" + new SimpleDateFormat("yyyyMMddhhmmssSS'.png'").format(new Date());
            File destination = new File(fileNameDestination);
            FileUtils.copyFile(src, destination);
            log.info("Screenshot have been taken and placed\n" + destination.getAbsolutePath());
            return destination.getAbsolutePath();
        } catch (Exception e) {
            log.error("Unable to take screenshot");
            return e.getMessage();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


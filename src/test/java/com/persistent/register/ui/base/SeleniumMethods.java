package com.persistent.register.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.persistent.register.common.SeleniumWaits.timeout;

public class SeleniumMethods extends BasePage {


    public void sendKeysMethod(By by, String text) {
        timeout();
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);


    }

    public void clickMethod(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).click();
    }

    public void submitMethod(By by) {
        timeout();
        driver.findElement(by).submit();
    }
}




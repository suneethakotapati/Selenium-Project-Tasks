package com.persistent.ui.api.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is used to pause the execution of the test until certain conditions are met
 */
public class SeleniumWaits extends  BaseMethods{
    /**
     * This method is used to check if an element is present in the HTML DOM of a page
     *
     * @param by used to locate elements on a web page
     */
    public void waitForPresentElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This method is used to check if an element is visible on the page, and it waits until the element is visible before continuing the test
     *
     * @param by used to locate elements on a web page
     */
    public void waitForVisibilityElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * This method is used to checks that the element is visible, enabled, and positioned correctly on the page before considering it clickable.
     *
     * @param by used to locate elements on a web page
     */
    public void waitForClickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForInvisibilityOfElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}

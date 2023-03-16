package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreConfirmOrderPage extends SeleniumMethods {
    WebDriver driver;

    public J2StoreConfirmOrderPage(WebDriver driver) {
        this.driver = driver;

    }

    private By subtotal = By.xpath("//th[contains(text(),' Subtotal')]//following::td[1]");
    private By total = By.xpath("//th[contains(text(),' Total')]//following::td[1]");
    private By cashSubmitButton=By.id("cash-submit-button");

    public float getSubtotalFromUi() {
        //waitForPresentElement(subtotal);
        String subtotalPrice = getTextFromUi(subtotal);
        return convertToFloat(subtotalPrice);
    }

    public float getTotalFromUi() {
        //waitForPresentElement(total);
        String totalPrice = getTextFromUi(total);
        return convertToFloat(totalPrice);
    }
    public void clickCashSubmitButton(){
        waitForPresentElement(cashSubmitButton);
        waitForVisibilityElement(cashSubmitButton);
        waitForClickElement(cashSubmitButton);
        click(cashSubmitButton);
        waitForInvisibilityOfElement(cashSubmitButton);
    }

}


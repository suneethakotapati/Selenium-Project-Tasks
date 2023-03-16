package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StorePaymentPage extends SeleniumMethods {
    WebDriver driver;
    public J2StorePaymentPage(WebDriver driver){
        this.driver=driver;
    }
    private By cashOnDeliveryRadioButton= By.xpath("//input[@value='payment_cash']");
    private By customerNoteBox=By.xpath("//textarea[@name='customer_note']");
    private By paymentPageContinueButton=By.id("button-payment-method");
    private By spinner=By.className("wait");

    public void clickCashOnDeliveryRadioButton(){
        waitForPresentElement(cashOnDeliveryRadioButton);
        waitForClickElement(cashOnDeliveryRadioButton);
        click(cashOnDeliveryRadioButton);
        waitForInvisibilityOfElement(spinner);
        //waitForInvisibilityOfElement(cashOnDeliveryRadioButton);
    }
    public void setCustomerNoteBox(String customerNote){
        sendKeys(customerNoteBox,customerNote);
    }
    public void clickPaymentPageContinueButton(){
        click(paymentPageContinueButton);

        waitForInvisibilityOfElement(paymentPageContinueButton);
    }
}

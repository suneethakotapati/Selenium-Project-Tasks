package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreCheckoutPage extends SeleniumMethods {
    WebDriver driver;
    private By registerAccountContinueButton= By.xpath("//button[@id='button-account']");
    public J2StoreCheckoutPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickRegisterAccountContinueButton(){
        waitForPresentElement(registerAccountContinueButton);
        scrollDown(registerAccountContinueButton);
        waitForInvisibilityOfElement(registerAccountContinueButton);
    }
}

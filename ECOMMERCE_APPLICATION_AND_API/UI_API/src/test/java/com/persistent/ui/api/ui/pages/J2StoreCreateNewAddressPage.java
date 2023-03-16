package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreCreateNewAddressPage extends SeleniumMethods {
    WebDriver driver;

    public J2StoreCreateNewAddressPage(WebDriver driver) {
        this.driver = driver;
    }
   private By createNewAddressRadioButton=By.id("shipping-address-new");
    public  void clickCreateNewAddressRadioButton(){
        waitForPresentElement(createNewAddressRadioButton);
        findCreateNewAddressButton(createNewAddressRadioButton);
        waitForClickElement(createNewAddressRadioButton);
        click(createNewAddressRadioButton);
    }
}

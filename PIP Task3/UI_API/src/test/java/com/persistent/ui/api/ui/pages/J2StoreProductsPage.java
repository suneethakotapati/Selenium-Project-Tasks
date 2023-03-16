package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreProductsPage extends SeleniumMethods {
    WebDriver driver;
     private By TShirt=By.xpath("//a[contains(text(),'T-Shirt2')]");
    public J2StoreProductsPage(WebDriver driver){
        this.driver= driver;
    }
    public void clickTShirt(){
        waitForVisibilityElement(TShirt);
        waitForPresentElement(TShirt);
        click(TShirt);

    }
}

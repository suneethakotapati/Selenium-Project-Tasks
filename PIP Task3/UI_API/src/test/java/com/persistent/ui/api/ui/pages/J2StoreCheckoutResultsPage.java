package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreCheckoutResultsPage extends SeleniumMethods {
    WebDriver driver;
    public J2StoreCheckoutResultsPage(WebDriver driver){
        this.driver=driver;
    }
   // private By goToOrderHistoryLink=By.linkText("//a[contains(text(),'Go to order history')]");
    private By goToOrderHistoryLink= By.xpath("//a[contains(text(),'Go to order history')]");
    public void clickGoToOrderHistoryLink(){
        click(goToOrderHistoryLink);
        waitForInvisibilityOfElement(goToOrderHistoryLink);
    }

}

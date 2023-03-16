package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreShippingAddressPage extends SeleniumMethods {
    WebDriver driver;
    public J2StoreShippingAddressPage(WebDriver driver){
        this.driver=driver;
    }
    private  By shippingAddressFirstName= By.xpath("//div[@id='shipping-new']//input[@id='first_name']");
    private By shippingAddressLastName=By.xpath("//div[@id='shipping-new']//input[@id='last_name']");
    private By shippingAddressMobileNumber=By.xpath("//div[@id='shipping-new']//input[@id='phone_2']");
    private  By shippingAddressLine1=By.xpath("//div[@id='shipping-new']//input[@id='address_1']");
    private By shippingAddressCity=By.xpath("//div[@id='shipping-new']//input[@id='city']");
    private By shippingAddressPostalCode=By.xpath("//div[@id='shipping-new']//input[@id='zip']");
    private By shippingAddressCountry=By.xpath("//div[@id='shipping-new']//select[@id='country_id']");
    private By shippingAddressZone=By.xpath("//div[@id='shipping-new']//select[@id='zone_id']");
    private By shippingAddressContinueButton=By.id("button-shipping-address");

    public void setShippingAddressFirstName(String firstName){
        waitForPresentElement(shippingAddressFirstName);
        waitForVisibilityElement(shippingAddressFirstName);
        sendKeysForTextBox(shippingAddressFirstName,firstName);
    }
    public void setShippingAddressLastName(String lastName){
        sendKeys(shippingAddressLastName,lastName);
    }
    public void setShippingAddressMobileNumber(String mobileNumber){
        sendKeys(shippingAddressMobileNumber,mobileNumber);
    }
    public void setShippingAddressLine1(String addressLine1){
        sendKeys(shippingAddressLine1,addressLine1);
    }
    public void setShippingAddressCity(String city){
        sendKeys(shippingAddressCity,city);
    }
    public void setShippingAddressPostalCode(String postalCode){
        sendKeys(shippingAddressPostalCode,postalCode);
    }
    public void selectShippingAddressCountry(String country){
        selectFromDropdown(shippingAddressCountry,country);
    }
    public void selectShippingAddressZone(String zone){
        selectFromDropdown(shippingAddressZone,zone);
    }
    public void clickShippingAddressContinueButton(){
        click(shippingAddressContinueButton);
        waitForInvisibilityOfElement(shippingAddressContinueButton);
    }
}

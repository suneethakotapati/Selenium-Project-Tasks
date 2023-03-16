package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class J2StoreAccountAndBillingDetailsPage extends SeleniumMethods {
    WebDriver driver;
    public J2StoreAccountAndBillingDetailsPage(WebDriver driver){
        this.driver=driver;

    }
    private By billingDetailsFirstName= By.id("first_name");
    private By billingDetailsLastName=By.id("last_name");
    private By billingDetailsEmail=By.id("email");
    private By billingDetailsPhoneNumber=By.id("phone_1");
    private By billingDetailsMobileNumber=By.id("phone_2");
    private By billingDetailsPassword =By.xpath("//input[@class='large-field']");
    private By billingDetailsCompany =By.id("company");
    private By billingDetailsAddressLine=By.id("address_1");
    private By billingDetailsCity=By.id("city");
    private By billingDetailsPostalCode=By.id("zip");
    private By billingDetailsCountry=By.id("country_id");
    private By billingDetailsZone=By.id("zone_id");
    private By billingDetailsCheckBox=By.id("shipping");
    private By billingDetailsRegisterButton=By.id("button-register");

    public void setBillingDetailsFirstName(String firstName){
        waitForPresentElement(billingDetailsFirstName);
        waitForVisibilityElement(billingDetailsFirstName);
        waitForClickElement(billingDetailsFirstName);
        sendKeysForTextBox(billingDetailsFirstName,firstName);
    }
    public void setBillingDetailsLastName(String lastName){
        sendKeys(billingDetailsLastName,lastName);
    }

    public String setEmail(){
        String randomEmailName = new String(RandomStringUtils.randomAlphanumeric(6))+"@gmail.com";
        return  randomEmailName;
    }
    public void setBillingDetailsEmail(){
        String email = setEmail();
        sendKeys(billingDetailsEmail,email);


        //sendKeys(billingDetailsEmail,email);
    }

    public void setBillingDetailsPhoneNumber(String phoneNumber){
        sendKeys(billingDetailsPhoneNumber,phoneNumber);
    }
    public void setBillingDetailsMobileNumber(String mobileNumber){
        sendKeys(billingDetailsMobileNumber,mobileNumber);
    }
    public void setBillingDetailsPassword(String text){
        sendPassword(billingDetailsPassword,text);
    }
    public void setBillingDetailsCompany(String companyName){
        sendKeys(billingDetailsCompany,companyName);
    }
    public void setBillingDetailsAddressLine(String addressLine){
        sendKeys(billingDetailsAddressLine,addressLine);
    }
    public void setBillingDetailsCity(String city){
        sendKeys(billingDetailsCity,city);
    }
    public void setBillingDetailsPostalCode(String postalCode){
        sendKeys(billingDetailsPostalCode,postalCode);
    }
    public void selectBillingDetailsCountry(String country){
        selectFromDropdown(billingDetailsCountry,country);
    }
    public void selectBillingDetailsZone(String zone){
        selectFromDropdown(billingDetailsZone,zone);
    }
    public void clickBillingDetailsCheckBox(){
        click(billingDetailsCheckBox);
    }
    public void clickBillingDetailsRegisterButton(){
        waitForVisibilityElement(billingDetailsRegisterButton);
        click(billingDetailsRegisterButton);
        waitForInvisibilityOfElement(billingDetailsRegisterButton);
    }

}

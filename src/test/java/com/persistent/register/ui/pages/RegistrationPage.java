package com.persistent.register.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    /**
     * Id's,xpath's for webelements present in the Qademo form website.
     */
    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By email = By.id("userEmail");
    public By gender = By.xpath("//*[@for='gender-radio-2']");
    public By mobileNumber = By.id("userNumber");
    public By dateOfBirthID = By.id("dateOfBirthInput");
    public By sendYear = By.xpath("//select[@class='react-datepicker__year-select']");
    public By sendMonth = By.xpath("//select[@class='react-datepicker__month-select']");
    public By sendDay = By.xpath("//div[@aria-label='Choose Wednesday, December 11th, 2002']");
    public By hobbies = By.id("hobbies-checkbox-2");
    public By uploadPic = By.id("uploadPicture");
    public By locality = By.id("currentAddress");
    public By subject=By.xpath("//div[@id='subjectsContainer']//following::input[@id='subjectsInput']");
    public By state = By.xpath("//div[contains(text(),'Select State')]//following::input[1]");
    public By city = By.xpath("//div[contains(text(),'Select City')]//following::input[1]");

    public By button = By.id("submit");
    public By popUp = By.id("example-modal-sizes-title-lg");

    public RegistrationPage(WebDriver d) {
        driver = d;

    }

}

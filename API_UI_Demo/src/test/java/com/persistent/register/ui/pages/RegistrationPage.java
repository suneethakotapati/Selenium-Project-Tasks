package com.persistent.register.ui.pages;

import com.persistent.register.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class RegistrationPage extends SeleniumMethods {
    WebDriver driver;
    /**
     * Id's,xpath's for webelements present in the QAdemo form website.
     */
    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By email = By.id("userEmail");
    public By gender_female = By.xpath("//*[@for='gender-radio-2']");
    public By gender_male = By.xpath("//*[@for='gender-radio-1']");
    public By gender_other = By.xpath("//*[@for='gender-radio-3']");
    public By phoneNumber = By.id("userNumber");
    public By dateOfBirthID = By.id("dateOfBirthInput");
    public By hobbies = By.id("hobbies-checkbox-2");
    public By photo = By.id("uploadPicture");
    public By locality = By.id("currentAddress");
    public By subject = By.xpath("//div[@id='subjectsContainer']//following::input[@id='subjectsInput']");
    public By state = By.xpath("//div[contains(text(),'Select State')]//following::input[1]");
    public By city = By.xpath("//div[contains(text(),'Select City')]//following::input[1]");
    public By button = By.id("submit");
    public By popUpText = By.id("example-modal-sizes-title-lg");

    public RegistrationPage(WebDriver d) {
        driver = d;

    }

    /**
     * This method is used to set the data to Firstname textbox
     * @param fname
     */
    public void setFirstName(String fname) {
        sendKeys(firstName, fname);
    }

    /**
     * This method is used to set the data to Lastname textbox
     *
     * @param lname
     */
    public void setLastName(String lname) {
        sendKeys(lastName, lname);
    }

    public void setEmail(String mail) {
        sendKeys(email, mail);
    }
    public void clickGenderRadioButton(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            clickBox(gender_female);
        } else if (gender.equalsIgnoreCase("male")) {
            clickBox(gender_male);
        }else{
            clickBox(gender_other);
        }
    }
    public void setPhoneNumber(String phone) {
        sendKeys(phoneNumber, phone);
    }
    public void clickDateOfBirthBox() {
        clickBox(dateOfBirthID);
    }
    public void setDateOfBirth(String dob) {
        dateSelector(dateOfBirthID, dob);
    }
    public void clickSubjectBox() {
        clickBox(subject);
    }
    public void setSubject(String sub) {
        subjectSelector(subject, sub);
    }
    public void clickHobbiesBox(){
      click(hobbies);
   }
    public void setPhoto(String pic) {
        sendKeys(photo, pic);
    }

    public void setAddress(String address) {
        sendKeys(locality, address);
    }

    public void setState(String sta) {
        sendTextToDropdown(state, sta);
    }

    public void setCity(String cit) {
        sendTextToDropdown(city, cit);
    }

    public void clickSubmitButton() {
        submit(button);
    }

    public void getPopUpText() {
        popUp(popUpText);
    }
}


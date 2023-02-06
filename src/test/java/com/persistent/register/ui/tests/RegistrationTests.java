package com.persistent.register.ui.tests;

import com.persistent.register.ui.base.SeleniumMethods;
import com.persistent.register.ui.enums.DataFile;
import com.persistent.register.ui.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.persistent.register.common.Listeners.class)
public class RegistrationTests extends SeleniumMethods {
    /**
     * This method is write code/business logic
     */
    @Test
    public void verifyTest() throws InterruptedException {
        RegistrationPage rgPage = new RegistrationPage(driver);
        String expectedTitle = DataFile.EXPECTED_TITLE.data;
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, DataFile.TITLE_WEBSITE.data);
        sendKeys(rgPage.firstName, DataFile.LOGIN_FIRSTNAME.data);
        sendKeys(rgPage.lastName, DataFile.LOGIN_LASTNAME.data);
        sendKeys(rgPage.email, DataFile.LOGIN_EMAIL.data);
        clickBox(rgPage.gender);
        sendKeys(rgPage.mobileNumber, DataFile.LOGIN_MOBILENUMBER.data);
        clickBox(rgPage.dateOfBirthID);
        clickBox(rgPage.dateOfBirthID);
        dropdown(rgPage.sendYear, DataFile.LOGIN_YEAR.data);
        dropdown(rgPage.sendMonth, DataFile.LOGIN_MONTH.data);
        day(rgPage.sendDay,DataFile.DOB_DAY.data);
        clickBox(rgPage.subject);
        sendData(rgPage.subject,DataFile.LOGIN_SUBJECT.data);
        click(rgPage.hobbies);
        sendKeys(rgPage.uploadPic, DataFile.LOGIN_PHOTO.data);
        sendKeys(rgPage.locality, DataFile.LOGIN_ADDRESS.data);
        sendTextToDropdown(rgPage.state,DataFile.STATE.data);
        sendTextToDropdown(rgPage.city,DataFile.CITY.data);
        submit(rgPage.button);
        popUp(rgPage.popUp);

    }
}


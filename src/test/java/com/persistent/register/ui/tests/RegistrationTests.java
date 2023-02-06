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
     * This method will used to write code/business logic
     */
    @Test
    public void verifyTest() {
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
        selectByVis(rgPage.sendYear, DataFile.LOGIN_YEAR.data);
        selectByVis(rgPage.sendMonth, DataFile.LOGIN_MONTH.data);
        clickBox(rgPage.sendDay);
        clickBox(rgPage.subject);
        sendData(rgPage.subject, DataFile.LOGIN_SUBJECT.data);
        click(rgPage.hobbies);
        sendKeys(rgPage.uploadPic, DataFile.LOGIN_PHOTO.data);
        sendKeys(rgPage.locality, DataFile.LOGIN_ADDRESS.data);
        sendData(rgPage.state, DataFile.STATE.data);
        sendData(rgPage.city, DataFile.CITY.data);
        submit(rgPage.button);
        popUp(rgPage.popUp);

    }
}


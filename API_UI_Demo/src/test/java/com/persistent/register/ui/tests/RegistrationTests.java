package com.persistent.register.ui.tests;

import com.persistent.register.ui.base.SeleniumMethods;
import com.persistent.register.ui.enums.DataFile;
import com.persistent.register.ui.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.persistent.register.common.Listeners.class)
public class RegistrationTests extends SeleniumMethods{
    /**
     * This method is write code/business logic
     */
    @Test(testName = "verifyTest")
    public void verifyTest() {
        RegistrationPage rgPage = new RegistrationPage(driver);
        driver.get(DataFile.LOGIN_URL.data);
        String expectedTitle = DataFile.EXPECTED_TITLE.data;
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, DataFile.TITLE_WEBSITE.data);
        rgPage.setFirstName(DataFile.FIRSTNAME.data);
        rgPage.setLastName(DataFile.LASTNAME.data);
        rgPage.setEmail(DataFile.EMAIL.data);
        rgPage.clickGenderRadioButton(DataFile.GENDER.data);
        rgPage.setPhoneNumber(DataFile.PHONENUMBER.data);
        rgPage.clickDateOfBirthBox();
        rgPage.setDateOfBirth(DataFile.DOB.data);
        rgPage.clickSubjectBox();
        rgPage.setSubject(DataFile.SUBJECT.data);
        rgPage.clickHobbiesBox();
        rgPage.setPhoto(DataFile.PHOTO.data);
        rgPage.setAddress(DataFile.ADDRESS.data);
        rgPage.setState(DataFile.STATE.data);
        rgPage.setCity(DataFile.CITY.data);
        rgPage.clickSubmitButton();
        rgPage.getPopUpText();
        Assert.assertTrue(false);
    }
}


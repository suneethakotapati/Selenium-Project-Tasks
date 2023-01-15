package com.persistent.register.ui.tests;
import com.persistent.register.ui.enums.DataFile;
import com.persistent.register.ui.pages.RegistrationPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.persistent.register.ui.tests.Listeners.class)
public class TestClass extends DataFile {

    @Test
    public void verify() {

        RegistrationPage rgPage = new RegistrationPage(driver);
        sendKeysMethod(rgPage.bFirstName, firstName);
        sendKeysMethod(rgPage.lastName, lastName);
        sendKeysMethod(rgPage.email, email);
        clickMethod(rgPage.gender);
        sendKeysMethod(rgPage.mobileNumber, mobileNumber);
        clickMethod(rgPage.dateOfBirthID);
        clickMethod(rgPage.sendData);
        clickMethod(rgPage.sendMonth);
        clickMethod(rgPage.sendDay);
        clickMethod(rgPage.hobbies);
        sendKeysMethod(rgPage.uploadPic, pic);
        sendKeysMethod(rgPage.locality, address);
        submitMethod(rgPage.button);
    }

}


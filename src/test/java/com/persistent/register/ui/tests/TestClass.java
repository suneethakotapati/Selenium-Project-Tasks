package com.persistent.register.ui.tests;
import com.persistent.register.ui.enums.DataFile;
import com.persistent.register.ui.pages.RegistrationPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.persistent.register.ui.tests.Listeners.class)
public class TestClass extends DataFile {

    @Test
    public void verify()  {
        RegistrationPage rgPage = new RegistrationPage(driver);
        sendKeysMethod(rgPage.bFirstName, firstName);
        sendKeysMethod(rgPage.lastName, lastName);
        sendKeysMethod(rgPage.email, email);
        clickMethod(rgPage.gender);
        sendKeysMethod(rgPage.mobileNumber, mobileNumber);
        clickMethod(rgPage.dateOfBirthID);
        selectByVis(rgPage.sendYear,year);
        selectByVis(rgPage.sendMonth,month);
        clickMethod(rgPage.sendDay);
        clickMethod(rgPage.subject);
        send(rgPage.subject,sendCommerce);
        clickMethod(rgPage.hobbies);
        sendKeysMethod(rgPage.uploadPic, pic);
        sendKeysMethod(rgPage.locality, address);
        clickMethod(rgPage.state);
        clickDropdown(rgPage.clickState);
        clickMethod(rgPage.city);
        clickDropdown(rgPage.clickCity);
        submitMethod(rgPage.button);
    }
}


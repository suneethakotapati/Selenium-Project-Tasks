package com.persistent.register.ui.pages;

import com.persistent.register.ui.base.SeleniumMethods;
import com.persistent.register.ui.enums.DataFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends DataFile {
    WebDriver driver;

    public By bFirstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By email = By.id("userEmail");
    public By gender = By.xpath("//*[@for=\"gender-radio-2\"]");
    public By mobileNumber = By.id("userNumber");
    public By dateOfBirthID = By.id("dateOfBirthInput");
    public By sendData=By.xpath("//select/option[@value=\"2000\"]");
    public By sendMonth=By.xpath("//select/option[@value=\"6\"]");
    public By sendDay=By.xpath("//div[@aria-label=\"Choose Sunday, July 2nd, 2000\"]");
    public By hobbies=By.xpath("//label[@for=\"hobbies-checkbox-2\" and @class=\"custom-control-label\"]");
    public By uploadPic=By.id("uploadPicture");
    public By locality=By.id("currentAddress");
    public By state=By.xpath("//div[@class=\" css-1wa3eu0-placeholder\" and text()=\"Select State\"]");
   // public By  state=By.xpath("//div[text()=\"Select State\"]");
    public By city=By.xpath("//div[text()=\"Select City\"]");
    public By button=By.id("submit");
    public RegistrationPage(WebDriver d) {
        driver = d;

    }

}

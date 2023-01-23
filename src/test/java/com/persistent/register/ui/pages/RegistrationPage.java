package com.persistent.register.ui.pages;
import com.persistent.register.ui.enums.DataFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegistrationPage extends DataFile {
    WebDriver driver;
    public By bFirstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By email = By.id("userEmail");
    public By gender = By.xpath("//*[@for=\"gender-radio-2\"]");
    public By mobileNumber = By.id("userNumber");
    public By dateOfBirthID = By.id("dateOfBirthInput");
    public By sendYear=By.xpath("//select[@class=\"react-datepicker__year-select\"]");
    public By sendMonth=By.xpath("//select[@class=\"react-datepicker__month-select\"]");
    public By sendDay=By.xpath("//div[@aria-label=\"Choose Wednesday, December 11th, 2002\"]");
    public By hobbies = By.xpath("//label[@for=\"hobbies-checkbox-2\" and @class=\"custom-control-label\"]");
    public By uploadPic = By.id("uploadPicture");
    public By locality = By.id("currentAddress");
    public By subject=By.xpath("//div[@id=\"subjectsContainer\"] //div[@class=\"subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3\"]//input[@id=\"subjectsInput\"]");
    public By state=By.xpath("//div/div[@id=\"state\"]");
    public By city=By.xpath("//div/div/div[@class=\" css-1wa3eu0-placeholder\"]");
    public By clickState=By.xpath("//div[@class=\" css-11unzgr\"] //div[@id=\"react-select-3-option-2\"]");
    public By clickCity=By.xpath("//div[@class=\" css-11unzgr\"] //div[@id=\"react-select-4-option-1\"]");
    public By button = By.id("submit");

    public RegistrationPage(WebDriver d) {
        driver = d;

    }

}

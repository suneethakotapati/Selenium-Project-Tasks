package com.persistent.register.ui.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.persistent.register.common.SeleniumWaits.timeout;

public class SeleniumMethods extends BasePage {
    /**
     * This method will used to send-data to textboxes,dropdowns.
     * @param by
     * @param text
     */
    public void sendKeys(By by, String text) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        Assert.assertEquals(true, element.isEnabled());
        Assert.assertTrue(true, "Assert passed");
    }

    /**
     * This method will used to Send data to dropdowns
     * @param by
     * @param data
     */

    public void sendData(By by, String data) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        //js.executeScript("arguments[0].click();", element);
        WebElement from = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", from);
       //js.executeScript("arguments[0].click();", from);
        from.sendKeys(data);
        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);
    }

    /**
     * This method will used to Click textboxes, radio buttons and checkboxes
     *
     * @param by
     */
    public void clickBox(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).click();
    }

    /**
     * This method will used to Click textboxes
     *
     * @param by
     */
    public void click(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].click();", element);
        Assert.assertEquals(true, element.isSelected());
        System.out.println("Assert Passed");
    }

    /**
     * This method will used to Submitting the form
     * @param b1
     */
    public void submit(By b1) {
        timeout();
        driver.findElement(b1).submit();
    }


    /**
     * This method will used to Selecting the data from dropdown using visible text
     * @param by
     * @param text
     */
    public void dropdown(By by, String text) {
        WebElement drop = driver.findElement(by);
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText(text);
        WebElement selectedText = dropdown.getFirstSelectedOption();
        System.out.println("selected text is : " + selectedText.getText());
    }

    /**
     * Screenshot
     */
    public void screenshot() {
        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Suneetha.Kotapati\\OneDrive - Vertex, Inc\\Documents\\API_UI_Demo\\src\\test\\java\\com\\persistent\\register\\ui\\screenshots\\testFailure4.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * This method will used to Get the text from popup
     * @param b2
     */
    public void popUp(By b2) {
        timeout();
        WebElement element = driver.findElement(b2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "Thanks for submitting the form");
        System.out.println("Assertion for Ui is Passed");

    }

    /**
     * This method is used to get the day from the calender
     * @param by
     * @param text
     */
    public void day(By by,String text){
        String date=text;
        List<WebElement> allDates=driver.findElements(by);
        for(WebElement ele :allDates){
            String dt=ele.getText();
            if(dt.equals(date)){
                ele.click();
                break;

            }

        }


    }

    /**
     * This method is used to send text to dropdwons
     * @param by
     * @param text
     */
    public void sendTextToDropdown(By by, String text){
        driver.findElement(by).sendKeys(text);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();

    }

}





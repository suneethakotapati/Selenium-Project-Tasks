package com.persistent.ui.api.ui.base;

import com.beust.ah.A;
import org.openqa.selenium.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * This class is used to pause the execution of the test until certain conditions are met
 */
public class SeleniumMethods extends SeleniumWaits {
    /**
     * This method is used to interact with web elements on a web page, such as clicking on buttons, links, checkboxes, and radio buttons
     *
     * @param click used to locate elements on a web page
     */
    public void click(By click) {
        WebElement element = driver.findElement(click);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void scrollDown(By continueButton) {
        WebElement element = driver.findElement(continueButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollUp(By continueButton) {
        WebElement element = driver.findElement(continueButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)");
        //js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        element.isSelected();
        //element.isEnabled();
        //element.isDisplayed();
    }


    /**
     * This method is used to interact with text-based elements on a web page
     *
     * @param textBox used to locate elements on a web page
     * @param text    sending text to text boxes
     */
    public void sendKeys(By textBox, String text) {
        WebElement element = driver.findElement(textBox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysForTextBox(By textBox, String text) {
        WebElement element = driver.findElement(textBox);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Wraps a WebElement with functionality to select options from a drop-down.
     *
     * @param dropdown        used to locate elements on a web page
     * @param textForDropdown the text to match
     */
    public void selectFromDropdown(By dropdown, String textForDropdown) {
        WebElement element = driver.findElement(dropdown);
        Select select = new Select(element);
        select.selectByVisibleText(textForDropdown);
    }

    public void elementToHover(By hoverElement) {
        WebElement elementToHover = driver.findElement(hoverElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToHover);
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
    }

    public void sendPassword(By password, String text) {
        List<WebElement> elements = driver.findElements(password);
        System.out.println(elements.size());
        for (WebElement element : elements) {
            element.sendKeys(text);

        }

    }

    public void clickRadioButton(By locator, String data) {
        List<WebElement> elements = driver.findElements(locator);
        System.out.println(elements.size());
        for (WebElement element : elements) {
            String radioButton = element.getAttribute("id");
            if (radioButton.equals(data)) {
                element.click();
            }
        }

    }

    public String getTextFromUi(By locator) {
        // waitForPresentElement(locator);
        // waitForVisibilityElement(locator);
        WebElement element = driver.findElement(locator);
        if (element.isDisplayed() == false) {
            element = driver.findElement(locator);
        }
        String confirmationText = element.getText();
        System.out.println(confirmationText);
        return confirmationText;
    }


    public String splitText(By split) {
        WebElement element = driver.findElement(split);
        String text = element.getText();
        String[] substring = text.split(" ");
        return substring[3];
    }

    public float convertToFloat(String strCurrency) {
        strCurrency = strCurrency.replace("$", "");
        return Float.parseFloat(strCurrency);
    }

    public void savingPdfInvoices(By printBtn, By dropdown, String text, By saveBtn, By fileName, String fileNameTextBox, By saveAsBtn) {
        //Click on the print button
        WebElement printButton = driver.findElement(printBtn);
        printButton.click();

//Simulate keyboard shortcut to open print dialog box
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("p").keyUp(Keys.CONTROL).build().perform();
        // actions.keyUp

//Select "Save as PDF" option from "Destination" drop-down menu
        // WebElement destinationDropdown = driver.findElement(dropdown);
        // Select select = new Select(destinationDropdown);
        //  select.selectByVisibleText(text);
        // actions.keyUp(Keys.)
        // Locate the dropdown element
        WebElement dropDown = driver.findElement(dropdown);

// Create an instance of Actions class
        // Actions actions = new Actions(driver);

// Move to the dropdown element
        actions.moveToElement(dropDown).perform();

// Instantiate a Select class to interact with the dropdown
        Select select = new Select(dropDown);

// Select an option by visible text
        select.selectByVisibleText(text);

//Click on the "Save" button in the print dialog box
        WebElement saveButton = driver.findElement(saveBtn);
        saveButton.click();
//filename creation with date time
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String date = myDateObj.format(myFormatObj);
        String filePath = fileNameTextBox + date;
//Enter file name and location in "Save As" dialog box and save the PDF file
        WebElement filenameTextBox = driver.findElement(fileName);
        filenameTextBox.sendKeys(filePath);

        WebElement saveAsButton = driver.findElement(saveAsBtn);
        saveAsButton.click();
    }

    public void findCreateNewAddressButton(By newAddressButton) {
        WebElement element = driver.findElement(newAddressButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)");
    }

    /* public void windowHandles(By printButton,By select,String text,By saveButton){
         String parentHandle=driver.getWindowHandle();
         System.out.println("parent window - "+parentHandle);


         Set<String> handles=driver.getWindowHandles();
         for(String handle:handles){
             System.out.println(handle);
             if(!handle.equals(parentHandle)){
                 driver.switchTo().window(handle);
                 waitForPresentElement(select);
                 WebElement ele= driver.findElement(select);
                 Select sel=new Select(ele);
                 sel.selectByVisibleText(text);
                 WebElement save=driver.findElement(saveButton);
                 save.click();


             }*/
    public void windowHandles(By printButton, By select, String text, By saveButton) {
        WebElement element = driver.findElement(printButton);
        element.click();
        // driver.switchTo().alert()
        waitForVisibilityElement(select);
        waitForPresentElement(select);
        WebElement ele = driver.findElement(select);
        Select sel = new Select(ele);
        sel.selectByVisibleText(text);
        WebElement save = driver.findElement(saveButton);
        save.click();


    }

    public void email() {

    }

    public void handlingWindows(By printButton) {
        WebElement element = driver.findElement(printButton);
        element.click();
        //waitForVisibilityElement(printWindow);
        String parentHandle = driver.getWindowHandle();
        System.out.println("the parent window handle is : " + parentHandle);
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            System.out.println("handles are " + handle);
        }
    }

    public void download(By downloadButton, By iframe) throws InterruptedException {
        WebElement element = driver.findElement(downloadButton);
        element.click();
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(iframe);
        driver.switchTo().frame(element1);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).perform();
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys(Keys.ENTER).perform();
       // WebElement ele = driver.findElement(select);
       // Select sel = new Select(ele);
        //sel.selectByVisibleText(text);
       // WebElement save = driver.findElement(saveButton);
        //save.click();
    }

    //element.click();
    // Find the iframe element);

// Switch to the iframe
    //driver.switchTo().frame(iframeElement);

// Perform any actions inside the iframe
       /* WebElement ele = driver.findElement(select);
        Select sel = new Select(ele);
        sel.selectByVisibleText(text);
        WebElement save = driver.findElement(saveButton);
        save.click();*/

// Switch back to the main window
    //driver.switchTo().defaultContent();

    // driver.switchTo().alert();
    // driver.switchTo().frame(0);
    // Robot robot = new Robot();
    // robot.keyPress(KeyEvent.VK_UP);
    // robot.keyPress(KeyEvent.VK_ENTER);
    // robot.keyPress(KeyEvent.VK_ENTER);

    // Actions action = new Actions(driver);
//        WebElement ele = driver.findElement(select);
//        Select sel = new Select(ele);
//        sel.selectByVisibleText(text);
//        WebElement save = driver.findElement(saveButton);
//        save.click();
    //Thread.sleep(5000);

    // action.sendKeys(Keys.PAGE_UP).perform();
    //  action.sendKeys(Keys.ENTER).perform();
    // action.sendKeys(Keys.ENTER).perform();
}





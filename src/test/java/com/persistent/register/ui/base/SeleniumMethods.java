package com.persistent.register.ui.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static com.persistent.register.common.SeleniumWaits.timeout;

public class SeleniumMethods extends BasePage {

    public void sendKeysMethod(By by, String text) {
        timeout();
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void send(By by, String data)  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        WebElement from = driver.findElement(by);
        from.sendKeys(data);
        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);
    }

    public void clickMethod(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(by).click();
    }

    public void clickDropdown(By by) {
        timeout();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].click();", element);
    }

    public void submitMethod(By by) {
        timeout();
        driver.findElement(by).submit();
    }

    public void selectByVis(By by, String text) {
        WebElement drop = driver.findElement(by);
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText(text);
        WebElement selectedText = dropdown.getFirstSelectedOption();
        System.out.println("selected text is : " + selectedText.getText());
    }
}





package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class J2StoreMyAccountPage extends SeleniumMethods {
    WebDriver driver;
    public J2StoreMyAccountPage(WebDriver driver){
        this.driver=driver;

    }
    private By printAction= By.xpath("//span[@class='fa fa-print']");
   // private By destinationDropdown=By.xpath("//select[@id='destination']");
    private By destinationDropdown=By.xpath("//button[@id='selecttrigger-1']");
    private By saveButton=By.xpath("//button//span[contains(text(),'Save')]");
    private By filename=By.xpath("By.xpath(//input[@id='filename']");
    private By saveAsButton=By.xpath("//button[@id='saveAsButton']");
    private By iframePopup=By.xpath("//span[@class='j2store-order-print']");
    /*public void setWindowHandles(String selectText){
        windowHandles(printAction,destinationDropdown,selectText,saveButton);
    }*/


   /* public void clickPrintAction(){
        waitForPresentElement(printAction);
        click(printAction);
    }*/
    /*public void invoicesPdf(String dropdownText,String filenameLocation){
        savingPdfInvoices(printAction,destinationDropdown,dropdownText,saveButton,filename,filenameLocation,saveAsButton);
    }*/
    public void setWindowHandles(String selectText){
        windowHandles(printAction,destinationDropdown,selectText,saveButton);

    }
    //Rafi's code below
    public void test1() throws InterruptedException{

        download(printAction,iframePopup);
    }
}

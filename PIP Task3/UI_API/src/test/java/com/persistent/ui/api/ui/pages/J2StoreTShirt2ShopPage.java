package com.persistent.ui.api.ui.pages;

import com.persistent.ui.api.ui.base.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class J2StoreTShirt2ShopPage extends SeleniumMethods {
    WebDriver driver;
    private By quantityBox = By.xpath("//div[@id='add-to-cart-57']//input[@name='product_qty']");
    private By addToCart = By.xpath("//div[@id='add-to-cart-57']//input[@value='Add to cart']");
    private By items = By.xpath("//div[@class='j2store-cart-info-link']");
    private By checkoutButton = By.xpath("//a[@class='btn btn-success btn-large']");
    private By subTotal = By.xpath("//div[@class='j2store-cart-info-link']//span");
    private By successMessage = By.xpath("//form[@id='j2store-addtocart-form-57']//p[@class='text-success']");

    public J2StoreTShirt2ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setQuantityBox(String quantity) {
        sendKeys(quantityBox, quantity);
    }

    public void clickAddToCartButton() {
        waitForPresentElement(addToCart);
        click(addToCart);
    }

    public void mouseOver() {
        waitForPresentElement(items);
        waitForVisibilityElement(items);
        elementToHover(items);
    }

    public void clickCheckoutButton() {
        waitForVisibilityElement(successMessage);
        waitForPresentElement(checkoutButton);
        waitForVisibilityElement(checkoutButton);
        click(checkoutButton);
    }

    public float getTextFromSubTotal() {
        waitForPresentElement(subTotal);
        waitForVisibilityElement(subTotal);
        String subtotal = splitText(subTotal);
        return convertToFloat(subtotal);
    }
}

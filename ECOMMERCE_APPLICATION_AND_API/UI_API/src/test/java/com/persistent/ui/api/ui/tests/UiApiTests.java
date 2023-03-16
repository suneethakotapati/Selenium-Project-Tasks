package com.persistent.ui.api.ui.tests;

import com.persistent.ui.api.api.pages.*;
import com.persistent.ui.api.common.enums.DataFile;
import com.persistent.ui.api.ui.base.SeleniumMethods;
import com.persistent.ui.api.ui.pages.*;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;


public class UiApiTests extends SeleniumMethods {
    String authToken;
    WebDriver driver;
    J2StoreProductsPage j2StoreProductsPage;
    J2StoreTShirt2ShopPage j2StoreTShirt2ShopPage;
    J2StoreCheckoutPage j2StoreCheckoutPage;
    J2StoreAccountAndBillingDetailsPage j2StoreAccountAndBillingDetailsPage;
    J2StoreCreateNewAddressPage j2StoreCreateNewAddressPage;
    J2StoreShippingAddressPage j2StoreShippingAddressPage;
    J2StorePaymentPage j2StorePaymentPage;
    J2StoreConfirmOrderPage j2StoreConfirmOrderPage;
    J2StoreCheckoutResultsPage j2StoreCheckoutResultsPage;
    J2StoreMyAccountPage j2StoreMyAccountPage;


    CreateBookingPage createBookingPage;
    CreateTokenPage createTokenPage;
    DeleteBookingPage deleteBookingPage;
    GetBookingIdsPage getBookingIdsPage;
    GetBookingPage getBookingPage;
    HealthCheckPage healthCheckPage;
    PartialUpdateBookingPage partialUpdateBookingPage;
    UpdateBookingPage updateBookingPage;

    @Test
    public void creatingAnOrder() throws InterruptedException, AWTException {
        j2StoreProductsPage = new J2StoreProductsPage(driver);
        j2StoreTShirt2ShopPage = new J2StoreTShirt2ShopPage(driver);
        j2StoreCheckoutPage = new J2StoreCheckoutPage(driver);
        j2StoreAccountAndBillingDetailsPage = new J2StoreAccountAndBillingDetailsPage(driver);
        j2StoreCreateNewAddressPage = new J2StoreCreateNewAddressPage(driver);
        j2StoreShippingAddressPage = new J2StoreShippingAddressPage(driver);
        j2StorePaymentPage = new J2StorePaymentPage(driver);
        j2StoreConfirmOrderPage = new J2StoreConfirmOrderPage(driver);
        j2StoreCheckoutResultsPage = new J2StoreCheckoutResultsPage(driver);
        j2StoreMyAccountPage = new J2StoreMyAccountPage(driver);
        j2StoreProductsPage.clickTShirt();
        j2StoreTShirt2ShopPage.setQuantityBox(DataFile.QUANTITY.data);
        j2StoreTShirt2ShopPage.clickAddToCartButton();
        j2StoreTShirt2ShopPage.mouseOver();
        float actualSubtotal = j2StoreTShirt2ShopPage.getTextFromSubTotal();
        System.out.println(actualSubtotal);
        j2StoreTShirt2ShopPage.clickCheckoutButton();
        j2StoreCheckoutPage.clickRegisterAccountContinueButton();
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsFirstName(DataFile.BILLING_DETAILS_FIRSTNAME.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsLastName(DataFile.BILLING_DETAILS_LASTNAME.data);
        //j2StoreAccountAndBillingDetailsPage.setBillingDetailsEmail(DataFile.BILLING_DETAILS_EMAIL.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsEmail();
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsPhoneNumber(DataFile.BILLING_DETAILS_PHONE.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsMobileNumber(DataFile.BILLING_DETAILS_MOBILE.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsPassword(DataFile.BILLING_DETAILS_PASSWORD.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsPassword(DataFile.BILLING_DETAILS_CONFIRM_PASSWORD.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsCompany(DataFile.BILLING_DETAILS_COMPANY.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsAddressLine(DataFile.BILLING_DETAILS_ADDRESS_LINE.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsCity(DataFile.BILLING_DETAILS_CITY.data);
        j2StoreAccountAndBillingDetailsPage.setBillingDetailsPostalCode(DataFile.BILLING_DETAILS_POSTCODE.data);
        j2StoreAccountAndBillingDetailsPage.selectBillingDetailsCountry(DataFile.COUNTRY.data);
        j2StoreAccountAndBillingDetailsPage.selectBillingDetailsZone(DataFile.ZONE.data);
        j2StoreAccountAndBillingDetailsPage.clickBillingDetailsCheckBox();
        j2StoreAccountAndBillingDetailsPage.clickBillingDetailsRegisterButton();
        j2StoreCreateNewAddressPage.clickCreateNewAddressRadioButton();
        j2StoreShippingAddressPage.setShippingAddressFirstName(DataFile.SHIPPING_ADDRESS_FIRST_NAME.data);
        j2StoreShippingAddressPage.setShippingAddressLastName(DataFile.SHIPPING_ADDRESS_LAST_NAME.data);
        j2StoreShippingAddressPage.setShippingAddressMobileNumber(DataFile.SHIPPING_ADDRESS_MOBILE_NUMBER.data);
        j2StoreShippingAddressPage.setShippingAddressLine1(DataFile.SHIPPING_ADDRESS_LINE1.data);
        j2StoreShippingAddressPage.setShippingAddressCity(DataFile.SHIPPING_ADDRESS_CITY.data);
        j2StoreShippingAddressPage.setShippingAddressPostalCode(DataFile.SHIPPING_ADDRESS_POSTAL_CODE.data);
        j2StoreShippingAddressPage.selectShippingAddressCountry(DataFile.COUNTRY.data);
        j2StoreShippingAddressPage.selectShippingAddressZone(DataFile.ZONE.data);
        j2StoreShippingAddressPage.clickShippingAddressContinueButton();
        j2StorePaymentPage.clickCashOnDeliveryRadioButton();
        j2StorePaymentPage.setCustomerNoteBox(DataFile.CUSTOMER_NOTE_BOX.data);
        j2StorePaymentPage.clickPaymentPageContinueButton();
        //float expectedSubtotal = j2StoreConfirmOrderPage.getSubtotalFromUi();
        //System.out.println(expectedSubtotal);
        //Assert.assertEquals(actualSubtotal,expectedSubtotal,"Subtotal Not equal");
        //float total = j2StoreConfirmOrderPage.getTotalFromUi();
        // System.out.println(total);
        // Assert.assertEquals(actualSubtotal,total);
        j2StoreConfirmOrderPage.clickCashSubmitButton();
        j2StoreCheckoutResultsPage.clickGoToOrderHistoryLink();
        //  j2StoreMyAccountPage.setWindowHandles(DataFile.DESTINATION_DROPDOWN_TEXT.data);
        j2StoreMyAccountPage.test1();
        // Thread.sleep(10000);
        // j2StoreMyAccountPage.invoicesPdf(DataFile.DESTINATION_DROPDOWN_TEXT.data,DataFile.INVOICES_PDF_FOLDER_PATH.data);
    }

    @Test
    public void getBookingIdsTest() {
        getBookingIdsPage=new GetBookingIdsPage();
        Response response = getBookingIdsPage.getBookingIds(DataFile.BOOKING_ENDPOINT.data);
        int responseCode = getBookingIdsPage.getStatusCode(response);
        System.out.println("Actual response code : "+ responseCode);
        Assert.assertEquals(responseCode,DataFile.SUCCESS_STATUS_CODE.data);
        String responseBody = getBookingIdsPage.getStatusBody(response);
        System.out.println("Actual response body : "+ responseBody);
        Assert.assertFalse(responseBody.isEmpty(),"Response body was empty");
    }
    @Test
    public void getBookingTest() {
        getBookingPage=new GetBookingPage();
        Response response = getBookingPage.getBooking(DataFile.BOOKING_ENDPOINT.data,DataFile.BOOKING_ID.data);
        int responseCode = getBookingPage.getStatusCode(response);
        System.out.println("Actual response code : "+ responseCode);
        Assert.assertEquals(responseCode,Integer.parseInt(DataFile.SUCCESS_STATUS_CODE.data));
        String responseBody = getBookingPage.getStatusBody(response);
        System.out.println("Actual response body : "+ responseBody);
        Assert.assertFalse(responseBody.isEmpty(),"Response body was empty");
    }
    @Test
    public void createBookingTest(){
        createBookingPage=new CreateBookingPage();
        Response response = createBookingPage.createBooking(DataFile.BOOKING_ENDPOINT.data);
        int responseCode = createBookingPage.getStatusCode(response);
        System.out.println("Actual response code : "+ responseCode);
        Assert.assertEquals(responseCode,Integer.parseInt(DataFile.SUCCESS_STATUS_CODE.data));
        String responseBody = createBookingPage.getStatusBody(response);
        System.out.println("Actual response body : "+ responseBody);
        Assert.assertFalse(responseBody.isEmpty(),"Response body was empty");

    }

    @Test
    public void getTokenTest(ITestContext context){
        createTokenPage=new CreateTokenPage();
        Response response = createTokenPage.createToken(DataFile.AUTH_ENDPOINT.data);
        int responseCode = createTokenPage.getStatusCode(response);
        System.out.println("Actual response code : "+ responseCode);
        Assert.assertEquals(responseCode,Integer.parseInt(DataFile.SUCCESS_STATUS_CODE.data));
        String responseBody = createTokenPage.getStatusBody(response);
       // String token = response.jsonPath().getString("token");
        //context.setAttribute("token", token);
       context.setAttribute("token",responseBody);
        authToken = responseBody;
       // authToken=token;
        System.out.println("context token is : " + (String) context.getAttribute("token"));
        System.out.println("Actual response body : "+ responseBody);
        Assert.assertFalse(responseBody.isEmpty(),"Response body was empty");
    }
    @Test
    public void updateBookingTest(ITestContext context){
        updateBookingPage=new UpdateBookingPage();
        System.out.println(context.getAttribute("token").toString());
        Response response = updateBookingPage.updateBooking(DataFile.BOOKING_ENDPOINT.data,DataFile.BOOKING_ID.data, authToken);
        int responseCode = updateBookingPage.getStatusCode(response);
        System.out.println("Actual response code : "+ responseCode);
        Assert.assertEquals(responseCode,Integer.parseInt(DataFile.SUCCESS_STATUS_CODE.data));
        String responseBody = updateBookingPage.getStatusBody(response);
        System.out.println("Actual response body : "+ responseBody);
        Assert.assertFalse(responseBody.isEmpty(),"Response body was empty");
    }


}

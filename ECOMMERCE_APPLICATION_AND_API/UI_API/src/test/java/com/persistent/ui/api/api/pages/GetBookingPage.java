package com.persistent.ui.api.api.pages;


import com.persistent.ui.api.api.base.Methods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.crypto.Mac;

public class GetBookingPage extends Methods {
    public Response getBooking(String endPoint,String bookingId) {
        String path = baseUrl + endPoint+bookingId;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.get(path);
        return response;

    }
    public int getStatusCode(Response response){
        return returnResponseCode(response);
    }
    public String getStatusBody(Response response){
        return returnResponseBody(response);
    }


    }


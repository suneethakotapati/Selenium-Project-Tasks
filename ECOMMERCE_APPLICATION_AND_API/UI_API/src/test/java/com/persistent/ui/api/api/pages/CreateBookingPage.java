package com.persistent.ui.api.api.pages;

import com.persistent.ui.api.api.base.Methods;
import com.persistent.ui.api.common.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class CreateBookingPage extends Methods {
    public Response createBooking(String endPoint) {
        String path = baseUrl + endPoint;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = createBookingBody(DataFile.FIRSTNAME.data, DataFile.LASTNAME.data, Integer.parseInt(DataFile.TOTAL_PRICE.data), Boolean.parseBoolean(DataFile.DEPOSIT_PAID.data), DataFile.CHECK_IN.data, DataFile.CHECK_OUT.data, DataFile.ADDITIONAL_NEEDS.data);
        System.out.println("JSON created is : " + json.toJSONString());
        HTTPRequest.header("Content-Type", "application/json");
        HTTPRequest.body(json);
        Response response = HTTPRequest.post(path);
        return response;
    }

    public int getStatusCode(Response response) {
        return returnResponseCode(response);
    }

    public String getStatusBody(Response response) {
        return returnResponseBody(response);
    }

}


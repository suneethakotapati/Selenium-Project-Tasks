package com.persistent.ui.api.api.pages;


import com.persistent.ui.api.api.base.BaseMethods;
import com.persistent.ui.api.api.base.Methods;
import com.persistent.ui.api.common.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetBookingIdsPage extends Methods {


    public Response getBookingIds(String endPoint) {
        String path = baseUrl + endPoint;
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






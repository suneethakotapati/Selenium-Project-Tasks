package com.persistent.ui.api.api.pages;


import com.persistent.ui.api.api.base.Methods;
import com.persistent.ui.api.common.enums.DataFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class CreateTokenPage  extends Methods {
    public Response createToken(String endPoint){
        String path = baseUrl + endPoint;
        RestAssured.baseURI = path;
        RequestSpecification HTTPRequest = RestAssured.given();
        JSONObject json = createTokenBody(DataFile.USERNAME.data, DataFile.PASSWORD.data);
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
        String token =  returnResponseBody(response);
        token = token.replace("{","");
        token = token.replace("}","");
        return token;
    }

    }




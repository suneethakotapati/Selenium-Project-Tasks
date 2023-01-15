package com.persistent.register.api.enums;

import com.persistent.register.api.base.Methods;
import org.json.simple.JSONObject;

public class Data extends Methods {
    public void createEmployee(String name, String salary, String age) {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("salary", salary);
        json.put("age", age);
    }
}

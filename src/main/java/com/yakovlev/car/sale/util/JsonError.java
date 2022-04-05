package com.yakovlev.car.sale.util;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonError {
    public JSONObject getError(String scope, String message) throws JSONException {
        JSONObject error = new JSONObject();
        error.put("scope", scope);
        error.put("message", message);
        return error;
    }
}

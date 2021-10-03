package com.learn.utils;
import com.google.gson.Gson;

import java.io.IOException;

public class JsonUtil {
    static Gson gson = new Gson();
    public static Object getObject(String json) {
        try {
            return gson.fromJson(json, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

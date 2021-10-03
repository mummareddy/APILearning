package com.learn.utils;

import com.learn.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonServerAPIUtil {
    static {
        RestAssured.baseURI = Constants.jsonServerEndPoint;
    }
    public Response postCall(Object file){
        return given().log().all().header("Content-Type", "application/json").body(file).post("/posts");
    }

    public Response getCall(int id){
        return given().log().all().get("/posts" + "/" +id);
    }

    public Response patchCall(Object obj, int id){
        return given().log().all().header("Content-Type", "application/json").body(obj).patch("/posts" + "/" +id);
    }

    public Response put(Object obj, int id){
        return given().log().all().header("Content-Type", "application/json").body(obj).put("/posts" + "/" +id);
    }
    public Response delete(int id){
        return given().log().all().delete("/posts" + "/" +id);
    }
}

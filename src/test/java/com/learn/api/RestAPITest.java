package com.learn.api;

import com.learn.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class RestAPITest {
    @BeforeClass
    public static void init() {
        baseURI = Constants.dogEndPoint;
    }
    @Test
    public void testDocUrl() throws Exception{
        Response response = given().log().all().get("random");
        assertEquals(response.getStatusCode(), 200, "api giving error response");
        assertEquals(response.jsonPath().get("status"), "success", "status messsage wrong");
    }
}

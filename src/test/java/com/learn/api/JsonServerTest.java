package com.learn.api;

import com.learn.utils.JsonServerAPIUtil;
import com.learn.utils.JsonUtil;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//Setup the open source json server to run this tests
//https://github.com/typicode/json-server

public class JsonServerTest {
    private String payload;
    private JsonServerAPIUtil apiUtil;

    @BeforeTest
    public void init(){
        payload = "{ \"title\": \"api-test\", \"author\": \"mahesh\" }";
        apiUtil = new JsonServerAPIUtil();
    }

    @Test
    public void testPost() throws Exception{
        Response response = apiUtil.postCall(JsonUtil.getObject(payload));
        assertEquals(response.getStatusCode(), 201, "post call failed");
    }

    @Test
    public void testGet() throws Exception{
        Response response =apiUtil.postCall(JsonUtil.getObject(payload));
        assertEquals(response.getStatusCode(), 201, "post call failed");
        int id = (Integer) response.jsonPath().get("id");
        response = apiUtil.getCall(id);
        assertEquals(response.getStatusCode(), 200, "get call failed");
        String author = (String) response.jsonPath().get("author");
        assertEquals(author, "mahesh", "author info wrong");
    }
    @Test
    public void testPut() throws Exception{
        Response response =apiUtil.postCall(JsonUtil.getObject(payload));
        assertEquals(response.getStatusCode(), 201, "post call failed");
        int id = (Integer) response.jsonPath().get("id");
        String putPayload = "{ \"title\": \"api-test-updated\", \"author\": \"mahesh\" }";
        response = apiUtil.put(JsonUtil.getObject(putPayload), id);
        assertEquals(response.getStatusCode(), 200, "put call failed");
        String title = (String) response.jsonPath().get("title");
        assertEquals(title, "api-test-updated", "title info wrong");
    }

    @Test
    public void testPatch() throws Exception{
        Response response =apiUtil.postCall(JsonUtil.getObject(payload));
        assertEquals(response.getStatusCode(), 201, "post call failed");
        int id = (Integer) response.jsonPath().get("id");
        String putPayload = "{ \"author\": \"madhu\" }";
        response = apiUtil.patchCall(JsonUtil.getObject(putPayload), id);
        assertEquals(response.getStatusCode(), 200, "patch call failed");
        String title = (String) response.jsonPath().get("author");
        assertEquals(title, "madhu", "author info wrong");
    }
    @Test
    public void testDelete() throws Exception{
        Response response =apiUtil.postCall(JsonUtil.getObject(payload));
        assertEquals(response.getStatusCode(), 201, "post call failed");
        int id = (Integer) response.jsonPath().get("id");
        response = apiUtil.delete(id);
        assertEquals(response.getStatusCode(), 200, "delete call failed");
        response = apiUtil.getCall(id);
        assertEquals(response.getStatusCode(), 404, "get call failed");
    }
}

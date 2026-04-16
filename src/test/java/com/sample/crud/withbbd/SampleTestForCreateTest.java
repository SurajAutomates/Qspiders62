package com.sample.crud.withbbd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class SampleTestForCreateTest {
	@Test
	public void postDataToServer() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Brahma");
		jsonObject.put("status", "Created");
		jsonObject.put("teamSize", 0);
		jsonObject.put("projectName", "lemon_124");
		
		
//		RequestSpecification req = RestAssured.given();
//		req.contentType(ContentType.JSON);
//		req.body(jsonObject.toJSONString());
//		
//		Response response = req.post("http://49.249.28.218:8091/addProject");
//		response.then().log().all();
//		response.then().assertThat().statusCode(201);
		
		given().contentType(ContentType.JSON).body(jsonObject.toJSONString()).when()
		.post("http://49.249.28.218:8091/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}

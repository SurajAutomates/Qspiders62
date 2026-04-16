package com.sample.crud.withbbd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPartialUpdateTest {
	@Test
	public void patchDataToServer() {
		JSONObject json_obj = new JSONObject();
		json_obj.put("projectName", "Tek2222");
		
//		RequestSpecification request = RestAssured.given();
//		request.contentType(ContentType.JSON);
//		request.body(json_obj.toJSONString());
//		
//		Response response = request.patch("http://49.249.28.218:8091/project/NH_PROJ_220");
//		response.then().log().all();
//		response.then().assertThat().statusCode(200);
		
		given().contentType(ContentType.JSON)
		.body(json_obj.toJSONString())
		.patch("http://49.249.28.218:8091/project/NH_PROJ_220")
		.then().assertThat().statusCode(200).log().all();
		
		
	}
}

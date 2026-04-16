package com.sample.crud.withbbd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForDeleteTest {
	@Test
	public void deleteFromServer() {
//		RequestSpecification request = RestAssured.given();
//		request.contentType(ContentType.JSON);
//		Response response = request.delete("http://49.249.28.218:8091/project/NH_PROJ_220");
//		response.then().and().log().all();
//		response.then().assertThat().statusCode(204);
//		
		
		given().contentType(ContentType.JSON)
		.delete("http://49.249.28.218:8091/project/NH_PROJ_230")
		.then().assertThat().statusCode(204).log().all();
		
	}
}

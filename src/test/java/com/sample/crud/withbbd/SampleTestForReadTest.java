package com.sample.crud.withbbd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForReadTest {
	@Test
	public void getDataFromServer() {
		given().contentType(ContentType.JSON).when().
		get("http://49.249.28.218:8091/projects").then().assertThat().statusCode(200).log().all();
	}
}

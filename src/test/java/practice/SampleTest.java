package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
	@Test
	public void sampleGetReqTest() {
		Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/9223372036854775807");
		System.out.println(response.prettyPrint());
	}
}

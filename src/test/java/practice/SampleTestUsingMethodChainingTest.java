package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChainingTest {
	@Test
	public void getRequestTest() {
		get("https://petstore.swagger.io/v2/pet/9223372036854775807").then().log().all();
		
	}
}

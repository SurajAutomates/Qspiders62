package practice.responseValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyRespHeaderTest {
	@Test
	public void verifyHeader() {
		Response response = given().get("http://49.249.28.218:8091/projects");
		response.then().log().all();

		response.then().assertThat().statusCode(200);

		response.then().assertThat().statusLine("HTTP/1.1 200 ");

		response.then().assertThat().header("Transfer-Encoding", "chunked");

	}
}

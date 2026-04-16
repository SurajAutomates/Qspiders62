package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Scenario_3_GetPayrollViaAuth {
	@Test
	public void loginAndGetPayroll() {
		// login
		Response login_response = given().formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials").when()
				.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		login_response.then().log().all();

		String token = login_response.jsonPath().get("access_token");
		System.out.println(token);
		given().header("Authorization", "Bearer" + token).get("http://49.249.28.218:8091/admin/payrolls").then().log()
				.all();

	}
}

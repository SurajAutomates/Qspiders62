package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyRespTimeTest {
	@Test
	public void verifyHeader() {
		Response response = given().get("http://49.249.28.218:8091/projects");
		response.then().log().all();
		long timetaken = response.time();
		long timeInSec = response.timeIn(TimeUnit.SECONDS);

		System.out.println(timetaken);
		System.out.println(timeInSec);

		response.then().assertThat().time(Matchers.lessThan(900l));

		response.then().assertThat().time(Matchers.greaterThan(200l));

		response.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(200l)));

	}
}

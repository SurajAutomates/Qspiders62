package practice.responseValidation;

import static io.restassured.RestAssured.given;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class ToGetAllProjectId_UsingJsonXpath {

	@Test
	public void verifyBody() {
		Response response = given().get("http://49.249.28.218:8091/projects-paginated");
		response.then().log().all();

		List<Object> projectIds = JsonPath.read(response.asString(), "content[*].projectId");

		for (Object obj : projectIds) {
			System.out.println(obj);
		}
	}
}

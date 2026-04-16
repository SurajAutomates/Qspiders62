package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utility.FileUtility;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class VerifyRespBody_Using_JsonPath {
	FileUtility file_lib = new FileUtility();
	@Test
	public void verifyBody() throws IOException {
		String baseURI = file_lib.getDataFromPropertyFile("BaseURI");
		
		Response response = given().get(baseURI+"/projects-paginated");
		response.then().log().all();

		Object numberOfProject = response.jsonPath().get("numberOfElements");
		System.out.println(numberOfProject);

		Object sortedValue = response.jsonPath().get("pageable.sort.sorted");
		System.out.println(sortedValue);

		Object projectId1 = response.jsonPath().get("content[0].projectId");
		System.out.println(projectId1);

		response.then().assertThat().body("numberOfElements", Matchers.equalTo(numberOfProject));

		response.then().assertThat().body("pageable.sort.sorted", Matchers.equalTo(sortedValue));

		response.then().assertThat().body("content[0].projectId", Matchers.equalTo(projectId1));

	}
}

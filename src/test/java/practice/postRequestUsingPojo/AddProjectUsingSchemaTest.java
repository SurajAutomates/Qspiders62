package practice.postRequestUsingPojo;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import pojoClass.utility.AddProjectPojo;


public class AddProjectUsingSchemaTest {
	@Test
	public void postDataToServer() {
		Random random = new Random();
		int randomNum = random.nextInt(5000);
		AddProjectPojo addProjectPojo = new AddProjectPojo("Kaustubh", "KP_" + randomNum, "Created", 0);

		Response response = given().contentType(ContentType.JSON).body(addProjectPojo).when().post("http://49.249.28.218:8091/addProject");
				response.then().assertThat().statusCode(201).log().all();
				response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema.json")));

	}
}

package practice.postRequestUsingPojo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoClass.utility.AddProjectPojo;

public class AddProjectTest {
	@Test
	public void postDataToServer() {
		Random random = new Random();
		int randomNum = random.nextInt(5000);
		AddProjectPojo addProjectPojo = new AddProjectPojo("Kaustubh", "KP_" + randomNum, "Created", 0);

		given().contentType(ContentType.JSON).body(addProjectPojo).when().post("http://49.249.28.218:8091/addProject")
				.then().assertThat().statusCode(201).log().all();

	}
}

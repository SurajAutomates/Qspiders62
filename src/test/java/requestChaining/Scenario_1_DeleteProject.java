package requestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoClass.utility.AddProjectPojo;

public class Scenario_1_DeleteProject {
//	Create an project via API1 and delete the same project via API2
	@Test
	public void createThenDeleteSameProjectTest() {
		// create a project
		Random randrom = new Random();
		int randomNum = randrom.nextInt(3000);
		AddProjectPojo pojo_object = new AddProjectPojo("Brahma", "Boat_"+randomNum, "Created", 0);
		
		Response response = given().contentType(ContentType.JSON).body(pojo_object)
		.when().post("http://49.249.28.218:8091/addProject");
		
		response.then().log().all();
		Object projectId = response.jsonPath().get("projectId");
		System.out.println(projectId);
		
		// delete same project
		
		given().delete("http://49.249.28.218:8091/project/"+projectId).then()
		.assertThat().statusCode(204).log().all();
		
	}
}

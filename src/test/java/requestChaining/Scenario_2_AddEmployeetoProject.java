package requestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoClass.utility.AddProjectPojo;
import pojoClass.utility.CreateEmployeePojo;

public class Scenario_2_AddEmployeetoProject {
	@Test
	public void createProjectAndAddEmployee() {
		// create project
		Random random = new Random();
		int randomNum = random.nextInt(300);

		AddProjectPojo pojo_object = new AddProjectPojo("Brahma", "Boat_" + randomNum, "Created", 0);

		Response project_response = given().contentType(ContentType.JSON).body(pojo_object).when()
				.post("http://49.249.28.218:8091/addProject");
		project_response.then().log().all();
		String projectName = project_response.jsonPath().get("projectName");
		System.out.println(projectName);

		// add Employee
		CreateEmployeePojo emp_pojo_obj = new CreateEmployeePojo("developer", "16/10/1999", "xyz22@gmail.com",
				"Kaustubh" + randomNum, 2, "9191919191", projectName, "xyz", "xyz_xyz" + randomNum);

		Response emp_response = given().contentType(ContentType.JSON).body(emp_pojo_obj).when()
				.post("http://49.249.28.218:8091/employees");

		emp_response.then().assertThat().statusCode(201).log().all();
		
		System.out.println("hi");

	}
}

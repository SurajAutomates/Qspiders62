package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParamterTest {
	@Test
	public void sampleTest() {
		given().formParam("projectId", "NH_PROJ_610")
		.log().all()
		.when().post("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}

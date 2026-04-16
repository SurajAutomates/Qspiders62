package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParamParameterTest {
	@Test
	public void sampleTest() {
		// act like form parameter

		given().param("projectId", "NH_PROJ_610").log().all().when().post("http://49.249.28.218:8091/project").then()
				.log().all();

		// act like query parameter
		given().param("projectId", "NH_PROJ_610").log().all().when().get("http://49.249.28.218:8091/project").then()
				.log().all();

	}
}

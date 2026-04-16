package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class SampleTest1 {
	@Test
	public void uploadImage() {
		given().contentType(ContentType.JSON).body(new File("./src/test/resources/huoadg5888-pets-3715733_1920.jpg"))
			.when().post("https://petstore.swagger.io/v2/pet/9223372036854775807/uploadImage").then().log().all();
	}
	
	@Test
	public void createPet() {
		
	}
}

package DDT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import utility.Excel_utility;

public class AddMultipleProjectTest {
	@Test(dataProvider = "getData")
	public void addMultipleProjectTest(String projectName, String status) {

		String requestBody = "{\n" + "  \"createdBy\": \"string\",\r\n" + "  \"projectName\": \"" + projectName
				+ "\",\r\n" + "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 0\r\n" + "}";

		given().contentType(ContentType.JSON).body(requestBody).when().post("http://49.249.28.218:8091/addProject")
				.then().log().all();
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Excel_utility excel_lib = new Excel_utility();
		Object[][] obj = excel_lib.getDataFromMultipleColumns("restAssuredTestData");
		return obj;

	}
}

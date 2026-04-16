package practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

class PojoClass{
	private String email;
	private String password;	
	public PojoClass() {
		super();
	}
	public PojoClass(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

public class RahulShettyRegister {
	String baseURL = "https://api.eventhub.rahulshettyacademy.com/api";
	@Test
	public void register() {
		PojoClass pojo = new PojoClass("Kp@gmail.com", "Kp@12345");
		
		given().contentType(ContentType.JSON).body(pojo).when()
		.post(baseURL+"/auth/register")
		.then()
		.assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void login() {
		PojoClass pojo = new PojoClass("Kp@gmail.com", "Kp@12345");
		
		given().contentType(ContentType.JSON).body(pojo).when()
		.post(baseURL+"/auth/login")
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
}

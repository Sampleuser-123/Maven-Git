package com.wbl.restassured.RestAssuredPractice;


//<scope>compile</scope> from pom .xml for restassured dependency,otherwise error comes
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class RestAssuredExampleGet {
	//http://dummy.restapiexample.com/api/v1/employees
	
	@Test(enabled=false)
	public void statusCodeValidation()
	{
		given().
	when().
	//get("https://jsonplaceholder.typicode.com/posts").
	get("http://services.groupkt.com/country/get/iso2code/IN").
	then().assertThat().statusCode(200);
	}
	@Test(enabled=false)
	public void testidCheck()
	{
		given().
	when().
	get("http://services.groupkt.com/country/get/iso2code/IN").
	then().body("RestResponse.result.name",equalTo("India")).and().log().all();
	}
	@Test(enabled=false)
	public void headerCheckContent()
	{
		given().
	when().
	get("http://services.groupkt.com/country/get/iso2code/IN").
	then().assertThat().contentType(ContentType.JSON);
	}
	//then().assertThat().header("headerName", "headerValue")
	@Test(enabled=false)
	public void headerCheck()
	{
		given().
	when().
	get("http://services.groupkt.com/country/get/iso2code/IN").
	then().assertThat().header("Connection","Keep-Alive");
	}
	@Test
	public void extractValue()
	{   Response actualResponse=given().
		when().
		get("http://services.groupkt.com/country/get/all").then().extract().response();
		JsonPath jpath=actualResponse.jsonPath();
		String name=jpath.getString("RestResponse.result.name");
		System.out.println(name);
	}
	@Test
	public void dataProviders()
	{
		
	}
}

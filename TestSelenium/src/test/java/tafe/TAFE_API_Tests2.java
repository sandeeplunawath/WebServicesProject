package tafe;

import static io.restassured.RestAssured.given;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TAFE_API_Tests2 extends Suite_Base {


	@Test
	public void TestCase1() {
		
		calculateRequest.inputs.add(new Inputs(1,"tom","check"));
		calculateRequest.inputs.add(new Inputs(2,"ciai","check"));
		calculateRequest.inputs.add(new Inputs(3,"hary","check"));

		calculateRequest.inputs.get(0).tag = "20";
		System.out.println(calculateRequest.inputs.get(0).tag);
		
	}
	
	@Test
	public void TestCase2() {
	    String systemURI = "http://dummy.restapiexample.com/api/v1/employees";
		// @formatter:off
	   Response resp =  RestAssured
	        .given()
	            .accept(ContentType.JSON)
	        .when()
	            .get(systemURI)
	      ;
	   
	   resp.then().log().all();
	   
	   
	}

}

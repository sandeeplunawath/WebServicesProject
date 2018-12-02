package edu.universit.testselenium.TestSelenium;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Send_HTTP_Post_Request {

	private static final String USER_AGENT = "Mozilla/5.0";
	
	@Test
	public void SendingGetRequest() throws Exception {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET);
		int statusCode = response.getStatusCode();
		
		System.out.println(statusCode);

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Get Method Executed Successfully$$$$$$$$$$$$$$$$$$$$");

	}
	
	@Test
	public void SendingPostRequest() throws Exception {

		String url = "https://postman-echo.com/post";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 


		// Setting basic post request
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type","application/json");

		String postJsonData = "{\n" +
				"    \"name\": \"user\",\n" +
				"    \"username\": \"user.docs\",\n" +
				"    \"location\": Hyderabad}";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postJsonData);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("nSending 'POST' request to URL : " + url);
		System.out.println("Post Data : " + postJsonData);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String output;
		StringBuffer response = new StringBuffer();

		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		in.close();

		//printing result from response
		System.out.println(response.toString());
	}

	
}